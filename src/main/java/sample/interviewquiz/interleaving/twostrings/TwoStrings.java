package sample.interviewquiz.interleaving.twostrings;


/**
 * google-interview-questions 39 Answers
 * 
 * Given two strings .Print all the interleavings of the two strings.
 * Interleaving means that the if B comes after A .It should also come after A in the interleaved string.
 * ex-
 * AB and CD
 * ABCD
 * ACBD
 * ACDB
 * CABD
 * CADB
 * CDAB
 * 
 * @author seiyak
 * 
 */

public class TwoStrings {

	private Node root;

	public void printInterleavings(String input1, String input2) {

		if ( isNull( input1 ) || isNull( input2 ) ) {
			throw new IllegalArgumentException( "inputs must not be null but found, input1, " + input1 + " input2, "
					+ input2 );
		}

		root = new Node( Character.toString( input1.charAt( 0 ) ) );
		root.setKind( "root" );
		char[] chars1 = input1.toCharArray();
		char[] chars2 = input2.toCharArray();

		addNode( root, chars1, chars2 );
		printPreOrder( root, "root" );
		System.out.println( "" );

		Node another = new Node( Character.toString( input2.charAt( 0 ) ) );
		another.setKind( "root" );
		addNode( another, chars2, chars1 );
		printPreOrder( another, "root" );
	}

	private boolean isNull(String input) {
		if ( input == null ) {
			return true;
		}

		return false;
	}

	private void addNode(Node node, char[] chars1, char[] chars2) {

		System.out.println( "node at the beginning: " + node );

		if ( node != null ) {
			if ( node.getStr().equals( Character.toString( chars1[0] ) ) && node.getKind().equals( "root" ) ) {
				node.getChildren()[0] = new Node( Character.toString( chars1[1] ) );
				node.getChildren()[0].setKind( "left" );
				node.getChildren()[1] = new Node( Character.toString( chars2[0] ) );
				node.getChildren()[1].setKind( "right" );

				addNode( node.getChildren()[0], chars1, chars2 );
				addNode( node.getChildren()[1], chars1, chars2 );
			}
			else if ( node.getStr().equals( Character.toString( chars1[1] ) ) && node.getKind().equals( "left" ) ) {
				node.getChildren()[0] = new Node( Character.toString( chars2[0] ) );
				node.getChildren()[0].setKind( "left" );
				addNode( node.getChildren()[0], chars1, chars2 );
			}
			else if ( node.getStr().equals( Character.toString( chars2[0] ) ) && node.getKind().equals( "left" ) ) {
				node.getChildren()[0] = new Node( Character.toString( chars2[1] ) );
				node.getChildren()[0].setKind( "left" );
			}
			else if ( node.getStr().equals( Character.toString( chars2[0] ) ) && node.getKind().equals( "right" ) ) {
				node.getChildren()[0] = new Node( Character.toString( chars2[1] ) );
				node.getChildren()[0].setKind( "left" );
				node.getChildren()[1] = new Node( Character.toString( chars1[1] ) );
				node.getChildren()[1].setKind( "right" );

				addNode( node.getChildren()[0], chars1, chars2 );
				addNode( node.getChildren()[1], chars1, chars2 );
			}
			else if ( node.getStr().equals( Character.toString( chars2[1] ) ) && node.getKind().equals( "left" ) ) {
				node.getChildren()[0] = new Node( Character.toString( chars1[1] ) );
				node.getChildren()[0].setKind( "left" );
			}

			else if ( node.getStr().equals( Character.toString( chars1[1] ) ) && node.getKind().equals( "right" ) ) {
				node.getChildren()[0] = new Node( Character.toString( chars2[1] ) );
				node.getChildren()[0].setKind( "left" );
			}
		}
	}

	private void printPreOrder(Node node, String side) {

		if ( node != null ) {
			System.out.println( "node's str: " + node.getStr() + " child[0]: " + node.getChildren()[0] + " child[1]: "
					+ node.getChildren()[1] + " side: " + side );
			printPreOrder( node.getChildren()[0], "left" );
			printPreOrder( node.getChildren()[1], "right" );
		}
	}
}
