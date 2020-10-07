package uba.algo3.tp1;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Telegrafo {
	
	List<Integer> kilometrosEntreCiudades;
	Integer maxCiudadesConectadas;

	public Integer rutaMasLarga(List<Integer> kilometrajes, Integer kmCable) {
		
		kilometrosEntreCiudades = new ArrayList<>();
		maxCiudadesConectadas = 0; 
		Integer anterior = 0;
		for(Integer km : kilometrajes)
		{
			kilometrosEntreCiudades.add(km-anterior);
			anterior = km;
		}
		
		ListIterator<Integer> inicioRuta = kilometrosEntreCiudades.listIterator();
		ListIterator<Integer> finRuta = kilometrosEntreCiudades.listIterator();
		
		Integer ciudadesEnRuta = 0;
		Integer cableRestante = kmCable;
		while(finRuta.hasNext()){
			Integer kmHastaProximaCiudad = finRuta.next();
			
			//Si no llego hasta la proxima ciudad con el cable restante
			while(kmHastaProximaCiudad > cableRestante && ciudadesEnRuta > 0){
				// Resto ciudades del inicio de la ruta hasta llegar.
				Integer kmPrimeraCiudad = inicioRuta.next();
				cableRestante += kmPrimeraCiudad;
				if(ciudadesEnRuta==2){
					ciudadesEnRuta--;
				}
				ciudadesEnRuta--;
			}
			
			// Si consegui suficiente cable restando atras, sumo una adelante
			// Sino, ese par de ciudades esta demasiado lejos y seguimos con las demas
			if(kmHastaProximaCiudad <= cableRestante){
				cableRestante -= kmHastaProximaCiudad;
				if(ciudadesEnRuta == 0){
					ciudadesEnRuta++;
				}
				ciudadesEnRuta++;
			}else{
				inicioRuta.next();
			}
			
			if(ciudadesEnRuta > maxCiudadesConectadas){
				maxCiudadesConectadas = ciudadesEnRuta;
			}
		}
		
		return maxCiudadesConectadas;
	}
}
