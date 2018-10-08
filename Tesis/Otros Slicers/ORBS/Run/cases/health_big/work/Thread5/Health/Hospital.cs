using System;







public class Hospital
{
	private int  personnel;
    private int  freePersonnel;

    private HList waiting;
    private HList assess;
    private HList inside;
    private HList up;

	public Hospital(int level)
	{
		personnel = 1 << (level - 1);
		freePersonnel = personnel;

        waiting = new HList();
        assess = new HList();
        inside = new HList();
        up = new HList();
	}




	public void putInHospital(Patient p)
	{


		if(freePersonnel > 0)
		{
			freePersonnel = freePersonnel - 1;
			assess.add(p);
			p.timeLeft = 3;

		}
		else
			waiting.add(p);
	}






    public void checkPatientsInside(HList returned)
	{
        for (HList.ListEnumerator e = inside.elements(); e.hasMoreElements(); ) 
		{
		  Patient p = (Patient)e.nextElement();
		  p.timeLeft -= 1;
		  if (p.timeLeft == 0) 
		  {


			returned.add(p);
		  }
		}
	}




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

			waiting.delete(p);
			assess.add(p);
		  } 


		}
	}
}
