package sample.interviewquiz.serieslastequal;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SeriesLastEqualTest {

	private SeriesLastEqual lastEqual;

	@Before
	public void setUp() throws Exception {

		lastEqual = new SeriesLastEqual( 2 );
	}

	@Test
	public void testGetEquation() {
		String res = lastEqual.getEquation( new int[] { 2, 3, 1, 4 } );
	}

}
