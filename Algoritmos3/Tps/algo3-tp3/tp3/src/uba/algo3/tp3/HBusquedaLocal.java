package uba.algo3.tp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class HBusquedaLocal {

	public static final Integer VECINDARIO_1 = 1;
	public static final Integer VECINDARIO_2 = 2;
	public static final Integer VECINDARIO_3 = 3;

	public GrafoColoreo busquedaLocal(GrafoColoreo g, Integer vecindario) {
		Integer conflictosIniciales = ColoringTestUtil.contarConflictos(g);
		GrafoColoreo solucionVecino = buscarEnVecindario(g, vecindario, conflictosIniciales);
		Integer conflictosVecino = ColoringTestUtil.contarConflictos(solucionVecino);
		while (conflictosVecino < conflictosIniciales) {
			// buscarMejorEnVecindario es decreciente
			// (si no encuentra mejor soluci�n que la que pasamos, devuelve la
			// misma)
			// por lo que con este criterio de parada nos aseguramos llegar al
			// minimo
			// local.
			conflictosIniciales = ColoringTestUtil.contarConflictos(solucionVecino);
			solucionVecino = buscarEnVecindario(solucionVecino, vecindario, conflictosVecino);
			conflictosVecino = ColoringTestUtil.contarConflictos(solucionVecino);
		}

		// Idem arriba, si no entro al while, solucionVecino = solucionInicial
		return solucionVecino;
	}

	public GrafoColoreo buscarEnVecindario(GrafoColoreo g, Integer vecindario, Integer conflictosIniciales) {
		if (VECINDARIO_1.equals(vecindario)) {
			return buscarMejorEnVecindario(g, conflictosIniciales);
		} else if (VECINDARIO_2.equals(vecindario)) {
			return buscarMejorEnVecindario2(g, conflictosIniciales);
		} else if (VECINDARIO_3.equals(vecindario)) {
			return buscarMejorEnVecindario3(g,conflictosIniciales);
		} else {
			return null;
		}

	}

	public GrafoColoreo buscarMejorEnVecindario(GrafoColoreo g, Integer conflictosIniciales) {
		// Vecindario I:
		// Soluciones alternativas obtenidas a partir de cambiar el color de un
		// nodo que entra en conflicto

		// Listamos todos los nodos con colores en comun con sus vecinos
		List<NodoColoreo> conflictos = new ArrayList<>(g.nodos.size());
		List<Integer> cantConflictos = new ArrayList<>();
		for (NodoColoreo nodo : g.nodos) {
			Integer conflictosEnNodo = ColoringTestUtil.cantConflictos(nodo);
			if (conflictosEnNodo>0) {
				conflictos.add(nodo);
				cantConflictos.add(conflictosEnNodo);
			}
		}

		// Partimos de la cantidad de conflictos inicial
		Integer mejorVecino = conflictosIniciales;
		NodoColoreo mejorCambio = null;

		// Por cada conflicto verificamos si se puede colorear el nodo de una
		// forma valida. De ser asi lo hacemos, sino pasamos al siguiente
		// conflicto.
		Iterator<Integer> itConflictos = cantConflictos.iterator();
		for (NodoColoreo conflicto : conflictos) {
			NodoColoreo nodoConflicto = g.getNodo(conflicto.getId());
			Integer colorOriginal = nodoConflicto.getColor();
			Integer conflictosEnNodo = itConflictos.next();

			
			List<Integer> coloresPosibles = new ArrayList<>(nodoConflicto.getColores());

			for(Integer color : coloresPosibles){
				nodoConflicto.setColor(color);

				// Si es mejor solucion, nos guardamos el cambio.
				Integer conflictosVecino = conflictosIniciales - conflictosEnNodo
						+ ColoringTestUtil.cantConflictos(nodoConflicto);
				if (conflictosVecino < mejorVecino) {
					mejorVecino = conflictosVecino;
					mejorCambio = new NodoColoreo(nodoConflicto);
				}
			}

			// Restituimos la solucion original
			nodoConflicto.setColor(colorOriginal);
		}

		// Si en el ciclo anterior encontramos un cambio que mejora la solucion
		// lo replicamos y devolvemos esa solucion.
		if (mejorCambio != null) {
			g.getNodo(mejorCambio.getId()).setColor(mejorCambio.getColor());
		}
		return g;
	}

	public GrafoColoreo buscarMejorEnVecindario2(GrafoColoreo g, Integer conflictosIniciales) {
		// Vecindario II:
		// Soluciones alternativas obtenidas a partir de, dado un nodo con
		// conflicto con algun vecino, cambiar el color del vecino de manera
		// que elimine el conflicto con el nodo.

		Integer mejorVecino = conflictosIniciales;
		NodoColoreo mejorCambio = null;

		// Listamos todos los nodos con colores en comun con sus vecinos
		List<NodoColoreo> conflictos = new ArrayList<>(g.nodos.size());
		for (NodoColoreo nodo : g.nodos) {
			if (ColoringTestUtil.cantConflictos(nodo)>0) {
				conflictos.add(nodo);
			}
		}

		for (NodoColoreo conflicto : conflictos) {
			for (NodoColoreo vecinoConf : conflicto.getVecinos()) {
				Integer colorOriginal = vecinoConf.getColor();
				NodoColoreo vecino = g.getNodo(vecinoConf.getId());
				if (vecino.getColor().equals(conflicto.getColor())) {
					List<Integer> coloresPosibles = new ArrayList<>(vecino.getColores());
					coloresPosibles.remove(conflicto.getColor());
					Integer confNodoVecinoOriginal = ColoringTestUtil.cantConflictos(vecino);
					// Probamos pintar el vecino con todos los colores restantes
					// (osea, los que no entran en conflicto con el nodo en que
					// estamos parados)
					for (Integer color : coloresPosibles) {
						vecino.setColor(color);
						Integer confNodoVecinoCambio = ColoringTestUtil.cantConflictos(vecino);
						// Si es mejor solucion, nos guardamos el cambio.
						Integer conflictosVecino = conflictosIniciales - confNodoVecinoOriginal + confNodoVecinoCambio;
						if (conflictosVecino < mejorVecino) {
							mejorVecino = conflictosVecino;
							mejorCambio = new NodoColoreo(vecino);
						}
					}

					// Restituimos la solucion original
					vecino.setColor(colorOriginal);
				}
			}
		}

		if (mejorCambio != null) {
			g.getNodo(mejorCambio.getId()).setColor(mejorCambio.getColor());
		}

		return g;

	}

	public GrafoColoreo buscarMejorEnVecindario3(GrafoColoreo g, Integer conflictosIniciales) {
		// Vecindario III:
		// Soluciones alternativas obtenidas a partir de, dado un nodo con
		// conflicto asignarle el siguiente que menos aparece, continuar hasta
		// encontrar uno valido.

		Integer mejorVecino = conflictosIniciales;
		NodoColoreo mejorCambio = null;

		// Listamos todos los nodos con colores en comun con sus vecinos
		List<NodoColoreo> conflictos = new ArrayList<>(g.nodos.size());
		List<Integer> cantConflictos = new ArrayList<>();
		for (NodoColoreo nodo : g.nodos) {
			Integer cantConflictosNodo = ColoringTestUtil.cantConflictos(nodo);
			if (cantConflictosNodo>0) {
				conflictos.add(nodo);
				cantConflictos.add(cantConflictosNodo);
			}
		}

		Iterator<Integer> itConflictos = cantConflictos.iterator();
		for (NodoColoreo conflicto : conflictos) {
			Integer colorOriginal = conflicto.getColor();
			Integer cantConflictosNodo = itConflictos.next();
			List<Integer> coloresPosibles = new ArrayList<>(conflicto.getColores());
			// Sacamos de la lista de colores posibles todos los que entran en
			// conflicto
			for (NodoColoreo vecino : conflicto.getVecinos()) {
				coloresPosibles.remove(vecino.getColor());
			}

			Integer colorNuevo = colorOriginal;

			// Si hay colores validos, elijo como nuevo color el segundo que
			// aparece menos en los vecinos del nodo.
			if (!coloresPosibles.isEmpty()) {
				Integer[] apariciones = new Integer[g.getCantColores()+1];
				for(Integer i = 0; i<g.getCantColores()+1; i++){
					apariciones[i] = 0;
				}
				
				for (NodoColoreo vecino : conflicto.getVecinos()) {
					for (Integer colorVecino : vecino.getColores()) {
						apariciones[colorVecino]++;
					}
				}

				List<Integer> aparicionesColoresPosibles = new ArrayList<>();
				Integer colorMinApariciones = null;
				Integer minApariciones = Integer.MAX_VALUE;
				Integer colorSiguienteMinApariciones = null;
				Integer siguienteMinApariciones = Integer.MAX_VALUE;

				for (Integer colorPosible : coloresPosibles) {
					aparicionesColoresPosibles.add(apariciones[colorPosible]);
					if (apariciones[colorPosible] < minApariciones) {
						colorMinApariciones = colorPosible;
						minApariciones = apariciones[colorPosible];
					}

					if ((apariciones[colorPosible] > minApariciones
							&& apariciones[colorPosible] < siguienteMinApariciones)) {
						colorSiguienteMinApariciones = colorPosible;
						siguienteMinApariciones = apariciones[colorPosible];
					}
				}
				if (colorSiguienteMinApariciones == null) {
					colorSiguienteMinApariciones = colorMinApariciones;
				}
				colorNuevo = colorSiguienteMinApariciones;
			}

			conflicto.setColor(colorNuevo);
			Integer cantConflictosCambio = ColoringTestUtil.cantConflictos(conflicto);
			// Si es mejor solucion, nos guardamos el cambio.
			Integer conflictosVecino = conflictosIniciales - cantConflictosNodo + cantConflictosCambio;
			if (conflictosVecino < mejorVecino) {
				mejorVecino = conflictosVecino;
				mejorCambio = new NodoColoreo(conflicto);
			}

			// Restituimos la solucion original
			conflicto.setColor(colorOriginal);
		}

		// Si en el ciclo anterior encontramos un cambio que mejora la
		// solucion lo replicamos y devolvemos esa solucion
		if (mejorCambio != null) {
			g.getNodo(mejorCambio.getId()).setColor(mejorCambio.getColor());
		}
		return g;

	}

}
