package bh;

import java.util.Enumeration;
import java.lang.Math;

public class BH 
{
  /**
   * The user specified number of bodies to create.
   **/
  private static int nbody = 40;

  /**
   * The maximum number of time steps to take in the simulation
   **/
  private static int nsteps = 10;

  /**
   * Should we print information messsages
   **/
  private static boolean printMsgs = false;
  /**
   * Should we print detailed results
   **/
  private static boolean printResults = false;

  static double DTIME = 0.0125;
  private static double TSTOP = 2.0;

  public static void main(int[] args)
  {
	  nbody = args[0];
	  nsteps = args[1];
		
	  if (printMsgs)
		  System.out.println("nbody = " + nbody);
	
	  Tree root = new Tree();
	  root.createTestData(nbody);
	  
	  if (printMsgs)
		  System.out.println("Bodies created");
		
	  double tnow = 0.0;
	  int i = 0;
	  while ((tnow < TSTOP + 0.1*DTIME) && (i < nsteps)) 
	  {
		  root.stepSystem(i++);
		  tnow += DTIME;
	  }
		
	  if (printResults) 
	  {
		  int j = 0;
		  for (Enumeration e = root.bodies(); e.hasMoreElements(); )
		  {
			  Body b = (Body)e.nextElement();
			  System.out.println("body " + j++ + " -- " + b.pos);
		  }
	  }
		
	  // Slicing
	  double sliceVariable = root.bodyTab.pos.data[0];
	  System.out.println(new Double(root.bodyTab.pos.data[0]).toString());
  }  

  /**
   * Random number generator used by the orignal BH benchmark.
   **/
  static final double myRand(double seed)
  {
    double t = 16807.0*seed + 1;
    
    seed = t - (2147483647.0 * Math.floor(t / 2147483647.0));
    return seed;
  }

  /**
   * Generate a floating point random number.  Used by
   * the original BH benchmark.
   **/
  static final double xRand(double xl, double xh, double r)
  {
    double res = xl + (xh-xl)*r/2147483647.0;
    return res;
  }
}
