package ex11;

import java.util.Scanner;
import java.io.*;

/**
 * HCF (profile here)
 * @author morgantepell
 *
 * n 			| runtime (ms)
 * ---------------------------
 * 2			| 0
 * 3			| 0
 * 4			| 0
 * 100			| 1
 * 1000			| 1
 * 5000000		| 1
 */

public class HCF {
    
	public static void main(String[] args) {
   
    	String s;

    	Scanner in = new Scanner( System.in );
    	
    	System.out.println("Please enter the numbers, seperated by commas, or n: ");
    	
    	s= in.next();
    	
    	String[] numbers = s.split(",");
    	
    	if( numbers.length == 1 ) {
    		HCF.test( Integer.parseInt(numbers[0] ) );
    	}
    	else
    	{
    		int hcf = HCF.calc( numbers );
        	
            System.out.println(hcf);
    	}
    }
	
	public static void test( int n ) {
		int[] numbers = new int[n];
		
		int i = 0;
		while( i < n ) {
			numbers[i] = (int)(Math.random()*1000);
			i++;
		}
		
		int hcf = HCF.calc( numbers );
		
		System.out.println(hcf);
	}
	
	public static int calc(String[] strings) {
		int[] numbers= new int[strings.length];
		
		int i = 0;
		
		for(String str: strings){
    		numbers[i] = Integer.parseInt( str );
    		i++;
    	}
		
		return HCF.calc(numbers);
	}
	
	public static int calc(int[] nums) {
		
		// start profile
		long startTime = System.currentTimeMillis();
		
		int hcf = HCF.calc( nums[0], nums[1] );
	
		for( int i = 2; i < nums.length; i++ ) {
			hcf = HCF.calc( hcf, nums[i] );
		}
		
		// end profile
		long endTime = System.currentTimeMillis();
		System.out.println( endTime - startTime );
		
		return hcf;
	}
	
	/**
	 * Calculate the HCF of 2 numbers
	 * @param a
	 * @param b
	 * @return
	 */
	private static int calc( int a, int b) {
		if( b == 0) {
			return a;
		} else {
			return HCF.calc( b, a % b); // recursive calculation
		}
	}
	
	
}
