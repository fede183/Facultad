package uba.algo3.caminominimo;

public class Autopista {

   private Ciudad ciudad; 
   private int peaje; 

   public Autopista( Ciudad c, int p ) {
      ciudad = c;
      peaje = p;
   }
   
   public Ciudad getCiudad() {                        return ciudad;    }
   public void setCiudad( Ciudad c ) {                ciudad = c;       }
   
   public int getPeaje() {                            return peaje;     }
   public void setPeaje( int p ) {                    peaje = p;        }

}