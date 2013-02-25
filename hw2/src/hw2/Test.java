package hw2;

public class Test {

	/**
	 * @param args
	 */
	public static void main (String args [])
	{
		LinkedList testList = new LinkedList ();
		
		testList.add (new Integer (4));
		testList.add (new Integer (6));
		testList.add (new Integer (3));
		testList.add (new Integer (5));
		testList.add (new Integer (18));
		testList.add (new Integer (2));
				
		testList.add (new Integer (10));
		testList.add (new Integer (19));
		testList.add (new Integer (14));
		
		System.out.println( testList.findPosition( new Integer( 10 ) ) );
		
		testList.printList();
	}

}