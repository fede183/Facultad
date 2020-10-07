package uba.algo3.tp3;

import java.io.IOException;

public class GeneradorTestSets {

	private static final String TEST_SET_1 = "TestSet1";
	private static final Long TEST_SET_1_SEED = 1L;

	public static void main(String args[]) throws IOException {
		buildTestSet(TEST_SET_1, TEST_SET_1_SEED);
	}

	private static void buildTestSet(String set, Long seed) throws IOException {
		GeneradorGrafos gg = new GeneradorGrafos(set, seed);
		for (Integer i = 5; i < 51; i++) {

			Integer n = i;
			Integer c = 10;
			Integer m = n/2;

			gg.exportSolvableKn(n, n, Boolean.TRUE);
			gg.exportSolvableKn(n, n, Boolean.FALSE);
			gg.exportSolvableKmn(m, n - m, c, Boolean.TRUE);
			gg.exportSolvableKmn(m, n - m, c, Boolean.FALSE);
			gg.exportUnsolvableKmn(m, n - m, c, Boolean.TRUE);
			gg.exportUnsolvableKn(n, c, Boolean.TRUE);
			gg.exportUnsolvableKn(n, c, Boolean.FALSE);
		}
		for (Integer i = 5; i < 26; i++) {
			Integer n = i;
			Integer c = 10;
			Integer m = n/2;
			gg.exportUnsolvableKmn(m, n - m, c, Boolean.FALSE);

		}
		for (Integer i = 3; i < 10; i++) {
			Integer n = (int) (Math.pow(2, i) - 1);
			gg.exportArbolBinarioBaseUnida(n);
		}

	}
}
