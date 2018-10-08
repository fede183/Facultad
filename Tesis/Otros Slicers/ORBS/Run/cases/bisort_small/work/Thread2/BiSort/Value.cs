








	private Value left;
	private Value right;

    public static bool FORWARD = false;



    private static int CONST_m1 = 10000;
    private static int CONST_b = 31415821;
    public static int RANGE = 100;







    Value(int v)
    {
        value = v;

    }








	public static Value createTree(int size, int seed)
	{
		if(size > 1)
		{
			seed = random(seed);
			int next_val = seed % RANGE;

			Value retval = new Value(next_val);
			retval.left = createTree(size / 2, seed);
			retval.right = createTree(size / 2, skiprand(seed, size + 1));
			return retval;
		}

			return null;
	}








	public int bisort(int spr_val, bool direction)
	{
		if(left == null)
		{






		}
		else
		{
			int val = value;
			value = left.bisort(val, direction);
			bool ndir = !direction;
			spr_val = right.bisort(spr_val, ndir);
			spr_val = bimerge(spr_val, direction);
		}
		return spr_val;
	}








	public int bimerge(int spr_val, bool direction)
	{
		int rv = value;
		Value pl = left;
		Value pr = right;

		bool rightexchange = (rv > spr_val) ^ direction;
		if(rightexchange)
		{
			value = spr_val;
			spr_val = rv;
		}

		while(pl != null)
		{
			int lv = pl.value;
			Value pll = pl.left;
			Value plr = pl.right;
			rv = pr.value;
			Value prl = pr.left;
			Value prr = pr.right;

			bool elementexchange = (lv > rv) ^ direction;
			if(rightexchange)
			{
				if(elementexchange)
				{
					pl.swapValRight(pr);
					pl = pll;
					pr = prl;
				}
				else
				{
					pl = plr;
					pr = prr;
				}
			}
			else
			{
				if(elementexchange)
				{
					pl.swapValLeft(pr);
					pl = plr;
					pr = prr;
				}
				else
				{
					pl = pll;
					pr = prl;
				}
			}
		}

		if(left != null)
		{
			value = left.bimerge(value, direction);
			spr_val = right.bimerge(spr_val, direction);
		}
		return spr_val;
	}





	public void swapValRight(Value n)
	{
		int tmpv = n.value;
		Value tmpr = n.right;

		n.value = value;
		n.right = right;

		value = tmpv;
		right = tmpr;
	}





	public void swapValLeft(Value n)
	{



		n.value = value;




	}





















	private static int mult(int p, int q)
	{
		int p1 = p / CONST_m1;
		int p0 = p % CONST_m1;
		int q1 = q / CONST_m1;
		int q0 = q % CONST_m1;
		return (((p0 * q1 + p1 * q0) % CONST_m1) * CONST_m1 + p0 * q0);
	}






	private static int skiprand(int seed, int n)
	{
		int i;
		for(i = n; i != 0; i--)
			seed = random(seed);
		return seed;
	}






	public static int random(int seed)
	{
		int tmp = mult(seed, CONST_b) + 1;
		return tmp;
	}
}
