using System;
using System.IO;
using System.Text;
using System.Collections.Generic;

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
	private static bool printMsgs = false;
	/**
	 * Should we print detailed results
	 **/
	private static bool printResults = false;

	public static double DTIME = 0.0125;
	private static double TSTOP = 2.0;

	public static void main(int[] args)
	{
        nbody = args[0];
        nsteps = args[1];

		if(printMsgs)
			Console.WriteLine("nbody = " + nbody);

		BTree root = new BTree();
		root.createTestData(nbody);

		if(printMsgs)
			Console.WriteLine("Bodies created");

		double tnow = 0.0;
		int i = 0;
		while((tnow < TSTOP + 0.1*DTIME) && (i < nsteps)) 
		{
			root.stepSystem(i++);
			tnow += DTIME;
		}

		if(printResults)
		{
			int j = 0;
            for (Body.BodyEnumerator e = root.bodies(); e.hasMoreElements(); )
		    {
			    Body b = (Body)e.nextElement();
			    Console.WriteLine("body " + j++ + " -- " + b.pos.toString());
		    }
		}

        // Slicing
        var sliceVariable = root.bodyTab.pos.data[0];
		Console.WriteLine(sliceVariable);
	}

	/**
	 * Random number generator used by the orignal BH benchmark.
	 */
	public static double myRand(double seed)
	{
		double t = 16807.0 * seed + 1.0;

		seed = t - (2147483647.0 * Math.Floor(t / 2147483647.0));
		return seed;
	}

	/**
	 * Generate a floating point random number.  Used by
	 * the original BH benchmark.
	 */
	public static double xRand(double xl, double xh, double r)
	{
		double res = xl + (xh - xl) * r / 2147483647.0;
		return res;
	}
}
