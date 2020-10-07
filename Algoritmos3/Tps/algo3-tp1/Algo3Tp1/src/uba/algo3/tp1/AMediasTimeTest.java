package uba.algo3.tp1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class AMediasTimeTest {
	
	Random rng = new Random(1L);
	
	@Test
	public void testTiempos() {
		System.out.println("tiempos para el peor caso:");
		int promedioDe = 100;
		for (int i = 100000; i <= 1000000; i+=100000) {
			double peor = 0;
			for(int j = 0; j<promedioDe; j++){
				peor = TestPeorCaso(i) + peor;
			}
			
			System.out.println(peor/promedioDe);
		}
		
		System.out.println("tiempos para el mejor caso:");
		for (int i = 100000; i <= 1000000; i+=100000) {
			double mejor = 0;
			for(int j = 0; j<promedioDe; j++){
				mejor = TestMejorCaso(i) + mejor;
			}
			
			System.out.println(mejor/promedioDe);
		}
		
		System.out.println("tiempos para el caso promedio:");
		for (int i = 100000; i <= 1000000; i+=100000) {
			double promedio = 0;
			for(int j = 0; j<promedioDe; j++){
				promedio = TestCasoAleatorio(i) + promedio;
			}
			
			System.out.println(promedio/promedioDe);
		}

	}
	
	//El peor caso es cuando esta ordenado de mayor a menor
	private double TestPeorCaso(int cant) {
		List<Integer> peor = new ArrayList<Integer>();
		for(int i = cant; i>0; i--){
			peor.add(i);
		}
		//Mido tiempo
		return run(peor);
	}
	
	//El mejor caso es cuando se va alternando entre el mayores y menores(las colas)
	public double TestMejorCaso(int cant){
		List<Integer> mejor = new ArrayList<Integer>();
		int mayor = 51, menor = 50;
		int i = cant/2;
		while(i>0){
			mejor.add(menor);
			mejor.add(mayor);
			mayor++;
			menor--;
			i--;
		}
		//Mido el tiempo
		return run(mejor);
	}
	
	//Caso promedio generando un arreglo aleatorio
	public double TestCasoAleatorio(int cant){
		List<Integer> aleatorio = new ArrayList<Integer>();
		for(int i = 0; i<cant; i++){
			aleatorio.add(rng.nextInt(100));
		}
		//Mido el tiempo
		return run(aleatorio);
	}
	
	public double run(List<Integer> input){
		AMedias mediana = new AMedias();
		long time = System.currentTimeMillis();
		mediana.Medianas(input);
		time = System.currentTimeMillis() - time;
		return (double) time / (double) 1000;
	}
}
