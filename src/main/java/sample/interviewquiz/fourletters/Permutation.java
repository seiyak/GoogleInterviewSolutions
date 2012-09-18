package sample.interviewquiz.fourletters;

public class Permutation {

	public void printPermutations(String input1, String input2) {

		doPrint( "", input1, 0, input2, 0 );
	}

	private void doPrint(String res, String input1, int pos1, String input2, int pos2) {

		if ( pos1 <= input1.length() && pos2 <= input2.length() ) {

			if ( res.length() < 2 ) {

				// A-B part
				doPrint( Character.toString( input1.charAt( 0 ) ) + Character.toString( input1.charAt( 1 ) ), input1,
						1, input2, pos2 );

				// A-C part
				doPrint( Character.toString( input1.charAt( 0 ) ) + Character.toString( input2.charAt( 0 ) ), input1,
						1, input2, pos2 );

				// A-D part
				doPrint( Character.toString( input1.charAt( 0 ) ) + Character.toString( input2.charAt( 1 ) ), input1,
						1, input2, pos2 );

			}

			if ( res.length() == 2 ) {

				if ( res.charAt( res.length() - 1 ) == input1.charAt( input1.length() - 1 ) ) {
					// A-B-C and A-B-D parts
					doPrint( res + input2.charAt( 0 ), input1, 1, input2, 1 );
					doPrint( res + input2.charAt( 1 ), input1, 1, input2, 0 );

				}
				else if ( res.charAt( res.length() - 1 ) == input2.charAt( 0 ) ) {
					// A-C-B and A-C-D parts
					doPrint( res + input1.charAt( 1 ), input1, 1, input2, 1 );
					doPrint( res + input2.charAt( 1 ), input1, 2, input2, 1 );

				}
				else if ( res.charAt( res.length() - 1 ) == input2.charAt( 1 ) ) {
					// A-D-B and A-D-C parts
					doPrint( res + input1.charAt( 1 ), input1, 1, input2, 0 );
					doPrint( res + input2.charAt( 0 ), input1, 2, input2, 1 );
				}
			}
			else if ( res.length() == 3 ) {

				if ( ( res.charAt( res.length() - 1 ) == input2.charAt( 0 ) ) && ( pos1 != input1.length() ) ) {
					// A-B-C-D part
					System.out.println( "expecting A-B-C-D: " + res + input2.charAt( 1 ) );

				}
				else if ( ( res.charAt( res.length() - 1 ) == input2.charAt( 0 ) ) && ( pos1 == input1.length() ) ) {
					// A-D-C-B part
					System.out.println( "expecting A-D-C-B: " + res + input1.charAt( 1 ) );

				}
				else if ( ( res.charAt( res.length() - 1 ) == input2.charAt( 1 ) ) && ( pos1 != input1.length() ) ) {
					// A-B-D-C part
					System.out.println( "expecting A-B-D-C: " + res + input2.charAt( 0 ) );

				}
				else if ( ( res.charAt( res.length() - 1 ) == input2.charAt( 1 ) ) && ( pos1 == input1.length() ) ) {
					// // A-C-D-B part
					System.out.println( "expecting A-C-D-B: " + res + input1.charAt( 1 ) );

				}
				else if ( ( res.charAt( res.length() - 1 ) == input1.charAt( 1 ) ) && ( pos2 == 0 ) ) {
					// // A-D-B-C part
					System.out.println( "expecting A-D-B-C: " + res + input2.charAt( 0 ) );

				}
				else if ( ( res.charAt( res.length() - 1 ) == input1.charAt( 1 ) ) && ( pos2 == 1 ) ) {
					// A-C-B-D part
					System.out.println( "expecting A-C-B-D: " + res + input2.charAt( 1 ) );
				}
			}
		}
	}
}
