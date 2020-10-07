package uba.algo3.ejemplotp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;
import org.junit.Test;


public class TokenTest {

   @Test 
   public void equalTest() {
      assertTrue( new Token( 1, 3 ).equals( new Token( 1, 3 ) ) );
      assertFalse( new Token( 1, 3 ).equals( new Token( 1, 2 ) ) );
      assertFalse( new Token( 1, 3 ).equals( "Token" ) );
      assertFalse( new Token( 1, 3 ) == new Token( 1, 3 ) );

      assertEquals( new Token( 1, 3 ), new Token( 1, 3 ) );
      assertNotSame( new Token( 1, 3 ), new Token( 1, 3 ) );
      
   }
   
   @Test 
   public void betweenTest() {
      assertEquals( new Token( 1, 4 ), new Token( 1, 3 ).between( new Token( 1, 5 ) ) );                 
      assertEquals( new Token( 1, 2 ), new Token( 1, 3 ).between( new Token( 1, 1 ) ) );                 

      assertEquals( new Token( 4, 1 ), new Token( 3, 1 ).between( new Token( 5, 1 ) ) );                 
      assertEquals( new Token( 2, 1 ), new Token( 3, 1 ).between( new Token( 1, 1 ) ) );                 

   }

   @Test 
   public void withinTest() {
      assertTrue( new Token( 1, 3 ).within( 3, 3 ) );
      assertTrue( new Token( 3, 3 ).within( 3, 3 ) );
      assertTrue( new Token( 1, 1 ).within( 3, 3 ) );
      assertTrue( new Token( 3, 1 ).within( 3, 3 ) );

      assertFalse( new Token( 0, 3 ).within( 3, 3 ) );
      assertFalse( new Token( 0, 4 ).within( 3, 3 ) );
      assertFalse( new Token( 4, 3 ).within( 3, 3 ) );
      assertFalse( new Token( 4, 4 ).within( 3, 3 ) );
      assertFalse( new Token( 0, 0 ).within( 3, 3 ) );
      assertFalse( new Token( 3, 0 ).within( 3, 3 ) );
      
   }

}
