using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * A Java implementation of the <tt>tsp</tt> Olden benchmark, the traveling
 * salesman problem.
 * <p/>
 * <cite>
 * R. Karp, "Probabilistic analysis of partitioning algorithms for the
 * traveling-salesman problem in the plane."  Mathematics of Operations Research
 * 2(3):209-224, August 1977
 * </cite>
 */
public class TSP
{
	/**
	   * Number of cities in the problem.
	   **/
	private static int cities = 3;
	/**
	 * Set to true if the result should be printed
	 **/
	private static bool printResult = false;
	/**
	 * Set to true to print informative messages
	 **/
	private static bool printMsgs = false;

	/**
	 * The main routine which creates a tree and traverses it.
	 *
	 * @param args the arguments to the program
	 */
	public static void main(int[] args)
	{
        cities = args[0];

		if(printMsgs)
			Console.WriteLine("Building tree of size " + cities);

		Tree t = Tree.buildTree(cities, false, 0.0, 1.0, 0.0, 1.0);

		t.tsp(cities / 10);

		if(printResult)
		    t.printVisitOrder();

        // Slicing
        var sliceVariable = t.next.x;
		Console.WriteLine(sliceVariable);
	}
}
