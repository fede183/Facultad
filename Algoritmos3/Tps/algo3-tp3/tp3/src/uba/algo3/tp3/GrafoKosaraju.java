package uba.algo3.tp3;

import java.util.ArrayList;
import java.util.List;

public class GrafoKosaraju {

	// Dos listas de nodos para representar los colores
	// posibles para cada uno.
	List<NodoKosaraju> nodosA;
	List<NodoKosaraju> nodosB;

	List<NodoKosaraju> nodos;

	// La cantidad de nodos del grafo original
	// Lo usamos como offset para acceder
	// a los nodos / nodos negados
	Integer n;

	public GrafoKosaraju() {
	}

	public GrafoKosaraju(GrafoColoreo g) {
		n = g.cantidadNodos();
		initNodos(n);

		// Agregamos todos los nodos/color con los que vamos a trabajar.
		for (NodoColoreo v : g.nodos) {
			NodoKosaraju nodoColorA = new NodoKosaraju(v, v.getColores().get(
					0));
			NodoKosaraju negNodoColorA = new NodoKosaraju(v, v.getColores()
					.get(0), Boolean.TRUE);
			this.agNodo(nodoColorA);
			this.agNodo(negNodoColorA);

			if (v.getColores().size() > 1) {
				NodoKosaraju nodoColorB = new NodoKosaraju(v, v.getColores()
						.get(1));
				NodoKosaraju negNodoColorB = new NodoKosaraju(v, v
						.getColores().get(1), Boolean.TRUE);
				this.agNodo(nodoColorB);
				this.agNodo(negNodoColorB);
			}
		}

		for (NodoColoreo v : g.nodos) {
			Integer colorA = v.getColores().get(0);
			if (v.getColores().size() > 1) {
				Integer colorB = v.getColores().get(1);

				// Por cada vertice tenemos dos colores a y b
				// Por lo que solo puede ser a o b
				// Y a v b se traduce por DeMorgan a (!a => b) ^ (!b => a)
				// Estas implicaciones con dos literales son las que definen
				// los ejes en el grafo para Kosaraju.

				
				this.agEje(v.getId(), v.getId(), Boolean.TRUE, Boolean.FALSE,
						colorA, colorB);
				this.agEje(v.getId(), v.getId(), Boolean.TRUE, Boolean.FALSE,
						colorB, colorA);
				
				// Agregamos tambien la vuelta de estas implicaciones, son sii
				this.agEje(v.getId(), v.getId(), Boolean.FALSE, Boolean.TRUE,
						colorA, colorB);
				this.agEje(v.getId(), v.getId(), Boolean.FALSE, Boolean.TRUE,
						colorB, colorA);
				
			}else{
				// Si solo tienen un color a lo interpretamos como a v a
				// Luego, lo reescribimos como (!a => a) y agregamos ese eje
				this.agEje(v.getId(), v.getId(), Boolean.TRUE, Boolean.FALSE,
						colorA, colorA);
			}

			for (NodoColoreo vecino : v.getVecinos()) {
				// Por cada vecino, no puede estar en ambos el mismo color
				// Osea, con a color, v y w verices: !(Va ^ Wa)
				// Por DeMorgan es equivalente a !Va v !Wa
				// Que al igual que arriba, se abre en dos implicaciones:
				// Va => !Wa y Wa => !Va

				for (Integer color : v.getColores()) {
					if (vecino.estaColor(color)) {
						this.agEje(v.getId(), vecino.getId(), Boolean.FALSE,
								Boolean.TRUE, color, color);
						this.agEje(vecino.getId(), v.getId(), Boolean.FALSE,
								Boolean.TRUE, color, color);
					}
				}
			}
		}

		// Una vez relacionados todos los vertices, agrupamos los nodos
		nodos = new ArrayList<>(4 * n);
		addAllNotNull(nodos,nodosA);
		addAllNotNull(nodos,nodosB);
		
	}
	
	private void addAllNotNull(List<NodoKosaraju> to, List<NodoKosaraju> from){
		for(NodoKosaraju b : from){
			if(b != null){
				to.add(b);
			}
		}
	}

	private void initNodos(Integer tamanio) {
		// Listas del doble del tamaño original para representar
		// en los primeros n la negacion de esos nodos/color
		nodosA = new ArrayList<NodoKosaraju>(tamanio * 2);
		nodosB = new ArrayList<NodoKosaraju>(tamanio * 2);
		this.n = tamanio;

		// Inicializamos todas las posiciones para luego setear por id
		for (int i = 0; i < 2 * n; i++) {
			nodosA.add(null);
			nodosB.add(null);
		}
	}

	private void agNodo(NodoKosaraju nodo) {
		// Ubicamos el nodo primero en nodosA, si se puede
		Integer index = getIndexOffset(nodo.getId(), nodo.getNegado());
		if (nodosA.get(index) == null) {
			nodosA.set(index, nodo);
		} else {
			nodosB.set(index, nodo);
		}
	}

	private int getIndexOffset(Integer id, Boolean negado) {
		return id + (negado ? 0 : n);
	}

	private void agEje(Integer idA, Integer idB, Boolean negadoA,
			Boolean negadoB, Integer colorA, Integer colorB) {
		NodoKosaraju origen;
		NodoKosaraju destino;

		int indexA = getIndexOffset(idA, negadoA);
		int indexB = getIndexOffset(idB, negadoB);

		// Buscamos primero en nodosA si esta el color que queremos vincular
		// porque si hay solo un color, va a estar ahi. (por agNodo)
		if (nodosA.get(indexA).getColor().equals(colorA)) {
			origen = nodosA.get(indexA);
		} else {
			origen = nodosB.get(indexA);
		}

		if (nodosA.get(indexB).getColor().equals(colorB)) {
			destino = nodosA.get(indexB);
		} else {
			destino = nodosB.get(indexB);
		}

		origen.getVecinos().add(destino);
	}

	public List<NodoKosaraju> getNodos() {
		return nodos;
	}

	public GrafoKosaraju invertir() {
		GrafoKosaraju inverso = new GrafoKosaraju();
		inverso.initNodos(n);

		// Copiamos las listas de nodos sin los vecinos.
		for (Integer i = 0; i < nodosA.size(); i++) {
			NodoKosaraju nodoA = new NodoKosaraju(nodosA.get(i), nodosA
					.get(i).getColor(), nodosA.get(i).getNegado());
			NodoKosaraju nodoB = null;
			if (nodosB.get(i) != null) {
				nodoB = new NodoKosaraju(nodosB.get(i), nodosB.get(i)
						.getColor(), nodosB.get(i).getNegado());
			}
			inverso.nodosA.set(i, nodoA);
			inverso.nodosB.set(i, nodoB);
		}

		// Agregamos los ejes inversos
		for (NodoKosaraju nodo : nodos) {
			for (NodoKosaraju nodoVecino : nodo.getVecinos()) {
				inverso.agEje(nodoVecino.getId(), nodo.getId(),
						nodoVecino.getNegado(), nodo.getNegado(),
						nodoVecino.getColor(), nodo.getColor());
			}
		}
		
		inverso.nodos = new ArrayList<>(4 * n);
		addAllNotNull(inverso.nodos,inverso.nodosA);
		addAllNotNull(inverso.nodos,inverso.nodosB);

		return inverso;
	}

	public NodoKosaraju getNodo(int id, Boolean negado, Integer color) {
		NodoKosaraju nodo = nodosA.get(getIndexOffset(id, negado));
		if (nodo.getColor().equals(color)) {
			return nodo;
		} else {
			return nodosB.get(getIndexOffset(id, negado));
		}
	}

}