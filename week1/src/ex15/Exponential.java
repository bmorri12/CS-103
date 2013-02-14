package ex15;

import java.util.Scanner;

public class Exponential {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s;
		Scanner in = new Scanner( System.in );
    	
    	System.out.println("Please enter the base:");
    	s= in.next();
    	int a = Integer.parseInt( s );
    	
    	System.out.println("Please enter the exponent:");
    	s= in.next();
    	int b = Integer.parseInt( s );
    	
    	System.out.println( Exponential.calc( a, b ) );
			
	}

	public static int calc( int a, int b) {
		if( b == 0)
		{
			return 1;
		}
		return a*Exponential.calc( a, b-1);
	}
	
}
