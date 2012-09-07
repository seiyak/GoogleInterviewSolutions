package sample.interviewquiz.interleaving.threestrings;

/**
 * Three strings say A,B,C are given to you. Check weather 3rd string is interleaved from string A and B.
 * Ex: A="abcd" B="xyz" C="axybczd". answer is yes. o(n)
 * 
 * @author seiyak
 * 
 */

public class ThreeStrings {

	public boolean check(String aStr, String bStr, String interleaved) {

		char[] aChar = aStr.toCharArray();
		char[] bChar = bStr.toCharArray();
		int aIndex = 0, bIndex = 0, interleavedIndex = 0;

		for ( char c : interleaved.toCharArray() ) {

			if ( !checkBoundaries( aIndex, aStr.length(), bIndex, bStr.length(), interleavedIndex, interleaved.length() ) ) {
				System.out.println( "exhausted before the end, aIndex: " + aIndex + " bIndex: " + bIndex
						+ " interleavedIndex: " + interleavedIndex + " size: " + interleaved.length() );
				return false;
			}

			if ( aIndex < aStr.length() && bIndex < bStr.length() ) {
				if ( ( aChar[aIndex] == c ) && ( bChar[bIndex] ) == c ) {
					if ( aIndex < bIndex ) {
						aIndex++;

						System.out.println( "aChar and bChar aIndex: " + aIndex );
						continue;
					}
					else if ( aIndex > bIndex ) {
						bIndex++;
						System.out.println( "aChar and bChar bIndex: " + bIndex );
						continue;
					}
				}
			}

			if ( aIndex < aStr.length() ) {
				if ( aChar[aIndex] == c ) {
					aIndex++;
					if ( Math.abs( aIndex - bIndex ) > aStr.length() ) {
						return false;
					}

					System.out.println( "from aChar aIndex: " + aIndex );
				}
			}

			if ( bIndex < bStr.length() ) {
				if ( bChar[bIndex] == c ) {
					bIndex++;
					if ( Math.abs( bIndex - aIndex ) > bStr.length() ) {
						return false;
					}

					System.out.println( "from bChar bIndex: " + bIndex );
				}
			}

			interleavedIndex++;
		}

		if ( ( aIndex != aStr.length() ) || ( bIndex != bStr.length() ) ) {
			return false;
		}

		return true;
	}

	private boolean checkBoundaries(int aIndex, int aStrLength, int bIndex, int bStrLength, int interleavedIndex,
			int interleavedLength) {

		boolean res = true;
		if ( interleavedIndex != ( interleavedLength - 1 ) ) {
			if ( ( aIndex == aStrLength ) && ( Math.abs( aIndex - bIndex ) == aStrLength ) ) {
				res = false;
			}
			else if ( ( bIndex == bStrLength ) && ( Math.abs( bIndex - aIndex ) == bStrLength ) ) {
				res = false;
			}
		}

		return res;
	}
}
