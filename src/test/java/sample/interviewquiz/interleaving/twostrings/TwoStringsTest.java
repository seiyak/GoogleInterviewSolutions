package sample.interviewquiz.interleaving.twostrings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TwoStringsTest {

	private TwoStrings twoStrings;

	@Before
	public void setUp() throws Exception {

		twoStrings = new TwoStrings();
	}

	@Test
	public void test() {

		twoStrings.printInterleavings( "AB", "CD" );
	}

}
