package sample.interviewquiz.bst.sorted.twobst;

import org.junit.Before;
import org.junit.Test;

public class SortedTwoBSTTest {

	private SortedTwoBST sorted;
	private Node root1;
	private Node root2;
	private Node root3;
	private Node root4;

	@Before
	public void setUp() throws Exception {

		root1 = new Node( 20 );
		root1.add( 10 );
		root1.add( 30 );

		root2 = new Node( 100 );
		root2.add( 50 );
		root2.add( 150 );

		root3 = new Node( 3 );
		root3.add( 1 );
		root3.add( 5 );

		root4 = new Node( 4 );
		root4.add( 2 );
		root4.add( 6 );

		sorted = new SortedTwoBST();
	}

	@Test
	public void testPrintSortedTwoBST() {

		sorted.printSortedTwoBST( root1, root2 );
		sorted.printSortedTwoBST( root3, root4 );
	}

}
