﻿using System;
using System.IO;
using System.Collections.Generic;
using System.Text;

/**
 * A class representing a hospital in the Columbian health care system.
 */
public class Hospital
{
	private int  personnel;
    private int  freePersonnel;
    private int  numWaitingPatients;
    private HList waiting;
    private HList assess;
    private HList inside;
    private HList up;

	public Hospital(int level)
	{
		personnel = 1 << (level - 1);
		freePersonnel = personnel;
		numWaitingPatients = 0;
        waiting = new HList();
        assess = new HList();
        inside = new HList();
        up = new HList();
	}

	/**
	 * Add a patient to this hospital
	 */
	public void putInHospital(Patient p)
	{
		int num = p.hospitalsVisited;
		p.hospitalsVisited = p.hospitalsVisited + 1;
		if(freePersonnel > 0)
		{
			freePersonnel = freePersonnel - 1;
			assess.add(p);
			p.timeLeft = 3;
			p.time += 3;
		}
		else
			waiting.add(p);
	}

	/**
	 * Check the patients inside the hospital to see if any are finished.
	 * If so, then free up the personnel and and the patient to the returned
	 * list.
	 */
    public void checkPatientsInside(HList returned)
	{
        for (HList.ListEnumerator e = inside.elements(); e.hasMoreElements(); ) 
		{
		  Patient p = (Patient)e.nextElement();
		  p.timeLeft -= 1;
		  if (p.timeLeft == 0) 
		  {
			freePersonnel++;
			inside.delete(p);
			returned.add(p);
		  }
		}
	}

	/**
	 * Asses the patients in the village.
	 */
	public HList checkPatientsAssess(Village v)
	{
        HList up = new HList();
		for (HList.ListEnumerator e = assess.elements(); e.hasMoreElements(); ) 
		{
		  Patient p = (Patient)e.nextElement();
		  p.timeLeft -= 1;
		  if (p.timeLeft == 0) 
		  {
			if (v.staysHere()) 
			{
			  assess.delete(p);
			  inside.add(p);
			  p.timeLeft = 10;
			  p.time += 10;
			} 
			else 
			{
			  freePersonnel++;
			  assess.delete(p);
			  up.add(p);
			}
		  }
		}
		return up;
	}

	public void checkPatientsWaiting()
	{
        for (HList.ListEnumerator e = waiting.elements(); e.hasMoreElements(); ) 
		{
		  Patient p = (Patient)e.nextElement();
		  if (freePersonnel > 0) 
		  {
			freePersonnel--;
			p.timeLeft = 3;
			p.time += 3;
			waiting.delete(p);
			assess.add(p);
		  } 
		  else 
			p.time++;
		}
	}
}
