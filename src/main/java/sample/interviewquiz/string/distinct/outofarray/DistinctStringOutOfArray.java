package sample.interviewquiz.string.distinct.outofarray;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * google-interview-questions 24 Answers
 * 
 * Give you an array of String,
 * return number of distinct strings in that array
 * 
 * @author seiyak
 * 
 */

public class DistinctStringOutOfArray {

	public String[] getDistinctStrings(String[] input) {

		if ( isNull( input ) ) {
			throw new IllegalArgumentException( "input must not be null" );
		}

		if ( isEmpty( input ) || input.length == 1 ) {
			return input;
		}

		return doGetDistinctStrings( input );
	}

	private boolean isNull(String[] input) {

		if ( input == null ) {
			return true;
		}

		return false;
	}

	private boolean isEmpty(String[] input) {

		if ( input.length == 0 ) {

			return true;
		}

		return false;
	}

	private String[] doGetDistinctStrings(String[] input) {

		Map<String, Integer> map = new LinkedHashMap<String, Integer>();

		for ( String str : input ) {

			if ( map.get( str ) == null ) {
				map.put( str, 1 );
			}
			else {
				map.put( str, map.get( str ) + 1 );
			}
		}

		List<String> list = new LinkedList<String>();
		for ( Entry<String, Integer> entry : map.entrySet() ) {

			if ( entry.getValue() == 1 ) {
				list.add( entry.getKey() );
			}
		}

		return list.toArray( new String[list.size()] );
	}
}
