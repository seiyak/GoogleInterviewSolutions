package sample.interviewquiz.bst.reconstruct.preorder;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PreOrderReconstructBSTTest {

	private PreOrderReconstructBST reconstruct;

	@Before
	public void setUp() throws Exception {

		reconstruct = new PreOrderReconstructBST();
	}

	@Test
	public void testReconstruct() {

		BST res = reconstruct.reconstructByPreOrder( new char[] { 'F', 'B', 'A', 'D', 'C', 'E', 'G', 'I', 'H' } );
		res.printPreOrder();
	}

}
