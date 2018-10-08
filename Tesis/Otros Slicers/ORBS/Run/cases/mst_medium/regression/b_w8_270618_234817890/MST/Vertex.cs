





internal class MSTVertex
{



	internal int _mindist;



	internal MSTVertex _next;



	internal Hashtable _neighbors;





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






	public Hashtable neighbors()
	{
		return _neighbors;
	}
}
