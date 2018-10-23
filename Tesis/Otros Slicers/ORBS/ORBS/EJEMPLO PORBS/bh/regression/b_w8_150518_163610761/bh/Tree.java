package bh;

import java.util.Enumeration;





class Tree
{
  MathVector rmin;
  double rsize;




  Node       root;



  public Body       bodyTab;



  private Body       bodyTabRev;




  Tree()
  {
    rmin       = new MathVector();
    rsize      = -2.0 * -2.0;
    root       = null;
    bodyTab    = null;
    bodyTabRev = null;

    rmin.value(0, -2.0);
    rmin.value(1, -2.0);
    rmin.value(2, -2.0);
  }





  final Enumeration bodies()
  {
    return bodyTab.elements();
  }





  final Enumeration bodiesRev()
  {
    return bodyTabRev.elementsRev();
  }




  final void createTestData(int nbody)
  {
    MathVector cmr = new MathVector();
    MathVector cmv = new MathVector();

    Body head = new Body();
    Body prev = head;

    double rsc  = 3.0 * Math.PI / 16.0;
    double vsc  = Math.sqrt(1.0 / rsc);
    double seed = 123.0;

    for (int i = 0; i < nbody; i++) 
	{
      Body p = new Body();

      prev.setNext(p);
      prev = p;
      p.mass = 1.0/(double)nbody;

      seed      = BH.myRand(seed);
      double t1 = BH.xRand(0.0, 0.999, seed);
      t1        = Math.pow(t1, (-2.0/3.0)) - 1.0;
      double r  = 1.0 / Math.sqrt(t1);

      double coeff = 4.0;
      for (int k = 0; k < MathVector.NDIM; k++) 
	  {
		seed = BH.myRand(seed);
		r = BH.xRand(0.0, 0.999, seed);
		p.pos.value(k, coeff*r);
      }

      cmr.addition(p.pos);

      double x, y;
      do 
	  {
		seed = BH.myRand(seed);
		x    = BH.xRand(0.0, 1.0, seed);
		seed = BH.myRand(seed);
		y    = BH.xRand(0.0, 0.1, seed);
      } while (y > x*x * Math.pow(1.0 - x*x, 3.5));

      double v = Math.sqrt(2.0) * x / Math.pow(1 + r*r, 0.25);

      double rad = vsc * v;
      double rsq;
      do 
	  {
		for (int k = 0; k < MathVector.NDIM; k++) 
		{
			seed     = BH.myRand(seed);
			p.vel.value(k, BH.xRand(-1.0, 1.0, seed));
		}
		rsq = p.vel.dotProduct();
      } while (rsq > 1.0);
      double rsc1 = rad / Math.sqrt(rsq);
      p.vel.multScalar(rsc1);
      cmv.addition(p.vel);
    }


    prev.setNext(null);

    bodyTab = head.getNext();

    cmr.divScalar((double)nbody);
    cmv.divScalar((double)nbody);

    prev = null;

    for (Enumeration e = bodyTab.elements(); e.hasMoreElements(); ) 
	{
      Body b = (Body)e.nextElement();
      b.pos.subtraction(cmr);
      b.vel.subtraction(cmv);
      b.setProcNext(prev);
      prev = b;
    }


    bodyTabRev = prev;
  }





  void stepSystem(int nstep)
  {

    root = null;

    makeTree(nstep);


    for (Enumeration e = bodyTabRev.elementsRev(); e.hasMoreElements(); ) 
	{
      Body b = (Body)e.nextElement();
      b.hackGravity(rsize, root);
    }

    vp(bodyTabRev, nstep);
  }




  private void makeTree(int nstep)
  {
    for (Enumeration e = bodiesRev(); e.hasMoreElements(); ) 
	{
      Body q = (Body)e.nextElement();
      if (q.mass != 0.0) 
	  {
		q.expandBox(this, nstep);
		MathVector xqic = intcoord(q.pos);
		if (root == null)
			root = q;
		else
			root = root.loadTree(q, xqic, Node.IMAX >> 1, this);
      }
    }
    root.hackcofm();
  }




  final MathVector intcoord(MathVector vp)
  {
    MathVector xp = new MathVector();

    double xsc = (vp.value(0) - rmin.value(0)) / rsize;
    if (0.0 <= xsc && xsc < 1.0)
      xp.value(0, Math.floor(Node.IMAX * xsc));
    else
      return null;

    xsc = (vp.value(1) - rmin.value(1)) / rsize;
    if (0.0 <= xsc && xsc < 1.0)
      xp.value(1, Math.floor(Node.IMAX * xsc));
    else
      return null;

    xsc = (vp.value(2) - rmin.value(2)) / rsize;
    if (0.0 <= xsc && xsc < 1.0)
      xp.value(2, Math.floor(Node.IMAX * xsc));
    else
      return null;

    return xp;
  }

  static final private void vp(Body p, int nstep)
  {
    MathVector dacc = new MathVector();
    MathVector dvel = new MathVector();
    double dthf = 0.5 * BH.DTIME;

    for (Enumeration e = p.elementsRev(); e.hasMoreElements(); ) 
	{
      Body b = (Body)e.nextElement();
      MathVector acc1 = (MathVector)b.newAcc.clone();
      if (nstep > 0) 
	  {
		dacc.subtraction(acc1, b.acc);
		dvel.multScalar(dacc, dthf);
		dvel.addition(b.vel);
		b.vel = (MathVector)dvel.clone();
      }
      b.acc = (MathVector)acc1.clone();
      dvel.multScalar(b.acc, dthf);

      MathVector vel1 = (MathVector)b.vel.clone();
      vel1.addition(dvel);
      MathVector dpos = (MathVector)vel1.clone();
      dpos.multScalar(BH.DTIME);
      dpos.addition(b.pos);
      b.pos = (MathVector)dpos.clone();
      vel1.addition(dvel);
      b.vel = (MathVector)vel1.clone();
    }
  }
}
