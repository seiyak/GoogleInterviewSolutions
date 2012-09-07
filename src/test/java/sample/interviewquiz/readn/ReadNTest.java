package sample.interviewquiz.readn;

import static org.junit.Assert.*;

import java.io.EOFException;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class ReadNTest {

	private ReadN readN;

	@Before
	public void setUp() throws Exception {

		readN = new ReadN();
	}

	@Test(expected = EOFException.class)
	public void testReadN() throws EOFException {

		char[] chars = generateRandomChars( 2000 );
		int res = readN.readN( chars, 1000 );
		assertTrue( "expecting res == 1000 but found res == " + res, res == 1000 );
		assertTrue( "expecting the next position == 1000 but found " + readN.getNextPosition(),
				readN.getNextPosition() == 1000 );

		res = readN.readN( chars, 500 );
		assertTrue( "expecting res == 500 but found res == " + res, res == 500 );
		assertTrue( "expecting the next position == 1500 but found " + readN.getNextPosition(),
				readN.getNextPosition() == 1500 );

		res = readN.readN( chars, 2000 );
		assertTrue( "expecting res == 500 but found res == " + res, res == 500 );
		assertTrue( "expecting the nexr position == 2000 but found " + readN.getNextPosition(),
				readN.getNextPosition() == 2000 );
		
		res = readN.readN( chars, 1000 );
	}

	private char[] generateRandomChars(int numberOfChars) {

		Random random = new Random();
		char[] chars = new char[numberOfChars];
		int index = 0;
		while ( numberOfChars > 0 ) {
			chars[index++] = (char) ( random.nextInt( 127 ) + 49 );
			numberOfChars--;
		}

		return chars;
	}

}
