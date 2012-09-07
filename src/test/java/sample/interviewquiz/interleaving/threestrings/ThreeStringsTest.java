package sample.interviewquiz.interleaving.threestrings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sample.interviewquiz.interleaving.threestrings.ThreeStrings;

public class ThreeStringsTest {

	private ThreeStrings threeStr;

	@Before
	public void setUp() throws Exception {

		threeStr = new ThreeStrings();
	}

	@Test
	public void testCheck() {
		boolean res = threeStr.check( "abcd", "xyz", "axybczd" );
		assertTrue( "expecting res == true but found " + res, res );

		System.out.println( "" );
		res = threeStr.check( "abcd", "xyz", "abcxydz" );
		assertTrue( "expecting res == true but found " + res, res );

		System.out.println( "" );
		res = threeStr.check( "abcd", "xyz", "xyzabcd" );
		assertFalse( "expecting res == false but found " + res, res );

		System.out.println( "" );
		res = threeStr.check( "bac", "acd", "bacadc" );
		assertTrue( "expecting res == true but found " + res, res );
	}

}
