package uba.algo3.ejemplotp;

import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.Vector;
import org.junit.Test;


public class UnoSoloTest {

   @Test
   public void simpleColumnTest() {
      UnoSolo us = new UnoSolo();

      // X  
      // X   
      // 0   
      checkPath( us.run( 3, 1, UnoSoloTest.parseTokens( "1 1; 2 1" ) ),
                 UnoSoloTest.parseTokens( "1 1; 3 1" ) );
      
      // X  
      // X   
      // X   
      checkPath( us.run( 3, 1, UnoSoloTest.parseTokens( "1 1; 2 1; 3 1" ) ),
                 new Vector() );
      
      // X  
      // X   
      // X   
      // 0   
      checkPath( us.run( 4, 1, UnoSoloTest.parseTokens( "1 1; 2 1; 3 1" ) ),
                 new Vector() );
      
      // 0  
      // X   
      // X   
      // X   
      checkPath( us.run( 4, 1, UnoSoloTest.parseTokens( "4 1; 2 1; 3 1" ) ),
                 new Vector() );
      // X  
      // X   
      // 0   
      // X   
      checkPath( us.run( 4, 1, UnoSoloTest.parseTokens( "4 1; 2 1; 1 1" ) ),
                 UnoSoloTest.parseTokens( "1 1; 3 1; 4 1; 2 1" ) );

      // 0  
      // X   
      // X   
      checkPath( us.run( 3, 1, UnoSoloTest.parseTokens( "2 1; 3 1" ) ),
                 UnoSoloTest.parseTokens( "3 1; 1 1" ) );
      
   }

   @Test
   public void simpleRowTest() {
      UnoSolo us = new UnoSolo();

      // X X 0  
      checkPath( us.run( 1, 3, UnoSoloTest.parseTokens( "1 1; 1  2" ) ),
                 UnoSoloTest.parseTokens( "1 1; 1 3" ) );

      // X X X  
      checkPath( us.run( 1, 3, UnoSoloTest.parseTokens( "1 1; 1 2; 1 3" ) ),
      new Vector() );
      
      // X X X 0  
      checkPath( us.run( 1, 4, UnoSoloTest.parseTokens( "1 1; 1 2; 1 3" ) ),
      new Vector() );
      
      // 0 X X X  
      checkPath( us.run( 1, 4, UnoSoloTest.parseTokens( "1 4; 1 2; 1 3" ) ),
      new Vector() );

      // X X 0 X  
      checkPath( us.run( 1, 4, UnoSoloTest.parseTokens( "1 4; 1 2; 1 1" ) ),
                 UnoSoloTest.parseTokens( "1 1; 1 3; 1 4; 1 2" ) );


      // 0 X X   
      checkPath( us.run( 1, 3, UnoSoloTest.parseTokens( "1  2; 1 3" ) ),
                 UnoSoloTest.parseTokens( "1 3; 1 1" ) );
   }


   @Test
   public void simpleTwoHopsTest() {
      UnoSolo us = new UnoSolo();

      // X X 0 
      // 0 0 X 
      // 0 0 0 
      checkPath( us.run( 3, 3, parseTokens( "1  1; 1 2; 2 3" ) ),
                 parseTokens( "1 1; 1 3; 1 3; 3 3" ) );
      
      // X X 0 X
      // 0 0 0 0
      // 0 0 0 0
      checkPath( us.run( 3, 4, parseTokens( "1  1; 1 2; 1 4" ) ),
                 parseTokens( "1 1; 1 3; 1 4; 1 2" ) );
      
   }
   
   @Test
   public void simpleLongHopsTest() {
      UnoSolo us = new UnoSolo();

      // X X 0 0 
      // 0 X X 0
      // 0 0 0 X 
      // 0 0 0 0 
      // 0 X 0 0 
      Vector tokens = parseTokens( "1 1; 1 2; 2 2; 2 3; 3 4; 5 2" ); 
      Vector control = parseTokens( "1 1; 1 3; 1 3; 3 3; 3 4; 3 2; 2 2; 4 2; 5 2; 3 2" );
      checkPath( us.run( 6, 4, tokens ),
                 control );

      UnoSoloPlayer usp = new UnoSoloPlayer();
      usp.check( 6, 4, tokens, control);
      
   }

   private void checkPath( Vector source, Vector control ) {
      assertEquals( source.size(), control.size() );
      Iterator sourceIterator = source.iterator();
      for ( Object token : control ) {
         assertEquals( token, sourceIterator.next() );
      }
   }

   public static Vector parseTokens( String line ) {
      Vector in = new Vector();

      StringTokenizer st = new StringTokenizer( line, ";" );
      while ( st.hasMoreTokens() ) {
         in.add( parseToken( st.nextToken() ) );
      }

      return in;
   }

   private static Token parseToken( String string ) {
      StringTokenizer st = new StringTokenizer( string, " " );
      return new Token( Integer.parseInt( st.nextToken() ), Integer.parseInt( st.nextToken() ) );
   }   
}