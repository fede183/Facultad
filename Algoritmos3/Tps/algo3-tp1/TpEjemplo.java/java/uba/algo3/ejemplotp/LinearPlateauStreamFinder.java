package uba.algo3.ejemplotp;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class LinearPlateauStreamFinder {

   private ListIterator<Integer> vA;
   private ListIterator<Integer> vB;


   public int run( List a, List b ) {
      vA = a.listIterator();
      vB = b.listIterator();
      return run();
   }

   public int run() {
      int old = 0;
      int longPlateaoActual = 1;
      int longPlateaoMax = 1;

      while ( vA.hasNext() || vB.hasNext() ) {
         int neu = findLower().next().intValue();

         if ( neu == old ) {
            longPlateaoActual++;
         } else { // fin del plateao
            longPlateaoMax = Math.max( longPlateaoActual, longPlateaoMax );
            longPlateaoActual = 1;
            old = neu;
         }

      }

      return Math.max( longPlateaoActual, longPlateaoMax );

   }

   private Iterator<Integer> findLower() {
      // elijo menor
      if ( !vA.hasNext() ) {
         return vB;
      } else if ( !vB.hasNext() ) {
         return vA;
      } else if ( vA.next().intValue() < vB.next().intValue() ) {
         vA.previous();
         vB.previous();
         return vA;
      } else {
         vA.previous();
         vB.previous();
         return vB;
      }

   }

}