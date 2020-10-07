package uba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

public class GirlScoutsFileTest extends GirlScoutsTest {
	@Test
	public void fileControlTest() throws IOException {
		// Con este test se compara un archivo de entrada con el formato de la
		// catedra contra otro archivo con valores esperados
		BufferedReader source = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Tp1Ej3.in")));
		BufferedReader control = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("Tp1Ej3.control.out")));

		String line;
		while ((line = source.readLine()) != null) {
			String controlResult = control.readLine();
			assertEquals(controlResult, run(line));
		}

	}
	
	@Test
	public void fileOutputTest() throws IOException {
		BufferedReader source = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("Tp1Ej3.in")));
		BufferedWriter output = new BufferedWriter(
				new FileWriter(getClass().getResource("").getPath() + "/Tp1Ej3.out"));
		String line;
		while ((line = source.readLine()) != null) {
			output.append(run(line));
			output.newLine();
		}
		output.flush();
		output.close();
	}
	
	private String run(String line) {
		Object[] input = parseInput(line);
		List<Scout> scouts = (List<Scout>) input[0];
		List<Amistad> amistades = (List<Amistad>) input[1];
		GirlScouts fogonSout = new GirlScouts(scouts,amistades);
		return fogonSout.formarRonda();
	}	

}
