package uba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RondaDistanceTest {

	
	@Test
	public void testDistancias(){
		Ronda ronda = new Ronda(5);
		ronda.set(0, 'a');
		ronda.set(1, 'b');
		ronda.set(2, 'e');
		ronda.set(3, 'c');
		ronda.set(4, 'd');
		assertEquals(ronda.distance('a', 'b'), 1);
		assertEquals(ronda.distance('a', 'c'), 2);
		assertEquals(ronda.distance('a', 'd'), 1);
	}
}
