using System;




public class Demand
{



	public double P;



	public double Q;

	private static double F_EPSILON = 0.000001;
	private static double G_EPSILON = 0.000001;
	private static double H_EPSILON = 0.000001;







	public Demand(double toP, double toQ)
	{
		P = toP;
		Q = toQ;
	}




    public Demand() : this(0.0, 0.0)
	{

	}





	public void increment(Demand frm)
	{
		P += frm.P;
		Q += frm.Q;
	}




	public void reset()
	{
		P = 0.0;
		Q = 0.0;
	}






	public void add(Demand a1, Demand a2)
	{
		P = a1.P + a2.P;
		Q = a1.Q + a2.Q;
	}





	public void assign(Demand frm)
	{
		P = frm.P;
		Q = frm.Q;
	}








	public void optimizeNode(double pi_R, double pi_I)
	{
		double[] grad_f = new double[2];
		double[] grad_g = new double[2];
		double[] grad_h = new double[2];
		double[] dd_grad_f = new double[2];

		double g = 0;
		double h = 0;
		double total = 0;
		double magnitude = 0;

		do
		{

			h = findH();
			if(Math.Abs(h) > H_EPSILON)
			{
				magnitude = findGradientH(grad_h);
				total = h / magnitude;
				P -= total * grad_h[0];
				Q -= total * grad_h[1];
			}


			g = findG();
			if(g > G_EPSILON)
			{
				magnitude = findGradientG(grad_g);

				magnitude *= makeOrthogonal(grad_g, grad_h);
				total = g / magnitude;
				P -= total * grad_g[0];
				Q -= total * grad_g[1];
			}


			magnitude = findGradientF(pi_R, pi_I, grad_f);
			findDDGradF(pi_R, pi_I, dd_grad_f);
			total = 0.0;
			for(int i = 0; i < 2; i++)
				total += grad_f[i] * dd_grad_f[i];

			magnitude = magnitude / Math.Abs(total);
			findGradientH(grad_h);
			magnitude *= makeOrthogonal(grad_f, grad_h);











			P += magnitude * grad_f[0];
			Q += magnitude * grad_f[1];



			findGradientF(pi_R, pi_I, grad_f);

		} while(Math.Abs(h) > H_EPSILON || g > G_EPSILON || (Math.Abs(g) > G_EPSILON && Math.Abs(grad_f[0] * grad_h[1] - grad_f[1] * grad_h[0]) > F_EPSILON));
	}

	private double findG()
	{
		return (P * P + Q * Q - 0.8);
	}

	private double findH()
	{
		return (P - 5.0 * Q);
	}

	private double findGradientF(double pi_R, double pi_I, double[] gradient)
	{
		gradient[0] = 1.0 / (1.0 + P) - pi_R;
		gradient[1] = 1.0 / (1.0 + Q) - pi_I;

		double magnitude = 0.0;
		for(int i = 0; i < 2; i++)
			magnitude += gradient[i] * gradient[i];

		magnitude = Math.Sqrt(magnitude);

		for(int i = 0; i < 2; i++)
			gradient[i] = gradient[i] / magnitude;

		return magnitude;
	}

	private double findGradientG(double[] gradient)
	{
		gradient[0] = 2.0 * P;
		gradient[1] = 2.0 * Q;
		double magnitude = 0.0;
		for(int i = 0; i < 2; i++)
			magnitude += gradient[i] * gradient[i];

		magnitude = Math.Sqrt(magnitude);




		return magnitude;
	}

	private double findGradientH(double[] gradient)
	{
		gradient[0] = 1.0;
		gradient[1] = -5.0;
		double magnitude = 0.0;

		for(int i = 0; i < 2; i++)
			magnitude += gradient[i] * gradient[i];

		magnitude = Math.Sqrt(magnitude);

		for(int i = 0; i < 2; i++)
			gradient[i] = gradient[i] / magnitude;

		return magnitude;
	}

	private void findDDGradF(double pi_R, double pi_I, double[] dd_grad)
	{
		double P_plus_1_inv = 1.0 / (P + 1.0);
		double Q_plus_1_inv = 1.0 / (Q + 1.0);
		double P_grad_term = P_plus_1_inv - pi_R;
		double Q_grad_term = Q_plus_1_inv - pi_I;

		double grad_mag = Math.Sqrt(P_grad_term * P_grad_term + Q_grad_term * Q_grad_term);

		dd_grad[0] = -P_plus_1_inv * P_plus_1_inv * P_grad_term / grad_mag;
		dd_grad[1] = -Q_plus_1_inv * Q_plus_1_inv * Q_grad_term / grad_mag;
	}

	private double makeOrthogonal(double[] v_mod, double[] v_static)
	{
		double total = 0.0;
		for(int i = 0; i < 2; i++)
			total += v_mod[i] * v_static[i];

		double length = 0.0;
		for(int i = 0; i < 2; i++)
		{
			v_mod[i] = v_mod[i] - (total * v_static[i]);
			length += v_mod[i] * v_mod[i];
		}
		length = Math.Sqrt(length);

		for(int i = 0; i < 2; i++)
			v_mod[i] = v_mod[i] / length;

		if(1.0 - total * total < 0.0)    // Roundoff error
			return 0.0;

		return Math.Sqrt(1.0 - total * total);
	}
}
