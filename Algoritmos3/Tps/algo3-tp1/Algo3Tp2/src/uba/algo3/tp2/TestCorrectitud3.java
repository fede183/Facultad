package uba.algo3.tp2;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestCorrectitud3 {
	@Test
	public void testAUnArbol1() {
		//Este test correra en una entrada que ya es un arbol y por ente el resultado 
		//Tiene que ser 0
		ArrayList pasillos = new ArrayList();
		pasillos.add( new Pasillo( 1, 2, 2 ) );
	    pasillos.add( new Pasillo( 2, 3, 3 ) );
	    pasillos.add( new Pasillo( 3, 4, 4 ) );									
	    assertEquals( 0, new Ejercicio3( pasillos ).solve() );
	}
	
	@Test
	public void testAUnArbol2() {
		//Este test correra en una entrada que ya es un arbol y por ende el resultado 
		//Tiene que ser 0
		//La diferencia con el anterior es que el arbol ahora consiste en un vertice
		//que se conecta a muchas aristas
		ArrayList pasillos = new ArrayList();
		pasillos.add( new Pasillo( 1, 2, 2 ) );
	    pasillos.add( new Pasillo( 1, 3, 3 ) );
	    pasillos.add( new Pasillo( 1, 4, 4 ) );									
	    assertEquals( 0, new Ejercicio3( pasillos ).solve() );
	}
	
	@Test
	public void testCircuito1() {
		//Tenemos un circuito con arista pesadas y una poco pesada.
		
		ArrayList pasillos = new ArrayList();
		pasillos.add( new Pasillo( 1, 2, 200 ) );
	    pasillos.add( new Pasillo( 2, 3, 300 ) );
	    pasillos.add( new Pasillo( 3, 4, 4 ) );	
	    pasillos.add( new Pasillo( 1, 5, 200 ) );
	    pasillos.add( new Pasillo( 5, 4, 100 ) );
	    assertEquals( 4, new Ejercicio3( pasillos ).solve() );
	}
	
	@Test
	public void testCircuito2() {
		//Tenemos un circuito con arista poco pesadas y una pesada.
		
		ArrayList pasillos = new ArrayList();
		pasillos.add( new Pasillo( 1, 2, 2 ) );
	    pasillos.add( new Pasillo( 2, 3, 3 ) );
	    pasillos.add( new Pasillo( 3, 4, 4 ) );	
	    pasillos.add( new Pasillo( 1, 5, 200 ) );
	    pasillos.add( new Pasillo( 5, 4, 5 ) );
	    assertEquals( 2, new Ejercicio3( pasillos ).solve() );
	}
	
	@Test
	public void testCircuitoMultiples() {
		//Tenemos varios circuitos
		
		ArrayList pasillos = new ArrayList();
		pasillos.add( new Pasillo( 1, 2, 200 ) );
	    pasillos.add( new Pasillo( 1, 4, 4 ) );	
	    pasillos.add( new Pasillo( 1, 5, 200 ) );
	    pasillos.add( new Pasillo( 1, 6, 100 ) );
	    pasillos.add( new Pasillo( 1, 7, 100 ) );
	    pasillos.add( new Pasillo( 1, 8, 100 ) );
	    pasillos.add( new Pasillo( 2, 3, 300 ) );
	    pasillos.add( new Pasillo( 4, 3, 100 ) );
	    pasillos.add( new Pasillo( 5, 3, 100 ) );
	    pasillos.add( new Pasillo( 6, 3, 100 ) );
	    pasillos.add( new Pasillo( 7, 3, 100 ) );
	    pasillos.add( new Pasillo( 8, 3, 100 ) );
	    assertEquals( 404, new Ejercicio3( pasillos ).solve() );
	}
	
	  
}
