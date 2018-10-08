using System;

/// <summary>
/// A Java implementation of the <tt>mst</tt> Olden benchmark. The Olden
/// benchmark computes the minimum spanning tree of a graph using
/// Bentley's algorithm.
/// J. Bentley. "A Parallel Algorithm for Constructing Minimum Spanning Trees"
/// J. of Algorithms, 1:51-59, 1980.
/// As with the original C version, this one uses its own implementation
/// of hashtable.
/// </summary>
public class MST
{
    /// <summary>
    /// The number of vertices in the graph.
    /// </summary>
    private static int vertices = 0;
    /// <summary>
    /// Set to true to print the final result.
    /// </summary>
    private static bool printResult = false;
    /// <summary>
    /// Set to true to print information messages and timing values
    /// </summary>
    private static bool printMsgs = false;

    public static void main(int[] args)
    {
        vertices = args[0];
        if (printMsgs)
            Console.WriteLine("Making graph of size " + vertices);

        long start0 = DateTime.UtcNow.Ticks / TimeSpan.TicksPerMillisecond;
        MSTGraph graph = new MSTGraph(vertices);
        long end0 = DateTime.UtcNow.Ticks / TimeSpan.TicksPerMillisecond;

        if (printMsgs)
            Console.WriteLine("About to compute MST");

        long start1 = DateTime.UtcNow.Ticks / TimeSpan.TicksPerMillisecond;
        int dist = computeMST(graph, vertices);
        long end1 = DateTime.UtcNow.Ticks / TimeSpan.TicksPerMillisecond;

        if (printResult || printMsgs)
            Console.WriteLine("MST has cost " + dist);

        if (printMsgs)
        {
            Console.WriteLine("Build graph time " + (end0 - start0) / 1000.0);
            Console.WriteLine("Compute time " + (end1 - start1) / 1000.0);
            Console.WriteLine("Total time " + (end1 - start0) / 1000.0);
        }
		
		// Slicing
        var sliceVariable = dist;

        Console.WriteLine(sliceVariable);
    }

    /// <summary>
    /// The method to compute the minimum spanning tree
    /// </summary>
    /// <param name="graph"> the graph data structure </param>
    /// <param name="numvert"> the number of vertices in the graph </param>
    /// <returns> the minimum spanning tree cost </returns>
    internal static int computeMST(MSTGraph graph, int numvert)
    {
        int cost = 0;

        // Insert first node
        MSTVertex inserted = graph.firstNode();
        MSTVertex tmp = inserted.next();
        MyVertexList = tmp;
        numvert--;

        // Annonunce insertion and find next one
        while (numvert != 0)
        {
            BlueReturn br = doAllBlueRule(inserted);
            inserted = br.vert();
            int dist = br.dist();
            numvert--;
            cost += dist;
        }
        return cost;
    }

    private static BlueReturn BlueRule(MSTVertex inserted, MSTVertex vlist)
    {
        BlueReturn retval = new BlueReturn();

        if (vlist == null)
        {
            retval.Dist = 999999;
            return retval;
        }

        MSTVertex prev = vlist;
        retval.Vert = vlist;
        retval.Dist = vlist.mindist();
        Hashtable hash = vlist.neighbors();
        object o = hash.get(inserted);
        if (o != null)
        {
            int dist = ((int?)o).Value;
            if (dist < retval.dist())
            {
                vlist.Mindist = dist;
                retval.Dist = dist;
            }
        }
        else
            Console.WriteLine("Not found");

        int count = 0;
        // We are guaranteed that inserted is not first in list
        for (MSTVertex tmp = vlist.next(); tmp != null; prev = tmp, tmp = tmp.next())
        {
            count++;
            if (tmp == inserted)
            {
                MSTVertex next = tmp.next();
                prev.Next = next;
            }
            else
            {
                hash = tmp.neighbors();
                int dist2 = tmp.mindist();
                o = hash.get(inserted);
                if (o != null)
                {
                    int dist = ((int?)o).Value;
                    if (dist < dist2)
                    {
                        tmp.Mindist = dist;
                        dist2 = dist;
                    }
                }
                else
                {
                    if (dist2 < retval.dist())
                    {
                        retval.Vert = tmp;
                        retval.Dist = dist2;
                    }
                }
            }
        }
        return retval;
    }

    private static MSTVertex MyVertexList = null;

    private static BlueReturn doAllBlueRule(MSTVertex inserted)
    {
        if (inserted == MyVertexList)
            MyVertexList = MyVertexList.next();
        BlueReturn b = BlueRule(inserted, MyVertexList);
        return b;
    }
}
