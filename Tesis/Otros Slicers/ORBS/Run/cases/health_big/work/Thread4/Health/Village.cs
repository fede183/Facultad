using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * A class represnting a village in the Columbian health care system
 * simulation.
 */
public class Village
{
	private Village[] forward;
	private Village   back;
	private HList returned;
	private Hospital hospital;
	private int label;
	public int seed;

	public static int IA = 16807;
	public static double IM = 2147483647.0;
	public static double AM = (1.0 / IM);
	public static int IQ = 127773;
	public static int IR = 2836;
	public static int MASK = 123459876;

	/**
	 * Construct an empty village.
	 */
	public Village(int level, int l, Village p, int s)
	{
		back = p;
		label = l;
		forward = new Village[4];
		seed = label * (IQ + s);
		hospital = new Hospital(level);
		returned = new HList();
	}

	/**
	* Add a connection from this village to the specifed village.
	* Each village contains connections to four other ones.
	**/
	void addVillage(int i, Village c)
	{
		forward[i] = c;
	}

	/**
	 * Return true if a patient should stay in this village or
	 * move up to the "parent" village.
	 */
	public bool staysHere()
	{
		double rand = myRand(seed);
		seed = (int)(rand * IM);
		return (rand > 0.1 || back == null);
	}

	/**
	 * Create a set of villages.  Villages are represented as a quad tree.
	 * Each village contains references to four other villages.  Users
	 * specify the number of levels.
	 */
	public static Village createVillage(int level, int label, Village back, int seed)
	{
		if(level == 0)
			return null;
		else
		{
            Village village = new Village(level, label, back, seed);
			for(int i = 3; i >= 0; i--)
			{
				Village child = createVillage(level - 1, (label * 4) + i + 1, village, seed);
				village.addVillage(i, child);
			}
			return village;
		}
	}

	/**
	 * Simulate the Columbian health care system for a village.
	 */
	public HList simulate()
	{
		// the list of patients refered from each child village
        HList[] val = new HList[4];

		for (int i = 3; i >= 0; i--) 
		{
		  Village v = forward[i];
		  if (v != null)
			val[i] = v.simulate();
		}

		for (int i = 3; i >= 0; i--) 
		{
		  HList l = val[i];
		  if (l != null) 
		  {
			for (var e = l.elements(); e.hasMoreElements(); ) 
			{
				Patient p = (Patient)e.nextElement();
				hospital.putInHospital(p);
			}
		  }
		}

		hospital.checkPatientsInside(returned);
		HList up = hospital.checkPatientsAssess(this);
		hospital.checkPatientsWaiting();

		// generate new patients
		Patient p2 = generatePatient();
		if (p2 != null)
		  hospital.putInHospital(p2);

		return up;
	}

	/**
	 * Summarize results of the simulation for the Village
	 */
	public Results getResults()
	{
        Results[] fval = new Results[4];
		for (int i = 3; i >=0 ; i--) 
		{
		  Village v = forward[i];
		  if (v != null)
			fval[i] = v.getResults();
		}

		Results r = new Results();
		for (int i = 3; i >= 0; i--) 
		{
		  if (fval[i] != null) 
		  {
			r.totalHospitals += fval[i].totalHospitals;
			r.totalPatients += fval[i].totalPatients;
			r.totalTime += fval[i].totalTime;
		  }
		}

		for (var e = returned.elements(); e.hasMoreElements(); ) 
		{
		  Patient p = (Patient)e.nextElement();
		  r.totalHospitals += (float)p.hospitalsVisited;
		  r.totalTime += (float)p.time;
		  r.totalPatients += 1.0;
		}

		return r;
	}

	/**
	 * Try to generate more patients for the village.
	 */
	private Patient generatePatient()
	{
		double rand = myRand(seed);
		seed = (int)(rand * IM);
		Patient p = null;
		if(rand > 0.666)
			p = new Patient(this);

		return p;
	}

	public string toString()
	{
		return label.ToString();
	}

	/**
	 * Random number generator.
	 */
	public static double myRand(int idum)
	{
		idum = idum ^ MASK;
		int k = idum / IQ;
		idum = IA * (idum - k * IQ) - IR * k;
		idum = idum ^ MASK;
		if(idum < 0)
			idum += (int)Math.Floor(IM);

		double answer = AM * ((double)idum);
		return answer;
	}
}
