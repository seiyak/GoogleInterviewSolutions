package sample.interviewquiz.sequence.increasedecrease;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MaximalStictIncreseDecreaseTest {

	private MaximalStrictIncreseDecrease maximal;

	@Before
	public void setUp() throws Exception {

		maximal = new MaximalStrictIncreseDecrease();
	}

	@Test
	public void testGetSequence() {

		boolean res = maximal.isStrictIncreaseDecrease( new int[] { 1, 2, 3, 4, 7, 6, 5, 2, 3, 4, 1, 2 }, 12, 5, 7, 3 );
		assertTrue( "expecting res == true but found res==" + res, res );
	}

}
