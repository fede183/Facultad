using System;










public class MST
{



    private static int vertices = 0;









    public static void main(int[] args)
    {
        vertices = args[0];




        MSTGraph graph = new MSTGraph(vertices);






        int dist = computeMST(graph, vertices);













        var sliceVariable = dist;

        Console.WriteLine(sliceVariable);
    }







    internal static int computeMST(MSTGraph graph, int numvert)
    {
        int cost = 0;


        MSTVertex inserted = graph.firstNode();
        MSTVertex tmp = inserted.next();
        MyVertexList = tmp;
        numvert--;


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







        MSTVertex prev = vlist;
        retval.Vert = vlist;
        retval.Dist = vlist.mindist();
        Hashtable hash = vlist.neighbors();
        object o = hash.get(inserted);

        {
            int dist = ((int?)o).Value;
            if (dist < retval.dist())
            {

                retval.Dist = dist;
            }
        }





        for (MSTVertex tmp = vlist.next(); tmp != null; prev = tmp, tmp = tmp.next())
        {







            {
                hash = tmp.neighbors();
                int dist2 = tmp.mindist();
                o = hash.get(inserted);

                {
                    int dist = ((int?)o).Value;
                    if (dist < dist2)
                    {
                        tmp.Mindist = dist;

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
