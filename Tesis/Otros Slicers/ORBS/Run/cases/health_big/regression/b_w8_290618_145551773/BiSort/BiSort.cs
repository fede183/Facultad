using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * A Java implementation of the <tt>bisort</tt> Olden benchmark.  The Olden
 * benchmark implements a Bitonic Sort as described in :
 * <p><cite>
 * G. Bilardi and A. Nicolau, "Adaptive Bitonic Sorting: An optimal parallel
 * algorithm for shared-memory machines." SIAM J. Comput. 18(2):216-228, 1998.
 * </cite>
 * <p/>
 * The benchmarks sorts N numbers where N is a power of 2.  If the user provides
 * an input value that is not a power of 2, then we use the nearest power of
 * 2 value that is less than the input value.
 */
public class BiSort
{
    /**
    * The number of values to sort.
    **/
	private static int treesize = 0;
	private static bool printMsgs = false;
	private static bool printResults = false;

	/**
	 * The main routine which creates a tree and sorts it a couple of times.
	 * @param args the command line arguments
	 */
	public static void main(int[] args)
	{
        treesize = args[0];

		if(printMsgs)
			Console.WriteLine("Bisort with " + treesize + " values");

		Value tree = Value.createTree(treesize, 12345768);
		int sval = Value.random(245867) % Value.RANGE;

        if (printResults)
		{
			tree.inOrder();
            Console.Write(sval);
		}

		if(printMsgs)
			Console.WriteLine("BEGINNING BITONIC SORT ALGORITHM HERE");

		sval = tree.bisort(sval, Value.FORWARD);

		if(printResults)
		{
			tree.inOrder();
            Console.Write(sval);
		}

		sval = tree.bisort(sval, Value.BACKWARD);

		if(printResults)
		{
			tree.inOrder();
            Console.Write(sval);
		}

        // Slicing
        var sliceVariable = tree.value;
		Console.WriteLine(sliceVariable);
	}
}
