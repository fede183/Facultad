package uba.algo3.tp1;

import java.util.Collections;
import java.util.List;

public class GirlScouts {

	Ronda ronda;
	List<Scout> scouts;
	List<Amistad> amistades;

	String mejorRonda;
	Integer menorDistancia;
	Integer menorDistanciaPar;

	public GirlScouts(List<Scout> scouts, List<Amistad> amistades) {
		this.scouts = scouts;
		this.amistades = amistades;
		ronda = new Ronda(scouts.size());
		menorDistanciaPar = scouts.size() / 2;
		menorDistancia = 0;
		mejorRonda = "";
	}

	public String formarRonda() {
		Collections.sort(scouts);
		ronda.set(0, scouts.get(0).letra);
		scouts.get(0).pos = 0;
		formarRonda(1);
		System.out.println(menorDistanciaPar + " " + mejorRonda);
		return menorDistanciaPar + " " + mejorRonda;
	}

	private void formarRonda(int depth) {
		Boolean rondaIncompleta = depth < scouts.size();

		// Calculamos la distancia parcial
		Integer maximoRonda = 0;
		Integer distanciaTotalRonda = 0;
		for (Amistad amistad : amistades) {
			if (amistad.amiga.pos > -1 && amistad.scout.pos > -1) {
				// Si ambas amigas estan en la ronda, calcular la distancia
				Integer distancia = ronda.distance(amistad.amiga.pos, amistad.scout.pos);
				if (maximoRonda == 0 || maximoRonda < distancia) {
					maximoRonda = distancia;
				}
				distanciaTotalRonda += distancia;
			}
		}

		if (rondaIncompleta) {
			// Si faltan posiciones, seguir buscando

			if (menorDistancia == 0 || distanciaTotalRonda < menorDistancia) {
				// Si la distancia parcial ya es mayor a la minima encontrada
				// podamos esta rama

				for (Scout scout : scouts) {
					if (scout.pos.equals(-1)) {
						// Poner esta scout en la posicion actual y bajar un
						// nivel
						ronda.set(depth, scout.letra);
						scout.pos = depth;
						formarRonda(depth + 1);
						scout.pos = -1;
					}
				}
				// Restituir esta posicion
				ronda.remove(depth);
			}

		} else {
			// Sino, verificar si es mejor solucion
			if (menorDistancia == 0 || distanciaTotalRonda < menorDistancia) {
				menorDistancia = distanciaTotalRonda;
				menorDistanciaPar = maximoRonda;
				mejorRonda = ronda.toString();
			}
		}

	}

}
