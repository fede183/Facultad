package bh;




public class BH 
{



  private static int nbody = 40;




  private static int nsteps = 10;










  static double DTIME = 0.0125;
  private static double TSTOP = 2.0;

  public static void main(int[] args)
  {
	  nbody = args[0];





	  Tree root = new Tree();
	  root.createTestData(nbody);




	  double tnow = 0.0;
	  int i = 0;
	  while ((tnow < TSTOP + 0.1*DTIME) && (i < nsteps)) 
	  {
		  root.stepSystem(i++);











	  }



	  System.out.println(new Double(root.bodyTab.pos.data[0]).toString());
  }  




  static final double myRand(double seed)
  {
    double t = 16807.0*seed + 1;

    seed = t - (2147483647.0 * Math.floor(t / 2147483647.0));
    return seed;
  }





  static final double xRand(double xl, double xh, double r)
  {
    double res = xl + (xh-xl)*r/2147483647.0;
    return res;
  }
}
