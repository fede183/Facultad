package main;
import bh.BH;
//import bisort.BiSort;
//import em3d.Em3d;
//import health.Health;
//import perimeter.Perimeter;
//import power.Power;
//import tsp.TSP;
//import mst.MST;

public class Program 
{
	public static void main(String[] args)
	{
		// 1er argumento: Nro. de programa. 
		// 2do argumento: Input del programa
		
		// Nros de programa:
		// BH = 1
		// BiSort = 2
		// Em3d = 3
		// Health = 4
		// Perimeter = 5
		// Power = 6
		// TSP = 7
		// MST = 8
		
		int programNumber;
		int[] programInputs;
		boolean readArgs = true;
		if (readArgs) 
		{
			programNumber = Integer.parseInt(args[0]);
			programInputs = new int[args.length - 1];
		    for(int i=1; i < args.length; i++)
		    	programInputs[i-1] = Integer.parseInt(args[i].trim());
		}
		else	
		{
			// Para debuguear:
			//programNumber = 1;
			//programInputs = new int[] { 40, 10 };
			
			programNumber = 8;
			programInputs = new int[] { 20 };
		}
		
		switch(programNumber) 
		{
			case 1:
				// Inputs originales { 40, 10 }
				// Inputs chicos { 2, 10 }
				BH.main(programInputs);
				break;
			case 2:
				//BiSort.main(programInputs);
				break;
			case 3:
				// Inputs originales { 50, 10, 3 }
				//Em3d.main(programInputs);	
				break;
			case 4:
				// Inputs originales { 5, 20 }
				// Inputs chicos { 2, 8 }
				//Health.main(programInputs);
				break;
			case 5:
				// Inputs originales { 12 }
				// Inputs chicos { 10 }
				//Perimeter.main(programInputs);
				break;
			case 6:
				// Inputs originales { 10, 20, 5, 10 }
				// Inputs chicos { 2, 4, 1, 2 }
				//Power.main(programInputs);
				break;
			case 7:
				// Inputs originales { 20 }
				//TSP.main(programInputs);
				break;
			case 8:
				// Inputs originales { Integer desconocido... }
				//MST.main(programInputs);
				break;
		}
		
        return;
	}
}

