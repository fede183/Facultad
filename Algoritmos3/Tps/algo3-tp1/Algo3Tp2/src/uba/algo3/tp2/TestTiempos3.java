package uba.algo3.tp2;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;



public class TestTiempos3 {

	Random rng = new Random(1L);
	@Test
	public void Tiempos(){
		
		int peor=0, mejor=0, prom=0;
		System.out.println("Mejor Caso:");
		for(int i = 100; i<=1000 ;i+=100){
			
			ArrayList aux = MejorCaso(i);
			for(int j = 0; j<100; j++){
				mejor += MedirTiempo(aux);
			}
			System.out.print(mejor/100 +" ");
		}
		
		System.out.println("Peor Caso:");
		for(int i = 100; i<=1000 ;i+=100){
			
			ArrayList aux = PeorCaso(i*(i-1)/2);
			for(int j = 0; j<100; j++){
				peor += MedirTiempo(aux);
			}
			System.out.print(peor/100 +" ");
		}
	}
	
	public ArrayList MejorCaso(int cantVertices){
		//El mejor caso es un grafo completo con todas las aristas de igual peso
		
		ArrayList pasillos = new ArrayList();
		for(int i = 1; i <= cantVertices ;i++){
			for(int j = i+1; j<=cantVertices; j++){
				pasillos.add( new Pasillo( i, j, 1) );
			}
		
		}
		
		return pasillos;
		
	}
	

	

	
	public ArrayList PeorCaso(int cantVertices){
		//El peor caso es un grafo lineal con las aristas variando de peso.
		
		ArrayList pasillos = new ArrayList();
		
		//pasillos.add( new Pasillo( 1, 2, 2) );
		boolean menor = false;
		for(int i = 1; i < cantVertices ;i++){
			if(menor){
				pasillos.add( new Pasillo( i, i+1, i) );
				menor = false;
			}
			else{
				pasillos.add( new Pasillo( i, i+1, cantVertices+ i) );
				menor = true;
			}
			
		}
		
		return pasillos;
		
		
	}
	

	
	private long MedirTiempo(ArrayList pasillos) {

		long tiempo = System.currentTimeMillis();
		
		new Ejercicio3( pasillos ).solve();
		
		tiempo = System.currentTimeMillis() - tiempo;

		return tiempo;
	}
}

