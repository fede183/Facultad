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
import uba.algo3.tp3.GeneradorGrafos;
import uba.algo3.tp3.GrafoColoreo;
import uba.algo3.tp3.HBusquedaLocal;
import uba.algo3.tp3.HCGolosa;
import uba.algo3.tp3.ListColoringBt;
import uba.algo3.tp3.NodoColoreo;

public class ListColoringExp {

	public Boolean coloreoValido(GrafoColoreo g) {
		return ColoringTestUtil.contarConflictos(g) == 0;
	}

	public void allFiles(File testFolder) throws IOException {
		BufferedWriter output = null;
		File[] files = testFolder.listFiles();
		Arrays.sort(files);
		String lastGrafoTipo = "";
		HashMap<Integer, String> results = new HashMap<>();
		for (File file : files) {
			if (file.isFile() && !file.getName().endsWith("2lc.in") && !file.getName().endsWith(".out")) {
				// Separamos los outputs segun tipo de grafo (definido por
				// prefijos kn, knm, gc...)
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
						for(Integer nodos : nodosExps){
							output.append(results.get(nodos));
							output.newLine();
						}
						output.flush();
						output.close();
					}
					
					results = new HashMap<>();
					output = new BufferedWriter(
							new FileWriter(testFolder.getPath() + "/results/" + grafoTipo + "_exacto.out"));
					output.append("#cantNodos cantColores HaySolucion tiempoEnMS");
					output.newLine();
					lastGrafoTipo = grafoTipo;
				}

				BufferedReader source = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
				ListColoringBt listColoring = new ListColoringBt();
				GrafoColoreo g = GrafoColoreo.fromInput(source);

				System.out.print("Solución exacta : " + file.getName());

				Long time = System.currentTimeMillis();
				GrafoColoreo res = listColoring.colorear(g);
				time = System.currentTimeMillis() - time;

				Boolean isValid = res != null && coloreoValido(res);
				System.out.print(isValid ? "Ok" : "X");
				System.out.println();
				
				ColoringTestUtil.writeOutput(g, testFolder.getPath(),
						file.getName().substring(0, file.getName().length() - 3) + "_exacto.out");

				// Contamos la cantidad de conflictos por vertice
				// Por lo que cada arista en conflicto se cuenta de ambos lados
				results.put(g.getNodos().size(), g.getNodos().size() + " " + g.getCantColores() + " " + (isValid ? "Ok" : "X") + " " + time);
			}
		}
		// Flush del ultimo archivo
		if (output != null) {
			Integer[] nodosExps = results.keySet().toArray(new Integer[1]);
			Arrays.sort(nodosExps);
			for(Integer nodos : nodosExps){
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
		allFiles(testFolder);
	}
	

}
