package uba.algo3.tp1;

import java.util.Vector;

import uba.algo3.Utils;

public class Ronda {

	// Implementacion de la ronda
	// Con esta clase queremos representar la ronda de exploradoras.
	// De la ronda queremos saber la distancia entre dos exploradoras dadas.

	Vector<Character> exploradoras;

	public Ronda(int size) {
		exploradoras = new Vector<>(size);
	}

	public int size() {
		return exploradoras.size();
	}

	public Character get(int pos) {
		return exploradoras.get(pos);
	}

	public void set(int pos, Character val) {
		try{
			exploradoras.set(pos, val);
		}catch(IndexOutOfBoundsException ex){
			exploradoras.insertElementAt(val, pos);
		}
	}
	
	public void remove(int pos){
		exploradoras.remove(pos);
	}

	public String toString() {
		return Utils.collectionToString(exploradoras,"");
	}

	/**
	 * Conociendo la ubicacion de cada exploradora, calcula la distancia entre
	 * ellas. </br>
	 * O(1)
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public int distance(Integer a, Integer b) {
		if (a > b) {
			int aux = b;
			b = a;
			a = aux;
		}

		if (b - a > exploradoras.size() / 2) {
			return exploradoras.size() + a - b;
		} else {
			return b - a;
		}
	}

	/**
	 * Mide la distancia entre dos exploradoras de la ronda. </br>
	 * O(e) con e = cantida de exploradoras
	 * 
	 * @param a
	 *            (que pertenece a la ronda)
	 * @param b
	 * @return distancia entre a y b si b pertence a la ronda, -1 sino
	 */
	public int distance(Character a, Character b) {
		return distance(exploradoras.indexOf(a), exploradoras.indexOf(b));
	}

}
