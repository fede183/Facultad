package uba.algo3.caminominimo;

import java.util.ArrayList;
import java.util.List;

public class Ciudad {

   private int ciudad; 
   private List<Autopista> autopistas; 


   public Ciudad( int c ) {
      ciudad = c;
      autopistas = new ArrayList<>();
   }

   public int getCiudad() {                           return ciudad;             }
   public void setCiudad( int c ) {                   ciudad = c;                }
   
   public List<Autopista> getAutopistas() {           return autopistas;         }
   public void setAutopistas( List<Autopista> a ) {   autopistas = a;            }   
   
}