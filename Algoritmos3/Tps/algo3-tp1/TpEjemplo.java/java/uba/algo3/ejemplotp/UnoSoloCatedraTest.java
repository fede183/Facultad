package uba.algo3.ejemplotp;

import static org.junit.Assert.assertEquals;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Vector;
import org.junit.Test;
import uba.algo3.Utils;


public class UnoSoloCatedraTest {

   @Test
   public void exampleFileRunTest() throws IOException {
      BufferedReader is = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.in" ) ) );
      BufferedWriter os = new BufferedWriter( new FileWriter( getClass().getResource( "" ).getPath() + "Tp1Ej3.out" ) );
      
      String line;
      while ( ( line = is.readLine() ) != null ) {
         Iterator tokens = run( line, is.readLine() ).iterator();
         while ( tokens.hasNext() ){
            os.append( tokens.next().toString() );
            if ( tokens.hasNext() ) {
               os.append( ';' );
            }
            
         }
         os.append( '\n' );
      }
      os.close();
      
   }

   @Test
   public void fullFileRunTest() throws IOException {
      BufferedReader source  = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.full.in" ) ) );
      BufferedReader control = new BufferedReader( new InputStreamReader( getClass().getResourceAsStream( "Tp1Ej3.full.out" ) ) );
      
      String line;
      while ( ( line = source.readLine() ) != null ) {
         checkPath( run( line, source.readLine() ),
                    UnoSoloTest.parseTokens( control.readLine() ) );
      }
      
   }

   private void checkPath( Vector source, Vector control ) {
      assertEquals( source.size(), control.size() );
      Iterator sourceIterator = source.iterator();
      for ( Object token : control ) {
         assertEquals( token, sourceIterator.next() );
      }
   }

   private Vector run( String a, String b ) {
      Vector<Integer> dim = Utils.parseVector( a );
      return new UnoSolo().run( dim.firstElement().intValue(), 
                                dim.lastElement().intValue(),
                                UnoSoloTest.parseTokens( b ) );
   }
  
}