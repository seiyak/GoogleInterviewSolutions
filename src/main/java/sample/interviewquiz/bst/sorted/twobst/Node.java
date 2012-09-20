package sample.interviewquiz.bst.sorted.twobst;

public class Node {

	private int data;
	private Node left;
	private Node right;
	boolean visited;

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public Node(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public void add(int value) {

		doAdd( this, value );
	}

	private void doAdd(Node node, int value) {

		if ( node.getData() > value ) {
			if ( node.getLeft() == null ) {
				node.setLeft( new Node( value ) );
			}
			else {
				doAdd( node.getLeft(), value );
			}
		}
		else if (node.getData() < value ) {
			if ( node.getRight() == null ) {
				node.setRight( new Node( value ) );
			}
			else {
				doAdd( node.getRight(), value );
			}
		}
	}
}
