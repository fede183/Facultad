using System.Collections;

/// <summary>
/// A class that represents a graph data structure.
/// </summary>
internal class MSTGraph
{
	/// <summary>
	/// List of vertices in the graph.
	/// </summary>
	private MSTVertex[] nodes;

	// parameters for the random number generater
	private const int CONST_m1 = 10000;
	private const int CONST_b = 31415821;
	private const int RANGE = 2048;

	/// <summary>
	/// Create a graph.
	/// </summary>
	/// <param name="numvert"> the number of vertices in the graph </param>
	public MSTGraph(int numvert)
	{
		nodes = new MSTVertex[numvert];
		MSTVertex v = null;
		// the original C code creates them in reverse order 
		for (int i = numvert - 1; i >= 0; i--)
		{
			MSTVertex tmp = nodes[i] = new MSTVertex(v, numvert);
			v = tmp;
		}
		addEdges(numvert);
	}

	/// <summary>
	/// Create a graph.  This is just another method for
	/// creating the graph data structure.
	/// </summary>
	/// <param name="numvert"> the size of the graph </param>
	public void createGraph(int numvert)
	{
		nodes = new MSTVertex[numvert];
		MSTVertex v = null;
		// the original C code creates them in reverse order 
		for (int i = numvert - 1; i >= 0; i--)
		{
			MSTVertex tmp = nodes[i] = new MSTVertex(v, numvert);
			v = tmp;
		}

		addEdges(numvert);
	}

	/// <summary>
	/// Return the first node in the graph.
	/// </summary>
	/// <returns> the first node in the graph. </returns>
	public MSTVertex firstNode()
	{
		return nodes[0];
	}

	/// <summary>
	/// Add edges to the graph.  Edges are added to/from every node
	/// in the graph and a distance is computed for each of them.
	/// </summary>
	/// <param name="numvert"> the number of nodes in the graph </param>
	private void addEdges(int numvert)
	{
		int count1 = 0;

		for (MSTVertex tmp = nodes[0]; tmp != null; tmp = tmp.next())
		{ 
			Hashtable hash = tmp.neighbors();
			for (int i = 0; i < numvert; i++)
			{ 
				if (i != count1)
				{
					int dist = computeDist(i, count1, numvert);
					hash.put(nodes[i], new int?(dist)); 														
				}
			}
			count1++;
		}
	}

	/// <summary>
	/// Compute the distance between two edges. A random number generator
	/// is used to compute the distance.
	/// </summary>
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
