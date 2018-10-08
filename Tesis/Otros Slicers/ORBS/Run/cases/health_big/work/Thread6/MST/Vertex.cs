using System.Collections;

/// <summary>
/// A class that represents a vertex in a graph.  We maintain a linked list
/// representation of the vertices.
/// </summary>
internal class MSTVertex
{
	/// <summary>
	/// The minimum distance value for the node
	/// </summary>
	internal int _mindist;
	/// <summary>
	/// The next vertex in the graph.
	/// </summary>
	internal MSTVertex _next;
	/// <summary>
	/// A hashtable containing all the connected vertices.
	/// </summary>
	internal Hashtable _neighbors;

	/// <summary>
	/// Create a vertex and initialize the fields.
	/// </summary>
	/// <param name="n"> the next element </param>
	internal MSTVertex(MSTVertex n, int numvert)
	{
		_mindist = 9999999;
		_next = n;
		_neighbors = new Hashtable(numvert / 4);
	}

	public int mindist()
	{
		return _mindist;
	}

	public int Mindist
	{
		set { _mindist = value; }
	}

	public MSTVertex next()
	{
		return _next;
	}

	public MSTVertex Next
	{
		set { _next = value; }
	}

	public Hashtable neighbors()
	{
		return _neighbors;
	}
}
