﻿

/**
 * A class which is used to compute and save information during the
 * gravity computation phse.
 */
public class HG
{
	/**
	 * Body to skip in force evaluation
	 */
	public Body pskip;
	/**
	 * Point at which to evaluate field
	 */
	public MathVector pos0;
	/**
	 * Computed potential at pos0
	 */
	public double phi0;
	/**
	 * computed acceleration at pos0
	 */
	public MathVector acc0;

	/**
	 * Create a HG  object.
	 */
	public HG (Body b, MathVector p)
	{
		pskip = b;
		pos0  = (MathVector)p.clone();
		phi0  = 0.0;
		acc0  = new MathVector();
	}
}
