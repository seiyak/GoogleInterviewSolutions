package sample.interviewquiz.serieslastequal;

/**
 * google-interview-questions 26 Answers
 * 
 * Given a series of numbers as the input, the last one as the result. Use the rest numbers to calculate the result,only
 * +, -, *, / are allowed. The order of the input cannot be changed. If there is an equation, print it; or print
 * "no equation". If more than one solution, any working equation is fine.
 * 
 * example:
 * input: 2, 3, 1, 4
 * output: 2+3-1 = 4.
 * 
 * @author seiyak
 * 
 */

public class SeriesLastEqual {
	private Node root;

	public SeriesLastEqual(int firstNumber) {

		root = new Node( firstNumber, firstNumber );
	}

	public String getEquation(int[] input) {

		boolean res = false;
		addNode( root, input, 1, res );
		return "no equation";
	}

	private boolean addNode(Node node, int[] input, int index, boolean res) {

		if ( ( index < input.length - 1 ) && !res ) {

			for ( int i = 0; i < node.MAX_CHILDREN; i++ ) {
				doArithmetic( node, input[index], i );

				if ( hasEquation( node.getChildren()[i], input[input.length - 1] ) ) {

					node.getChildren()[i].setEquation( node.getChildren()[i].getEquation()
							+ node.getChildren()[i].getValue() );

					System.out.println( "found it, " + node.getChildren()[i].getCurrentResult() );
					System.out.println( "equation: " + node.getChildren()[i].getEquation() );

					return true;
				}
			}

			System.out.println( "" );

			System.out.println( "index: " + index );
			index++;

			res = addNode( node.getChildren()[0], input, index, res );
			res = addNode( node.getChildren()[1], input, index, res );
			res = addNode( node.getChildren()[2], input, index, res );
			res = addNode( node.getChildren()[3], input, index, res );
		}

		return res;
	}

	private Node doArithmetic(Node node, int number, int i) {

		node.getChildren()[i] = new Node( number );

		if ( i == 0 ) {
			// addition
			printEquation( node.getCurrentResult(), number, "+" );
			node.getChildren()[i].setEquation( node.getEquation() + node.getValue() + " + " );
			node.getChildren()[i].setCurrentResult( node.getCurrentResult() + number );
		}
		else if ( i == 1 ) {
			// subtraction
			printEquation( node.getCurrentResult(), number, "-" );
			node.getChildren()[i].setEquation( node.getEquation() + node.getValue() + " - " );
			node.getChildren()[i].setCurrentResult( node.getCurrentResult() - number );
		}
		else if ( i == 2 ) {
			// multiplication
			printEquation( node.getCurrentResult(), number, "*" );
			node.getChildren()[i].setEquation( node.getEquation() + node.getValue() + " * " );
			node.getChildren()[i].setCurrentResult( node.getCurrentResult() * number );
		}
		else if ( i == 3 ) {
			// division
			printEquation( node.getCurrentResult(), number, "/" );
			node.getChildren()[i].setEquation( node.getEquation() + node.getValue() + " / " );
			node.getChildren()[i].setCurrentResult( node.getCurrentResult() / number );
		}

		System.out.println( "equation here: " + node.getChildren()[i].getEquation() );
		return node.getChildren()[i];
	}

	private void printEquation(int input1, int input2, String operator) {

		System.out.println( input1 + " " + operator + " " + input2 );
	}

	private boolean hasEquation(Node node, int total) {

		if ( node.getCurrentResult() == total ) {
			return true;
		}

		return false;
	}
}
