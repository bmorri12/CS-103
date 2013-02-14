package ex27;

import java.util.Scanner;

/**
 * Exercise 2.7 (2)
 * @author morgantepell
 *
 * a)	O(n(n+1)/2) or O(n^2)
 * b)	O(100) = 0
 * 		O(1000) = 5
 * 		O(2000) = 7
 * 		O(10000) = 8
 * 		O(100000) = 411
 * 		O(200000) = 1626
 * c) This grew exponentially, as predicted, though exact numbers are difficult.
 */

public class Program4 {

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
			for( int j = 0; j < i; j++) {
				sum++;
			}	
	      }
		long endTime = System.currentTimeMillis();
		
		System.out.println( sum );
		System.out.println( endTime - startTime );
		
	}

}
