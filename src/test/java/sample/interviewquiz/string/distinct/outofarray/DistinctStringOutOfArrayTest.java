package sample.interviewquiz.string.distinct.outofarray;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DistinctStringOutOfArrayTest {

	private DistinctStringOutOfArray distinctStrings;

	@Before
	public void setUp() throws Exception {

		distinctStrings = new DistinctStringOutOfArray();
	}

	@Test
	public void testGetDistinctStrings() {

		String[] res = distinctStrings.getDistinctStrings( new String[] { "", "", "" } );
		checkEachElement( new String[] {}, res );

		res = distinctStrings.getDistinctStrings( new String[] { "hello", "world", "hello" } );
		checkEachElement( new String[] { "world" }, res );

		res = distinctStrings.getDistinctStrings( new String[] { "this", "is", "a", "sample", "input", "input" } );
		checkEachElement( new String[] { "this", "is", "a", "sample" }, res );
	}

	private void checkEachElement(String[] expected, String[] res) {

		assertTrue( "expecting they are the same length but found, expected.length == " + expected.length
				+ " res.length == " + res.length, expected.length == res.length );

		for ( int i = 0; i < expected.length; i++ ) {
			assertTrue( "expecting expected[" + i + "] == res[" + i + "] but found expected[" + i + "]," + expected[i]
					+ " and res[" + i + "], " + res[i], expected[i].equals( res[i] ) );
		}
	}

}
