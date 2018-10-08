using System;
















public class BiSort
{



	private static int treesize = 0;







	public static void main(int[] args)
	{
        treesize = args[0];




		Value tree = Value.createTree(treesize, 12345768);
		int sval = Value.random(245867) % Value.RANGE;










		sval = tree.bisort(sval, Value.FORWARD);
















        var sliceVariable = tree.value;
		Console.WriteLine(sliceVariable);
	}
}
