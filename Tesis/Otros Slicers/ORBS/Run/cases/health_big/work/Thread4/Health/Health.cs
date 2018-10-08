using System;











public class Health
{



	private static int maxLevel = 5;



	private static int maxTime = 20;



	private static int seed = 1;









	public static void main(int[] args)
	{



		Village top = Village.createVillage(maxLevel, 0, null, seed);




		for(int i = 0; i < maxTime; i++)
			top.simulate();

		Results r = top.getResults();









        var sliceVariable = r.totalPatients;

		Console.WriteLine(sliceVariable);
	}
}
