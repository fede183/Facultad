package uba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import uba.algo3.Utils;

public class TelegrafoFileTest {

	@Test
	public void fileTestingRunTest() throws IOException {
		// Con este test se compara un archivo de entrada con el formato de la
		// catedra contra otro archivo con valores esperados
		BufferedReader source = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Tp1Ej1.in")));
		BufferedReader control = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("Tp1Ej1.control.out")));

		String line;
		while ((line = source.readLine()) != null) {
			assertEquals(control.readLine(), run(line, source.readLine()));
		}

	}
	
	@Test
	public void fileOutputTest() throws IOException {
		BufferedReader source = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Tp1Ej1.in")));
		BufferedWriter output = new BufferedWriter(
				new FileWriter(getClass().getResource("").getPath() + "/Tp1Ej1.out"));
		String line;
		while ((line = source.readLine()) != null) {
			output.append(run(line, source.readLine()));
			output.newLine();
		}
		output.flush();
		output.close();
	}
	

	private String run(String a, String b) {
		return String.valueOf(new Telegrafo().rutaMasLarga(Utils.parseVector(b), Integer.valueOf(a)));
	}

}
