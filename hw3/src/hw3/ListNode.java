package hw3;

//Basic node stored in a linked list
//Note that this class is not accessible outside
//of package DataStructures

class ListNode
{
		// Constructors
	ListNode( char theElement )
	{
		this( theElement, null );
	}

	ListNode( char theElement, ListNode n )
	{
		element = theElement;
		next	= n;
	}

		// Friendly data; accessible by other package routines
	char   element;
	ListNode next;
}

