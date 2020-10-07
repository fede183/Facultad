package uba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import uba.algo3.Utils;

public class TelegrafoTestCorrectitud {
	@Test
	public void fileTestingRunTest() throws IOException {
		// Con este test se compara un archivo de entrada con el formato de la
		// catedra contra otro archivo con valores esperados
		BufferedReader source = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("tests/Ej1Test.in")));
		BufferedReader control = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("tests/Ej1Test.out")));

		String line;
		while ((line = source.readLine()) != null) {
			assertEquals(control.readLine(), run(line, source.readLine()));
		}

	}

	private String run(String a, String b) {
		return String.valueOf(new Telegrafo().rutaMasLarga(Utils.parseVector(b), Integer.valueOf(a)));
	}
}