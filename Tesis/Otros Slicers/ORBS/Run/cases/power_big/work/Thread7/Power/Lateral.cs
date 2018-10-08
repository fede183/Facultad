using System;









public class Lateral
{



	private Demand D;
	private double alpha = 0.0;
	private double beta = 0.0;
	private double R = 1.0 / 300000.0;
	private double X = 0.000001;



	private Lateral next_lateral;



	private Branch branch;







	public Lateral(int num, int nbranches, int nleaves)
	{
		D = new Demand();


		if(num <= 1)
			next_lateral = null;
		else
			next_lateral = new Lateral(num - 1, nbranches, nleaves);


		branch = new Branch(nbranches, nleaves);
	}









	public Demand compute(double theta_R, double theta_I, double pi_R, double pi_I)
	{

		double new_pi_R = pi_R + alpha * (theta_R + (theta_I * X) / R);
		double new_pi_I = pi_I + beta * (theta_I + (theta_R * R) / X);

		Demand a1;
		if(next_lateral != null)
			a1 = next_lateral.compute(theta_R, theta_I, new_pi_R, new_pi_I);
		else
			a1 = null;

		Demand a2 = branch.compute(theta_R, theta_I, new_pi_R, new_pi_I);

		if(next_lateral != null)
			D.add(a1, a2);
		else
			D.assign(a2);


		double a = R * R + X * X;
		double b = 2.0 * R * X * D.Q - 2.0 * X * X * D.P - R;
		double c = R * D.Q - X * D.P;
		c = c * c + R * D.P;
		double root = (-b - Math.Sqrt(b * b - 4.0 * a * c)) / (2.0 * a);
		D.Q = D.Q + ((root - D.P) * X) / R;
		D.P = root;


		a = 2.0 * R * D.P;
		b = 2.0 * X * D.Q;
		alpha = a / (1.0 - a - b);
		beta = b / (1.0 - a - b);

		return D;
	}
}
