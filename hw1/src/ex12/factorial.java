package ex12;

import java.util.Scanner;

public class factorial {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s;
		

    	Scanner in = new Scanner( System.in );
    	
    	System.out.println("Please enter the number:");
    	
    	s= in.next();
    	
    	int i = Integer.parseInt( s );
    	
    	int f = factorial.calc( i );
    	
    	System.out.println(f);
			
	}
	
	public static int calc( int i ) {
		int f = 1;
		
		while( i > 0)
		{
			f = f * i;
			i--;
		}
		
		return f;
	}

}
