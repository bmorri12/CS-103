package ex115;

import java.util.ArrayList;

/**
 * @author morgantepell
 *
 */
public class Circle {

	private Double radius;
	
	/**
	 * Set the radius
	 * @param r
	 * @return
	 */
	public void setRadius( Double r ) {
		this.radius = r;
	}
	
	/**
	 * Get the radius
	 * @return double radius
	 */
	public Double getRadius() {
		return this.radius;
	}
	
	/**
	 * Create a new circle with radius r
	 * @param r
	 */
	public Circle( Double r ) {
		this.setRadius( r );
	}
	
	public Circle( double r ) {
		Double r1 = new Double(r);
		this.setRadius( r1 );
	}
	
	public String toString() {
		return this.getRadius().toString();
	}
	
	/**
	 * Get the area of the Circle
	 * @return double
	 */
	public double getArea() {
		return Math.PI * this.getRadius() * this.getRadius();
	}
	
	/**
	 * Get the circumference of the Circle
	 * @return double
	 */
	public double getCircumference() {
		return 2 * Math.PI * this.getRadius();
	}

}
