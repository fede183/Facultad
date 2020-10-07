package uba.algo3.tp1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.PriorityQueue;

public class AMedias {

	public List<Integer> Medianas(List<Integer> arreglo) {
		// La implementaci�n por defecto de java para PQs usa orden natural 
		// (para tipos numericos, orden ascendiente)
		// Por lo que se comporta como un MinHeap (la cabeza de la cola es el minimo)
		PriorityQueue<Integer> mayores = new PriorityQueue<Integer>();
		
		// Para que se comporte como un MaxHeap, invertimos el orden
		PriorityQueue<Integer> menores = new PriorityQueue<Integer>(arreglo.size(), Collections.reverseOrder()); 
		
		// Cantidad de elemntos vistos, nos sirve para saber si es par o impar
		
		ListIterator<Integer> itArreglo = arreglo.listIterator();
		List<Integer> resultado = new ArrayList<Integer>();

		// Agrego el primero, que siempre queda igual, y lo pongo en menores
		if (itArreglo.hasNext()) { 
			Integer aAgregar = itArreglo.next();
			resultado.add(aAgregar);
			menores.add(aAgregar);
		}

		while (itArreglo.hasNext()) {
			Integer actual = itArreglo.next();
			
			// Lo agrego en la que corresponde
			if (menores.peek() >= actual) {
				menores.add(actual);
			} else {
				mayores.add(actual);
			}

			Integer cantidadNumeros = mayores.size() + menores.size(); 
			
			// Si tienen una diferencia mayor o igual a 2, pongo el menor o mayor segun
			// corresponda en la del otro
			if (mayores.size() - menores.size() == 2) {
				menores.add(mayores.peek());
				mayores.remove(mayores.peek());
			} else if (mayores.size() - menores.size() == -2) {
				mayores.add(menores.peek());
				menores.remove(menores.peek());
			}

			if (cantidadNumeros % 2 == 0) { 
				// Si es par
				resultado.add((mayores.peek() + menores.peek()) / 2);
			} else { 
				// Si es impar
				if (menores.size() < mayores.size()) {
					resultado.add(mayores.peek());
				} else {
					resultado.add(menores.peek());
				}
			}
		}
		return resultado;
	}
}
