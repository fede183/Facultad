






public class Leaf
{



	private Demand D;









	public Leaf()
	{
		D = new Demand(1.0, 1.0);
	}





	public Demand compute(double pi_R, double pi_I)
	{
		D.optimizeNode(pi_R, pi_I);






		return D;
	}
}
