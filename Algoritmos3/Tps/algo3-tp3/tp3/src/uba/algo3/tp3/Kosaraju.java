package uba.algo3.tp3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Kosaraju {

	private static void dfs(NodoKosaraju nodoOrigen, Stack<NodoKosaraju> nodos) {
		nodoOrigen.setVisto(true);
		for (NodoKosaraju nodo : nodoOrigen.getVecinos()) {
			if (!nodo.getVisto()) {
				dfs(nodo, nodos);
			}
		}
		nodos.push(nodoOrigen);
	}

	public static List<List<NodoKosaraju>> listarCFCs(GrafoKosaraju grafo) {
		GrafoKosaraju grafoInverso = grafo.invertir();
		List<List<NodoKosaraju>> componentes = new ArrayList<>();
		
		Stack<NodoKosaraju> nodos = new Stack<>();
		for (NodoKosaraju nodo : grafo.getNodos()) {
			if (!nodo.getVisto()) {
				dfs(nodo, nodos);
			}
		}
		
		while(!nodos.isEmpty()){
			NodoKosaraju nodo = nodos.pop();
			NodoKosaraju nodoEnInverso = grafoInverso.getNodo(nodo.getId(), nodo.getNegado(), nodo.getColor());
			if(!nodoEnInverso.getVisto()){
				Stack<NodoKosaraju> componente = new Stack<>();
				dfs(nodoEnInverso,componente);
				componentes.add(componente);
			}
		}
		
		return componentes;
	}

}
