package uba.algo3.tp3.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import uba.algo3.tp3.ColoringTestUtil;
import uba.algo3.tp3.GeneradorGrafos;
import uba.algo3.tp3.GrafoColoreo;
import uba.algo3.tp3.HCGolosa;

public class HCGolosaTiempos {
	
	@Test
	public void TestsTiemposN(){
		System.out.println("Peor Caso variando el tamaño del grafo:");
		long tiempoP;
		for(int i = 20; i<=200 ; i+=20){

			tiempoP = 0;
			for(int k = 0; k<100 ;k++){
				tiempoP = tiempoP + MedirTiempo(peorCaso(i, 200));
			}
			System.out.print(tiempoP / 100 + " ");
		}
	}
	
	@Test
	public void TestsTiemposC(){
		System.out.println("Peor Caso variando la cantidad de colores:");
		long tiempoP;
		for(int i = 20; i<=200 ; i+=20){

			tiempoP = 0;
			for(int k = 0; k<100 ;k++){
				tiempoP = tiempoP + MedirTiempo(peorCaso(200, i));
			}
			System.out.print(tiempoP / 100 + " ");
		}
	}
	
	@Test
	public void TestsTiemposM(){
		System.out.println("Peor Caso variando la cantidad de aristas:");
		long tiempoP;
		for(int i = 0; i<10 ; i++){

			tiempoP = 0;
			for(int k = 0; k<100 ;k++){
				tiempoP = tiempoP + MedirTiempo(peorCasoM(120, i));
			}
			System.out.print(tiempoP / 100 + " ");
		}
	}
	

	
	//El peor caso es un grafo completo.
	private GrafoColoreo peorCaso(int n, int cantColores){
		List<List<Integer> > vecinos = new ArrayList<>();
		List<List<Integer> > colores = new ArrayList<>();
		
		//Conecto a todos con todos.
		for(int i = 0; i<n ;i++){
			List<Integer> nuevaAristas = new ArrayList<>();
			for(int j = 0; j<n ;j++){
				if(i != j){
					nuevaAristas.add(j);
				}
			}
			vecinos.add(nuevaAristas);
		}
		
		List<Integer> coloresDeCadaUno = new ArrayList<>();
		for(int i = 1; i<=cantColores ;i++){
			coloresDeCadaUno.add(i);
		}
		
		//Agrego todos los colores a todos los nodos.
		for(int i = 1; i<=n ;i++){
			List<Integer> nuevosColores = new ArrayList<>(coloresDeCadaUno);
			colores.add(nuevosColores);
		}
		
		return new GrafoColoreo(n, colores, vecinos, cantColores);
	}
	
	/**Devuelve true si y solo si el j esta en la lista.**/
	private boolean esta(List<Integer> lista, Integer j){
		
		for(int i = 0; i<lista.size() ;i++){
			if(lista.get(i).equals(j)){
				return true;
			}
		}
		
		return false;
	}
	
	/**Peor caso variando m.**/
	private GrafoColoreo peorCasoM(int n, int cantAristas){
		List<List<Integer> > vecinos = new ArrayList<>();
		List<List<Integer> > colores = new ArrayList<>();
		
		//Conecto a cada uno con cantAristas vecinos.
		for(int i = 0; i<n ;i++){
			List<Integer> nuevaAristas = new ArrayList<>();
			vecinos.add(nuevaAristas);
		}
		
		for(int i = 0; i<n ;i++){
			int m = cantAristas - vecinos.get(i).size();

			for(int j = 0; j<n && m>0 ;j++){
				if(!esta(vecinos.get(i), j) && i != j){
					//System.out.println("unio: " + i + " " + j);
					m--;
					vecinos.get(i).add(j);
					vecinos.get(j).add(i);
				}	
			}
			
			
		}
		
		
		List<Integer> coloresDeCadaUno = new ArrayList<>();
		for(int i = 1; i<=n ;i++){
			coloresDeCadaUno.add(i);
		}
		
		//Agrego todos los colores a todos los nodos.
		for(int i = 1; i<=n ;i++){
			List<Integer> nuevosColores = new ArrayList<>(coloresDeCadaUno);
			colores.add(nuevosColores);
		}
		
		return new GrafoColoreo(n, colores, vecinos, n);
	}
	
	
	private long MedirTiempo(GrafoColoreo g) {
		long tiempo = System.currentTimeMillis();
		new HCGolosa().HCCombinado(g);
		tiempo = System.currentTimeMillis() - tiempo;
		
		return tiempo;
	}
	
	@Test
	public void testsFamilias() {
		System.out.println("Fallos con familia 1:");
		for (int i = 15; i < 100000; i = i * 2 + 1) {
			HCGolosa greedy = new HCGolosa();
			GeneradorGrafos gen = new GeneradorGrafos();
			System.out
					.print(ColoringTestUtil.contarConflictos(greedy.HCCombinado(gen.generarArbolBinarioConBaseUnida(i)))
							+ " ");
		}

	}
}
