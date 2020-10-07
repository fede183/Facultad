package uba.algo3.tp2;

import java.util.List;

import uba.algo3.tp2.ej3.DesarmarCiclos;

public class Ejercicio3 {

	List<Pasillo> pasillos;

	public Ejercicio3(List<Pasillo> ps) {
		pasillos = ps;
	}

	public int solve() {
		return new DesarmarCiclos(pasillos).desarmarCiclos();
	}

}