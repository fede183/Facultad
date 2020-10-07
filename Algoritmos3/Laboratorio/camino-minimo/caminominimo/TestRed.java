package uba.algo3.caminominimo;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class TestRed {

   @Test
   public void test0() {
      Red red = new Red()
                  .unir( 0, 1, 10 )
                  .unir( 0, 2, 10 )
                  .unir( 1, 2, 10 );
      
      assertEquals( 10, red.solve( 0, 2 ) );
   }

   @Test
   public void test1() {
      Red red = new Red()
               .unir( 0, 1, 10 )
               .unir( 0, 2, 15 )
               .unir( 2, 4, 15 )
               .unir( 4, 6, 15 )
               .unir( 6, 8, 15 )
               .unir( 1, 3, 10 )
               .unir( 3, 5, 10 )
               .unir( 5, 7, 10 )
               .unir( 7, 8, 10 );
      assertEquals( 50, red.solve( 0, 8 ) );
   }

   @Test
   public void test2() {
      Red red = new Red();
               
      for ( int i = 0; i < 15; i++ ) {
         for ( int j = 0; j < 15; j++ ) {
            if ( ((i + j) * (i + j) * (i + j)) % 17 < 3 ) {
               red.unir( i, j, 10 );
            } else if ( ((i + j) * (i + j)) % 5 == 3 ) {
               red.unir( i, j, 15 );
            }
         }
      }
      assertEquals( 50, red.solve( 0, 3 ) );

   }

   @Test
   public void test3() {
      Red red = new Red();

      for ( int i = 0; i < 50; i++ ) {
         if ( i + 3 < 50 ) {
            red.unir( i, i + 3, 10 );
         }
         if ( i + 4 < 50 ) {
            red.unir( i, i + 4, 15 );
         }
      }
      assertEquals( 165, red.solve( 0, 49 ) );
   }

   @Test
   public void test4() {
      Red red = new Red();

      for ( int i = 0; i < 10007; i++ ) {
         red.unir( i,  ((i + 2) * (i + 2)) % 10007, 10 );
         red.unir( i,  ((i + 2) * (i + 2) * (i + 2)) % 10007, 15 );
      }
      assertEquals( 175, red.solve( 1000, 2000 ) );
   }
   
}