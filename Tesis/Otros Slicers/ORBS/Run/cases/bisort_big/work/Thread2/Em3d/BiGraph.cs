using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * A class that represents the irregular bipartite graph used in
 * EM3D.  The graph contains two linked structures that represent the
 * E nodes and the N nodes in the application.
 */
public class BiGraph
{
    /**
   * Nodes that represent the electrical field.
   **/
    public ENode eNodes;
    /**
     * Nodes that representhe the magnetic field.
     **/
    public ENode hNodes;

	/**
	 * Construct the bipartite graph.
	 * @param e the nodes representing the electric fields
	 * @param h the nodes representing the magnetic fields
	 */
	public BiGraph(ENode e, ENode h)
	{
		eNodes = e;
		hNodes = h;
	}

	/**
	 * @param numNodes  the number of nodes to create
	 * @param numDegree the out-degree of each node
	 * @return the bi graph that we've created.
	 */
	public static BiGraph create(int numNodes, int numDegree)
	{
        // making nodes (we create a table)
        ENode[] hTable = ENode.fillTable(numNodes, numDegree);
        ENode[] eTable = ENode.fillTable(numNodes, numDegree);

        ENode hTable0 = hTable[0];
        ENode eTable0 = eTable[0];

        // making neighbors

        for (var e1 = hTable0.elements(); e1.hasMoreElements(); )
        {
            ENode n1 = (ENode)e1.nextElement();
            n1.makeUniqueNeighbors(eTable);
        }
        for (var e2 = eTable0.elements(); e2.hasMoreElements(); )
        {
            ENode n2 = (ENode)e2.nextElement();
            n2.makeUniqueNeighbors(hTable);
        }
        // Create the fromNodes and coeff field
        for (var e3 = hTable0.elements(); e3.hasMoreElements(); )
        {
            ENode n3 = (ENode)e3.nextElement();
            n3.makeFromNodes();
        }
        for (var e4 = eTable0.elements(); e4.hasMoreElements(); )
        {
            ENode n4 = (ENode)e4.nextElement();
            n4.makeFromNodes();
        }
        // Update the fromNodes
        for (var e5 = hTable0.elements(); e5.hasMoreElements(); )
        {
            ENode n5 = (ENode)e5.nextElement();
            n5.updateFromNodes();
        }
        for (var e6 = eTable0.elements(); e6.hasMoreElements(); )
        {
            ENode n6 = (ENode)e6.nextElement();
            n6.updateFromNodes();
        }

        BiGraph g = new BiGraph(eTable0, hTable0);
        return g;
	}

	/**
	 * Update the field values of e-nodes based on the values of
	 * neighboring h-nodes and vice-versa.
	 */
	public void compute()
	{
        for (var e = eNodes.elements(); e.hasMoreElements(); )
        {
            var n = (ENode)e.nextElement();
            n.computeNewValue();
        }
        for (var e = hNodes.elements(); e.hasMoreElements(); )
        {
            var n = (ENode)e.nextElement();
            n.computeNewValue();
        }
	}

	public void printGraph()
	{
        for (var e = eNodes.elements(); e.hasMoreElements(); )
        {
            Console.Write("E: ");
            ((ENode)e.nextElement()).printNode();
            Console.Write("\n");
        }

        for (var e = hNodes.elements(); e.hasMoreElements(); )
        {
            Console.Write("H: ");
            ((ENode)e.nextElement()).printNode();
            Console.Write("\n");
        }
	}
}
