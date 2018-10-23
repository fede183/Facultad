package bh;





final class Cell extends Node
{

  public final static int NSUB = 8;  // 1 << NDIM





  Node[] subp;
  Cell   next;

  Cell()
  {
    subp = new Node[NSUB];
    next = null;
  }





  final Node loadTree(Body p, MathVector xpic, int l, Tree tree)
  {

    int si = oldSubindex(xpic, l);
    Node rt = subp[si];
    if (rt != null) 
      subp[si] = rt.loadTree(p, xpic, l >> 1, tree);
    else 
      subp[si] = p;

    return this;
  }




  final double hackcofm()
  {
    double mq = 0.0;
    MathVector tmpPos = new MathVector();
    MathVector tmpv   = new MathVector();
    for (int i=0; i < NSUB; i++)
	{
      Node r = subp[i];
      if (r != null) 
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




  final HG walkSubTree(double dsq, HG hg)
  {
    if (subdivp(dsq, hg)) 
	{
		for (int k = 0; k < Cell.NSUB; k++) 
		{
			Node r = subp[k];
			if (r != null)
				hg = r.walkSubTree(dsq / 4.0, hg);
		}
    } 
	else
      hg = gravSub(hg);

    return hg;
  }




  final boolean subdivp(double dsq, HG hg)
  {
    MathVector dr = new MathVector();
    dr.subtraction(pos, hg.pos0);
    double drsq = dr.dotProduct();


    return (drsq < dsq);
  }




  public String toString()
  {
    return "Cell " + super.toString();
  }
}
