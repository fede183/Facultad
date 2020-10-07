package uba.algo3.tp3.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

import uba.algo3.tp3.ColoringTestUtil;
import uba.algo3.tp3.GeneradorGrafos;
import uba.algo3.tp3.GrafoColoreo;
import uba.algo3.tp3.HBusquedaLocal;
import uba.algo3.tp3.HCGolosa;
import uba.algo3.tp3.ListColoringBt;
import uba.algo3.tp3.NodoColoreo;

public class TestGrafosRandom {
	
	HashMap<Integer, String> results = new HashMap<>();
	String filename = "";
	@Test
	public void test() throws IOException{
		Integer n = 30;
		Integer nMax = 31;
		Integer nMaxHeur = 101;
		
		results = new HashMap<>();
		filename = "random_e.out";
		for(n = 10; n<nMax; n++){
			testRandomsExactos(n,10);
		}
		printResults();
		
		for(Integer i = 1; i<=3; i++){
			results = new HashMap<>();
			filename = "random_HBL_v"+i+".out";
			for(n = 10; n<nMaxHeur; n++){
				testRandomsHBL(n,n/2,i);
			}
			printResults();
		}
		
		results = new HashMap<>();
		filename = "random_golosa.out";
		for(n = 10; n<nMaxHeur; n++){
			testRandomsGolosa(n,n/2);
		}
		printResults();
	}
	
	private void printResults() throws IOException{
		BufferedWriter output = new BufferedWriter(
				new FileWriter(getClass().getResource("").getPath()+"/"+filename));
		output.append("#cantNodos cantColores tiempoEnMS");
		output.newLine();
		Integer[] nodosExps = results.keySet().toArray(new Integer[1]);
		Arrays.sort(nodosExps);
		for(Integer nodos : nodosExps){
			output.append(results.get(nodos));
			output.newLine();
		}
		output.flush();
		output.close();
	}
	
	private void testRandomsExactos(Integer n, Integer c){
		GeneradorGrafos gg = new GeneradorGrafos();
		ListColoringBt listColoring = new ListColoringBt();
		Integer promedio = 100;
		Long time = 0L;
		Long meanTime = 0L;
		System.out.print("Solución exacta : ");
		for(Integer i = 0; i< promedio; i++){
			System.out.print("N = "+n+" Seed "+i+" ");
			gg.setSeed(i.longValue());
			GrafoColoreo g = gg.generarGrafoRandom(n, c);
			time = System.currentTimeMillis();
			GrafoColoreo res = listColoring.colorear(g);
			time = System.currentTimeMillis() - time;
			meanTime += time;
			Boolean isValid= res != null && ColoringTestUtil.contarConflictos(res) == 0;
			System.out.print("Parcial : "+time+" "+(isValid ? "Ok" : "X"));
			System.out.println();
		}
		Double promedioTotal = meanTime.doubleValue() / promedio.doubleValue();
		System.out.print(" in "+promedioTotal+"ms ");
		results.put(n, n+" "+c+" "+promedioTotal);
		System.out.println();
	}
	
	private void testRandomsHBL(Integer n, Integer c, Integer vecindario){
		GeneradorGrafos gg = new GeneradorGrafos();
		HBusquedaLocal local = new HBusquedaLocal();
		System.out.print("HBL v"+vecindario+" : ");
		Integer promedio = 100;
		Long time = 0L;
		Long meanTime = 0L;
		Integer promedioConflictos = 0;
		
		Double mejoria = 0.0;
		for(Integer i = 0; i< promedio; i++){
			gg.setSeed(i.longValue());
			GrafoColoreo g = gg.generarGrafoRandom(n, c);
			
			Random rng = new Random(16L);
			for (NodoColoreo nodo : g.getNodos()) {
				if(nodo.getColores().isEmpty()){
					System.out.println("fuck");
				}
				nodo.setColor(nodo.getColores().get(rng.nextInt(nodo.getColores().size())));
			}
			
			Integer confOg = ColoringTestUtil.contarConflictos(g);
			
			time = System.currentTimeMillis();
			local.busquedaLocal(g, vecindario);
			time = System.currentTimeMillis() - time;
			meanTime += time;
			
			Integer conf = ColoringTestUtil.contarConflictos(g);
			System.out.print("Parcial :  "+time+" ("+ conf+" conf de "+confOg+")");
			mejoria += conf.doubleValue()/confOg.doubleValue();
			promedioConflictos += conf;
			System.out.println();
		}
		Double promedioTotal = meanTime.doubleValue() / promedio.doubleValue();
		Double porcentajeMejora = (100 - (mejoria.doubleValue()/promedio.doubleValue()) * 100);
		System.out.print(" in "+promedioTotal+"ms ");
		results.put(n, n+" "+c+" "+promedioTotal+" "+porcentajeMejora+" "+promedioConflictos.doubleValue()/promedio.doubleValue());
		System.out.print(" in "+meanTime+"ms ");
		System.out.println();
		
	}
	private void testRandomsGolosa(Integer n, Integer c){		
		GeneradorGrafos gg = new GeneradorGrafos();
		HCGolosa greedy = new HCGolosa();
		System.out.print("Golosa : ");
		Integer promedio = 100;
		Long time = 0L;
		Long meanTime = 0L;
		Integer promedioConflictos = 0;
		
		Double mejoria = 0.0;
		for(Integer i = 0; i< promedio; i++){
			gg.setSeed(i.longValue());
			GrafoColoreo g = gg.generarGrafoRandom(n, c);
			
			Random rng = new Random(16L);
			for (NodoColoreo nodo : g.getNodos()) {
				if(nodo.getColores().isEmpty()){
					System.out.println("fuck");
				}
				nodo.setColor(nodo.getColores().get(rng.nextInt(nodo.getColores().size())));
			}
			
			Integer confOg = ColoringTestUtil.contarConflictos(g);
			
			time = System.currentTimeMillis();
			greedy.HCCombinado(g);
			time = System.currentTimeMillis() - time;
			meanTime += time;
			
			Integer conf = ColoringTestUtil.contarConflictos(g);
			System.out.print("Parcial :  "+time+" ("+ conf+" conf)");
			mejoria += conf.doubleValue()/confOg.doubleValue();
			promedioConflictos += conf;
			System.out.println();
		}
		Double promedioTotal = meanTime.doubleValue() / promedio.doubleValue();
		Double porcentajeMejora = (100 - (mejoria.doubleValue()/promedio.doubleValue()) * 100);
		System.out.print(" in "+promedioTotal+"ms ");
		results.put(n, n+" "+c+" "+promedioTotal+" "+porcentajeMejora+" "+promedioConflictos.doubleValue()/promedio.doubleValue());
		System.out.println();
		
	}
}
