package uba.algo3.ejemplotp;

import java.util.List;
import java.util.Stack;
import java.util.Vector;



public class UnoSolo {

//   static public enum Direction { Right, Left, Top, Bottom    }
   
   private Stack path;
   private int filas;
   private int columnas;
   
   public Vector run( int fila, int columna, List tokens ) {
      filas = fila;
      columnas = columna;
      path = new Stack();
      run( tokens );
      return path;
   }

   public boolean run( List<Token> tokens ) {
      
      for ( Token ficha: tokens ) {
         Vector reduced = new Vector( tokens );
         reduced.remove( ficha );
         
         for ( Direction dir: Direction.all() ) {
            if ( mayTry( ficha, reduced, dir ) ) {
               return true;
            } 
         }
      } 
      
      return false;
   }

   private boolean mayTry( Token ficha, List<Token> tokens, Direction dir ) {
      return mayLand( ficha, dir ) && 
             !tokens.contains( dir.move( dir.move( ficha ) )) &&
             tokens.contains( dir.move( ficha ) ) && 
             moveSuccesful( ficha, tokens, dir );
      
   }

   private boolean moveSuccesful( Token ficha, List<Token> tokens, Direction dir ) {
      tokens.remove( dir.move( ficha ) );
      tokens.add( dir.move( dir.move( ficha ) ));
      
      path.push( ficha );
      path.push( dir.move( dir.move( ficha ) ));
      
      if ( tokens.size() == 1 || run( tokens ) ) {
         return true;
      } else {
         path.pop();
         path.pop();
         return false;
      }
   }

   private boolean mayLand( Token ficha, Direction dir ) {
      return  dir.move( dir.move( ficha ) ).within( filas, columnas );
   }
      
   
   
}
