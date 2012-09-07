package sample.interviewquiz.forwardrotate;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ForwardRotateTest {

	private ForwardRotate forwardRotate;

	@Before
	public void setUp() throws Exception {

		forwardRotate = new ForwardRotate();
	}

	@Test
	public void testRotate() {

		int[] res = forwardRotate.rotate( 0, 3, 8, new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 } );
		checkEachElement( new int[] { 4, 5, 6, 7, 8, 9, 1, 2, 3 }, res );
	}

	private void checkEachElement(int[] expected, int[] res) {

		assertTrue( "expecting they are the same length but found, expected.length == " + expected.length
				+ " res.length == " + res.length, expected.length == res.length );

		for ( int i = 0; i < expected.length; i++ ) {
			assertTrue( "expecting expected[" + i + "] == res[" + i + "] but found expected[" + i + "]," + expected[i]
					+ " and res[" + i + "], " + res[i], expected[i] == res[i] );
		}
	}

}
