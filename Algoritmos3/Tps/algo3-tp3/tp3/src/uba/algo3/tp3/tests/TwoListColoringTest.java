package uba.algo3.tp3.tests;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;
import uba.algo3.tp3.ColoringTestUtil;
import uba.algo3.tp3.GrafoColoreo;
import uba.algo3.tp3.TwoListColoring;

public class TwoListColoringTest {

	@Test
	public void test2ListColoring1() {

		List<Integer> colores1 = new ArrayList<Integer>(Arrays.asList(1, 2));
		List<Integer> colores2 = new ArrayList<Integer>(Arrays.asList(1, 2));
		List<Integer> colores3 = new ArrayList<Integer>(Arrays.asList(1));

		List<Integer> vecinos1 = new ArrayList<Integer>(Arrays.asList(1));
		List<Integer> vecinos2 = new ArrayList<Integer>(Arrays.asList(0, 2));
		List<Integer> vecinos3 = new ArrayList<Integer>(Arrays.asList(1));

		GrafoColoreo g = new GrafoColoreo(3, Arrays.asList(colores1, colores2, colores3),
				Arrays.asList(vecinos1, vecinos2, vecinos3), 3);
		TwoListColoring twoListColoring = new TwoListColoring();
		twoListColoring.colorear(g);

		Assert.assertTrue(coloreoValido(g));
	}

	public Boolean coloreoValido(GrafoColoreo g) {
		return ColoringTestUtil.contarConflictos(g) == 0;
	}

	
	public void fileTest() throws IOException {

		BufferedReader source = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("TwoListTest.in")));

		GrafoColoreo g = GrafoColoreo.fromInput(source);
		TwoListColoring t = new TwoListColoring();
		Assert.assertTrue(coloreoValido(t.colorear(g)));
	}
	
	

}
