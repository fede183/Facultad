package uba.algo3.caminominimo;

import java.util.HashMap;
import java.util.Map;

public class Red {
   
   Map<Integer, Ciudad> red = new HashMap();
   
   public Ciudad ciudad( int i ) {
      if ( red.containsKey( i ) ) {
         red.put( i, new Ciudad( i ) );
      }
      return red.get( i );
   }
   
   public Red unir( int origen, int destino, int costo ) {
      Ciudad ori = ciudad( origen );
      Ciudad des = ciudad( destino );
      ori.getAutopistas().add( new Autopista( des, costo ) );
      
      // completar
      
      return this;
   }
   
   public int solve( int BuenosAires, int RioCuarto ) {
      
      // completar
      
      return 0;
   }
}