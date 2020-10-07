package uba.algo3.tp2;

import java.util.ArrayList;
import java.util.Random;

import org.junit.Test;

public class TestTiempos1 {
	Random rng = new Random(1L);
	@Test
	public void Tiempos(){
		
		int peor=0, mejor=0, prom=0;
		System.out.println("Mejor Caso:");
		for(int i = 200; i<=2000 ;i+=200){
			
			ArrayList aux = MejorCaso(i);
			for(int j = 0; j<100; j++){
				mejor += MedirTiempo(aux, i);
			}
			System.out.print(mejor/100 +" ");
		}
		System.out.println("Peor Caso:");
		for(int i = 200; i<300 ;i+=10){
			
			ArrayList aux = PeorCaso(i);
			for(int j = 0; j<100; j++){
				peor += MedirTiempo(aux, i);
			}
			System.out.print(peor/100 +" ");
		}
		System.out.println("Caso Promedio:");
		for(int i = 200; i<300 ;i+=10){
			
			ArrayList aux = CasoPromedio(i);
			for(int j = 0; j<100; j++){
				prom += MedirTiempo(aux, i);
			}
			System.out.print(prom/100 +" ");
		}
	}
	
	public ArrayList MejorCaso(int cantVertices){
		//Simplemente es un camino lineal y que utiliza todos los vertices para llegar
		//al piso N
		
		ArrayList portales = new ArrayList();
		
		for(int i = 0; i < cantVertices-1 ;i++){
			portales.add( new Portal( i, i+1) );
		}
		
		
		return portales;
		
	}
	
	public ArrayList PeorCaso(int cantVertices){
		//El peor es el grafo completo.
		
		ArrayList portales = new ArrayList();
		
		for(int i = 0; i < cantVertices  ;i++){

			for(int j = i+1; j < cantVertices  ;j++){
				portales.add( new Portal( i, j) );
			}
		}

		return portales;
		
	}
	
	public ArrayList CasoPromedio(int cantVertices){
		//Genero el grafo aleatoriamente
		
		//Necesito asegurarme que sea conexo
		ArrayList portales = new ArrayList();
		
		
		for(int i = 0; i < cantVertices-1 ;i++){
			portales.add( new Portal( i, i+1) );
		}
		
		for(int i = 0; i < cantVertices ;i++){
			for(int j = i+2; j < cantVertices ;j++){

				boolean loConecto = rng.nextBoolean(); 
				if(loConecto){
					portales.add( new Portal( i, j) );
				}
				
				
			}
		}
		
		return portales;
		
	}
	
	private long MedirTiempo(ArrayList Portales, int cantVertices) {

		long tiempo = System.currentTimeMillis();
		
		new Ejercicio1(cantVertices-1, Portales ).solve();
		tiempo = System.currentTimeMillis() - tiempo;

		return tiempo;
	}
}