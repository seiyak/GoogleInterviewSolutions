package sample.interviewquiz.count.inversion;

public class Node {

	private final int val;
	private Node left;
	private Node right;

	public Node(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setLeft(Node node) {
		left = node;
	}

	public Node getLeft() {
		return left;
	}

	public void setRight(Node node) {
		right = node;
	}

	public Node getRight() {
		return right;
	}

	public int[] getInversion(int[] input) {

		int[] inversions = new int[input.length];

		for ( int i = 1; i < input.length; i++ ) {
			inversions[input.length - i - 1] = doAdd( this, input[input.length - i - 1] );
		}

		return inversions;
	}

	private int doAdd(Node node, int val) {

		int count = 0;

		if ( node.getVal() > val ) {
			if ( node.getLeft() == null ) {
				node.setLeft( new Node( val ) );
			}
			else if ( node.getLeft() != null ) {
				doAdd( node.getLeft(), val );
			}
		}
		else if ( node.getVal() < val ) {
			if ( node.getRight() == null ) {
				node.setRight( new Node( val ) );
				count++;
			}
			else if ( node.getRight() != null ) {
				doAdd( node.getRight(), val );
				count++;
			}
		}

		return count;
	}
}
