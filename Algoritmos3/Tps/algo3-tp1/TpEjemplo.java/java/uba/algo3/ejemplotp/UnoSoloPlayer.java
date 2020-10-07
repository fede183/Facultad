package uba.algo3.ejemplotp;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;



public class UnoSoloPlayer {

   int filas;
   int columnas;
   
   public void check( int fila, int columna, List tokens, List testPath ) {
      filas = fila;
      columnas = columna;
      run( testPath, new Vector( tokens ) );
   }
   

   public void run( List<Token> path, List<Token> tokens ) {
      Iterator<Token> stream = new Vector( path ).iterator();
      
      while( stream.hasNext() ) {
         Token origin = stream.next();
         Token dest = stream.next();

         assertTrue( origin.within( filas, columnas ) ); 
         assertTrue( dest.within( filas, columnas ) );
         assertTrue( tokens.contains( origin ) );
         assertTrue( tokens.contains( origin.between( dest ) ) );
         assertFalse( tokens.contains( dest ) );
         
         tokens.remove( origin );
         tokens.remove( origin.between( dest ) );
         tokens.add( dest );
         
      } 
      assertEquals( 1, tokens.size() );

   }

   
}
