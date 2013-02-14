package ex27;

import java.util.Scanner;

/**
 * Exercise 2.7 (2)
 * @author morgantepell
 *
 * a)	O(n^3)
 * b)	O(10) = 0
 * 		O(100) = 88
 * 		O(101) = 107
 * 		O(200) = 2960
 * c) This grew exponentially, as predicted, though exact numbers are difficult to compare. Multiplying
 * N by 2 caused O to increase 30-fold.
 */

public class Program5 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s;
		Scanner in = new Scanner( System.in );
    	
    	System.out.println("n:");
    	s= in.next();
    	int n = Integer.parseInt( s );
		
		long sum = 0;
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
			for( int j = 0; j < i * i; j++) {
				for( int k = 0; k < j; k++ ) {
					sum++;
				}
			}	
	      }
		long endTime = System.currentTimeMillis();
		
		System.out.println( sum );
		System.out.println( endTime - startTime );
		
	}

}
