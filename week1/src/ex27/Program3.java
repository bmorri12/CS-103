package ex27;

import java.util.Scanner;

/**
 * Exercise 2.7 (2)
 * @author morgantepell
 *
 * a)	O(n^3)
 * b)	O(100) = 5
 * 		O(200) = 8
 * 		O(1000) = 109
 * 		O(2000) = 1030
 * c) This grew exponentially, around n^3, as predicted, though exact numbers are difficult.
 */

public class Program3 {

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
			for( int j = 0; j < n * n; j++) {
				sum++;
			}	
	      }
		long endTime = System.currentTimeMillis();
		
		System.out.println( sum );
		System.out.println( endTime - startTime );
		
	}

}
