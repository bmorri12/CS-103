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
		testList.add (new Integer (8));
		testList.add (new Integer (1));
		testList.add (new Integer (2));

		testList.add (new Integer (10));
		testList.add (new Integer (19));
		testList.add (new Integer (14));

		
		testList.printList();
	}

}