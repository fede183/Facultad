package uba.algo3.tp3;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class HCGolosa {

	private GrafoColoreo colorear(GrafoColoreo g) {
		for (NodoColoreo nodo : g.nodos) {
			Integer color = 0;
			// Si la lista de colores esta vac�a es porque eliminamos
			// todos (porque entraban en conflicto con algun vecino)
			if(nodo.getColores().isEmpty()){
				// En ese caso elegimos arbitrariamente alguno de los eliminados
				// ya que es inevitable que entre en conflicto
				color = nodo.getColoresEliminados().get(0);
			}else{
				color = nodo.getColores().get(0);
			}
			nodo.setColor(color);
		}
		return g;
	}

	/**  Busco el color que menos veces aparece en los nodos adyacentes y pinto a
	mi nodo de este.**/
	public GrafoColoreo HCGolosa1(GrafoColoreo g) {
		for (NodoColoreo nodo : g.nodos) {
			Integer color = nodo.colorMenosAparecido();
			nodo.quitarColorAdyacentes(color);
		}
		return g;
	}

	/**  Idem anterior pero haciendo un BFS para recorrer el grafo.**/
	public GrafoColoreo HCGolosa1BFS(GrafoColoreo g) {

		Queue<NodoColoreo> cola = new LinkedList<>();

		while (g.getNodoNoVisitado() != null) { // Si me quedan nodos por visitar.

			NodoColoreo noVisitado = g.getNodoNoVisitado();
			cola.add(noVisitado);
			noVisitado.setVisto(true);

			while (!cola.isEmpty()) {

				// Obtengo el nodo y encuentro su color segun la heuristica.
				NodoColoreo nodoActual = cola.poll();
				Integer nColor = nodoActual.colorMenosAparecido();
				nodoActual.quitarColorAdyacentes(nColor);

				// Guardo el color
				nodoActual.setColor(nColor);

				// Recorro todos los vecinos no visitados.
				List<NodoColoreo> nVecinos = nodoActual.getVecinos();
				for (NodoColoreo vecino : nVecinos) {
					if (!vecino.getVisto()) {
						vecino.setVisto(true);
						cola.add(vecino);
					}
				}
			}
		}

		return g;
	}

	/**  Consiste en buscar todos los de unos y sacar ese color de los adyacentes,
	repetir esto hasta que no queden de uno.**/
	public GrafoColoreo HCPrimeroElDeUno(GrafoColoreo g) {
		// Mientras exista alguno de uno no visitado.
		while (actualizaTodosLosDeUno(g)) {
		}
		return colorear(g);
	}

	// Este se trata de hacer la heuristica 2 después de hacer la 3.
	public GrafoColoreo HCCombinado(GrafoColoreo g) {
		HCPrimeroElDeUno(g);
		g.setAllVisto(false);
		return HCGolosa1BFS(g);

	}
	
	/** Busca en el grafo todos los que tienen un solo color y los pinta de este.**/
	public boolean actualizaTodosLosDeUno(GrafoColoreo g) {
		boolean resultado = false;

		for (NodoColoreo nodo : g.nodos) {
			// Si el nodo solo se puede pintar de un color posible y no fue
			// visitado
			if (nodo.getColores().size() == 1 && !nodo.getVisto()) {
				// Devuelvo true si y solo si tube que modificar algun nodo.
				resultado = true;
				// No vuelvo a ver dos veces el mismo nodo.
				nodo.setVisto(true);
				// Obtengo ese color
				Integer color = nodo.getColores().get(0);
				// Y lo quito de los adyacentes
				nodo.quitarColorAdyacentes(color);
			}
		}

		return resultado;
	}

}
