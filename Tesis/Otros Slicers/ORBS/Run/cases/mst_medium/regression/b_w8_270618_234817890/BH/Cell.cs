using System;
using System.Collections.Generic;

/**
 * A class used to represent internal nodes in the tree
 */
public class Cell : Node
{
	// subcells per cell
	public static int NSUB = 8;

	/**
	 * The children of this cell node.  Each entry may contain either
	 * another cell or a body.
	 */
	public Node[] subp;
	public Cell   next;

	public Cell()
	{
		subp = new Node[NSUB];
		next = null;
	}

	/**
	 * Descend Tree and insert particle.  We're at a cell so
	 * we need to move down the tree.
	 */
	public override Node loadTree(Body p, MathVector xpic, int l, BTree tree)
	{
		// move down one level
		int si = Node.oldSubindex(xpic, l);
		Node rt = subp[si];
		if(rt != null)
			subp[si] = rt.loadTree(p, xpic, l >> 1, tree);
		else
			subp[si] = p;

		return this;
	}

	/**
	 * Descend tree finding center of mass coordinates
	 */
	public override double hackcofm()
	{
		double mq = 0.0;
		MathVector tmpPos = new MathVector();
		MathVector tmpv = new MathVector();
		for(int i = 0; i < NSUB; i++)
		{
			Node r = this.subp[i];
			if(r != null)
			{
				double mr = r.hackcofm();
				mq = mr + mq;
				tmpv.multScalar(r.pos, mr);
				tmpPos.addition(tmpv);
			}
		}
		mass = mq;
		pos = tmpPos;
		pos.divScalar(mass);

		return mq;
	}

	/**
	 * Recursively walk the tree to do hackwalk calculation
	 */
	public override HG walkSubTree(double dsq, HG hg)
	{
		if(subdivp(dsq, hg))
		{
			for(int k = 0; k < Cell.NSUB; k++)
			{
				Node r = this.subp[k];
				if(r != null)
					hg = r.walkSubTree(dsq / 4.0, hg);
			}
		}
		else
			hg = gravSub(hg);

		return hg;
	}

	/**
	 * Decide if the cell is too close to accept as a single term.
	 */
	public bool subdivp(double dsq, HG hg)
	{
		MathVector dr = new MathVector();
		dr.subtraction(pos, hg.pos0);
		double drsq = dr.dotProduct();

		// in the original olden version drsp is multiplied by 1.0
		return (drsq < dsq);
	}

	/**
	* Return a string represenation of a cell.
	**/
	public string toString()
	{
		return "Cell " + base.toString();
	}
}
