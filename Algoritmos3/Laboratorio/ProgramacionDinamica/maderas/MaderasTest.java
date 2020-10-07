package uba.algo3.maderas;

import static org.junit.Assert.assertEquals;
import java.util.Vector;
import org.junit.Test;
import uba.algo3.Utils;

public class MaderasTest {

	@Test
	public final void test0() {
		assertEquals( new Ejercicio().solve( 20, Utils.parseVector( "2 5 10" ) ), 35 );
	}

	@Test
	public final void test1() {
		assertEquals( new Ejercicio().solve( 23, Utils.parseVector( "2 3 5 7 11 13 17 19" ) ), 72 );
	}

	@Test
	public final void test2() {
		assertEquals( new Ejercicio().solve( 128, Utils.parseVector( "1 2 4 8 16 32 64" ) ), 254 );
	}

	@Test
	public final void test3() {
		assertEquals( new Ejercicio().solve( 144, Utils.parseVector( "1 2 3 5 8 13 21 34 55 89" ) ), 374 );
	}

	@Test
	public final void test4() {
		assertEquals( new Ejercicio().solve( 50, Utils.parseVector( "5 14 23 32 41" ) ), 132 );
	}

	@Test
	public void test5() {
		Vector<Integer> cortes = new Vector<Integer>();
		for (int i = 1; i < 1000; i++) {
			if (i % 60 == 3 || i % 60 == 14 || i % 60 == 23 || i % 60 == 31 || i % 60 == 42 || i % 60 == 55) {
			cortes.add( i );
			}
		}
		assertEquals( new Ejercicio().solve( 1000, cortes ), 6677 );
	}
}