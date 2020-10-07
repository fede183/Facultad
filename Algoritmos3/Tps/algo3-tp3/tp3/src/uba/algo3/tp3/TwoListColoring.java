package uba.algo3.tp3;

import java.util.List;

public class TwoListColoring {

	public GrafoColoreo colorear(GrafoColoreo g) {
		GrafoKosaraju grafo = new GrafoKosaraju(g);
		List<List<NodoKosaraju>> componentesFC = Kosaraju.listarCFCs(grafo);

		// Recorremos la lista de componentes FC en orden topo
		// Las primeras que encontramos las damos por falsas y marcamos
		// las que tengan los componentes negados de estas como verdaderas

		// Esto es por lo que comentaba Leopoldo sobre equivalencias
		// entre implicaciones de literales y sus negados
		// Ej: !a => !b => c <=> !c => b => a

		Boolean componentes[] = new Boolean[componentesFC.size()];

		for (Integer i = 0; i < componentesFC.size(); i++) {
			List<NodoKosaraju> compFuertementeConexa = componentesFC.get(i);

			for (NodoKosaraju nodo : compFuertementeConexa) {
				// Si un nodo y su negacion estan en la misma CFC, no hay
				// solución.
				if (contieneNegado(nodo, compFuertementeConexa)) {
					return null;
				}
			}

			// Si no le asignamos un valor, esta comp es falsa
			// y las componentes que tengan alguno de sus elementos negados
			// son verdaderas
			if (componentes[i] == null) {
				componentes[i] = false;
				// Vemos solo las que aun no analizamos
				for (Integer j = i; j < componentesFC.size(); j++) {
					for (NodoKosaraju nodo : compFuertementeConexa) {
						if (contieneNegado(nodo, componentesFC.get(j))) {
							componentes[j] = true;
						}
					}
				}

			}
		}

		// Nos quedamos con los nodos no-negados de las comps verdaderas
		for (Integer i = 0; i < componentesFC.size(); i++) {
			if (componentes[i]) {
				for (NodoKosaraju nodo : componentesFC.get(i)) {
				
					if (!nodo.getNegado()) {
						g.getNodo(nodo.getId()).setColor(nodo.getColor());
					}
				}
			}
		}

		return g;
	}

	private Boolean contieneNegado(NodoKosaraju nodo, List<NodoKosaraju> compFuertementeConexa) {
		for (NodoKosaraju nodoB : compFuertementeConexa) {
			if (nodo.getId() == nodoB.getId() && nodo.getNegado().equals(!nodoB.getNegado())
					&& nodo.getColor().equals(nodoB.getColor())) {
				return true;
			}
		}
		return false;
	}

}
