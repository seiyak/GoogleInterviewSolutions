package sample.interviewquiz.string.possiblesubstrings;

/**
 * google-interview-questions 49 Answers
 * 
 * Generate all the possible substrings using the characters of a given string. Write code. (The order of chars do not
 * matter, i.e., ac <=> ca)
 * i/p: abc
 * o/p: { a,b,c,ab,ac,bc,abc}
 * 
 * <Modified the language of the question, to avoid any confusions>
 * 
 * @author seiyak
 * 
 */
public class AllSubStrings {
	public void printAllSubString(String input) {

		doPrintAllSubString( 0, 0, input.toCharArray() );
	}

	public void doPrintAllSubString(int base, int index, char[] chars) {

		if ( ( base < chars.length ) && ( index < chars.length ) ) {

			if ( index < ( chars.length - 1 ) ) {

				if ( index == 0 ) {
					System.out.println( chars[base] );
				}
				else if ( base < index ) {
					System.out.println( chars[base] + "" + chars[index] );
				}

				doPrintAllSubString( base, ++index, chars );
			}
			else {

				if ( index == ( chars.length - 1 ) ) {
					if ( ( index - base ) > 1 ) {

						String str = "";
						for ( int i = base; i <= index; i++ ) {
							str += chars[i];
						}
						System.out.println( str );
					}
					else if ( ( index - base ) == 1 ) {
						System.out.println( chars[base] + "" + chars[index] );
					}
					doPrintAllSubString( ++base, 0, chars );
				}
			}

		}
	}
}
