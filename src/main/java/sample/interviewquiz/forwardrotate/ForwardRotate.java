package sample.interviewquiz.forwardrotate;

/**
 * google-interview-questions 38 Answers
 * 
 * Implement rotate function for forward-only iterators.
 * 
 * Clarification: with O(1) additional memory. Rotate semantics should be that of std::rotate.
 * 
 * I personally know a O(n*log(n)) solution which takes O(log(n)) extra memory, and I assume it should be possible to
 * reduce memory costs to O(1).
 * 
 * @author seiyak
 * 
 */

public class ForwardRotate {

	public int[] rotate(int startIndex, int middleIndex, int endIndex, int[] input) {

		if ( isNull( input ) ) {
			throw new IllegalArgumentException( "input must not be null" );
		}

		// return the original input array without doing anything
		if ( input.length == 0 || input.length == 1 ) {
			return input;
		}

		if ( checkIndex( startIndex, input.length ) && checkIndex( middleIndex, input.length )
				&& checkIndex( endIndex, input.length ) ) {
			return doRotate( startIndex, middleIndex, endIndex, input );
		}

		throw new IllegalArgumentException( "invalid index was specified, startIndex: " + startIndex + " middleIndex: "
				+ middleIndex + " endIndex: " + endIndex + " input length: " + input.length );
	}

	private boolean isNull(int[] input) {
		if ( input == null ) {
			return true;
		}

		return false;
	}

	private boolean checkIndex(int index, int inputLength) {

		if ( index < 0 || index >= inputLength ) {
			return false;
		}

		return true;
	}

	private int[] doRotate(int startIndex, int middleIndex, int endIndex, int[] input) {

		int newStartIndex = ( endIndex - middleIndex ) + 1;

		while ( newStartIndex <= endIndex ) {

			int s = input[startIndex];
			input[startIndex++] = input[middleIndex];
			input[middleIndex] = input[newStartIndex];
			input[newStartIndex] = s;

			middleIndex++;
			newStartIndex++;
		}

		return input;
	}
}
