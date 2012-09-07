package sample.interviewquiz.bst.reconstruct.preorder;

/**
 * google-interview-questions 51 Answers
 * 
 * Given preorder traversal array of a BST, recontruct the BST.
 * 
 * @author seiyak
 * 
 */

public class PreOrderReconstructBST {
	public BST reconstructByPreOrder(char[] preOrderedArray) {

		if ( isNull( preOrderedArray ) || isEmpty( preOrderedArray ) ) {
			throw new IllegalArgumentException( "input must not be null nor empty" );
		}

		if ( preOrderedArray.length == 1 ) {
			return new BST( preOrderedArray[0] );
		}

		return doReconstruct( preOrderedArray );
	}

	private boolean isNull(char[] preOrderedArray) {

		if ( preOrderedArray == null ) {

			return true;
		}

		return false;
	}

	private boolean isEmpty(char[] preOrderedArray) {

		if ( preOrderedArray.length == 0 ) {
			return true;
		}

		return false;
	}

	private BST doReconstruct(char[] preOrderedArray) {

		BST bst = new BST( preOrderedArray[0] );

		for ( int i = 1; i < preOrderedArray.length; i++ ) {
			bst.add( preOrderedArray[i] );
		}

		return bst;
	}
}
