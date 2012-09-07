package sample.interviewquiz.readn;

import java.io.EOFException;

/**
 * google-interview-questions 13 Answers
 * 
 * Given API:
 * int Read4096(char* buf);
 * It reads data from a file and records the position so that the next time when it is called it read the next 4k chars
 * (or the rest of the file, whichever is smaller) from the file.
 * The return is the number of chars read.
 * 
 * Todo: Use above API to Implement API
 * "int Read(char* buf, int n)" which reads any number of chars from the file.
 * 
 * @author seiyak
 * 
 */

public class ReadN {

	private static int nextPosition = 0;
	private static final int MAX_READ = 4096;
	private char[] chars;

	private synchronized void addAndSetNextPosition(int offset) {

		nextPosition += offset;
	}

	public synchronized int getNextPosition() {
		return nextPosition;
	}

	public int read4096(char[] input) throws EOFException {

		if ( isNull( input ) ) {
			throw new IllegalArgumentException( "input must not be null" );
		}

		if ( isEmpty( input ) ) {
			return 0;
		}

		return doRead4096( input, MAX_READ );
	}

	private int doRead4096(char[] input, int maxRead) throws EOFException {

		if ( isEndOfFile( input ) ) {
			throw new EOFException( "next position, " + getNextPosition() + " is greater than input length, "
					+ input.length );
		}

		int index = getNextPosition();
		int numberOfRead = 0;

		if ( chars == null ) {
			chars = new char[input.length];
		}

		while ( numberOfRead < maxRead ) {

			try {
				chars[index] = input[index];
				index++;
				numberOfRead++;
			}
			catch ( IndexOutOfBoundsException ex ) {
				System.out.println( "reached the end of file, index: " + index );
				break;
			}
		}

		addAndSetNextPosition( numberOfRead );

		return numberOfRead;
	}

	private boolean isEndOfFile(char[] input) {

		if ( input.length <= nextPosition ) {
			return true;
		}

		return false;
	}

	public int readN(char[] input, int n) throws EOFException {

		return doRead4096( input, n );
	}

	private boolean isNull(char[] input) {

		if ( input == null ) {
			return true;
		}

		return false;
	}

	private boolean isEmpty(char[] input) {

		if ( input.length == 0 ) {
			return true;
		}

		return false;
	}
}
