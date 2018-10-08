using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * A Java implementation of the <tt>health</tt> Olden benchmark.  The Olden
 * benchmark simulates the Columbian health-care system:
 * G. Lomow , J. Cleary, B. Unger, and D. West. "A Performance Study of
 * Time Warp," In SCS Multiconference on Distributed Simulation, pages 50-55,
 * Feb. 1988.
 **/
public class Health
{
	/**
	 * The size of the health-care system.
	 **/
	private static int maxLevel = 5;
	/**
	 * The maximum amount of time to use in the simulation.
	 **/
	private static int maxTime = 20;
	/**
	* A seed value for the random no. generator.
	**/
	private static int seed = 1;
	/**
	 * Set to true to print the results.
	 **/
	private static bool printResult = false;
	/**
	 * Set to true to print information messages.
	 **/
	private static bool printMsgs = false;

	public static void main(int[] args)
	{
        maxLevel = args[0];
        maxTime = args[1];

		Village top = Village.createVillage(maxLevel, 0, null, seed);

		if(printMsgs)
			Console.WriteLine("Columbian Health Care Simulator\nWorking...");

		for(int i = 0; i < maxTime; i++)
			top.simulate();

		Results r = top.getResults();

		if (printResult || printMsgs) 
		{
			Console.WriteLine("# People treated: " + (int)r.totalPatients);
			Console.WriteLine("Avg. length of stay: " + r.totalTime / r.totalPatients);
			Console.WriteLine("Avg. # of hospitals visited: " + r.totalHospitals / r.totalPatients);
		}

        // Slicing
        var sliceVariable = r.totalPatients;

		Console.WriteLine(sliceVariable);
	}
}
