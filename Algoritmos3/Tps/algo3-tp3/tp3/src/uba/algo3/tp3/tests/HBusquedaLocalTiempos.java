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
import uba.algo3.tp3.NodoColoreo;

public class HBusquedaLocalTiempos {

	private static final Integer grafoCompleto = 0;
	private static final Integer grafoBipartito = 1;

	@Test
	public void Tiempos() throws IOException {
		 TestsTiempos(0, 20, 20, grafoCompleto);
		 TestsTiempos(1, 20, 20, grafoCompleto);
		 TestsTiempos(2, 20, 20, grafoCompleto);
		 TestsTiempos(0, 20, 20, grafoBipartito);
		 TestsTiempos(1, 40, 40, grafoBipartito);
		 TestsTiempos(2, 40, 40, grafoBipartito);
		 TestsTiemposFamilia1(0);
		 TestsTiemposFamilia1(1);
		 TestsTiemposFamilia1(2);
	}

	public void TestsTiempos(Integer solucionInicial, Integer tiempoInicial, Integer saltos, Integer tipoGrafo)
			throws IOException {

		for (int vecindario = 1; vecindario <= 3; vecindario++) {
			HashMap<Integer, String> results = new HashMap<>();
			System.out.println("");
			System.out.println("Vecindad " + vecindario + " Tiempos:");
			for (int i = tiempoInicial; i <= tiempoInicial * 10; i += saltos) {
				GrafoColoreo g;
				//Elegimos nuesto grafo.
				if (tipoGrafo == grafoCompleto) {
					g = new GeneradorGrafos().generarFullKn(i, i);
				} else {
					g = new GeneradorGrafos().generarSolvableKmn(i / 2, i / 2, i / 2, false);
				}
				//Y nuestra solucion inicial.
				if (solucionInicial == 0) {
					asignarPrimerColor(g);
				} else if (solucionInicial == 1) {
					asignarColoreoRandom(g);
				} else {
					HCGolosa h = new HCGolosa();
					g = h.HCCombinado(g);
				}
				
				//Medimos los tiempos y los conflictos.
				Long tiempo = System.currentTimeMillis();
				new HBusquedaLocal().busquedaLocal(g, vecindario);
				tiempo = System.currentTimeMillis() - tiempo;
				Integer conf = ColoringTestUtil.contarConflictos(g);
				System.out.println(i + " " + tiempo + " " + conf);
				results.put(i, i + " " + tiempo + " " + conf);
			}

			System.out.println("");
			BufferedWriter output = new BufferedWriter(new FileWriter(getClass().getResource("").getPath()
					+ "/TestsEj4_" + tipoGrafo + "_sol" + solucionInicial + "_v" + vecindario + ".dat"));
			output.append("#cantNodos tiempoEnMS conflictos");
			output.newLine();

			if (output != null) {
				Integer[] nodosExps = results.keySet().toArray(new Integer[1]);
				Arrays.sort(nodosExps);
				for (Integer nodos : nodosExps) {
					output.append(results.get(nodos));
					output.newLine();
				}
				output.flush();
				output.close();
			}
		}

	}

	public void TestsTiemposFamilia1(Integer solucionInicial) throws IOException {

		GeneradorGrafos gg = new GeneradorGrafos();

		for (int vecindario = 1; vecindario <= 3; vecindario++) {
			HashMap<Integer, String> results = new HashMap<>();
			System.out.println("");
			System.out.println("Vecindad " + vecindario + " Tiempos:");
			for (Integer i = 3; i < 15; i++) {

				Integer n = (int) (Math.pow(2, i) - 1);
				GrafoColoreo g = gg.generarArbolBinarioConBaseUnida(n);
				
				//Elegimos nuestra solucion inicial.
				if (solucionInicial == 0) {
					asignarPrimerColor(g);
				} else if (solucionInicial == 1) {
					asignarColoreoRandom(g);
				} else {
					HCGolosa h = new HCGolosa();
					g = h.HCCombinado(g);
				}
				
				//Medimos los tiempos y los conflictos.
				Long tiempo = System.currentTimeMillis();
				new HBusquedaLocal().busquedaLocal(g, vecindario);
				tiempo = System.currentTimeMillis() - tiempo;
				Integer conf = ColoringTestUtil.contarConflictos(g);
				System.out.println(i + " " + tiempo + " " + conf);
				results.put(i, i + " " + tiempo + " " + conf);

			}

			BufferedWriter output = new BufferedWriter(new FileWriter(getClass().getResource("").getPath()
					+ "/TestsEj4_ab_sol" + solucionInicial + "_v" + vecindario + ".dat"));
			output.append("#cantNodos tiempoEnMS conflictos");
			output.newLine();

			if (output != null) {
				Integer[] nodosExps = results.keySet().toArray(new Integer[1]);
				Arrays.sort(nodosExps);
				for (Integer nodos : nodosExps) {
					output.append(results.get(nodos));
					output.newLine();
				}
				output.flush();
				output.close();
			}
		}

	}

	/** Le asigno al grafo g el primer color de cada nodo.**/
	private GrafoColoreo asignarPrimerColor(GrafoColoreo g) {
		for (int j = 0; j < g.cantidadNodos(); j++) {
			Integer _color = g.getNodo(j).getColores().get(0);
			g.getNodo(j).setColor(_color);
		}
		return g;
	}

	/** Le asigno al grafo g un color aleatorio de cada nodo.**/
	private GrafoColoreo asignarColoreoRandom(GrafoColoreo g) {
		Random rng = new Random();
		for (NodoColoreo nodo : g.getNodos()) {
			nodo.setColor(nodo.getColores().get(rng.nextInt(nodo.getColores().size())));
		}
		return g;
	}

}
