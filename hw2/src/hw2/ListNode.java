package hw2;

//Basic node stored in a linked list
//Note that this class is not accessible outside
//of package DataStructures

class ListNode
{
		// Constructors
	ListNode( Comparable theElement )
	{
		this( theElement, null );
	}

	ListNode( Comparable theElement, ListNode n )
	{
		element = theElement;
		next	= n;
	}

		// Friendly data; accessible by other package routines
	Comparable   element;
	ListNode next;
}

