using System;




/**



















 */
public class Power
{





	public static void main(int[] args)
	{
        Root r = new Root(args[0], args[1], args[2], args[3]);

		r.compute();
		r.nextIter(0.7, 0.14);


		while(true)
		{

			r.compute();




			if(r.reachedLimit())
				break;

			r.nextIter();
		}








        var sliceVariable2 = r.last.P;

		Console.WriteLine(sliceVariable2);
	}
}
