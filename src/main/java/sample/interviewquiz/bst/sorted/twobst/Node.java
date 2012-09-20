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

		if ( this.getData() > value ) {
			if ( this.getLeft() == null ) {
				this.setLeft( new Node( value ) );
			}
			else {
				doAdd( this.getLeft(), value );
			}
		}
		else if ( this.getData() < value ) {
			if ( this.getRight() == null ) {
				this.setRight( new Node( value ) );
			}
			else {
				doAdd( this.getRight(), value );
			}
		}
	}
}
