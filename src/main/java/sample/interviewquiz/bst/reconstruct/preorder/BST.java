package sample.interviewquiz.bst.reconstruct.preorder;

import java.util.LinkedList;

public class BST {

	private Node root;
	public static final int NONE = 0;
	public static final int LEFT_ONLY = 1;
	public static final int RIGHT_ONLY = 2;
	public static final int LEFT_AND_RIGHT = 3;

	public BST(char rootValue) {
		root = new Node( rootValue );
	}

	public void add(char value) {

		doAdd( root, value );
	}

	private void doAdd(Node root, char value) {

		if ( root.getData() > value ) {
			if ( root.getLeft() == null ) {
				root.setLeft( new Node( value ) );
			}
			else {
				doAdd( root.getLeft(), value );
			}
		}
		else if ( root.getData() < value ) {
			if ( root.getRight() == null ) {
				root.setRight( new Node( value ) );
			}
			else {
				doAdd( root.getRight(), value );
			}
		}
	}

	public void remove(int value) {
		doRemove( root, value );
	}

	private void doRemove(Node node, int value) {

		Node target = search( value );
		Node parent = searchParent( value );

		if ( target != null ) {

			System.out.println( "target: " + target.getData() + " parent: " + parent.getData() + " node: "
					+ node.getData() + " value: " + value );

			if ( hasChildren( target ) == 0 ) {
				// node has no children
				if ( ( parent.getLeft() != null ) && ( parent.getLeft().getData() == value ) ) {
					target = null;
					parent.setLeft( null );
				}
				else if ( ( parent.getRight() != null ) && ( parent.getRight().getData() == value ) ) {
					target = null;
					parent.setRight( null );
				}
			}
			else if ( hasChildren( target ) == 1 || hasChildren( target ) == 2 ) {
				// node has one child
				if ( parent.getLeft().getData() == value ) {

					if ( target.getLeft() != null ) {
						Node left = target.getLeft();
						parent.setLeft( null );
						parent.setLeft( left );
						target = null;
					}
					else if ( target.getRight() != null ) {
						Node right = target.getRight();
						parent.setRight( null );
						parent.setRight( right );

						target = null;
					}
				}
				else if ( parent.getRight().getData() == value ) {
					if ( target.getLeft() != null ) {
						Node left = target.getLeft();
						parent.setLeft( null );
						parent.setLeft( left );

						target = null;
					}
					else if ( target.getRight() != null ) {
						Node right = target.getRight();
						parent.setRight( null );
						parent.setRight( right );

						target = null;
					}
				}
			}
			else if ( hasChildren( target ) == 3 ) {
				// node has left and right children
				Node min = doSearchMin( target.getRight() );
				// target.setData( min.getData() );
				doRemove( parent, min.getData() );
				target.setData( min.getData() );
			}
		}
	}

	private int hasChildren(Node node) {

		if ( node == null ) {
			throw new IllegalArgumentException( "node must not be null" );
		}

		if ( node.getLeft() != null && node.getRight() == null ) {
			return LEFT_ONLY;
		}
		else if ( node.getLeft() == null && node.getRight() != null ) {
			return RIGHT_ONLY;
		}
		else if ( node.getLeft() != null && node.getRight() != null ) {
			return LEFT_AND_RIGHT;
		}

		return NONE;
	}

	public Node searchParent(int value) {

		if ( root.getData() == value ) {
			return root;
		}

		return doSearchParent( root, value );
	}

	private Node doSearchParent(Node node, int value) {

		Node res = null;

		if ( node != null ) {

			if ( node.getData() > value ) {
				if ( node.getLeft() != null ) {
					if ( node.getLeft().getData() == value ) {
						res = node;
					}
					else {
						res = doSearchParent( node.getLeft(), value );
					}
				}
			}
			else if ( node.getData() < value ) {
				if ( node.getRight() != null ) {
					if ( node.getRight().getData() == value ) {
						res = node;
					}
					else {
						res = doSearchParent( node.getRight(), value );
					}
				}
			}
		}

		return res;
	}

	public Node searchMinFromRoot() {

		return doSearchMin( root );
	}

	private Node doSearchMin(Node node) {

		Node res = null;
		if ( node != null ) {

			if ( node.getLeft() != null ) {
				res = doSearchMin( node.getLeft() );
			}
			else {
				res = node;
			}
		}

		return res;
	}

	public Node search(int value) {

		return doSearch( root, value );
	}

	private Node doSearch(Node node, int value) {

		Node res = null;
		if ( node != null ) {
			if ( node.getData() == value ) {
				res = node;
			}
			else if ( node.getData() > value ) {
				res = doSearch( node.getLeft(), value );
			}
			else if ( node.getData() < value ) {
				res = doSearch( node.getRight(), value );
			}
		}

		return res;
	}

	public void printBFT() {

		LinkedList<Node> queue = new LinkedList<Node>();
		queue.addLast( root );
		root.setVisited( true );

		while ( queue.size() > 0 ) {

			Node node = queue.pollFirst();

			if ( node != null ) {

				System.out.println( "value: " + node.getData() );

				if ( node.getLeft() != null ) {

					if ( !node.getLeft().isVisited() ) {
						node.getLeft().setVisited( true );
						queue.addLast( node.getLeft() );
					}
				}

				if ( node.getRight() != null ) {

					if ( !node.getRight().isVisited() ) {
						node.getRight().setVisited( true );
						queue.addLast( node.getRight() );
					}
				}
			}
		}
	}

	public void printPreOrder() {
		doPrintPreOrder( root );
	}

	private void doPrintPreOrder(Node node) {

		if ( node != null ) {

			System.out.println( "data: " + node.getData() );
			doPrintPreOrder( node.getLeft() );
			doPrintPreOrder( node.getRight() );
		}
	}

	public void printInOrder() {
		doPrintInOrder( root );
	}

	private void doPrintInOrder(Node node) {

		if ( node != null ) {

			doPrintInOrder( node.getLeft() );
			System.out.println( "data: " + node.getData() );
			doPrintInOrder( node.getRight() );
		}
	}

	public void printPostOrder() {

		doPrintPostOrder( root );
	}

	private void doPrintPostOrder(Node node) {

		if ( node != null ) {

			doPrintPostOrder( node.getLeft() );
			doPrintPostOrder( node.getRight() );
			System.out.println( "data: " + node.getData() );
		}
	}
}
