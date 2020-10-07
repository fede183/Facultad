package uba.algo3.tp1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.junit.Test;

public class GirlScoutsTimeTest extends GirlScoutsTest {

	@Test
	public void timeTestingRunTest() throws IOException {
		// Test1: Variamos la cantidad de exploradoras con una cantidad fija de
		// amistades
		// e : 5..12 ; a : 5

		// Test2: Variamos la cantidad de amistades para una cantidad de
		// exploradoras fija
		// e : 7, a: 5,10,15,20,25,30,35,40
		
		// Test3: Mejor caso (circulo, amigas de la siguiente en orden)
		
		// Test4: Peor caso (grafo completo, todas amigas de todas)
		for (int i = 1; i < 5; i++) {
			BufferedReader source = new BufferedReader(
					new InputStreamReader(getClass().getResourceAsStream("tests/Tp1Ej3Test"+i+".in")));
			BufferedWriter output = new BufferedWriter(
					new FileWriter(getClass().getResource("").getPath() + "/tests/Tp1Ej3Test"+i+".out"));

			String line;
			while ((line = source.readLine()) != null) {
				String time = run(line);
				System.out.println(time);
				output.write(time);
				output.newLine();
			}
			output.flush();
			output.close();
		}
	}

	private String run(String line) {
		Object[] input = parseInput(line);
		List<Scout> scouts = (List<Scout>) input[0];
		List<Amistad> amistades = (List<Amistad>) input[1];
		Long time = System.currentTimeMillis();

		GirlScouts fogonSout = new GirlScouts(scouts, amistades);
		fogonSout.formarRonda();

		time = System.currentTimeMillis() - time;

		return String.valueOf((double) time / (double) 1000);
	}

}
