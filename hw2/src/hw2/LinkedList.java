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
	 * Insert into the list, sorted
	 * 
	 * Best case: O(1) for start or end
	 * Worst case: O(n) for 1 before end
	 * Average case: O(n/2)
	 * 
	 * @param x the item to insert.
	 */
	public ListNode add( Comparable x )
	{
		ListNode xx = new ListNode( x );
		
		// handle empty lists
		if( this.header.element == null ) {
			this.header = xx;
			this.footer = this.header;
		}
		// is it less than start?
		else if( x.compareTo( this.header.element ) <= 0 ) {
			xx.next = this.header;
			this.header = xx;
		}
		// not on end	
		else if( x.compareTo( this.footer.element ) >= 0)
		{
			this.footer.next = xx;
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
					xx.next = itr.current.next;
					itr.current.next = xx;
					
					break;
				}
			}
		}
		
		return xx;
	}

	/**
	 * Return iterator corresponding to the first node containing an item.
	 * 
	 * Best case: O(1) for start or end
	 * Worst case: O(n) for 1 before end
	 * Average case: O(n/2)
	 * 
	 * @param x the item to search for.
	 * @return an iterator; iterator isPastEnd if item is not found.
	 */
	public LinkedListItr find( Comparable x )
	{
		// smart handling for front
		if( x.compareTo( this.header.element ) < 0 ) {
			return new LinkedListItr( null );
		}
		
		// smart handling for tail
		if( x.compareTo( this.footer.element ) > 0 ) {
			return new LinkedListItr( null );
		}
		
		LinkedListItr itr = this.zeroth( );

		for( ; !itr.isPastEnd( ); itr.advance( ) )
		{
//			System.out.print( x + "|" + itr.retrieve() );
			if( x.equals( itr.retrieve() ) )
			{
				return itr;
			}
		}

		return itr;
	}
	
	/**
	 * Return integer corresponding to the first node containing an item.
	 * 
	 * Best case: O(1) for start or end
	 * Worst case: O(n) for 1 before end
	 * Average case: O(n/2)
	 * 
	 * @param x the item to search for.
	 * @return int; -1 if not found;
	 */
	public int findPosition( Comparable x )
	{
		// smart handling for front
		if( x.compareTo( this.header.element ) < 0 ) {
			return -1;
		}
		
		// smart handling for tail
		if( x.compareTo( this.footer.element ) > 0 ) {
			return -1;
		}
		
		int i = 0;
		
		LinkedListItr itr = this.zeroth( );

		for( ; !itr.isPastEnd( ); itr.advance( ) )
		{
//			System.out.print( x + "|" + itr.retrieve() );
			if( x.equals( itr.retrieve() ) )
			{
				return i;
			}
			i++;
		}

		return i;
	}

	/**
	 * Return iterator prior to the first node containing an item.
	 * @param x the item to search for.
	 * @return appropriate iterator if the item is found. Otherwise, the
	 * iterator corresponding to the last element in the list is returned.
	 */
	public LinkedListItr findPrevious( Comparable x )
	{
		// smart handling for front
		if( x.compareTo( this.header.element ) < 0 ) {
			return new LinkedListItr( null );
		}
		
		// smart handling for end
		if( x.compareTo( this.footer.element ) > 0 ) {
			return new LinkedListItr( null );
		}
				
		LinkedListItr itr = this.zeroth( );

		for( ; !itr.isPastEnd( ); itr.advance( ) )
		{
//		System.out.print( x + "|" + itr.retrieve() );
			if( x.equals( itr.next() ) )
			{
				return itr;
			}
		}

		return itr;
	}

	/**
	 * Remove the first occurrence of an item.
	 * 
	 * Best case: O(1) for start or end
	 * Average case: O(n/2)
	 * 
	 * @param x the item to remove.
	 */
	public void remove( Comparable x )
	{
		if( this.header.element == x )
		{
			this.header = this.header.next;
		}
		else
		{
			LinkedListItr p = findPrevious( x );
			
			// fix for header
			if( this.footer.element == x )
			{
				this.footer = p.current;
			}

			if( p.current.next != null )
				p.current.next = p.current.next.next;  // Bypass deleted node
			
		}
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