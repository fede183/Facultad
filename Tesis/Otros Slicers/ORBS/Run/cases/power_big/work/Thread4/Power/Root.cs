﻿using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * The root node of the power system optimization tree.
 * The root node represents the power plant.
 */
public class Root
{
	/**
	 * Total system power demand.
	 */
	private Demand D;
	/**
	 * Lagrange multiplier for the global real power equality constraint
	 */
	private double theta_R = 0.8;
	/**
	 * Lagrange multiplier for the global reactive power equality constraint
	 */
	private double theta_I = 0.16;
	/**
	 * The power demand on the previous iteration
	 */
	public Demand last;
	/**
	 * The real power equality constraint on the previous iteration
	 */
	private double last_theta_R;
	/**
	 * The reactive power equality constraint on the previous iteration
	 */
	private double last_theta_I;
	/**
	 * A representation of the customers that feed off of the power plant.
	 */
	private Lateral[] feeders;

	/**
	 * Value used to compute convergence
	 */
	private static double ROOT_EPSILON = 0.00001;

	/**
	 * Domain of thetaR->P map is 0.65 to 1.00 [index*0.01+0.65]
	 */
	private static double[] map_P = {
    8752.218091048, 8446.106670416, 8107.990680283,
    7776.191574285, 7455.920518777, 7146.602181352,
    6847.709026813, 6558.734204024, 6279.213382291,
    6008.702199986, 5746.786181029, 5493.078256495,
    5247.206333097, 5008.828069358, 4777.615815166,
    4553.258735900, 4335.470002316, 4123.971545694,
    3918.501939675, 3718.817618538, 3524.683625800,
    3335.876573044, 3152.188635673, 2973.421417103,
    2799.382330486, 2629.892542617, 2464.782829705,
    2303.889031418, 2147.054385395, 1994.132771399,
    1844.985347313, 1699.475053321, 1557.474019598,
    1418.860479043, 1283.520126656, 1151.338004216
  };

	private static double MIN_THETA_R = 0.65;
	private static double PER_INDEX_R = 0.01;
	private static double MAX_THETA_R = 0.995;

	/**
	 * Domain of thetaI->Q map is 0.130 to 0.200 [index*0.002+0.130]
	 */
	private static double[] map_Q = {
    1768.846590190, 1706.229490046, 1637.253873079,
    1569.637451623, 1504.419525242, 1441.477913810,
    1380.700660446, 1321.980440476, 1265.218982201,
    1210.322424636, 1157.203306183, 1105.780028163,
    1055.974296746, 1007.714103979, 960.930643875,
    915.558722782, 871.538200178, 828.810882006,
    787.322098340, 747.020941334, 707.858376214,
    669.787829741, 632.765987756, 596.751545633,
    561.704466609, 527.587580585, 494.365739051,
    462.004890691, 430.472546686, 399.738429196,
    369.773787595, 340.550287137, 312.041496095,
    284.222260660, 257.068973074, 230.557938283
  };

	private static double MIN_THETA_I = 0.13;
	private static double PER_INDEX_I = 0.002;
	private static double MAX_THETA_I = 0.199;

	/**
	 * Create the tree used by the power system optimization benchmark.
	 * Each root contains <tt>nfeeders</tt> feeders which each contain
	 * <tt>nlaterals</tt> lateral nodes, which each contain
	 * <tt>nbranches</tt> branch nodes, which each contain <tt>nleafs</tt>
	 * leaf nodes.
	 *
	 * @param nfeeders  the number of feeders off of the root
	 * @param nlaterals the number of lateral nodes per feeder
	 * @param nbranches the number of branches per lateral
	 * @param nleaves   the number of leaves per branch
	 */
	public Root(int nfeeders, int nlaterals, int nbranches, int nleaves)
	{
		D = new Demand();
		last = new Demand();

		feeders = new Lateral[nfeeders];
		for(int i = 0; i < nfeeders; i++)
			this.feeders[i] = new Lateral(nlaterals, nbranches, nleaves);
	}

	/**
	 * Return true if we've reached a convergence.
	 * @return true if we've finished.
	 */
	public bool reachedLimit()
	{
		return (Math.Abs(D.P / 10000.0 - theta_R) < ROOT_EPSILON && Math.Abs(D.Q / 10000.0 - theta_I) < ROOT_EPSILON);
	}

	/**
	 * Pass prices down and compute demand for the power system.
	 */
	public void compute()
	{
		D.P = 0.0;
		D.Q = 0.0;
		for(int i = 0; i < this.feeders.Length; ++i)
			D.increment(this.feeders[i].compute(theta_R, theta_I, theta_R, theta_I));
	}

	/**
	 * Set up the values for another pass of the algorithm.
	 */
	public void nextIter(double new_theta_R, double new_theta_I)
	{
		last.P = D.P;
		last.Q = D.Q;
		last_theta_R = theta_R;
		last_theta_I = theta_I;
		theta_R = new_theta_R;
		theta_I = new_theta_I;
	}

	/**
	 * Set up the values for another pass of the algorithm.
	 * @param verbose is set to true to print the values of the system.
	 */
	public void nextIter()
	{
		int i = (int)((theta_R - MIN_THETA_R) / PER_INDEX_R);
		if(i < 0)
			i = 0;

		if(i > 35)
			i = 35;

		double d_theta_R = -(theta_R - D.P / 10000.0) / (1.0 - (map_P[i + 1] - map_P[i]) / (PER_INDEX_R * 10000.0));

		i = (int)((theta_I - MIN_THETA_I) / PER_INDEX_I);
		if(i < 0)
			i = 0;

		if(i > 35)
			i = 35;







		theta_R += d_theta_R;
		theta_I += d_theta_I;
	}








}
