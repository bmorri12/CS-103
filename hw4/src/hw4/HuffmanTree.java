package hw4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class HuffmanTree {

	HuffmanNode root;
	   
	// - add a constructor to init the Tree from a HuffmanNode
	public HuffmanTree(HuffmanNode huff)
	{
		this.root = huff;
	}
	
	// print legend
	public void printLegend()
	{
		this.printLegend(this.root, "");
	}
	
	private void printLegend(HuffmanNode t, String s)
	{
		if( t.letter.length() > 1 )
		{
			this.printLegend( t.left, s + "0");
			this.printLegend( t.right, s + "1" );
		}
		else
		{
			System.out.print( t.letter + "=" + s );
		}
	}
	
	// takes a String for the file name containing our input (letter & frequency data).
	// The letters and frequencies are all in the first line of the file, with spaces as separators.
	// (You may assume each separator is a single space).
	public static BinaryHeap fileToHeap(String filename)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader( filename ));
			
			String line = br.readLine();			
			br.close();
			
			String[] key = line.split(" ");
			HuffmanNode[] huffs = new HuffmanNode[ key.length / 2];
			int i = 0;
			int j = 0;
			while( i < key.length )
			{
				huffs[ j ] = new HuffmanNode( key[i], key[i + 1]);
//				System.out.println( key[i] + " " + key[i + 1 ] );
				
				i = i + 2;
				j++;
			}
			
			BinaryHeap heap = new BinaryHeap( huffs );
			return heap;
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static HuffmanTree createFromHeap(BinaryHeap b)
	{
		try {
			while( b.getSize() > 1 )
			{
				HuffmanNode huff1 = (HuffmanNode) b.deleteMin();
				HuffmanNode huff2 = (HuffmanNode) b.deleteMin();
				HuffmanNode huff = new HuffmanNode( huff1, huff2 );
				b.insert( huff );
			}
			HuffmanTree tree = new HuffmanTree( (HuffmanNode) b.deleteMin() );
			return tree;
		} catch (Underflow e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	// - the main method will go here, as well as code to take
	//   a command-line argument for the input file name
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryHeap bheap = HuffmanTree.fileToHeap( args[0] );
		bheap.printHeap();
		HuffmanTree htree = HuffmanTree.createFromHeap( bheap );
		htree.printLegend();
	}

}
