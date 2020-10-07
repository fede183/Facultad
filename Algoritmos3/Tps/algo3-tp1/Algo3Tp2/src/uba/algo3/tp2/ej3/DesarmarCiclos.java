package uba.algo3.tp2.ej3;

import java.util.List;
import java.util.PriorityQueue;

import uba.algo3.tp2.Pasillo;

public class DesarmarCiclos {
	/*
	 * Grafo de entrada conexo (con o sin ciclos)
	 * 
	 * Arbol generador minimo de Kruskal, pero buscando arbol maximo, queremos
	 * dejar afuera las aristas que menos cuesten. Podemos justificar que sea un
	 * arbol (osea conexo, ademas de aciclico) porque no tendria sentido dejar
	 * pasillos inaccesibles.
	 * 
	 */

	PriorityQueue<Pasillo> pasillos;
	UFSet grafoUnionFind;

	public DesarmarCiclos(List<Pasillo> pasillos) {

		// Pasamos los pasillos a un MaxHeap. Queremos elegir los mas pesados
		// para el AGM para minimizar el peso de las que quedan fuera.
		this.pasillos = new PriorityQueue<Pasillo>(pasillos);
		Integer n = 0;

		//Obtenemos la cantidad de vertices
		for (Pasillo pasillo : pasillos) {
			n = Math.max(n, Math.max(pasillo.getExtremo1() , pasillo.getExtremo2()));
		}
		grafoUnionFind = new UFSet(n+1);
	}

	public Integer desarmarCiclos() {
		Integer sumaPasillosEliminados = 0;
		while (pasillos.peek() != null) {
			// Desencolamos
			Pasillo pasillo = pasillos.poll();

			// Pasamos a Integer, java generics no se banca clases parametricas
			// con tipos primitivos
			Integer e1 = Integer.valueOf(pasillo.getExtremo1());
			Integer e2 = Integer.valueOf(pasillo.getExtremo2());

			// Buscamos en que conjunto esta cada extremo
			if (grafoUnionFind.connected(e1, e2)) {
				// Estan el mismo: se forma un ciclo, sacamos esta arista
				sumaPasillosEliminados += pasillo.getLongitud();
			} else {
				// No se forma un ciclo, agregamos esta arista al AGM
				grafoUnionFind.union(e1, e2);
			}
		}
		return sumaPasillosEliminados;
	}

}
