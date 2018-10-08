using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;


namespace Jolden
{
    class Program
    {
        static void Main(string[] args)
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
            var readArgs = true;
            if (readArgs)
            {
                programNumber = int.Parse(args[0]);
                programInputs = new int[args.Length - 1];
                for (int i = 1; i < args.Length; i++)
                    programInputs[i-1] = int.Parse(args[i].Trim());
            }
            else
            {
                // Para debuguear:
                programNumber = 5;
                programInputs = new int[] { 10 };
            }

            switch (programNumber)
            {
                case 1:
                    // Inputs originales { 40, 10 }
                    // Inputs chicos { 2, 10 }
                    BH.main(programInputs);
                    break;
                case 2:
                    BiSort.main(programInputs);
                    break;
                case 3:
                    // Inputs originales { 10, 3 }
                    Em3d.main(programInputs);
                    break;
                case 4:
                    // Inputs originales { 5, 20 }
                    // Inputs chicos { 2, 8 }
                    Health.main(programInputs);
                    break;
                case 5:
                    // Inputs originales { 12 }
                    // Inputs chicos { 10 }
                    Perimeter.main(programInputs);
                    break;
                case 6:
                    // Inputs originales { 10, 20, 5, 10 }
                    // Inputs chicos { 2, 4, 1, 2 }
                    Power.main(programInputs);
                    break;
                case 7:
                    // Inputs originales { 20 }
                    TSP.main(programInputs);
                    break;
                case 8:
                    MST.main(programInputs);
                    break;
            }

            return;
        }
    }
}
