package sample.interviewquiz.string.findpattern;

import java.util.ArrayList;
import java.util.List;

/**
 * google-interview-questions 26 Answers
 * 
 * You are given a 2D array of characters and a character pattern. WAP to find if pattern is present in 2D array.
 * Pattern can be in any way (all 8 neighbors to be considered) but you can't use same character twice while matching.
 * Return 1 if match is found, 0 if not.
 * 
 * eg :
 * 
 * Matrix
 * {'A','C','P','R','C'},
 * {'X','S','O','P','C'},
 * {'V','O','V','N','I'},
 * {'W','G','F','M','N'},
 * {'Q','A','T','I','T'}
 * 
 * And pattern is microsoft.
 * 
 * @author seiyak
 * 
 */

public class FindPattern {

	public boolean findPattern(char[][] chars, int width, int height, char[] pattern) {

		if ( isNull( chars ) || isNull( pattern ) ) {
			throw new IllegalArgumentException( "chars and pattern must not be null" );
		}

		return doFindPattern( chars, width, height, pattern );
	}

	private boolean isNull(char[][] chars) {

		if ( chars == null ) {
			return true;
		}

		return false;
	}

	private boolean isNull(char[] pattern) {

		if ( pattern == null ) {
			return true;
		}

		return false;
	}

	private boolean doFindPattern(char[][] chars, int width, int height, char[] pattern) {

		char[] array = convert1DArray( chars, width, height );
		int i = 0, j = 0, nextIndex = -1;
		boolean found = true;

		while ( j < pattern.length ) {

			if ( j == 0 ) {
				if ( array[i] != pattern[j] ) {
					i++;
				}
				else {
					j++;
					nextIndex = i;
				}
			}
			else {
				nextIndex = checkNeighbors( array, nextIndex, pattern, j, width, height );
				if ( nextIndex == -1 ) {
					found = false;
					break;
				}
				else {
					j++;
				}
			}
		}

		return found;
	}

	private char[] convert1DArray(char[][] chars, int width, int height) {

		char[] charArray = new char[width * height];
		int index = 0;
		for ( int row = 0; row < height; row++ ) {
			for ( int col = 0; col < width; col++ ) {
				charArray[index++] = chars[row][col];
			}
		}

		return charArray;
	}

	private int checkNeighbors(char[] chars, int charIndex, char[] pattern, int patternIndex, int width, int height) {

		chars[charIndex] = ' ';
		List<Integer> candidates = new ArrayList<Integer>();

		if ( charIndex < width ) {

			candidates.add( getLower( charIndex, width ) );

			// uppers are out of array
			if ( ( charIndex % width ) == 0 ) {
				// index 0
				candidates.add( getRight( charIndex, width ) );
				candidates.add( getLowerRight( charIndex, width ) );

			}
			else if ( ( charIndex % width ) == ( width - 1 ) ) {

				// index (width - 1)
				candidates.add( getLeft( charIndex, width ) );
				candidates.add( getLeftLower( charIndex, width ) );
			}
			else {
				candidates.add( getLeft( charIndex, width ) );
				candidates.add( getRight( charIndex, width ) );
				candidates.add( getLeftLower( charIndex, width ) );
				candidates.add( getLowerRight( charIndex, width ) );
			}

		}
		else if ( ( ( charIndex % width ) == 0 ) && ( charIndex != 0 )
				&& ( charIndex != ( ( width * height ) - width ) ) ) {

			// lefts are out of array
			candidates.add( getUpper( charIndex, width ) );
			candidates.add( getRightUpper( charIndex, width ) );
			candidates.add( getRight( charIndex, width ) );
			candidates.add( getLower( charIndex, width ) );
			candidates.add( getLowerRight( charIndex, width ) );

		}
		else if ( ( ( charIndex % width ) == ( width - 1 ) ) && ( charIndex != ( width - 1 ) )
				&& ( charIndex != ( ( width * height ) - 1 ) ) ) {

			// rights are out of array
			candidates.add( getLeftUpper( charIndex, width ) );
			candidates.add( getUpper( charIndex, width ) );
			candidates.add( getLeft( charIndex, width ) );
			candidates.add( getLeftLower( charIndex, width ) );
			candidates.add( getLower( charIndex, width ) );
		}
		else if ( charIndex >= ( ( width * height ) - width ) ) {

			candidates.add( getUpper( charIndex, width ) );

			// lowers are out of range
			if ( ( charIndex % width ) == 0 ) {

				candidates.add( getRightUpper( charIndex, width ) );
				candidates.add( getRight( charIndex, width ) );

			}
			else if ( ( charIndex % width ) == ( width - 1 ) ) {

				candidates.add( getLeftUpper( charIndex, width ) );
				candidates.add( getLeft( charIndex, width ) );

			}
			else {

				candidates.add( getLeftUpper( charIndex, width ) );
				candidates.add( getRightUpper( charIndex, width ) );
				candidates.add( getLeft( charIndex, width ) );
				candidates.add( getRight( charIndex, width ) );
			}
		}
		else {
			// add all the neighbors
			candidates.add( getLeftUpper( charIndex, width ) );
			candidates.add( getUpper( charIndex, width ) );
			candidates.add( getRightUpper( charIndex, width ) );
			candidates.add( getLeft( charIndex, width ) );
			candidates.add( getRight( charIndex, width ) );
			candidates.add( getLeftLower( charIndex, width ) );
			candidates.add( getLower( charIndex, width ) );
			candidates.add( getLowerRight( charIndex, width ) );
		}

		return getNextIndex( chars, candidates, pattern, patternIndex );
	}

	private int getLeftUpper(int charIndex, int width) {

		return charIndex - width - 1;
	}

	private int getUpper(int charIndex, int width) {

		return charIndex - width;
	}

	private int getRightUpper(int charIndex, int width) {

		return charIndex - width + 1;
	}

	private int getLeft(int charIndex, int width) {

		return charIndex - 1;
	}

	private int getRight(int charIndex, int width) {

		return charIndex + 1;
	}

	private int getLeftLower(int charIndex, int width) {

		return charIndex + width - 1;
	}

	private int getLower(int charIndex, int width) {

		return charIndex + width;
	}

	private int getLowerRight(int charIndex, int width) {

		return charIndex + width + 1;
	}

	private int getNextIndex(char[] chars, List<Integer> candidates, char[] pattern, int patternIndex) {

		int nextIndex = -1;
		for ( int candidate : candidates ) {
			if ( chars[candidate] == pattern[patternIndex] ) {
				nextIndex = candidate;
				break;
			}
		}

		return nextIndex;
	}
}
