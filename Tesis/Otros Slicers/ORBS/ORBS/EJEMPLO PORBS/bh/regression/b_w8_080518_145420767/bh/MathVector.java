package bh;







class MathVector implements Cloneable
{



  public final static int NDIM = 3;



  public double data[];




  MathVector()
  {
    data = new double[NDIM];
    for (int i=0; i < NDIM; i++)
      data[i] = 0.0;
  }




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




  final double value(int i)
  {
    return data[i];
  }




  final void value(int i, double v)
  {
    data[i] = v;
  }




  final void unit(int j)
  {
	for (int i=0; i < NDIM; i++)
		data[i] = (i == j ? 1.0 : 0.0);
  }




  final void addition(MathVector u)
  {
    for (int i=0; i < NDIM; i++)
      data[i] += u.data[i];
  }




  final void subtraction(MathVector u)
  {
    for (int i=0; i < NDIM; i++)
      data[i] -= u.data[i];
  }




  final void subtraction(MathVector u, MathVector v)
  {
    for (int i=0; i < NDIM; i++)
      data[i] = u.data[i] - v.data[i];
  }




  final void multScalar(double s)
  {
    for (int i=0; i < NDIM; i++)
      data[i] *= s;
  }




  final void multScalar(MathVector u, double s)
  {
    for (int i=0; i < NDIM; i++)
      data[i] = u.data[i] * s;
  }




  final void divScalar(double s)
  {
    for (int i=0; i < NDIM; i++)
      data[i] /= s;
  }




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
