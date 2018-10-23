package bh;

/**
 * A class representing a three dimensional vector that implements
 * several math operations.  To improve speed we implement the
 * vector as an array of doubles rather than use the exising
 * code in the java.util.Vector class.
 **/
class MathVector implements Cloneable
{
  /**
   * The number of dimensions in the vector
   **/
  public final static int NDIM = 3;
  /**
   * An array containing the values in the vector.
   **/
  public double data[];

  /**
   * Construct an empty 3 dimensional vector for use in Barnes-Hut algorithm.
   **/
  MathVector()
  {
    data = new double[NDIM];
    for (int i=0; i < NDIM; i++)
      data[i] = 0.0;
  }

  /**
   * Create a copy of the vector.
   **/
  public Object clone() 
  {
    try 
	{
      MathVector v = (MathVector)super.clone();
      v.data = new double[NDIM];
      for (int i = 0; i < NDIM; i++)
		v.data[i] = data[i];
      return v;
    } 
	catch (CloneNotSupportedException e) 
	{
		throw new Error();
    }
  }

  /**
   * Return the value at the i'th index of the vector.
   **/
  final double value(int i)
  {
    return data[i];
  }

  /**
   * Set the value of the i'th index of the vector.
   **/
  final void value(int i, double v)
  {
    data[i] = v;
  }

  /**
   * Set one of the dimensions of the vector to 1.0
   **/
  final void unit(int j)
  {
	for (int i=0; i < NDIM; i++)
		data[i] = (i == j ? 1.0 : 0.0);
  }

  /**
   * Add two vectors and the result is placed in this vector.
   **/
  final void addition(MathVector u)
  {
    for (int i=0; i < NDIM; i++)
      data[i] += u.data[i];
  }

  /**
   * Subtract two vectors and the result is placed in this vector this vector contain the first operand.
   **/
  final void subtraction(MathVector u)
  {
    for (int i=0; i < NDIM; i++)
      data[i] -= u.data[i];
  }

  /**
   * Subtract two vectors and the result is placed in this vector.
   **/
  final void subtraction(MathVector u, MathVector v)
  {
    for (int i=0; i < NDIM; i++)
      data[i] = u.data[i] - v.data[i];
  }

  /**
   * Multiply the vector times a scalar.
   **/
  final void multScalar(double s)
  {
    for (int i=0; i < NDIM; i++)
      data[i] *= s;
  }

  /**
   * Multiply the vector times a scalar and place the result in this vector.
   **/
  final void multScalar(MathVector u, double s)
  {
    for (int i=0; i < NDIM; i++)
      data[i] = u.data[i] * s;
  }

  /**
   * Divide each element of the vector by a scalar value.
   **/
  final void divScalar(double s)
  {
    for (int i=0; i < NDIM; i++)
      data[i] /= s;
  }

  /**
   * Return the dot product of a vector.
   **/
  final double dotProduct()
  {
    double s = 0.0;
    for (int i=0; i < NDIM; i++)
      s += data[i] * data[i];
    return s;
  }

  final double absolute()
  {
    double tmp = 0.0;
    for (int i = 0; i < NDIM; i++)
      tmp += data[i] * data[i];

    return Math.sqrt(tmp);
  }

  final double distance(MathVector v)
  {
    double tmp = 0.0;
    for (int i = 0; i < NDIM; i++)
      tmp += ((data[i] - v.data[i]) * (data[i] - v.data[i]));

    return Math.sqrt(tmp);
  }

  final void crossProduct(MathVector u, MathVector w)
  {
    data[0] = u.data[1] * w.data[2] - u.data[2]*w.data[1];
    data[1] = u.data[2] * w.data[0] - u.data[0]*w.data[2];
    data[2] = u.data[0] * w.data[1] - u.data[1]*w.data[0];
  }

  final void incrementalAdd(MathVector u)
  {
    for (int i = 0; i < NDIM; i++)
      data[i] += u.data[i];
  }

  final void incrementalSub(MathVector u)
  {
    for (int i = 0; i < NDIM; i++)
      data[i] -= u.data[i];
  }

  final void incrementalMultScalar(double s) 
  {
    for (int i=0; i < NDIM; i++)
      data[i] *= s;
  }

  final void incrementalDivScalar(double s)
  {
    for (int i=0; i < NDIM; i++)
      data[i] /= s;
  }

  /**
   * Add a scalar to each element in the vector and put the result in this vector
   **/
  final void addScalar(MathVector u, double s) 
  {
    for (int i = 0; i < NDIM; i++)
      data[i] = u.data[i] + s;
  }

  public String toString()
  {
    StringBuffer s = new StringBuffer();
    for (int i = 0; i < NDIM; i++)
      s.append(data[i] + " ");
    return s.toString();
  }
}
