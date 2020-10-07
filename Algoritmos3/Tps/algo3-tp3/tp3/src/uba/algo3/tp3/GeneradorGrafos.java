package uba.algo3.tp3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class GeneradorGrafos {

	// Este es el seed que variamos para crear los escenarios
	private Long seed;
	// nombre del set de pruebas
	private String testSet;

	private Random rng;

	public GeneradorGrafos() {
		// default seed
		rng = new Random(1L);
		testSet = "TestSet1";
	}

	public GeneradorGrafos(String testSet, Long seed) {
		// Este es el seed que variamos para crear los escenarios
		this.seed = seed;
		// nombre del set de pruebas
		this.testSet = testSet;
		rng = new Random(seed);
	}

	BufferedWriter getWriter(String filename) throws IOException {
		return new BufferedWriter(
				new FileWriter(getClass().getResource("").getPath() + "tests/" + testSet + "/" + filename + ".in"));
	}

	public GrafoColoreo generarUnsolvableKmn(Integer m, Integer n, Integer c, Boolean is2List) {
		List<List<Integer>> vecinos = new ArrayList<>();
		List<List<Integer>> colores = new ArrayList<>();

		// Conecto a todos los primeros n con los ultimos m
		for (int i = 0; i < n; i++) {
			List<Integer> aristas = new ArrayList<>();
			for (int j = n; j < n + m; j++) {
				aristas.add(j);
			}
			vecinos.add(aristas);
		}
		// y viceversa
		for (int i = n; i < n + m; i++) {
			List<Integer> aristas = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				aristas.add(j);
			}
			vecinos.add(aristas);
		}

		for (int i = 0; i < n + m; i++) {
			// Usamos un conjunto de colores para no repetirlos
			Set<Integer> iColores = new HashSet<>();
			// Particionamos los colores en 2
			// cada parte corresponde a un subconjunto de vertices

			// Para asegurar que hay solucion, los nodos de un conjunto deben
			// tener al menos un color de la parte correspondiente del
			// conjunto de colores
			if (i == n-1) {
				iColores.add(getColorBipartito(0, m, n, c));
			} else if (i == n + m - 1) {
				// si es el ultimo elemento de la segunda particion
				// le agregamos solo colores de la primera para forzar un
				// conflicto
				iColores.addAll(colores.get(n-1));
			} else {
				// Sino lo coloreamos como en el grafo con solucion
				Integer color = getColorBipartito(i, m, n, c);
				iColores.add(color);
				if (is2List) {
					// Agrego un segundo color cualquiera
					color = rng.nextInt(c);
					while (iColores.contains(color))
						color = rng.nextInt(c);
					iColores.add(color);
				} else {
					// Para cada vertice y un random t en [0,c-1)
					// agrego t colores mas
					iColores.addAll(elegirK(c, 3));
				}
			}
			colores.add(new ArrayList<Integer>(iColores));
		}

		return new GrafoColoreo(n + m, colores, vecinos, c);
	}

	/**
	 * Genera un grafo completo donde cada nodo tiene c colores
	 * 
	 * @param n
	 * @param c
	 * @return
	 */
	public GrafoColoreo generarFullKn(Integer n, Integer c) {
		List<List<Integer>> vecinos = new ArrayList<>();
		List<List<Integer>> colores = new ArrayList<>();

		// Conecto a todos con todos.
		for (int i = 0; i < n; i++) {
			List<Integer> nuevaAristas = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (i != j) {
					nuevaAristas.add(j);
				}
			}
			vecinos.add(nuevaAristas);
		}
		for (int i = 0; i < n; i++) {
			List<Integer> iColores = new ArrayList<>();
			for (int j = 0; j < c; j++) {
				iColores.add(j);
			}
			colores.add(iColores);
		}

		return new GrafoColoreo(n, colores, vecinos, c);
	}

	public GrafoColoreo generarUnsolvableKn(Integer n, Integer c, Boolean is2List) {
		List<List<Integer>> vecinos = new ArrayList<>();
		List<List<Integer>> colores = new ArrayList<>();

		// Conecto a todos con todos.
		for (int i = 0; i < n; i++) {
			List<Integer> nuevaAristas = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (i != j) {
					nuevaAristas.add(j);
				}
			}
			vecinos.add(nuevaAristas);
		}

		// Para cada vertice (salvo el ultimo) y un random t en [0,c-1)
		// agrego t colores mas (+/- 1)

		for (int i = 0; i < n - 2; i++) {
			List<Integer> iColores = new ArrayList<>();
			if (is2List) {
				iColores = elegirK(c, 2);
			} else {
				iColores = elegirK(c, 1 + rng.nextInt(c-1));
			}
			colores.add(iColores);
		}
		colores.add(Arrays.asList(0));
		colores.add(Arrays.asList(0));

		return new GrafoColoreo(n, colores, vecinos, c);
	}

	public GrafoColoreo generarSolvableKmn(Integer m, Integer n, Integer c, Boolean is2List) {
		List<List<Integer>> vecinos = new ArrayList<>();
		List<List<Integer>> colores = new ArrayList<>();

		// Conecto a todos los primeros n con los ultimos m
		for (int i = 0; i < n; i++) {
			List<Integer> aristas = new ArrayList<>();
			for (int j = n; j < n + m; j++) {
				aristas.add(j);
			}
			vecinos.add(aristas);
		}
		// y viceversa
		for (int i = n; i < n + m; i++) {
			List<Integer> aristas = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				aristas.add(j);
			}
			vecinos.add(aristas);
		}

		for (int i = 0; i < n + m; i++) {
			// Usamos un conjunto de colores para no repetirlos
			Set<Integer> iColores = new HashSet<>();
			// Particionamos los colores en 2
			// cada parte corresponde a un subconjunto de vertices

			// Para asegurar que hay soluci�n, los nodos de un conjunto deben
			// tener al menos un color de la parte correspondiente del
			// conjunto de colores
			Integer color = getColorBipartito(i, m, n, c);
			iColores.add(color);
			if (is2List) {
				// Agrego un segundo color cualquiera
				color = rng.nextInt(c);
				while (iColores.contains(color))
					color = rng.nextInt(c);
				iColores.add(color);
			} else {
				// Para cada vertice y un random t en [0,c-1)
				// agrego t colores mas
				Integer t = c/2; // rng.nextInt(c/2);
				iColores.addAll(elegirK(c - 1, t));
			}
			colores.add(new ArrayList<Integer>(iColores));
		}

		return new GrafoColoreo(n + m, colores, vecinos, c);
	}

	private Integer getColorBipartito(Integer indiceNodo, Integer m, Integer n, Integer c) {
		if (indiceNodo < n) {
			return rng.nextInt(c / 2);
		} else {
			return c / 2 + rng.nextInt(c / 2);
		}

	}

	// Para asegurar solucion, c >= n
	public GrafoColoreo generarSolvableKn(Integer n, Integer c, Boolean is2List) {
		List<List<Integer>> vecinos = new ArrayList<>();
		List<List<Integer>> colores = new ArrayList<>();
		List<Integer> coloreoValido = elegirK(c,n);
		// Conecto a todos con todos.
		for (int i = 0; i < n; i++) {
			List<Integer> nuevaAristas = new ArrayList<>();
			for (int j = 0; j < n; j++) {
				if (i != j) {
					nuevaAristas.add(j);
				}
			}
			vecinos.add(nuevaAristas);
		}

		// Para cada vertice y un random t en [0,c-1)
		// agrego t colores mas (+/- 1)
		for (Integer i = 0; i < n; i++) {
			Set<Integer> iColores = new HashSet<>();
			// Agrego un color por cada uno
			if (is2List) {
				iColores.add(coloreoValido.get(i.intValue()));
				Integer color = rng.nextInt(c);
				// Si da el mismo, repetimos hasta conseguir otro
				while (color.equals(i))
					color = rng.nextInt(c);
				iColores.add(color);
			} else {
				// Acotamos t por c/2 para reducir la magnitud de
				// las variaciones de t y obtener resultados mas
				// consistentes
				Integer t = c/2; 
				
				iColores.addAll(elegirK(c, t));
				iColores.add(i);
			}
			colores.add(new ArrayList<>(iColores));
		}

		return new GrafoColoreo(n, colores, vecinos, c);
	}

	public List<Integer> elegirK(Integer c, Integer t) {
		List<Integer> colores = new LinkedList<>();
		List<Integer> elegidos = new LinkedList<>();
		for (int i = 0; i < c; i++) {
			colores.add(i);
		}
		for (int i = 0; i < t; i++) {
			int colorIndex = rng.nextInt(colores.size());
			elegidos.add(colores.get(colorIndex));
			colores.remove(colorIndex);
		}
		return elegidos;
	}

	public GrafoColoreo generarGrafoRandom(Integer n, Integer c) {
		List<List<Integer>> vecinos = new ArrayList<>();
		List<List<Integer>> colores = new ArrayList<>();

		// Agrego v menor o igual a n-1 vecinos
		for (Integer i = 0; i < n; i++) {
			List<Integer> aristas = new ArrayList<>();
			Integer cantVecinos = rng.nextInt(n);
			aristas = elegirK(n, cantVecinos);
			// No permitimos autoejes
			aristas.remove(i);

			vecinos.add(aristas);
		}

		// Agrego t menor o igual a c colores
		for (int i = 0; i < n; i++) {
			List<Integer> iColores = new ArrayList<>();
			// Entre 1 y c colores
			iColores = elegirK(c, c/2);
			colores.add(iColores);
		}
		return new GrafoColoreo(n, colores, vecinos, c);
	}

	// Arbol completo con la base unida de a pares.
	public GrafoColoreo generarArbolBinarioConBaseUnida(int n) {
		if (n % 2 == 0) {
			n++;
		}
		List<List<Integer>> vecinos = new ArrayList<>();
		List<List<Integer>> colores = new ArrayList<>();
		int niveles = (int) (Math.log(n) / Math.log(2));

		for (int i = 0; i < n; i++) {
			List<Integer> nuevaArista = new ArrayList<>();
			List<Integer> nuevosColores = new ArrayList<>();

			if (i < ((n + 1) / 2) - 1) {
				// No estoy en las hojas
				nuevaArista.add((i * 2) + 1);
				nuevaArista.add((i * 2) + 2);
				if (i != 0) {
					if (i % 2 == 0) {
						nuevaArista.add((i / 2) - 1);
					} else {
						nuevaArista.add((i - 1) / 2);
					}
				}
				nuevosColores.add(1);
				nuevosColores.add(2);

			} else {
				// Estoy en las hojas
				if (i % 2 == 0) {
					nuevaArista.add((i / 2) - 1);
					nuevaArista.add(i - 1);
					if (niveles % 2 != 0) {
						nuevosColores.add(1);
					} else {
						nuevosColores.add(2);
					}

					nuevosColores.add(3);
				} else {
					nuevaArista.add((i - 1) / 2);
					nuevaArista.add(i + 1);
					if (niveles % 2 != 0) {
						nuevosColores.add(1);
					} else {
						nuevosColores.add(2);
					}
					nuevosColores.add(3);
				}
			}
			colores.add(nuevosColores);
			vecinos.add(nuevaArista);
		}

		return new GrafoColoreo(n, colores, vecinos, 3);
	}

	public void exportArbolBinarioBaseUnida(Integer n) throws IOException {
		GrafoColoreo g = generarArbolBinarioConBaseUnida(n);
		String descripcion = "ab_n" + n + "_c3";
		export(g, calcularAristas(g), 3, descripcion);
	}

	public void exportSolvableKn(Integer n, Integer c, Boolean is2List) throws IOException {
		GrafoColoreo g = generarSolvableKn(n, c, is2List);
		String descripcion = "s_kn_n" + n + "_c" + c + (is2List ? "_2lc" : "");
		export(g, n - 1 * n, c, descripcion);
	}

	public void exportFullKn(Integer n, Integer c) throws IOException {
		GrafoColoreo g = generarFullKn(n, c);
		String descripcion = "f_kn_n" + n + "_c" + c;
		export(g, ((n - 1) * n), c, descripcion);
	}

	public void exportGrafoRandom(Integer n, Integer c) throws IOException {
		GrafoColoreo g = generarGrafoRandom(n, c);
		// Para el grafo random no podemos deducir la cantidad de aristas
		// a partir de su estructura
		Integer aristas = calcularAristas(g);
		String descripcion = "random_n" + n + "_c" + c;
		export(g, aristas, c, descripcion);
	}

	public void exportUnsolvableKn(Integer n, Integer c, Boolean is2List) throws IOException {
		GrafoColoreo g = generarUnsolvableKn(n, c, is2List);
		String descripcion = "u_kn_n" + n + "_c" + c + (is2List ? "_2lc" : "");
		export(g, n - 1 * n, c, descripcion);
	}

	public void exportUnsolvableKmn(Integer m, Integer n, Integer c, Boolean is2List) throws IOException {
		GrafoColoreo g = generarUnsolvableKmn(m, n, c, is2List);
		String descripcion = "u_kmn_m" + m + "n" + n + "_c" + c + (is2List ? "_2lc" : "");
		export(g, m * n, c, descripcion);
	}

	public void exportSolvableKmn(Integer m, Integer n, Integer c, Boolean is2List) throws IOException {
		GrafoColoreo g = generarSolvableKmn(m, n, c, is2List);
		String descripcion = "s_kmn_m" + m + "n" + n + "_c" + c + (is2List ? "_2lc" : "");
		export(g, m * n, c, descripcion);
	}

	private void export(GrafoColoreo g, Integer cantAristas, Integer cantColores, String filename) throws IOException {
		BufferedWriter writer = getWriter(filename);
		writer.append(String.valueOf(g.cantidadNodos()) + " " + cantAristas + " " + cantColores);
		writer.newLine();
		for (NodoColoreo nodoColoreo : g.nodos) {
			writer.append(pasarAStringColores(nodoColoreo));
			writer.newLine();
		}

		for (NodoColoreo nodoColoreo : g.nodos) {
			escribirAristas(nodoColoreo, writer);
		}
		writer.close();

	}

	private void escribirAristas(NodoColoreo nodoColoreo, BufferedWriter writer) throws IOException {
		for (NodoColoreo ady : nodoColoreo.getVecinos()) {
			writer.append(String.valueOf(nodoColoreo.getId()) + " " + String.valueOf(ady.getId()));
			writer.newLine();
		}

	}

	private String pasarAStringColores(NodoColoreo nodoColoreo) {
		StringBuffer sb = new StringBuffer();
		sb.append(String.valueOf(nodoColoreo.getColores().size()) + " ");
		for (Integer color : nodoColoreo.getColores()) {
			sb.append(String.valueOf(color) + " ");
		}
		return sb.toString();
	}

	private Integer calcularAristas(GrafoColoreo g) {
		Integer sumGrados = 0;
		for (NodoColoreo nodo : g.getNodos()) {
			sumGrados += nodo.getVecinos().size();
		}
		return sumGrados / 2;
	}

	public Long getSeed() {
		return seed;
	}

	public void setSeed(Long seed) {
		this.seed = seed;
		rng.setSeed(seed);
	}

	public String getTestSet() {
		return testSet;
	}

	public void setTestSet(String testSet) {
		this.testSet = testSet;
	}

	public Random getRng() {
		return rng;
	}

	public void setRng(Random rng) {
		this.rng = rng;
	}

}
