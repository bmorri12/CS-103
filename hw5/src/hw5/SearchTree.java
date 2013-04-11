package hw5;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

// SearchTree class
//
// CONSTRUCTION: with no initializer
//
// ******************PUBLIC OPERATIONS*********************
// void insert( x )       --> Insert x
// void remove( x )       --> Remove x
// Comparable find( x )   --> Return item that matches x
// Comparable findMin( )  --> Return smallest item
// Comparable findMax( )  --> Return largest item
// boolean isEmpty( )     --> Return true if empty; else false
// void makeEmpty( )      --> Remove all items
// void printTree( )      --> Print tree in sorted order

/**
 * Implements an unbalanced binary search tree.
 * Note that all "matching" is based on the compareTo method.
 * @author Mark Allen Weiss
 */
public class SearchTree
{
	/**
	 * Construct the tree.
	 */
	public SearchTree( )
	{
		root = null;
	}
	
	public SearchTree( TreeNode rootNode )
	{
		root = rootNode;
	}

	/**
	 * Remove from the tree. Nothing is done if x is not found.
	 * @param x the item to remove.
	 */
	public void remove( Comparable x )
	{
		root = remove( x, root );
	}

	/**
	 * Find the smallest item in the tree.
	 * @return smallest item or null if empty.
	 */
	public Object findMin( )
	{
		return elementAt( findMin( root ) );
	}

	/**
	 * Find the largest item in the tree.
	 * @return the largest item of null if empty.
	 */
	public Object findMax( )
	{
		return elementAt( findMax( root ) );
	}

	/**
	 * Make the tree logically empty.
	 */
	public void makeEmpty( )
	{
		root = null;
	}

	/**
	 * Test if the tree is logically empty.
	 * @return true if empty, false otherwise.
	 */
	public boolean isEmpty( )
	{
		return root == null;
	}

	/**
	 * Print the tree contents in sorted order.
	 */
	public void printTree( )
	{
		if( isEmpty( ) )
			System.out.println( "Empty tree" );
		else
			printTree( root );
	}

	/**
	 * Internal method to get element field.
	 * @param t the node.
	 * @return the element field or null if t is null.
	 */
	private Object elementAt( TreeNode t )
	{
		return t == null ? null : t.element;
	}

	/**
	 * Internal method to remove from a subtree.
	 * @param x the item to remove.
	 * @param t the node that roots the tree.
	 * @return the new root.
	 */
	private TreeNode remove( Object x, TreeNode t )
	{
		// does not currently work
		t = ( t.left != null ) ? t.left : t.right;
		return t;
	}

	/**
	 * Internal method to find the smallest item in a subtree.
	 * @param t the node that roots the tree.
	 * @return node containing the smallest item.
	 */
	private TreeNode findMin( TreeNode t )
	{
		if( t == null )
			return null;
		else if( t.left == null )
			return t;
		return findMin( t.left );
	}

	/**
	 * Internal method to find the largest item in a subtree.
	 * @param t the node that roots the tree.
	 * @return node containing the largest item.
	 */
	private TreeNode findMax( TreeNode t )
	{
		if( t != null )
			while( t.right != null )
				t = t.right;

		return t;
	}

	/**
	 * Internal method to find an item in a subtree.
	 * @param x is item to search for.
	 * @param t the node that roots the tree.
	 * @return node containing the matched item.
	 */
	private TreeNode find( Object x )
	{
		return this.findClosest( this.root, x );
	}
	
	/**
	 * Actual method to find the closest instance of x
	 * @throws Overflow 
	 */
	public TreeNode findClosest( TreeNode start, Object x) throws Overflow
	{
		BinaryHeap heap = new BinaryHeap(); // could do some fancy checking of tree size
		
		heap.insert( start );
		
		TreeNode min = (TreeNode) heap.findMin();
		
		while( ( !heap.isEmpty() && !min.element.equals( x ) && min != null ) )
		{
			min = (TreeNode) heap.deleteMin();
			if( min.left != null )
			{
				min.left.distance = min.left.distance + min.distance;
				heap.insert( min.left );
			}
			if( min.right != null )
			{
				min.right.distance = min.right.distance + min.distance;
				heap.insert( min.right );
			}
		}
		
		if( min.element.equals( x ) )
		{
			return min;
		}
		else
		{
			return null;
		}
	}

	/**
	 * Internal method to print a subtree in sorted order.
	 * @param t the node that roots the tree.
	 */
	private void printTree( TreeNode t )
	{
		if( t != null )
		{
			printTree( t.left );
			System.out.println( t.element );
			printTree( t.right );
		}
	}

	/** The tree root. */
	private TreeNode root;


	// Test program
	public static void main( String [ ] args ) throws Overflow
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader( args[0] ));
			
			String line = br.readLine();			
			br.close();
			
			String[] key = line.split(" ");
			StackLi stack = new StackLi();
			
			int i = 0;
			while( i < key.length )
			{
				String s = key[ i ];
				
				if( s.equals( "(" ) )
				{
				}
				else if( s.equals( ")" ) )
				{
					TreeNode right_child = (TreeNode) stack.topAndPop();
					TreeNode left_child = (TreeNode) stack.topAndPop();
					TreeNode parent = (TreeNode) stack.top();
					parent.left = left_child;
					parent.right = right_child;
				}
				else {
					i++;
					stack.push( new TreeNode( s, Double.parseDouble( key[ i ] ) ) );
				}
				
				i++;
			}
			
			// System.out.println( "done parsing" );
			
			SearchTree tree = new SearchTree( (TreeNode) stack.topAndPop() );
						
			System.out.println( "What would you like to search for?" );
			
			Scanner in = new Scanner( System.in  );
	    	String needle = in.next();	    	
			
			TreeNode node = tree.findClosest( tree.root, needle);
			
			if( node != null )
			{
				System.out.println( "Found '" + node.element + "' at distance " + node.distance + ".");
			}
			else
			{
				System.out.println( "Could not find " + needle + '.' );
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}