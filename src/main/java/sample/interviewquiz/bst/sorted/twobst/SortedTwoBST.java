package sample.interviewquiz.bst.sorted.twobst;

import java.util.LinkedList;
import java.util.List;

/**
 * google-interview-questions 50 Answers
 * 
 * Given two BST print the element in sorted form
 * 
 * complexity O(n) time maxm alloted space will be O(height of bigger tree)
 * 
 * eg ;
 * 
 * T1
 * 
 * 
 *  3
 * 1 5
 * 
 * T2
 * 
 * 
 *  4
 * 2 6
 * 
 * o/p 1 2 3 4 5 6
 * 
 * @author seiyak
 * 
 */

public class SortedTwoBST {

	public void printSortedTwoBST(Node root1, Node root2) {

		printArray( compareAndGetOrderedTwoBST( getBSTasArray( root1 ), getBSTasArray( root2 ) ) );
	}

	private Integer[] getBSTasArray(Node root) {

		List<Integer> list = new LinkedList<Integer>();
		traverseInOrder( root, list );

		return list.toArray( new Integer[list.size()] );
	}

	private void traverseInOrder(Node node, List<Integer> list) {

		if ( node != null ) {

			traverseInOrder( node.getLeft(), list );
			list.add( node.getData() );
			traverseInOrder( node.getRight(), list );
		}
	}

	private int[] compareAndGetOrderedTwoBST(Integer[] array1, Integer[] array2) {

		int i = 0, j = 0, k = 0;
		int[] res = new int[array1.length + array2.length];
		while ( ( i < array1.length ) && ( j < array2.length ) ) {

			if ( array1[i] > array2[j] ) {
				res[k++] = array2[j++];
			}
			else if ( array1[i] < array2[j] ) {
				res[k++] = array1[i++];
			}
		}

		while ( i < array1.length ) {
			res[k++] = array1[i++];
		}

		while ( j < array2.length ) {
			res[k++] = array2[j++];
		}

		return res;
	}

	private void printArray(int[] array) {

		String res = "";

		for ( int val : array ) {
			res += val + " ";
		}

		System.out.println( "sorted BST: " + res + "\n" );
	}
}
