package uba.algo3.tp2.ej2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Vector;

public class MinimoPortales {

	/*
	 * Breadth first search con listas de adyacencia. L*N es la cantidad de
	 * vertices (las posiciones posibles) P es la cantidad de aristas
	 * 
	 * Tomamos L*N como cantidad de vertices para "normalizar" los costos
	 * Agregamos tambien un vertice por cada arista para el mismo proposito.
	 * 
	 * Podemos guardar cada portal en una matriz de L*N, donde cada
	 * posicion(piso,metro) guarda una lista de los destinos de esa posicion (si
	 * esta vacía, solo se conecta con las posiciones a los costados, una de las
	 * cuales ya visitamos, asi que solo suma un vertice a la cola)
	 * 
	 */

	Vector<Vector<Posicion>> mapaPortales;
	Integer n;
	Integer l;

	public MinimoPortales(Integer n, Integer l, Vector<Vector<Posicion>> mapaPortales) {
		this.mapaPortales = mapaPortales;
		this.n = n;
		this.l = l;
	}

	/**
	 * Camino minimo por BFS. Para adaptarlo al grafo con aristas pesadas, al
	 * parsear la entrada consideramos todos los puntos posibles (piso,metro)
	 * como vertices. <br/>
	 * Todos son adyacentes a los puntos (piso,metro+1) y (piso,metro-1) donde
	 * estas posiciones son validas. Si hay un portal, se suman las posiciones
	 * destino a los vecinos de la posicion donde esta ubicado.<br/>
	 * Dentro del algoritmo, cuando encontramos un portal agregamos una arista
	 * ficticia de "loop" a si mismo, para representar el costo 2 de usar un
	 * portal.
	 * 
	 * 
	 */
	public Integer caminoMinimo(Boolean optimizar) {
		Queue<Posicion> verticesRestantes = new LinkedList<Posicion>();
		verticesRestantes.add(mapaPortales.get(0).get(0));
		while (!verticesRestantes.isEmpty()) {
			Posicion pos = verticesRestantes.poll();
			for (Posicion destino : pos.getVecinos()) {
				if (destino.distancia.equals(0)) {
					if (hayPortal(pos, destino)) {
						Posicion portalBuffer = new Posicion(destino.piso, destino.metro);
						portalBuffer.distancia = pos.distancia + 1;
						portalBuffer.vecinos.add(destino);
						verticesRestantes.add(portalBuffer);
					} else {
						destino.distancia = pos.distancia + 1;
						verticesRestantes.add(destino);
					}
				}
				if(optimizar && !mapaPortales.get(n).get(l).distancia.equals(0)){
					return mapaPortales.get(n).get(l).distancia;
				}
			}
		}
		return mapaPortales.get(n).get(l).distancia;
	}

	/**
	 * Asumimos neighbor vecino de pos. <br/>
	 * Si estan en distinto piso o a distancia > 1, entre ellos hay un portal.
	 * Si hubiera entre dos posiciones consecutivas lo ignoramos, es mas barato
	 * caminar.
	 */
	Boolean hayPortal(Posicion pos, Posicion neighbor) {
		return !pos.piso.equals(neighbor.piso) || Math.abs(pos.metro - neighbor.metro) > 1;
	}
}
