package uba.algo3.tp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class TelegrafoTimeTest {
	Random rng = new Random(1l);
	
	@Test
	public void testTiempos() {
		int promedioDe = 100;
		System.out.println("tiempos para el mejor caso:");
		for (int i = 100000; i <= 1000000; i+=100000) {
			double peor = 0;
			for(int j = 0; j<promedioDe; j++){
				peor = testMejorCaso(i, i) + peor;
			}
			
			System.out.println(peor/promedioDe);
		}
		
		System.out.println("tiempos para el peor caso:");
		for (int i = 100000; i <= 1000000; i+=100000) {
			int kmCableMejor = i;
			double mejor = 0;
			for(int j = 0; j<promedioDe; j++){
				mejor = testPeorCaso(i, kmCableMejor) + mejor;
			}
			
			System.out.println(mejor/promedioDe);
		}
		
		System.out.println("tiempos para el caso promedio:");
		
		for (int i = 100000; i <= 1000000; i+=100000) {
			double promedio = 0;
			int kmCablePromedio = rng.nextInt(i/2);
			for(int j = 0; j<promedioDe; j++){
				promedio = testCasoAleatorio(i, kmCablePromedio) + promedio;
			}
			
			System.out.println(promedio/promedioDe);
		}

	}
	
	// El mejor caso es cuando se pueden agregar todas las ciudades
	private double testMejorCaso(int cant, int kmCable) {
		List<Integer> kilometrajes = new ArrayList<Integer>();
		for(int i = cant; i>0; i--){
			kilometrajes.add(i);
		}
		//Mido tiempo
		return run(kilometrajes,kmCable);
	}
	
	// El peor caso es cuando cada vez que se agrega una ciudad
	// se tiene que restar para agregar la proxima
	private double testPeorCaso(int cant, int kmCable){
		List<Integer> kilometrajes = new ArrayList<Integer>();
		for(int i = 1; i<cant; i++){
			kilometrajes.add(kmCable);
		}
		//Mido el tiempo
		return run(kilometrajes,kmCable);
	}
	
	//Caso promedio generando un arreglo aleatorio
	private double testCasoAleatorio(int cant, int kmCable){
		List<Integer> aleatorio = new ArrayList<Integer>();
		int j = 1;
		for(int i = 0; i<cant; i++){
			j = (rng.nextInt(cant)+1) + j;
			aleatorio.add(j);
		}
		//Mido el tiempo
		return run(aleatorio,kmCable);
	}
	
	
	public double run(List<Integer> kilometrajes, Integer cable){
		Telegrafo tele = new Telegrafo();
		long time = System.currentTimeMillis();
		tele.rutaMasLarga(kilometrajes, cable);
		time = System.currentTimeMillis() - time;
		return (double) time / (double) 1000;
	}
	
}
