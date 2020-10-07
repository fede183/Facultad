package uba.algo3.tp1;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

import uba.algo3.Utils;

public class AMediasTestCorrectitud {
	@Test
	public void TestCorrectitudAMedias() throws IOException {
		
		BufferedReader source = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("tests/Ej2Test.in")));
		BufferedReader control = new BufferedReader(
				new InputStreamReader(getClass().getResourceAsStream("tests/Ej2Test.out")));

		String line;
		while ((line = source.readLine()) != null) {
			assertEquals(control.readLine(), run(line));
		}

	}

	private String run(String a) {
		return Utils.collectionToString(new AMedias().Medianas(Utils.parseVector(a))," ");
	}
}