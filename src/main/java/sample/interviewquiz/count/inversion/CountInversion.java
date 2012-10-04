package sample.interviewquiz.count.inversion;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * google-interview-questions 39 Answers
 * 
 * Count smaller elements on right side
 * 
 * eg : [4,12,5,6,1,34,3,2]
 * o/p [3,5,3,3,0,2,1,0]
 * 
 * @author seiyak
 * 
 */
public class CountInversion {

	public int[] countInversion(int[] input) {

		Map<Integer, Integer> inversionMap = new LinkedHashMap<Integer, Integer>();
		int[] original = copyInput( input );

		doCountInversion( input, inversionMap );

		return getInversions( original, inversionMap );
	}

	private int[] copyInput(int[] input) {

		int[] copy = new int[input.length];
		for ( int i = 0; i < input.length; i++ ) {
			copy[i] = input[i];
		}

		return copy;
	}

	public void doCountInversion(int[] input, Map<Integer, Integer> inversionMap) {

		divide( input, inversionMap, 0, input.length - 1 );
	}

	private void divide(int[] input, Map<Integer, Integer> inversionMap, int lo, int hi) {

		if ( lo < hi ) {

			int mid = ( lo + hi ) / 2;

			divide( input, inversionMap, lo, mid );
			divide( input, inversionMap, mid + 1, hi );

			merge( input, inversionMap, lo, mid, hi );

			// System.out.println( "lo: " + lo + " mid: " + mid + " hi: " + hi );
		}
	}

	private void merge(int[] input, Map<Integer, Integer> inversionMap, int lo, int mid, int hi) {

		int i = lo, j = mid + 1, k = 0;
		int[] temp = new int[( mid - lo ) + 1];
		System.arraycopy( input, lo, temp, 0, temp.length );
		int offset = 0;

		while ( ( i < j ) && ( j <= hi ) ) {

			if ( temp[k] > input[j] ) {

				if ( k < ( temp.length - 1 ) ) {
					++offset;
				}
				else {
					add( inversionMap, temp, k, 1 );
				}

				// System.out.println( "inversion: i: " + i + " j: " + j + " k: " + k + " temp[k]: " + temp[k]
				// + " input[j]: " + input[j] );

				input[i++] = input[j++];
			}
			else if ( temp[k] < input[j] ) {
				// System.out.println( "sorted: i: " + i + " j: " + j + " k: " + k + " temp[k]: " + temp[k]
				// + " input[j]: " + input[j] );

				if ( offset != 0 ) {
					add( inversionMap, temp, k, offset );
				}

				input[i++] = temp[k++];
			}
		}

		while ( i < j ) {
			// System.out.println( "leftovers: i: " + i + " j: " + j + " k: " + k + " temp[k]: " + temp[k] );
			input[i++] = temp[k++];
		}
		// System.out.println();
	}

	private void add(Map<Integer, Integer> inversionMap, int[] temp, int inversionIndex, int offset) {

		if ( inversionMap.get( temp[inversionIndex] ) == null ) {
			inversionMap.put( temp[inversionIndex], offset );
		}
		else {
			inversionMap.put( temp[inversionIndex], inversionMap.get( temp[inversionIndex] ) + offset );
		}
	}

	private int[] getInversions(int[] input, Map<Integer, Integer> inversionMap) {

		int[] inversions = new int[input.length];
		for ( int i = 0; i < input.length; i++ ) {

			Integer inversion = inversionMap.get( input[i] );
			inversions[i] = inversion != null ? inversion : 0;
		}

		return inversions;
	}
}
