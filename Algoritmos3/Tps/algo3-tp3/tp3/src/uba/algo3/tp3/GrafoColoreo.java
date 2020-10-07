package uba.algo3.tp3;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import uba.algo3.Utils;

public class GrafoColoreo {
	//Nuesto grafo funciona como una lista de adyacencia.
	List<NodoColoreo> nodos = new ArrayList<NodoColoreo>();
	Integer cantColores = 0;

	public GrafoColoreo(int cant, List<List<Integer>> colores,
			List<List<Integer>> vecinos, Integer cantColores) {
		// Creo y agrego todas las materias a mi grafo.
		for (int i = 0; i < cant; i++) {
			NodoColoreo nueva = new NodoColoreo(i, colores.get(i));
			nodos.add(nueva);
		}

		// Les agrego a todas sus vecinos.
		for (int i = 0; i < vecinos.size(); i++) {
			for (Integer vecino : vecinos.get(i)) {
				if(!nodos.get(i).getVecinos().contains(nodos.get(vecino))){
					nodos.get(i).getVecinos().add(nodos.get(vecino));
				}
				
				if(!nodos.get(vecino).getVecinos().contains(nodos.get(i))){
					nodos.get(vecino).getVecinos().add(nodos.get(i));
				}
				
			}
		}
		this.cantColores = cantColores;
	}

	public GrafoColoreo(List<NodoColoreo> nodos) {
		this.nodos = nodos;
	}

	public static GrafoColoreo fromInput(BufferedReader source)
			throws IOException {
		String line;
		List<List<Integer>> colores = new ArrayList<>();
		List<List<Integer>> vecinos = new ArrayList<>();
		List<Integer> aux = Utils.parseVector(source.readLine());
		Integer n = aux.get(0);
		Integer c = aux.get(2);
		Integer m = aux.get(1);
		Integer lineNumber = 0;
		while ((line = source.readLine()) != null) {
			// Voy armando la lista de los colores de cada nodo.
			if (lineNumber < n) {
				List<Integer> nuevaLista = Utils.parseVector(line);
				// El primer elemento es la cantidad de colores del nodo
				nuevaLista.remove(0);

				colores.add(nuevaLista);

				List<Integer> listaVacia = new ArrayList<>();
				vecinos.add(listaVacia);
			} else {
				// Voy armando las aristas entre los vertices.
				List<Integer> arista = Utils.parseVector(line);
				int u = arista.get(0);
				int v = arista.get(1);
				if(!vecinos.get(u).contains(v)){
					vecinos.get(u).add(v);
				}
				if(!vecinos.get(v).contains(u)){
					vecinos.get(v).add(u);
				}
			}

			lineNumber++;
		}

		return new GrafoColoreo(n, colores, vecinos, c);
	}

	public NodoColoreo getNodo(int i) {
		return nodos.get(i);
	}

	public int cantidadNodos() {
		return nodos.size();
	}

	public void setAllVisto(Boolean visto) {
		for (NodoColoreo nodo : nodos) {
			nodo.setVisto(visto);
		}
	}

	/** Devuelve algun nodo del grafo si existe uno no visitado, null sino */
	public NodoColoreo getNodoNoVisitado() {
		for (NodoColoreo nodo : nodos) {
			if (!nodo.getVisto()) {
				return nodo;
			}
		}
		return null;
	}

	public List<NodoColoreo> getNodos() {
		return nodos;
	}

	public void setNodos(List<NodoColoreo> nodos) {
		this.nodos = nodos;
	}

	public Integer getCantColores() {
		return cantColores;
	}

	public void setCantColores(Integer cantColores) {
		this.cantColores = cantColores;
	}
}
