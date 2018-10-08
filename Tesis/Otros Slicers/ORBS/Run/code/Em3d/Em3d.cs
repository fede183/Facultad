using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * Java implementation of the <tt>em3d</tt> Olden benchmark.  This Olden
 * benchmark models the propagation of electromagnetic waves through
 * objects in 3 dimensions. It is a simple computation on an irregular
 * bipartite graph containing nodes representing electric and magnetic
 * field values.
 * <p/>
 * <p><cite>
 * D. Culler, A. Dusseau, S. Goldstein, A. Krishnamurthy, S. Lumetta, T. von
 * Eicken and K. Yelick. "Parallel Programming in Split-C".  Supercomputing
 * 1993, pages 262-273.
 * </cite>
 */
public class Em3d
{
    /**
    * The number of nodes (E and H)
    **/
	static int numNodes = 50;
    /**
    * The out-degree of each node.
    **/
    static int numDegree = 10;
    /**
    * The number of compute iterations
    **/
    static int numIter = 3;

	private static bool printResult = false;
	private static bool printMsgs = false;

	/**
	 * The main roitine that creates the irregular, linked data structure
	 * that represents the electric and magnetic fields and propagates the
	 * waves through the graph.
	 * @param args the command line arguments
	 */
	public static void main(int[] args)
	{
        numNodes = args[0];
        numDegree = args[1];
        numIter = args[2];

		if(printMsgs)
			Console.WriteLine("Initializing em3d random graph...");

        BiGraph graph = BiGraph.create(numNodes, numDegree);

		// compute a single iteration of electro-magnetic propagation
		if(printMsgs)
            Console.WriteLine("Propagating field values for " + numIter + " iteration(s)...");

        for (int i = 0; i < numIter; i++)
			graph.compute();

		if(printResult)
			graph.printGraph();

        // Slicing
        double sliceVariable = graph.eNodes.value;

        // Slicing
        double temp = 0;
        for (var e = graph.eNodes.elements(); e.hasMoreElements(); )
            temp += ((ENode)e.nextElement()).value;
        double sliceVariable2 = temp;

		Console.WriteLine(sliceVariable);
	}
}
