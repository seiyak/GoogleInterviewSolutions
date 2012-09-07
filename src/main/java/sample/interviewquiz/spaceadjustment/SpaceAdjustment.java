package sample.interviewquiz.spaceadjustment;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * google-interview-questions 15 Answers
 * 
 * Given a line, adjust this line to the page width.
 * 
 * For example, given "Dog is cute" (length of chars is 11) and the page width is 15, adjust the line to "Dog is cute".
 * The extra spaces should be distributed as much even as possible. Assume there is no space before the first word or
 * after the last word.
 */

public class SpaceAdjustment {

	Pattern pattern = Pattern.compile( "\\s" );
	public static final int NUMBER_OF_CHARACTERS = 15;

	public String adjust(String input) {

		if ( isNull( input ) ) {
			return null;
		}

		if ( input.isEmpty() ) {
			return returnSpaces();
		}

		List<String> list = new ArrayList<String>();

		addString( input, list );

		String res = "";
		int count = 0;
		for ( String str : list ) {

			if ( count >= 1 ) {
				res += "\n";
			}

			res += doAdjust( str );
			count++;
		}

		return res;
	}

	private boolean isNull(String input) {

		if ( input == null ) {
			return true;
		}

		return false;
	}

	private String returnSpaces() {
		String res = "";
		for ( int i = 0; i < NUMBER_OF_CHARACTERS; i++ ) {
			res += " ";
		}

		return res;
	}

	private void addString(String input, List<String> list) {

		if ( input.length() < NUMBER_OF_CHARACTERS ) {
			list.add( input );
		}
		else {
			splitInput( input, list );
		}
	}

	private void splitInput(String input, List<String> list) {

		int startIndex = 0, endIndex = NUMBER_OF_CHARACTERS;

		while ( true ) {

			list.add( input.substring( startIndex, endIndex ) );

			if ( endIndex == input.length() ) {
				break;
			}

			startIndex = endIndex;
			endIndex = endIndex + ( input.length() - endIndex );
		}
	}

	private String doAdjust(String input) {

		int spaceLeft = getNumberOfSpacesLeft( input, NUMBER_OF_CHARACTERS );
		int spaceDiff = 0;
		Matcher matcher = pattern.matcher( input );

		List<Integer> minSpaceList = new ArrayList<Integer>();
		StringBuilder str = new StringBuilder( input );
		while ( matcher.find() ) {

			spaceDiff = matcher.end() - matcher.start();
			System.out.println( "start: " + matcher.start() + " end: " + matcher.end() + " spaceDiff: " + spaceDiff
					+ " spaceLeft: " + spaceLeft );

			if ( spaceDiff < spaceLeft ) {
				minSpaceList.add( matcher.start() );
			}
		}

		if ( !minSpaceList.isEmpty() ) {

			System.out.println( "minSpaceList size: " + minSpaceList.size() + " space size: "
					+ ( spaceLeft / minSpaceList.size() ) );

			int offset = 0;

			for ( int index : minSpaceList ) {
				System.out.println( "index: " + index );

				index += offset;
				if ( minSpaceList.size() == 1 ) {
					int indx = index;
					for ( int i = 0; i < 2; i++ ) {
						for ( int j = 0; j < ( spaceLeft / 2 ); j++ ) {
							str.insert( indx + j, " " );
						}
						
						indx = str.length();
					}
				}
				else {
					for ( int i = 0; i < ( spaceLeft / minSpaceList.size() ); i++ ) {
						str.insert( index + i, " " );
						offset++;
					}
				}
			}
		}

		System.out.println( "str size: " + str.length());
		for(int i = 0; i < str.length();i++){
			System.out.println( "index: " + i + " char: " + str.charAt( i ) );
		}

		return str.toString();
	}

	private int getNumberOfSpacesLeft(String input, int numberOfCharacters) {

		return numberOfCharacters - input.length();
	}
}
