using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * A Java implementation of the <tt>power</tt> Olden benchmark.
 * The original algorithm is from the following paper:
 * <p><cite>
 * S. Lumetta, L. Murphy, X. Li, D. Culler, and I. Khalil.
 * "Decentralized optimal power pricing: The development of a parallel
 * program."  Supercomputing '93, 243-249
 * </cite>
 * <p/>
 * Note - the number of customers is fixed at 10,000 for this
 * benchmark.  We create a data structure that contains 1 root (the
 * (power substation).  There are 10 main feeders from the root and
 * each feeder branches to 20 lateral nodes.  Each lateral node is the
 * head of a line of five branch nodes and each branch has 10
 * customers.  In total, there are 10,000 customers (and 1201 internal
 * nodes).
 * <p/>
 * The power pricing problems sets the price of each customer's power
 * consumption so that the economic efficiency of the whole community
 * is maximized.
 */
public class Power
{
	/**
	* Should we print the results as we run the benchmark
	**/
	static bool printResults = false;
	
	public static void main(int[] args)
	{
        Root r = new Root(args[0], args[1], args[2], args[3]);

		r.compute();
		r.nextIter(0.7, 0.14);

		int i = 0;
		while(true)
		{
			++i;
			r.compute();

			if (printResults)
				Console.WriteLine(r);
			
			if(r.reachedLimit())
				break;

			r.nextIter();
		}

		if(printResults)
			Console.WriteLine("Power compute iters " + i);

        // Slicing
        var sliceVariable = i;

        // Slicing
        var sliceVariable2 = r.last.P;

		Console.WriteLine(sliceVariable2);
	}
}
