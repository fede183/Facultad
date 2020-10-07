package uba.algo3.tp2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestCorrectitud1 {
	@Test
	public void testCaminoSimple1() {
		//Con esto tendremos un camino simple que tome todos los nodos.
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 1) );
									
	    assertEquals( 1, new Ejercicio1(1, portales ).solve() );
	}
	
	@Test
	public void testCaminoSimple2() {
		//Con esto tendremos un camino simple que tome todos los nodos.
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 1) );
		portales.add( new Portal( 1, 2) );						
	    assertEquals( 2, new Ejercicio1(2 , portales ).solve() );
	}
	
	@Test
	public void testCaminoSimple3() {
		//Con esto tendremos un camino simple que tome todos los nodos.
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 1) );
		portales.add( new Portal( 1, 2) );	
		portales.add( new Portal( 2, 3) );	
	    assertEquals( 3, new Ejercicio1(3, portales ).solve() );
	}
	
	@Test
	public void testDosCaminosIguales() {
		//Tengo dos caminos de igual cantidad de portales.
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 1) );
		portales.add( new Portal( 1, 2) );	
		portales.add( new Portal( 2, 5) );	
		portales.add( new Portal( 0, 3) );	
		portales.add( new Portal( 3, 4) );
		portales.add( new Portal( 4, 5) );
	    assertEquals( 3, new Ejercicio1(5, portales ).solve() );
	}

	@Test
	public void testDosCaminosDistintos() {
		//Tengo dos caminos de distinta cantidad de portales.
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 1) );
		portales.add( new Portal( 1, 2) );	
		portales.add( new Portal( 2, 8) );	
		portales.add( new Portal( 0, 3) );	
		portales.add( new Portal( 3, 4) );
		portales.add( new Portal( 4, 5) );
		portales.add( new Portal( 5, 6) );
		portales.add( new Portal( 6, 7) );
		portales.add( new Portal( 7, 8) );
	    assertEquals( 6, new Ejercicio1(8, portales ).solve() );
	}
	
	@Test
	public void testMenorCamino() {
		//Existe un camino que no parte del origen pero que llega al destino
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 4) );
		portales.add( new Portal( 1, 2) );	
		portales.add( new Portal( 2, 3) );	
		portales.add( new Portal( 3, 5) );
		portales.add( new Portal( 4, 5) );
	    assertEquals( 2, new Ejercicio1(5, portales ).solve() );
	}
	
	
	@Test
	public void testMenorCamino2() {
		//Existe un camino que no parte del origen y tampoco llega al destino
		ArrayList portales = new ArrayList();
		portales.add( new Portal( 0, 5) );
		portales.add( new Portal( 1, 2) );	
		portales.add( new Portal( 2, 3) );	
		portales.add( new Portal( 3, 4) );
	    assertEquals( 1, new Ejercicio1(5, portales ).solve() );
	}
	
}
