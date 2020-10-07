package uba.algo3.tp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListColoringBt {

	StringBuffer debugTree = new StringBuffer();
	Integer nivel = 0;

	public GrafoColoreo colorear(GrafoColoreo g) {
		Boolean haySolucion = true;
		Iterator<NodoColoreo> itNodos = g.nodos.iterator();
		while (itNodos.hasNext() && haySolucion) {
			NodoColoreo nodo = itNodos.next();
			if (!nodo.getVisto()) {
				// Como en cada dfs de backtracking (si es existoso) se marcan
				// todos los nodos como vistos, cuando hay solución solo se
				// ejecuta esto una vez por componente conexa.

				// Si no hay solución para una componente conexa, entonces no
				// hay solución para todo el grafo.
				haySolucion = haySolucion && dfsBacktracking(nodo);
			}
		}
		if (haySolucion) {
			return g;
		} else {
			return null;
		}
	}

	/**
	 * Busca una solución por backtracking a partir de un nodo de origen.
	 * Devuelve true si encontro una solución (los nodos quedan coloreados en el
	 * grafo al que pertenecen), o false si no hay solución.
	 * 
	 * @param nodoOrigen
	 * @return
	 */
	private Boolean dfsBacktracking(NodoColoreo nodoOrigen) {
		nodoOrigen.setVisto(true);
		for (Integer color : nodoOrigen.getColores()) {
			nodoOrigen.setColor(color);

			// Para debug, visualizamos el arbol de decision
			// System.out.print("\n");
			// for (int i = 0; i < nivel; i++) {
			// System.out.print("\t");
			// }
			// System.out.print(nodoOrigen.getId() + " : " + color);

			// Con este flag controlamos que el color elegido alcanze una
			// solucion para todos los vecinos.
			Boolean encontreSolucion = true;

			// Implicitamente estamos podando los casos en que dos
			// vecinos se pintan del mismo color, ya que al pintar
			// un nodo, sacamos ese color de los vecinos que lo compartan
			List<NodoColoreo> adyacentesQuiteColor = new ArrayList<>(nodoOrigen.getVecinos().size());
			for (NodoColoreo vecino : nodoOrigen.getVecinos()) {
				if (!vecino.getVisto()) {
					if (vecino.getColores().remove(color)) {
						vecino.getColoresEliminados().add(color);
						// Nos guardamos a que vecinos les quitamos el color en
						// este nivel para restituirlo en este mismo nivel y no
						// en alguno inferior si no lo visitamos todavia
						adyacentesQuiteColor.add(vecino);
					}

					// Si al hacer esto ya dejamos un vecino sin colores
					// posibles
					// no iteramos sobre los demas: no hay solucion con este
					// color.
					if (vecino.getColores().isEmpty()) {
						encontreSolucion = false;
					}
				}
			}

			Iterator<NodoColoreo> itVecinos = nodoOrigen.getVecinos().iterator();
			// Hay solucion sii cuando pinto el nodo de este color hay solucion
			// para todos los vecinos, osea si no encontramos solucion para un
			// vecino, entonces este color no sirve.
			while (itVecinos.hasNext() && encontreSolucion) {
				NodoColoreo nodo = itVecinos.next();
				// Si el nodo vecino no fue visto decidimos como seguir:
				// Si podemos usar 2ListColoring, lo hacemos
				if (!nodo.getVisto()) {
					GrafoColoreo subgrafo = construirSubgrafo(nodo);
					if (instancia2ListColoring(subgrafo)) {
						encontreSolucion = encontreSolucion && (resolver2ListColoring(subgrafo));
					} else {
//						nivel++;
						encontreSolucion = encontreSolucion && (dfsBacktracking(nodo));
//						nivel--;
					}
				}
			}

			// Restituimos los colores que ignoramos en los vecinos
			// antes de pasar al siguiente color
			for (NodoColoreo vecino : adyacentesQuiteColor) {
				if (vecino.getColoresEliminados().remove(color)) {
					vecino.getColores().add(color);
				}
			}

			// Si no visitamos ningun vecino y tenemos color con que pintar
			// encontramos un coloreo válido para esta rama.
			if (encontreSolucion) {
//				nivel = 0;
				return true;
			}
		}

		// Si al eliminar los colores conflictivos en los vecinos
		// llegamos a un nodo que no tiene colores validos, no hay solución
		// a partir de ese punto.
		// Si no llegamos a una solucion antes de analizar todos los nodos
		// Entonces no hay solución exacta para el problema.
		nodoOrigen.setVisto(Boolean.FALSE);
		return false;
	}

	private GrafoColoreo construirSubgrafo(NodoColoreo nodoOrigen) {
		// Construimos un subgrafo recorriendo los vecinos no visitados por el
		// backtracking
		// (es decir, sin color asignado), a partir de un nodo de origen.
		Queue<NodoColoreo> noVisitados = new LinkedList<>();
		List<NodoColoreo> nodosSubgrafo = new ArrayList<>();
		noVisitados.add(nodoOrigen);
		while (!noVisitados.isEmpty()) {
			NodoColoreo nodoSubgrafo = noVisitados.poll();
			nodoSubgrafo.setVisto(true);
			nodosSubgrafo.add(nodoSubgrafo);
			for (NodoColoreo vecino : nodoSubgrafo.getVecinos()) {
				if (!vecino.getVisto()) {
					noVisitados.add(vecino);
					vecino.setVisto(true);
				}
			}
		}

		GrafoColoreo subgrafo = new GrafoColoreo(nodosSubgrafo);
		for (NodoColoreo nodo : subgrafo.nodos) {
			nodo.setVisto(false);
		}
		return subgrafo;
	}

	private Boolean instancia2ListColoring(GrafoColoreo g) {
		Boolean is2List = Boolean.TRUE;
		Iterator<NodoColoreo> itNodos = g.nodos.iterator();
		while (is2List && itNodos.hasNext()) {
			Integer cantColores = itNodos.next().getColores().size();
			is2List = 0 < cantColores && cantColores <= 2;
		}
		return is2List;
	}

	public Boolean resolver2ListColoring(GrafoColoreo subgrafo) {
		// El subgrafo no necesariamente tiene nodos con ids desde 0
		// y puede tener aristas con nodos que no le pertenecen
		// (son nodos del grafo original)
		// Para poder usar nuestro algoritmo de 2ListColoring
		// Lo pasamos a un grafo sin estos problemas.

		List<NodoColoreo> nodos = new ArrayList<>(subgrafo.cantidadNodos());
		Integer id = 0;
		for (NodoColoreo nodo : subgrafo.nodos) {
			NodoColoreo nuevoNodo = new NodoColoreo(nodo);
			nuevoNodo.setId(id);
			id++;
			nodos.add(nuevoNodo);
		}

		// Como copiamos todos en orden, mantienen las relaciones de los indices
		// Por lo que usamos esto para quedarnos con las aristas entre nodos de
		// la lista
		for (Integer i = 0; i < subgrafo.cantidadNodos(); i++) {
			NodoColoreo nodo = subgrafo.getNodo(i);
			for (NodoColoreo vecino : nodo.getVecinos()) {
				Integer index = subgrafo.nodos.indexOf(vecino);
				if (index >= 0) {
					nodos.get(i).getVecinos().add(nodos.get(index));
				}
			}
		}
		GrafoColoreo g = new GrafoColoreo(nodos);
		TwoListColoring solver = new TwoListColoring();
		if (solver.colorear(g) != null) {
			for (Integer i = 0; i < subgrafo.cantidadNodos(); i++) {
				subgrafo.getNodo(i).setColor(nodos.get(i).getColor());
				subgrafo.getNodo(i).setVisto(true);
			}
			return true;
		} else {
			return false;
		}
	}

}
