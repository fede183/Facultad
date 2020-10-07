package uba.algo3.ejemplotp;

import java.util.Vector;
import org.junit.BeforeClass;
import org.junit.Test;


public class UnoSoloStressTest {
   static private Vector tokens;
   
   @BeforeClass
   static public void beforeClass() {
      tokens = UnoSoloTest.parseTokens( "1 4; 1 6; 2 2; 2 3; 2 7; 3 2; 4 1; 5 3; 5 4; 5 6; 6 3; 6 5; 6 6; 7 3" );
   }

   @Test
   public void just1RunTest() {
      UnoSolo us = new UnoSolo();

      long l = System.currentTimeMillis();
      us.run( 8, 7, tokens );
      System.out.println( System.currentTimeMillis() - l );
     
   }
       
   @Test
   public void just2RunTest() {
      UnoSolo us = new UnoSolo();

//      us.run( 8, 7, tokens );
//      us.run( 8, 7, tokens );
//      us.run( 8, 7, tokens );
//      us.run( 8, 7, tokens );
//      us.run( 8, 7, tokens );
      us.run( 8, 7, tokens );
      us.run( 8, 7, tokens );
      us.run( 8, 7, tokens );
      us.run( 8, 7, tokens );
      us.run( 8, 7, tokens );
      long l = System.currentTimeMillis();
      us.run( 8, 7, tokens );
      System.out.println( System.currentTimeMillis() - l );
 
      l = System.currentTimeMillis();
      us.run( 8, 7, tokens );
      System.out.println( System.currentTimeMillis() - l );
       
   }
       
}