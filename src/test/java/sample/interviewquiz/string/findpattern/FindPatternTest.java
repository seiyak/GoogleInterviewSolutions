package sample.interviewquiz.string.findpattern;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FindPatternTest {

	private FindPattern findPattern;

	@Before
	public void setUp() throws Exception {

		findPattern = new FindPattern();
	}

	@Test
	public void testFindPattern() {

		char[][] input = new char[][] { { 'A', 'C', 'P', 'R', 'C' }, { 'X', 'S', 'O', 'P', 'C' },
				{ 'V', 'O', 'V', 'N', 'I' }, { 'W', 'G', 'F', 'M', 'N' }, { 'Q', 'A', 'T', 'I', 'T' } };

		boolean res = findPattern.findPattern( input, 5, 5, new char[] { 'M', 'I', 'C', 'R', 'O', 'S', 'O', 'F', 'T' } );
		assertTrue( "expecting res == true but found res==" + res, res );

		res = findPattern.findPattern( input, 5, 5, new char[] { 'A', 'P', 'P', 'L', 'E' } );
		assertFalse( "expecting res == false but found res==" + res, res );

		res = findPattern.findPattern( input, 5, 5, new char[] { 'P', 'O', 'V', 'G', 'Q' } );
		assertTrue( "expecting res == true but found res==" + res, res );

		res = findPattern.findPattern( input, 5, 5, new char[] { 'C', 'O', 'G', 'A' } );
		res = findPattern.findPattern( input, 5, 5, new char[] { 'A', 'P', 'P', 'L', 'E' } );
		assertFalse( "expecting res == false but found res==" + res, res );
	}
}
