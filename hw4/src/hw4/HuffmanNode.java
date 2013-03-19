package hw4;

public class HuffmanNode implements Comparable
{
   public String letter; 
   public Double frequency;
   public HuffmanNode left, right;
 
   // - add constructors to initialize letter and frequency, etc.
   public HuffmanNode(String letter, Double frequency)
   {
	   this.letter = letter;
	   this.frequency = frequency;
   }
   
   public HuffmanNode(String letter, String frequency)
   {
	   Double freq = new Double( Double.parseDouble( frequency ) );
	   this.letter = letter;
	   this.frequency = freq;
   }

   public HuffmanNode(HuffmanNode left, HuffmanNode right)
   {
	   this.left = left;
	   this.right = right;
	   this.letter = left.letter + right.letter;
	   this.frequency = left.frequency + right.frequency;
   }
   
   public String toString()
   {
	   return "<" + this.letter + ", " + this.frequency + ">";
   }
   
   public int compareTo(Object o)
   {
	   HuffmanNode huff = (HuffmanNode) o;
	   return this.frequency.compareTo( huff.frequency );
   }
}
