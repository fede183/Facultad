package uba.algo3.tp3.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import org.junit.Test;

import uba.algo3.tp3.ColoringTestUtil;
import uba.algo3.tp3.GrafoColoreo;
import uba.algo3.tp3.HBusquedaLocal;
import uba.algo3.tp3.HCGolosa;
import uba.algo3.tp3.NodoColoreo;

public class HBusquedaLocalExp {

	private final Integer PRIMER_COLOR = 0;
	private final Integer HEURISTICA_GOLOSA = 1;
	private final Integer RANDOM = 2;

	private static Random rng = new Random(16L);

	public void allFiles(File testFolder, Integer vecindario, Integer solucionInicial) throws IOException {
		// Output en formato
		BufferedWriter output = null;
		File[] files = testFolder.listFiles();
		Arrays.sort(files);
		String lastGrafoTipo = "";
		HashMap<Integer, String> results = new HashMap<>();
		for (File file : files) {
			if (file.isFile() && !file.getName().endsWith("2lc.in") && !file.getName().endsWith(".out") ){
				// Separamos los outputs segun tipo de grafo (definido por
				// prefijos kn, knm..)
				Integer offset = file.getName().indexOf("_");
				if (file.getName().startsWith("s_") || file.getName().startsWith("u_")) {
					offset = file.getName().indexOf("_", 2);
				}
				String grafoTipo = file.getName().substring(0, offset);

				// Cuando cambia el tipo de grafo escribimos el archivo
				if (output == null || !grafoTipo.equals(lastGrafoTipo)) {
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

					results = new HashMap<>();
					output = new BufferedWriter(new FileWriter(testFolder.getPath() + "/results/" + grafoTipo
							+ "_busquedaLocal_v" + vecindario + "_s" + solucionInicial + ".out"));
					output.append("#vecindario solucionInicial cantNodos cantColores conflictos tiempoEnMS");
					output.newLine();
					lastGrafoTipo = grafoTipo;
				}

				BufferedReader source = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				HBusquedaLocal local = new HBusquedaLocal();
				GrafoColoreo g = GrafoColoreo.fromInput(source);

				if (solucionInicial.equals(PRIMER_COLOR)) {
					for (NodoColoreo nodo : g.getNodos()) {
						nodo.setColor(nodo.getColores().get(0));
					}
				} else if (solucionInicial.equals(HEURISTICA_GOLOSA)) {
					HCGolosa h = new HCGolosa();
					g = h.HCCombinado(g);
				} else if (solucionInicial.equals(RANDOM)) {
					rng = new Random(16L);
					for (NodoColoreo nodo : g.getNodos()) {
						nodo.setColor(nodo.getColores().get(rng.nextInt(nodo.getColores().size())));
					}
				}

				System.out.print("Busqueda local por vecindario " + vecindario + ", solucion inicial " + solucionInicial
						+ " : " + file.getName());

				Long time = System.currentTimeMillis();
				g = local.busquedaLocal(g, vecindario);
				time = System.currentTimeMillis() - time;

				ColoringTestUtil.writeOutput(g, testFolder.getPath(),
						file.getName().substring(0, file.getName().length() - 3) + "_busquedaLocal_v" + vecindario
								+ "_s" + solucionInicial + ".out");

				Integer conflictos = ColoringTestUtil.contarConflictos(g);
				System.out.print("Conflictos : " + conflictos);
				System.out.println();

				// Contamos la cantidad de conflictos por vertice
				// Por lo que cada arista en conflicto se cuenta de ambos lados
				results.put(g.getNodos().size(), vecindario + " " + solucionInicial + " " + g.getNodos().size() + " "
						+ g.getCantColores() + " " + conflictos + " " + time);
			}
		}
		// Flush del ultimo archivo
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

	@Test
	public void allFilesTestSet1() throws IOException {
		File testFolder = new File(getClass().getResource("TestSet1/").getFile());
		testAll(testFolder);
	}

	public void testAll(File testFolder) throws IOException {
		allFiles(testFolder, HBusquedaLocal.VECINDARIO_1, PRIMER_COLOR);
		allFiles(testFolder, HBusquedaLocal.VECINDARIO_2, PRIMER_COLOR);
		allFiles(testFolder, HBusquedaLocal.VECINDARIO_3, PRIMER_COLOR);

		allFiles(testFolder, HBusquedaLocal.VECINDARIO_1, HEURISTICA_GOLOSA);
		allFiles(testFolder, HBusquedaLocal.VECINDARIO_2, HEURISTICA_GOLOSA);
		allFiles(testFolder, HBusquedaLocal.VECINDARIO_3, HEURISTICA_GOLOSA);

		allFiles(testFolder, HBusquedaLocal.VECINDARIO_1, RANDOM);
		allFiles(testFolder, HBusquedaLocal.VECINDARIO_2, RANDOM);
		allFiles(testFolder, HBusquedaLocal.VECINDARIO_3, RANDOM);
	}

}
