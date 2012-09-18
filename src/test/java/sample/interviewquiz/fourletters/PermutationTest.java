package sample.interviewquiz.fourletters;

import org.junit.Before;
import org.junit.Test;

public class PermutationTest {

	private Permutation permutation;

	@Before
	public void setUp() throws Exception {

		permutation = new Permutation();
	}

	@Test
	public void testPrintPermutations() {

		permutation.printPermutations( "AB", "CD" );
	}

}
