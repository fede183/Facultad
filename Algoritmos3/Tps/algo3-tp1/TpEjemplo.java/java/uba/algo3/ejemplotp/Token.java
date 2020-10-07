package uba.algo3.ejemplotp;


public class Token {

   private int row;
   private int col;
   
   public Token( int r, int c ) {
      row = r;
      col = c;
   }

   public String toString() {
      return "" + row + " " + col;
   }

   public Object between( Token dest ) {
      return new Token( (row + dest.row ) / 2 , (col + dest.col) / 2);
   }
   
   public boolean within( int filas, int columnas ) {
      return 1 <= row && row <= filas && 
             1 <= col && col <= columnas;
   }

   // Comparable interface
   public int hashCode() {
      return 31* (31 + col) + row;
   }

   public boolean equals( Object other ) {
      return getClass().isInstance( other ) && equals( (Token)other ); 
   }
   public boolean equals( Token other ) {
      return col == other.col &&  row == other.row; 
   }

   // Accessors
   public void setCol( int i ) {       col = i;       }
   public int getCol() {               return col;    }
   
   public void setRow( int i ) {       row = i;       }
   public int getRow() {               return row;    }

}
