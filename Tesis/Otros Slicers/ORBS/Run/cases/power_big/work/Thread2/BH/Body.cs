using System;



/**
 * A class used to representing particles in the N-body simulation.
 **/
public class Body : Node
{
	public MathVector vel;
	public MathVector acc;
	public MathVector newAcc;
	public double phi;

	private Body next;
	private Body procNext;

	/**
	 * Create an empty body.
	 */
	public Body() : base()
	{
		this.vel = new MathVector();
		this.acc = new MathVector();
		this.newAcc = new MathVector();
		this.phi = 0.0;
		next     = null;
		procNext = null;
	}

	/**
	* Set the next body in the list.
	**/
	public void setNext(Body n)
	{
		next = n;
	}

	/**
	* Get the next body in the list.
	**/
	public Body getNext()
	{
		return next;
	}

	/**
	* Set the next body in the list.
	**/
	public void setProcNext(Body n)
	{
		procNext = n;
	}

	/**
	* Get the next body in the list.
	**/
	public Body getProcNext()
	{
		return procNext;
	}

	/**
	 * Enlarge cubical "box", salvaging existing tree structure.
	 */
	public void expandBox(BTree tree, int nsteps)
	{
		MathVector rmid = new MathVector();

		var inbox = icTest(tree);
		while (!inbox) 
        {
            double rsize = tree.rsize;
            rmid.addScalar(tree.rmin, 0.5 * rsize);
		  
            for (int k = 0; k < MathVector.NDIM; k++) 
            {
                if (pos.value(k) < rmid.value(k)) 
                {
                    double rmin = tree.rmin.value(k);
                    tree.rmin.setValue(k, rmin - rsize);
                }
            }
		    tree.rsize = 2.0 * rsize;
		    if (tree.root != null) 
            {
		        MathVector ic = tree.intcoord(rmid);
		        if (ic == null) 
                    throw new Exception("Value is out of bounds");
		        int k = oldSubindex(ic, IMAX >> 1);
		        Cell newt = new Cell();
		        newt.subp[k] = tree.root;
		        tree.root = newt;
		        inbox = icTest(tree);
		    }
		}
	}

	/**
	 * Check the bounds of the body and return true if it isn't in the
	 * correct bounds.
	 */
	public bool icTest(BTree tree)
	{
		double pos0 = pos.value(0);
		double pos1 = pos.value(1);
		double pos2 = pos.value(2);

		// by default, it is in bounds
		bool result = true;

		double xsc = (pos0 - tree.rmin.value(0)) / tree.rsize;
		if(!(0.0 < xsc && xsc < 1.0))
			result = false;

		xsc = (pos1 - tree.rmin.value(1)) / tree.rsize;
		if(!(0.0 < xsc && xsc < 1.0))
			result = false;

		xsc = (pos2 - tree.rmin.value(2)) / tree.rsize;
		if(!(0.0 < xsc && xsc < 1.0))
			result = false;

		return result;
	}

	/**
	 * Descend Tree and insert particle.  We're at a body so we need to
	 * create a cell and attach this body to the cell.
	 */
	public override Node loadTree(Body p, MathVector xpic, int l, BTree tree)
	{
		// create a Cell
		Cell retval = new Cell();
		int si = subindex(tree, l);
		// attach this Body node to the cell
		retval.subp[si] = this;

		// move down one level
		si = Node.oldSubindex(xpic, l);
		Node rt = retval.subp[si];
		if(rt != null)
			retval.subp[si] = rt.loadTree(p, xpic, l >> 1, tree);
		else
			retval.subp[si] = p;

		return retval;
	}

	/**
	 * Descend tree finding center of mass coordinates
	 */
	public override double hackcofm()
	{
		return mass;
	}

	/**
	 * Determine which subcell to select.
	 * Combination of intcoord and oldSubindex.
	 */
	public int subindex(BTree tree, int l)
	{
		MathVector xp = new MathVector();

		double imxv = (double)Node.IMAX;
		double xsc = (pos.value(0) - tree.rmin.value(0)) / tree.rsize;
		xp.setValue(0, Math.Floor(imxv * xsc));

		xsc = (pos.value(1) - tree.rmin.value(1)) / tree.rsize;
		xp.setValue(1, Math.Floor(imxv * xsc));

		xsc = (pos.value(2) - tree.rmin.value(2)) / tree.rsize;
		xp.setValue(2, Math.Floor(imxv * xsc));

		int i = 0;
		for(int k = 0; k < MathVector.NDIM; k++)
			if(((int)xp.value(k) & l) != 0)
				i += Cell.NSUB >> (k + 1);
			
		return i;
	}

	/**
	 * Evaluate gravitational field on the body.
	 * The original olden version calls a routine named "walkscan",
	 * but we use the same name that is in the Barnes code.
	 */
	public void hackGravity(double rsize, Node root)
	{
		MathVector pos0 = pos.clone();

		HG hg = new HG(this, pos);
		hg = root.walkSubTree(rsize * rsize, hg);
		phi = hg.phi0;
		newAcc = hg.acc0;
	}

	/**
	 * Recursively walk the tree to do hackwalk calculation
	 */
	public override HG walkSubTree(double dsq, HG hg)
	{
		if(this != hg.pskip)
			hg = gravSub(hg);
		return hg;
	}
	
    public BodyEnumerator elements()
    {
        return new BodyEnumerator(this);
    }

    public class BodyEnumerator
    {
        private Body current;
        public BodyEnumerator(Body body) 
	    { 
	        this.current = body; 
	    } 
        public bool hasMoreElements() 
	    { 
	        return (current != null); 
	    } 
        public Object nextElement() 
	    {
	        Object retval = current;
	        current = current.next;
	        return retval;
        }
    }

    public BodyEnumeratorRev elementsRev()
    {
        return new BodyEnumeratorRev(this);
    }

    public class BodyEnumeratorRev
    {
        private Body current;
        public BodyEnumeratorRev(Body body) 
	    { 
	        this.current = body; 
	    } 
        public bool hasMoreElements() 
	    { 
	        return (current != null); 
	    } 
        public Object nextElement() 
	    {
	        Object retval = current;
	        current = current.procNext;
	        return retval;
        }
    }

    /**
    * Return a string represenation of a body.
    **/
    public string toString()
    {
        return "Body " + base.toString();
    }
}
