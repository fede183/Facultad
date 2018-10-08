using System;












public class Branch
{



	private Demand D;
	private double alpha = 0.0;
	private double beta = 0.0;
	private double R = 0.0001;
	private double X = 0.00002;



	private Branch nextBranch;



	Leaf[] leaves;








	public Branch(int num, int nleaves)
	{
		D = new Demand();

		if(num <= 1)
			nextBranch = null;
		else
			nextBranch = new Branch(num - 1, nleaves);


		leaves = new Leaf[nleaves];
		for(int k = 0; k < nleaves; k++)
			leaves[k] = new Leaf();
	}









	public Demand compute(double theta_R, double theta_I, double pi_R, double pi_I)
	{
		double new_pi_R = pi_R + alpha * (theta_R + (theta_I * X) / R);
		double new_pi_I = pi_I + beta * (theta_I + (theta_R * R) / X);

		Demand a1 = null;
		if(nextBranch != null)
			a1 = nextBranch.compute(theta_R, theta_I, new_pi_R, new_pi_I);


		D.reset();
		for(int i = 0; i < this.leaves.Length; ++i)
			D.increment(this.leaves[i].compute(new_pi_R, new_pi_I));

		if(nextBranch != null)
			D.increment(a1);


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
