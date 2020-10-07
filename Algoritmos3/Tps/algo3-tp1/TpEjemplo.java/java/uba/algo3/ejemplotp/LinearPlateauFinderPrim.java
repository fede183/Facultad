package uba.algo3.ejemplotp;



public class LinearPlateauFinderPrim {

   private int[] vA;
   private int[] vB;

   int ia; 
   int ib;

   public int run( int[] a, int[] b ) {
      vA = a;
      vB = b;
      ia = 0; 
      ib = 0;
      return run();
   }
   
   public int run() {

      int old = findLower();
      int longPlateaoActual = 1;
      int longPlateaoMax = 1;

      while ( ia < vA.length || ib < vB.length ) {
         if ( ia < vA.length && vA[ ia ] == old ) {
            ia++;
            longPlateaoActual++;
         } else if ( ib < vB.length && vB[ ib ] == old ) {
            ib++;
            longPlateaoActual++;
         } else { // fin de Plateao
            longPlateaoMax = Math.max( longPlateaoActual, longPlateaoMax );

            old = findLower();
            longPlateaoActual = 1;
         }

      }

      return Math.max( longPlateaoActual, longPlateaoMax );

   }


   private int findLower() {
      int old;

      // elijo menor
      if ( ia == vA.length ) {
         old = vB[ ib ];
         ib++;
      } else if ( ib == vB.length ) {
         old = vA[ ia ];
         ia++;
      } else if ( vA[ ia ] < vB[ ib ] ) {
         old = vA[ ia ];
         ia++;
      } else {
         old = vB[ ib ];
         ib++;
      }

      return old;
   }

}