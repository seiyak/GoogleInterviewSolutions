package sample.interviewquiz.count.inversion;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class NodeTest {

	private Node root;

	@Before
	public void setUp() throws Exception {

		root = new Node( 2 );
	}

	@Test
	public void testGetInversion() {

		int[] res = root.getInversion( new int[] { 4, 12, 5, 6, 1, 34, 3, 2 } );
		
	}

}
