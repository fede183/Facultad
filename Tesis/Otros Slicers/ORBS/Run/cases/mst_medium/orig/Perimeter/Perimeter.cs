using System;
using System.IO;
using System.Text;

/**
 * A Java version of the <tt>perimeter</tt> Olden benchmark.
 * <p/>
 * The algorithm computes the total perimeter of a region
 * in a binary image represented by a quadtree.  The
 * algorithm was presented in the paper:
 * <p/>
 * <cite>
 * Hanan Samet, "Computing Perimeters of Regions in Images
 * Represented by Quadtrees," IEEE Transactions on Pattern
 * Analysis and Machine Intelligence, PAMI-3(6), November, 1981.
 * </cite>
 * <p/>
 * The benchmark creates an image, count the number of leaves on the
 * quadtree and then computes the perimeter of the image using Samet's
 * algorithm.
 */
public class Perimeter
{
	/**
	 * The number of levels in the tree/image.
	 **/
	private static int levels = 12;
	/**
	 * Set to true to print the final result.
	 **/
	private static bool printResult = false;
	
	public static void main(int[] args)
	{
        levels = args[0];

		int size = 1 << levels;
		int msize = 1 << (levels - 1);
		QuadTreeNode.gcmp = size * 1024;
		QuadTreeNode.lcmp = msize * 1024;

		QuadTreeNode tree = QuadTreeNode.createTree(msize, 0, 0, null, Quadrant.cSouthEast, levels);

		int leaves = tree.countTree();
		int perm = tree.perimeter(size);

		if(printResult)
		{
			Console.WriteLine("Perimeter is " + perm);
			Console.WriteLine("Number of leaves " + leaves);
		}

        // Slicing
        var sliceVariable = perm;

		Console.WriteLine(sliceVariable);
	}
}
