package uba.algo3.tp2;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import uba.algo3.tp2.ej1.MaximoPortales;
import uba.algo3.tp2.ej1.Piso;

public class Ejercicio1 {

	Vector<Piso> pisos;
	Integer cantPisos;

	public Ejercicio1(int p, List<Portal> portales) {
		pisos = new Vector<Piso>(p);
		for (int i = 0; i < p + 1; i++) {
			List<Integer> antecesores = new LinkedList<Integer>();
			Piso piso = new Piso(i, antecesores);
			pisos.add(piso);
		}
		for (Portal<Integer> portal : portales) {
			pisos.get(portal.getHasta()).getAntecesores().add((Integer) portal.getDesde());
		}
	}

	public int solve() {
		return new MaximoPortales(pisos).caminoMaximo();
	}

}