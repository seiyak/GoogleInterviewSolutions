package sample.interviewquiz.bst.sorted.twobst;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BST {

	public void add(Node root, int value) {

		if ( root.getData() > value ) {
			if ( root.getLeft() == null ) {
				root.setLeft( new Node( value ) );
			}
			else {
				add( root.getLeft(), value );
			}
		}
		else if ( root.getData() < value ) {
			if ( root.getRight() == null ) {
				root.setRight( new Node( value ) );
			}
			else {
				add( root.getRight(), value );
			}
		}
	}

	public void printBFT(Node root) {

		Queue<Node> queue = new LinkedList<Node>();
		queue.add( root );
		root.setVisited( true );

		while ( queue.size() > 0 ) {

			Node node = queue.poll();

			if ( node != null ) {

				System.out.println( "value: " + node.getData() );

				if ( node.getLeft() != null ) {

					if ( !node.getLeft().isVisited() ) {
						node.getLeft().setVisited( true );
						queue.add( node.getLeft() );
					}
				}

				if ( node.getRight() != null ) {

					if ( !node.getRight().isVisited() ) {
						node.getRight().setVisited( true );
						queue.add( node.getRight() );
					}
				}
			}
		}
	}
}
