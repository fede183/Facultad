package uba.algo3.tp2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

public class TestTiempos2 {

	Integer m = 100; // Promedio de m
	Integer valorFijo = 100;
	Integer incremento = 5;
	Integer valorMovilTope = 50;

	@Test
	public void variarN() throws IOException {
		BufferedWriter os = new BufferedWriter(
				new FileWriter(getClass().getResource("").getPath() + "Tp2Ej2.n.time.out"));

		// NL entre 1000 y 5000
		Integer l = valorFijo;
		HashMap<Integer, Double[]> resultados = new HashMap<>();
		for (Integer n = incremento; n <= valorMovilTope; n += incremento) {
			resultados.put(n * l, new Double[] { null, null });
		}

		for (Integer n = incremento; n <= valorMovilTope; n += incremento) {
			Long mejor = 0L;
			for (int j = 0; j < m; j++) {
				mejor += mejorCaso(n, l);
			}
			System.out.println("Mejor " + n * l + " hecho");
			resultados.get(n * l)[0] = Double.valueOf(mejor) / m;
		}

		for (Integer n = incremento; n <= valorMovilTope; n += incremento) {
			Long peor = 0L;
			for (int j = 0; j < m; j++) {
				peor += peorCaso(n, l);
			}
			System.out.println("Peor " + n * l + " hecho");
			resultados.get(n * l)[1] = Double.valueOf(peor) / m;
		}

		System.out.println("Escribiendo output...");
		// Ordenamos las keys para graficarlas correctamente en gnuplot
		ArrayList<Integer> keys = new ArrayList<Integer>(resultados.keySet());
		Collections.sort(keys);
		for (Integer key : keys) {
			os.append(key + " " + resultados.get(key)[0] + " " + resultados.get(key)[1] + "\n");
		}
		os.close();
	}

	@Test
	public void variarL() throws IOException {
		BufferedWriter os = new BufferedWriter(
				new FileWriter(getClass().getResource("").getPath() + "Tp2Ej2.l.time.out"));

		// NL entre 1000 y 5000
		Integer n = valorFijo;
		HashMap<Integer, Double[]> resultados = new HashMap<>();
		for (Integer l = incremento; l <= valorMovilTope; l += incremento) {
			resultados.put(l * n, new Double[] { 0.0, 0.0 });
		}

		for (Integer l = incremento; l <= valorMovilTope; l += incremento) {
			Long mejor = 0L;
			for (int j = 0; j < m; j++) {
				mejor += mejorCaso(n, l);
			}
			System.out.println("Mejor " + n * l + " hecho");
			resultados.get(n * l)[0] = Double.valueOf(mejor) / m;
		}

		for (Integer l = incremento; l <= valorMovilTope; l += incremento) {
			Long peor = 0L;
			for (int j = 0; j < m; j++) {
				peor += peorCaso(n, l);
			}
			System.out.println("Peor " + n * l + " hecho");
			resultados.get(n * l)[1] = Double.valueOf(peor) / m;
		}

		System.out.println("Escribiendo output...");
		// Ordenamos las keys para graficarlas correctamente en gnuplot
		ArrayList<Integer> keys = new ArrayList<Integer>(resultados.keySet());
		Collections.sort(keys);
		for (Integer key : keys) {
			os.append(key + " " + resultados.get(key)[0] + " " + resultados.get(key)[1] + "\n");
		}
		os.close();

	}

