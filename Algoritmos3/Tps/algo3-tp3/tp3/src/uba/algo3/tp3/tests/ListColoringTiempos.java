package uba.algo3.tp3.tests;

import org.junit.Test;

import uba.algo3.tp3.ColoringTestUtil;
import uba.algo3.tp3.GeneradorGrafos;
import uba.algo3.tp3.GrafoColoreo;
import uba.algo3.tp3.HBusquedaLocal;
import uba.algo3.tp3.HCGolosa;
import uba.algo3.tp3.ListColoringBt;

public class ListColoringTiempos {
	private static final Integer grafoCompleto = 0;
	private static final Integer grafoBipartito = 1;
	
	@Test
	public void Tiempos(){
		TestsTiempos(2, 1, 11,false);
		TestsTiempos(2, 1, 11, true);
		TestsTiemposN(2, 1, 11, false);
		TestsTiemposN(2, 1, 11, true);
		TestsTiemposC(2, 1, 11,false);
		TestsTiemposC(2, 1, 11, true);
	}
	
	
	private void TestsTiempos(Integer tiempoInicial, Integer saltos, Integer tiempoFinal, boolean resoluble){
		long tiempoP;

		System.out.println("");
		System.out.println("Tiempos Exacta Peor Caso:");
		for(int i = tiempoInicial; i<=tiempoFinal ; i+=saltos){
					
			tiempoP = 0;
			for(int k = 0; k<100 ;k++){
				GrafoColoreo g;
				if(!resoluble){
					g = new GeneradorGrafos().generarFullKn(i, i-1);
				}
				else{
					g = new GeneradorGrafos().generarFullKn(i, i);
				}
					
						
				tiempoP = tiempoP + MedirTiempo(g);
			}
				
			System.out.print(tiempoP / 100 + " ");
		}
		
	}
	
	private void TestsTiemposN(Integer tiempoInicial, Integer saltos, Integer tiempoFinal, boolean resoluble){
		long tiempoP;

		System.out.println("");
		System.out.println("Tiempos Exacta Peor Caso (Variando n):");
		for(int i = tiempoInicial; i<=tiempoFinal ; i+=saltos){
					
			tiempoP = 0;
			for(int k = 0; k<100 ;k++){
				GrafoColoreo g;
				if(!resoluble){
					g = new GeneradorGrafos().generarFullKn(i, (tiempoFinal-4));
				}
				else{
					g = new GeneradorGrafos().generarFullKn(i, tiempoFinal);
				}
					
						
				tiempoP = tiempoP + MedirTiempo(g);
			}
				
			System.out.print(tiempoP / 100 + " ");
		}
		
	}
	
	private void TestsTiemposC(Integer tiempoInicial, Integer saltos, Integer tiempoFinal, boolean resoluble){
		long tiempoP;

		System.out.println("");
		System.out.println("Tiempos Exacta Peor Caso (Variando c):");
		for(int i = tiempoInicial; i<=tiempoFinal ; i+=saltos){
					
			tiempoP = 0;
			for(int k = 0; k<100 ;k++){
				GrafoColoreo g;
				if(!resoluble){
					g = new GeneradorGrafos().generarFullKn(tiempoFinal, i);
				}
				else{
					g = new GeneradorGrafos().generarFullKn(tiempoFinal, i + tiempoFinal);
				}
					
						
				tiempoP = tiempoP + MedirTiempo(g);
			}
				
			System.out.print(tiempoP / 100 + " ");
		}
		
	}
	
	private long MedirTiempo(GrafoColoreo g) {
		//Asigno como color inicial a los primeros colores de cada nodo.

		long tiempo = System.currentTimeMillis();
		g = new ListColoringBt().colorear(g);
		tiempo = System.currentTimeMillis() - tiempo;
		
		
		return tiempo;
	}
	
	
	private long MedirConflictos(GrafoColoreo g) {
		//Asigno como color inicial a los primeros colores de cada nodo.
		
		
		g = new ListColoringBt().colorear(g);

		ColoringTestUtil c = new ColoringTestUtil();
		return c.contarConflictos(g);
	}
}
