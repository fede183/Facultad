package bh;





  class HG
  {



    Body       pskip;



    MathVector pos0;  



    double     phi0;  



    MathVector acc0;  




    HG(Body b, MathVector p)
    {
      pskip = b;
      pos0  = (MathVector)p.clone();
      phi0  = 0.0;
      acc0  = new MathVector();
    }
  }

