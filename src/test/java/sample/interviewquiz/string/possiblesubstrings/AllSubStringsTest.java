package sample.interviewquiz.string.possiblesubstrings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AllSubStringsTest {

	private AllSubStrings alls;

	@Before
	public void setUp() throws Exception {

		alls = new AllSubStrings();
	}

	@Test
	public void testPrintAllSubString() {

		alls.printAllSubString( "abc" );
	}

}
