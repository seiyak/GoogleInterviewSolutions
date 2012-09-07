package sample.interviewquiz.spaceadjustment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SpaceAdjustmentTest {

	private SpaceAdjustment spaceAdjustment;

	@Before
	public void setUp() throws Exception {
		spaceAdjustment = new SpaceAdjustment();
	}

	@Test
	public void testAdjustment() {
		String res = spaceAdjustment.adjust( "Dog is cute" );
		assertTrue( "expecting res == 'Dog   is   cute' but found " + res, res.equals( "Dog   is   cute" ) );

		System.out.println( "" );
		res = spaceAdjustment.adjust( "Dog is so so so cute" );
	}

}
