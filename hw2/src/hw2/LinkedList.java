package hw2;

// LinkedList class
//
// CONSTRUCTION: with no initializer
// Access is via LinkedListItr class
//
// ******************PUBLIC OPERATIONS*********************
// boolean isEmpty( )	 --> Return true if empty; else false
// void makeEmpty( )	  --> Remove all items
// LinkedListItr zeroth( )--> Return position to prior to first
// LinkedListItr first( ) --> Return first position
// void insert( x, p )	--> Insert x after current iterator position p
// void remove( x )	   --> Remove x
// LinkedListItr find( x )
//						--> Return position that views x
// LinkedListItr findPrevious( x )
//						--> Return position prior to x

/**
 * Linked list implementation of the list
 *	using a header node.
 * Access to the list is via LinkedListItr.
 * @author Mark Allen Weiss
 * @see LinkedListItr
 */
public class LinkedList<T>
{
	/**
	 * Construct the list
	 */
	public LinkedList( )
	{
		header = new ListNode( null );
		this.footer = header;
	}

	/**
	 * Test if the list is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return header.next == null;
	}

	/**
	 * Make the list logically empty.
	 */
	public void makeEmpty( )
	{
		header.next = null;
	}


	/**
	 * Return the header node
	 */
	public ListNode getStart( )
	{
		return this.header;
	}
	
	/**
	 * Return the footer node
	 */
	public ListNode getFinish( )
	{
		return this.footer;
	}
	
	/**
	 * Return an iterator representing the header node.
	 */
	public LinkedListItr zeroth( )
	{
		return new LinkedListItr( header );
	}

	/**
	 * Return an iterator representing the first node in the list.
	 * This operation is valid for empty lists.
	 */
	public LinkedListItr first( )
	{
		return new LinkedListItr( header.next );
	}

	/**
	 * Insert after p.
	 * @param x the item to insert.
	 * @param p the item prior to the newly inserted item.
	 */
	public ListNode add( Comparable x, ListNode p )
	{
		ListNode xx = new ListNode( x );
		
		if( p.next != null )
		{
			xx.next = p.next;
		}
		p.next = xx;
		
		return p.next;
	}
	
	/**
	 * Insert at the end of the list
	 * @param x the item to insert.
	 */
	public void add( Comparable x )
	{
		// handle empty lists
		if( this.header.element == null ) {
			this.header = new ListNode( x );
			this.footer = this.header;
		}
		// is it less than start?
		else if( x.compareTo( this.header.element ) <= 0 ) {
			ListNode xx = new ListNode( x );
			xx.next = this.header;
			this.header = xx;
		}
		// not on end	
		else if( x.compareTo( this.footer.element ) >= 0)
		{
			this.footer.next = new ListNode( x );
			this.footer = this.footer.next;
		}
		// okay, somewhere else
		else
		{
			LinkedListItr itr = this.zeroth( );
			for( ; !itr.isPastEnd( ); itr.advance( ) )
			{
				if( x.compareTo( itr.next() ) <= 0 )
				{
					ListNode xx = new ListNode( x );
					xx.next = itr.current.next;
					itr.current.next = xx;
					
					break;
				}
			}
		}
	}

	/**
	 * Return iterator corresponding to the first node containing an item.
	 * @param x the item to search for.
	 * @return an iterator; iterator isPastEnd if item is not found.
	 */
	public LinkedListItr find( Object x )
	{
/* 1*/	  ListNode itr = header.next;

/* 2*/	  while( itr != null && !itr.element.equals( x ) )
/* 3*/		  itr = itr.next;

/* 4*/	  return new LinkedListItr( itr );
	}

	/**
	 * Return iterator prior to the first node containing an item.
	 * @param x the item to search for.
	 * @return appropriate iterator if the item is found. Otherwise, the
	 * iterator corresponding to the last element in the list is returned.
	 */
	public LinkedListItr findPrevious( Object x )
	{
/* 1*/	  ListNode itr = header;

/* 2*/	  while( itr.next != null && !itr.next.element.equals( x ) )
/* 3*/		  itr = itr.next;

/* 4*/	  return new LinkedListItr( itr );
	}

	/**
	 * Remove the first occurrence of an item.
	 * @param x the item to remove.
	 */
	public void remove( Object x )
	{
		LinkedListItr p = findPrevious( x );

		if( p.current.next != null )
			p.current.next = p.current.next.next;  // Bypass deleted node
	}

	// Simple print method
	public static void printList( LinkedList theList )
	{
		if( theList.isEmpty( ) )
			System.out.print( "Empty list" );
		else
		{
			LinkedListItr itr = theList.zeroth( );
			for( ; !itr.isPastEnd( ); itr.advance( ) )
				System.out.print( itr.retrieve( ) + " " );
		}

		System.out.println( );
	}
	
	public void printList()
	{
		LinkedList.printList( this );
	}

	private ListNode header;
	private ListNode footer;

}