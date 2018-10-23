package bh;

  /**
   * A class which is used to compute and save information during the 
   * gravity computation phse.
   **/
  class HG
  {
    /**
     * Body to skip in force evaluation
     **/
    Body       pskip;
    /**
     * Point at which to evaluate field
     **/
    MathVector pos0;  
    /**
     * Computed potential at pos0
     **/
    double     phi0;  
    /** 
     * computed acceleration at pos0
     **/
    MathVector acc0;  
   
    /**
     * Create a HG  object.
     **/
    HG(Body b, MathVector p)
    {
      pskip = b;
      pos0  = (MathVector)p.clone();
      phi0  = 0.0;
      acc0  = new MathVector();
    }
  }
  