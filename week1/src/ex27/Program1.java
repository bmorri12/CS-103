package ex27;

import java.util.Scanner;

/**
 * Exercise 2.7 (1)
 * @author morgantepell
 *
 * a)	O(n)
 * b)	O(10) = 2
 * 		O(1000000) = 2
 * 		O(2000000) = 3
 * 		O(10000000) = 3
 * 		O(100000000) = 3
 * 		O(100000000) = 3
 * c) It doesn't seem to grow at all, but this is likely due to inadequate timing.
 */

public class Program1 {

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
		
		int sum = 0;
		long startTime = System.currentTimeMillis();
		for(int i = 0; i < n; i++) {
	         sum++;
	      }
		long endTime = System.currentTimeMillis();
		
		System.out.println( sum );
		System.out.println( endTime - startTime );
		
	}

}