	@Test
	public void variarNOptimizado() throws IOException {
		BufferedWriter os = new BufferedWriter(
				new FileWriter(getClass().getResource("").getPath() + "Tp2Ej2.opt.time.out"));

		// NL entre 1000 y 5000
		Integer l = valorFijo;
		HashMap<Integer, Double[]> resultados = new HashMap<>();
		for (Integer n = incremento; n <= valorMovilTope; n += incremento) {
			resultados.put(n * l, new Double[] { null, null, null });
		}

		for (Integer n = incremento; n <= valorMovilTope; n += incremento) {
			Long mejor = 0L;
			for (int j = 0; j < m; j++) {
				mejor += mejorCasoOptimizado(n, l);
			}
			System.out.println("Mejor " + n * l + " hecho");
			resultados.get(n * l)[0] = Double.valueOf(mejor) / m;
		}

		for (Integer n = incremento; n <= valorMovilTope; n += incremento) {
			Long peor = 0L;
			for (int j = 0; j < m; j++) {
				peor += grafoCompletoOptimizado(n, l);
			}
			System.out.println("Grafo completo " + n * l + " hecho");
			resultados.get(n * l)[1] = Double.valueOf(peor) / m;
		}
		
		for (Integer n = incremento; n <= valorMovilTope; n += incremento) {
			Long peor = 0L;
			for (int j = 0; j < m; j++) {
				peor += peorCasoOptimizado(n, l);
			}
			System.out.println("Peor " + n * l + " hecho");
			resultados.get(n * l)[2] = Double.valueOf(peor) / m;
		}

		System.out.println("Escribiendo output...");

		// Ordenamos las keys para graficarlas correctamente en gnuplot
		ArrayList<Integer> keys = new ArrayList<Integer>(resultados.keySet());
		Collections.sort(keys);
		for (Integer key : keys) {
			os.append(key + " " + resultados.get(key)[0] + " " + resultados.get(key)[1] + " " + resultados.get(key)[2] + "\n");
		}
		os.close();
	}

	public Long peorCaso(int n, int l) {
		// Para el peor caso tomamos el grafo completo.
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < l + 1; j++) {
				for (int x = i; x < n + 1; x++) {
					for (int y = j + 1; y < l + 1; y++) {
						if (i != x || j != y) {
							Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(i, j), new Baldoza(x, y));
							portales.add(portal);
						}
					}
				}
			}
		}
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		return medirTiempo(ej2);
	}

	public Long mejorCaso(int n, int l) {
		// Para el peor caso tomamos el grafo completo.
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(0, 0), new Baldoza(n, l));
		portales.add(portal);
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		return medirTiempo(ej2);
	}

	public Long mejorCasoOptimizado(int n, int l) {
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(0, 0), new Baldoza(n, l));
		portales.add(portal);
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		long tiempo = System.currentTimeMillis();
		ej2.solveOpt();
		tiempo = System.currentTimeMillis() - tiempo;
		return tiempo;
	}

	public Long grafoCompletoOptimizado(int n, int l) {
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < l + 1; j++) {
				for (int x = i; x < n + 1; x++) {
					for (int y = j + 1; y < l + 1; y++) {
						if (i != x || j != y) {
							Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(i, j), new Baldoza(x, y));
							portales.add(portal);
						}
					}
				}
			}
		}
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		long tiempo = System.currentTimeMillis();
		ej2.solveOpt();
		tiempo = System.currentTimeMillis() - tiempo;
		return tiempo;
	}
	
	public Long peorCasoOptimizado(int n, int l) {
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		for (int i = 0; i < n ; i++) {
			for (int j = 0; j < l + 1; j++) {
				for (int x = i; x < n ; x++) {
					for (int y = j + 1; y < l + 1; y++) {
						if (i != x || j != y) {
							Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(i, j), new Baldoza(x, y));
							portales.add(portal);
						}
					}
				}
			}
		}
		
		Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(n-1, l), new Baldoza(n, 0));
		portales.add(portal);
		
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		long tiempo = System.currentTimeMillis();
		ej2.solveOpt();
		tiempo = System.currentTimeMillis() - tiempo;
		return tiempo;
	}

	private long medirTiempo(Ejercicio2 ej2) {
		long tiempo = System.currentTimeMillis();
		ej2.solve();
		tiempo = System.currentTimeMillis() - tiempo;
		return tiempo;
	}
}
