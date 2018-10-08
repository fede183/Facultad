




internal class MSTGraph
{



	private MSTVertex[] nodes;


	private const int CONST_m1 = 10000;
	private const int CONST_b = 31415821;
	private const int RANGE = 2048;





	public MSTGraph(int numvert)
	{
		nodes = new MSTVertex[numvert];
		MSTVertex v = null;

		for (int i = numvert - 1; i >= 0; i--)
		{
			MSTVertex tmp = nodes[i] = new MSTVertex(v, numvert);
			v = tmp;
		}
		addEdges(numvert);



















	}





	public MSTVertex firstNode()
	{
		return nodes[0];
	}






	private void addEdges(int numvert)
	{
		int count1 = 0;

		for (MSTVertex tmp = nodes[0]; tmp != null; tmp = tmp.next())
		{ 
			Hashtable hash = tmp.neighbors();
			for (int i = 0; i < numvert; i++)
			{ 

				{
					int dist = computeDist(i, count1, numvert);
					hash.put(nodes[i], new int?(dist)); 														
				}
			}
			count1++;
		}
	}





	private int computeDist(int i, int j, int numvert)
	{
		int less, gt;
		if (i < j)
		{
			less = i;
			gt = j;
		}
		else
		{
			less = j;
			gt = i;
		}
		return (random(less * numvert + gt) % RANGE) + 1;
	}

	private static int mult(int p, int q)
	{
		int p1, p0, q1, q0;

		p1 = p / CONST_m1;
		p0 = p % CONST_m1;
		q1 = q / CONST_m1;
		q0 = q % CONST_m1;
		return (((p0 * q1 + p1 * q0) % CONST_m1) * CONST_m1 + p0 * q0);
	}

	private static int random(int seed)
	{
		return mult(seed, CONST_b) + 1;
	}
}
