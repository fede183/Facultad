using System;

/**
 * A class representing a three dimensional vector that implements
 * several math operations.  To improve speed we implement the
 * vector as an array of doubles rather than use the exising
 * code in the java.util.Vector class.
 */
public class MathVector
{
	/**
	 * The number of dimensions in the vector
	 */
	public static readonly int NDIM = 3;
	/**
	 * An array containing the values in the vector.
	 */
	public double[] data;
	
	/**
    * Construct an empty 3 dimensional vector for use in Barnes-Hut algorithm.
    **/
	public MathVector()
	{
		data = new double[NDIM];
		for (int i=0; i < NDIM; i++)
			data[i] = 0.0;
	}

	/**
	 * Create a copy of the vector.
	 */
	public MathVector clone()
	{
		try
		{
			MathVector v = new MathVector();
			v.data = new double[NDIM];
			for(int i = 0; i < NDIM; i++)
				v.data[i] = data[i];
			return v;
		}
		catch(Exception ex) 
		{
			throw;
		}
	}

	/**
	 * Return the value at the i'th index of the vector.
	 */
	public double value(int i)
	{
		return data[i];
	}

	/**
	 * Set the value of the i'th index of the vector.
	 */
	public void setValue(int i, double v)
	{
		data[i] = v;
	}

	/**
	 * Set one of the dimensions of the vector to 1.0
	 */
	public void unit(int j)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = (i == j ? 1.0 : 0.0);
	}

	/**
	 * Add two vectors and the result is placed in this vector.
	 */
	public void addition(MathVector u)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] + u.data[i];
	}

	/**
	 * Subtract two vectors and the result is placed in this vector this vector contain the first operand.
	 */
	public void subtraction(MathVector u)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] - u.data[i];
	}

	/**
	 * Subtract two vectors and the result is placed in this vector.
	 */
	public void subtraction(MathVector u, MathVector v)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = u.data[i] - v.data[i];
	}

	/**
	 * Multiply the vector times a scalar.
	 */
	public void multScalar(double s)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] * s;
	}

	/**
	 * Multiply the vector times a scalar and place the result in this vector.
	 */
	public void multScalar(MathVector u, double s)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = u.data[i] * s;
	}

	/**
	 * Divide each element of the vector by a scalar value.
	 */
	public void divScalar(double s)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] / s;
	}

	/**
	 * Return the dot product of a vector.
	 */
	public double dotProduct()
	{
		double s = 0.0;
		for(int i = 0; i < NDIM; i++)
			s += data[i] * data[i];
		return s;
	}

	public double absolute()
	{
		double tmp = 0.0;
		for(int i = 0; i < NDIM; i++)
			tmp += data[i] * data[i];

		return Math.Sqrt(tmp);
	}

	public double distance(MathVector v)
	{
		double tmp = 0.0;
		for(int i = 0; i < NDIM; i++)
			tmp += ((data[i] - v.data[i]) * (data[i] - v.data[i]));

		return Math.Sqrt(tmp);
	}

	public void crossProduct(MathVector u, MathVector w)
	{
		data[0] = u.data[1] * w.data[2] - u.data[2] * w.data[1];
		data[1] = u.data[2] * w.data[0] - u.data[0] * w.data[2];
		data[2] = u.data[0] * w.data[1] - u.data[1] * w.data[0];
	}

	public void incrementalAdd(MathVector u)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] + u.data[i];
	}

	public void incrementalSub(MathVector u)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] - u.data[i];
	}

	public void incrementalMultScalar(double s)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] * s;
	}

	public void incrementalDivScalar(double s)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = data[i] / s;
	}

	/**
	 * Add a scalar to each element in the vector and put the result in this vector
	 */
	public void addScalar(MathVector u, double s)
	{
		for(int i = 0; i < NDIM; i++)
			data[i] = u.data[i] + s;
	}

	public string toString()
	{
		System.Text.StringBuilder sb = new System.Text.StringBuilder();
		for(int i = 0; i < NDIM; i++)
				sb.Append(this.data[i] + " ");
		return sb.ToString();
	}
}
