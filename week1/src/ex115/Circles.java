package ex115;

import java.util.ArrayList;

public class Circles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int number = 15;
		int i = 0;
		ArrayList<Circle> circles = new ArrayList<Circle>();

		while( i < number ) {
			Circle c = new Circle( Math.random() );
			circles.add( c );
			i++;
		}
//		Circle c1 = new Circle( Math.random() );
//		Circle c2 = new Circle( Math.random() );
//		Circle c3 = new Circle( Math.random() );
//		Circle c4 = new Circle( Math.random() );
//		
//		circles.add( c1 );
//		circles.add( c2 );
//		circles.add( c3 );
//		circles.add( c4 );
		
		System.out.println( "Circles:" );
		Circle largestC = circles.get(0); // same as largest radius, but let's do it anyways...
		Circle largestA = circles.get(0); // same as largestA, but let's do it anyways...
		for( Circle c: circles ) {
			if( c.getCircumference() > largestC.getCircumference() ) {
				largestC = c;
			}
			if( c.getArea() > largestC.getArea() ) {
				largestA = c; // this is the same as 
			}
			System.out.println( c.toString() );
		}
		
		System.out.println( "largest circumference:" );
		System.out.println( largestC.getCircumference() );
		
		System.out.println( "largest area for:" );
		System.out.println( largestA.getArea() );
		
//		System.out.println( c1.getArea() );
//		System.out.println( c1.getCircumference() );

	}

}
