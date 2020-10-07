package uba.algo3.ejemplotp;

import java.util.Arrays;
import java.util.List;


public class Direction {

   private int row;
   private int col;

   
   static public List<Direction> all() {  return Arrays.asList( left(), right(), top(), bottom() );   }
   
   static public Direction left() {       return new Direction(   0, - 1 );   }
   static public Direction right() {      return new Direction(   0,   1 );   }
   static public Direction top() {        return new Direction( - 1,   0 );   }
   static public Direction bottom() {     return new Direction(   1,   0 );   }
   
   public Direction( int r, int c ) {
      row = r;
      col = c;
   }

   public String toString() {
      return "" + row + " " + col;
   }

   public Token move( Token aToken ) {
      return new Token( aToken.getRow() + getRow(), aToken.getCol() + getCol() );
   }
   
   // Accessors
   public void setCol( int i ) {       col = i;       }
   public int getCol() {               return col;    }
   
   public void setRow( int i ) {       row = i;       }
   public int getRow() {               return row;    }

}
