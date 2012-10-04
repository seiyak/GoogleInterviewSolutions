package sample.interviewquiz.count.inversion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * google-interview-questions 39 Answers
 * 
 * Count smaller elements on right side
 * 
 * eg : [4,12,5,6,1,34,3,2]
 * o/p [3,5,3,3,0,2,1,0]
 * 
 * @author seiyak
 * 
 */

public class CountInversionTest {

	private CountInversion inversion;

	@Before
	public void setUp() throws Exception {

		inversion = new CountInversion();
	}

	@Test
	public void testCountInversion() {

		int[] input = new int[] { 4, 12, 5, 6, 1, 34, 3, 2 };
		int[] res = inversion.countInversion( input );
		checkEachElement( res, new int[] { 3, 5, 3, 3, 0, 2, 1, 0 } );
	}

	private void checkEachElement(int[] res, int[] expected) {

		assertTrue( "expecting res.length == expected.lenth but found res.length==" + res.length
				+ ", expected.length==" + expected.length, res.length == expected.length );

		for ( int i = 0; i < res.length; i++ ) {
			assertTrue( "expecting they are the same but found res[" + i + "]==" + res[i] + " expected[" + i + "]=="
					+ expected[i], res[i] == expected[i] );
		}
	}

}
