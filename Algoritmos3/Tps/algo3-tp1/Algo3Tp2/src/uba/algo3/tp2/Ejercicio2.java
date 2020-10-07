package uba.algo3.tp2;

import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import uba.algo3.tp2.ej2.MinimoPortales;
import uba.algo3.tp2.ej2.Posicion;

public class Ejercicio2 {
	Vector<Vector<Posicion>> mapaPortales;
	Integer n;
	Integer l;

	public Ejercicio2(int n, int l, List<Portal<Baldoza>> portales) {
		this.n = n;
		this.l = l;
		mapaPortales = new Vector<Vector<Posicion>>();

		for (int i = 0; i < n + 1; i++) {
			mapaPortales.add(new Vector<Posicion>());
			for (int j = 0; j < l + 1; j++) {
				Posicion pos = new Posicion(i, j);
				List<Posicion> vecinos = new LinkedList<Posicion>();
				pos.setVecinos(vecinos);
				mapaPortales.get(i).add(pos);
			}
		}

		for (int i = 0; i < n + 1; i++) {
			for (int j = 0; j < l + 1; j++) {
				if (j > 0) {
					mapaPortales.get(i).get(j).getVecinos().add(mapaPortales.get(i).get(j - 1));
				}
				if (j < l) {
					mapaPortales.get(i).get(j).getVecinos().add(mapaPortales.get(i).get(j + 1));
				}
			}
		}

		for (Portal<Baldoza> portal : portales) {
			Baldoza pos = portal.getDesde();
			Baldoza destino = portal.getHasta();
			//Ida
			mapaPortales.get(pos.getPiso()).get(pos.getMetros()).getVecinos()
					.add(mapaPortales.get(destino.getPiso()).get(destino.getMetros()));
			// y vuelta
			mapaPortales.get(destino.getPiso()).get(destino.getMetros()).getVecinos()
				.add(mapaPortales.get(pos.getPiso()).get(pos.getMetros()));
		}

	}

	public final int solve() {
		return new MinimoPortales(n, l, mapaPortales).caminoMinimo(Boolean.FALSE);
	}
	
	public final int solveOpt() {
		return new MinimoPortales(n, l, mapaPortales).caminoMinimo(Boolean.TRUE);
	}
}