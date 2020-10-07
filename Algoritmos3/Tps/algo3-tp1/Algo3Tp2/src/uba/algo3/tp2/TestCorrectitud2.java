package uba.algo3.tp2;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class TestCorrectitud2 {

	@Test
	public void peorCaso() {
		// Para el peor caso tomamos el grafo completo.
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		Integer n = 10;
		Integer l = 10;
		for (int i = 0; i < n+1; i++) {
			for (int j = 0; j < l+1; j++) {
				for (int x = i; x < n+1; x++) {
					for (int y = j+1; y < l+1; y++) {
						if (i != x || j != y) {
							Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(i, j), new Baldoza(x, y));
							portales.add(portal);
						}
					}
				}
			}
		}
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		Assert.assertEquals(2, ej2.solve());
	}
	
	@Test
	public void mejorCaso() {
		// Para el peor caso tomamos el grafo completo.
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		Integer n = 10;
		Integer l = 10;
		Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(0, 0), new Baldoza(n, l));
		portales.add(portal);
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		Assert.assertEquals(2, ej2.solve());
	}
	
	@Test
	public void dosPisos() {
		// Para el peor caso tomamos el grafo completo.
		List<Portal<Baldoza>> portales = new ArrayList<Portal<Baldoza>>();
		Integer n = 10;
		Integer l = 10;
		Portal<Baldoza> portal = new Portal<Baldoza>(new Baldoza(0, l), new Baldoza(n, 0));
		portales.add(portal);
		Ejercicio2 ej2 = new Ejercicio2(n, l, portales);
		Assert.assertEquals(2*l+2, ej2.solve());
	}

}
