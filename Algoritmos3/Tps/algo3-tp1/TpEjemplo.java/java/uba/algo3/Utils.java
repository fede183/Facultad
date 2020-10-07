package uba.algo3;

import java.util.StringTokenizer;
import java.util.Vector;


public class Utils {

   public static Vector parseVector( String line ) {
      Vector in = new Vector();

      StringTokenizer st = new StringTokenizer( line, " " );
      while ( st.hasMoreTokens() ) {
         in.add( new Integer( st.nextToken() ) );
      }

      return in;
   }

   public static Integer[] parseArray( String line ) {
      Vector in = parseVector( line );

      return (Integer[]) in.toArray( new Integer[ in.size() ] );
   }

   public static int[] parseArrayI( String line ) {
      Vector<Integer> in = parseVector( line );
      int[] v = new int[  in.size() ];

      for ( int i = 0; i < v.length; i++ ) {
         v[ i ] = in.get( i ).intValue();
      }

      return v;

   }   
}
