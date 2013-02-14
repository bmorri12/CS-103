package ex114;

import java.util.ArrayList;

public class OrderedVECTOR {
	
	private ArrayList<Object> list;

	public OrderedVECTOR() {
		this.list = new ArrayList<Object>();
	}
	
	public OrderedVECTOR(ArrayList<Object> list) {
		this.list = list;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		OrderedVECTOR ov = new OrderedVECTOR();
		
		int i = 5;
		int g = 3;
		
		ov.insert( i );
		ov.insert( g );
		
		System.out.println( ov.toString() );
		
	}
	
	public boolean insert( Object o ) {
		return this.list.add(o);
	}
	
	public boolean remove( Object o ) {
		return this.list.remove(o);
	}
	
	public boolean removeAll( Object o ) {
		return this.list.remove(o);
	}
	
	public Object lastElement() {
		return this.list.get( this.list.size() - 1 );
	}
	
	public String toString() {
		return this.list.toString();
	}
	
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

}
