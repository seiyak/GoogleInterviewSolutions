package sample.interviewquiz.sequence.increasedecrease;

/**
 * google-interview-questions 16 Answers
 * 
 * There is a sequence {a1, a2, a3, a4, ..... aN}. A run is the maximal strictly increasing or strictly decreasing
 * continuous part of the sequence. Eg. If we have a sequence {1,2,3,4,7,6,5,2,3,4,1,2} We have 5 possible runs
 * {1,2,3,4,7}, {7,6,5,2}, {2,3,4}, {4,1} and {1,2}.
 * 
 * Given four numbers N, M, K, L. Count the number of possible sequences of N numbers that has exactly M runs, each of
 * the number in the sequence is less than or equal to K and difference between the adjacent numbers is less than equal
 * to L.
 * 
 * @author seiyak
 * 
 */

public class MaximalStrictIncreseDecrease {

	public boolean isStrictIncreaseDecrease(int[] input, int n, int m, int k, int l) {

		// n is the number of sequences.
		// m is the total runs.
		// k is the max allowable value.
		// l is the max diff between the adjacent numbers

		if ( hasMoreThanMax( input, k ) ) {
			throw new IllegalArgumentException( "found larger than max allowable value, " + k );
		}

		return doStrictIncreaseDecrease( input, n, m, k, l );
	}

	private boolean doStrictIncreaseDecrease(int[] input, int n, int m, int k, int l) {

		int startIndex = 0, currentIndex = 0;
		int count = 0;
		while ( startIndex < ( n - 1 ) ) {

			currentIndex = getUpperBoundOfIncreasing( input, startIndex, l ) - 1;
			if ( currentIndex > startIndex ) {
				// found an increasing range
				System.out.println( "found an increasing range from: " + startIndex + " to: " + currentIndex + " val: "
						+ getValuesWithinRange( input, startIndex, currentIndex ) );
				startIndex = currentIndex;
				count++;
			}

			currentIndex = getUpperBoundOfDecreasing( input, startIndex, l ) - 1;
			if ( currentIndex > startIndex ) {
				// found decreasing range
				System.out.println( "found a decreasing range from: " + startIndex + " to: " + currentIndex + " val: "
						+ getValuesWithinRange( input, startIndex, currentIndex ) );
				startIndex = currentIndex;
				count++;
			}
		}

		if ( count == m ) {
			return true;
		}

		return false;
	}

	private boolean hasMoreThanMax(int[] input, int k) {

		for ( int i = 0; i < input.length; i++ ) {

			if ( input[i] > k ) {
				return true;
			}
		}

		return false;
	}

	private boolean isIncreasing(int[] input, int startIndex) {

		if ( ( input[startIndex] - input[startIndex + 1] ) < 0 ) {
			return true;
		}

		return false;
	}

	private boolean isDecreasing(int[] input, int startIndex) {

		if ( ( input[startIndex] - input[startIndex + 1] ) > 0 ) {
			return true;
		}

		return false;
	}

	private int getUpperBoundOfIncreasing(int[] input, int startIndex, int l) {

		boolean done = false;

		while ( !done ) {

			if ( !isIncreasingDiffWithinRange( input, startIndex, l ) ) {
				done = true;
			}

			startIndex++;
		}

		return startIndex;
	}

	private boolean isIncreasingDiffWithinRange(int[] input, int startIndex, int l) {

		if ( startIndex < ( input.length - 1 ) ) {
			int diff = ( input[startIndex] - input[startIndex + 1] );
			if ( isIncreasing( input, startIndex ) && ( ( diff >= -l ) && ( diff <= 0 ) ) ) {
				return true;
			}
		}

		return false;
	}

	private int getUpperBoundOfDecreasing(int[] input, int startIndex, int l) {

		boolean done = false;

		while ( !done ) {

			if ( !isDecreasingDiffWithinRange( input, startIndex, l ) ) {
				done = true;
			}

			startIndex++;
		}

		return startIndex;
	}

	private boolean isDecreasingDiffWithinRange(int[] input, int startIndex, int l) {

		if ( startIndex < ( input.length - 1 ) ) {
			int diff = ( input[startIndex] - input[startIndex + 1] );
			if ( isDecreasing( input, startIndex ) && ( ( diff >= 0 ) && ( diff <= l ) ) ) {
				return true;
			}
		}

		return false;
	}

	private String getValuesWithinRange(int[] input, int startIndex, int endIndex) {

		String res = "";
		int index = startIndex;
		while ( index <= endIndex ) {

			res += input[index++] + " ";
		}

		return res;
	}
}
