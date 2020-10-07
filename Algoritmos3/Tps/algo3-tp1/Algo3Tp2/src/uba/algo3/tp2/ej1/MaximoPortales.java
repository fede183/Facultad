package uba.algo3.tp2.ej1;

import java.util.Vector;

public class MaximoPortales {

	Vector<Integer> maximoDesdeN;
	Vector<Boolean> accesible;
	Vector<Piso> pisos;
	Integer n;

	public MaximoPortales(Vector<Piso> pisos) {
		this.n = pisos.size();
		this.pisos = pisos;
		maximoDesdeN = new Vector<Integer>();
		accesible = new Vector<Boolean>();
		for (int i = 0; i < n; i++) {
			maximoDesdeN.add(0);
			// Accesibles desde el ultimo piso
			// Inicialmente, solo el mismo
			accesible.add(i==n-1);
		}
	}

	public Integer caminoMaximo() {
		for (Integer p = n - 1; p >= 0; p--) {
			Piso piso = pisos.get(p);
			if (accesible.get(p)) {
				for (Integer antecesor : piso.antecesores) {
					Integer max = Math.max(maximoDesdeN.get(piso.numero) + 1, maximoDesdeN.get(antecesor));
					maximoDesdeN.set(antecesor, max);
					accesible.set(antecesor, true);
				}
			}
		}
		return maximoDesdeN.get(0);
	}

}
