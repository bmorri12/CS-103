package hw5;

// Basic node stored in unbalanced binary search trees
// Note that this class is not accessible outside
// of package DataStructures

class TreeNode<AnyType> implements Comparable
{
	// Constructors
	TreeNode( AnyType theElement, double dist )
	{
		this( theElement, dist, null, null );
	}

	TreeNode( AnyType theElement, double dist, TreeNode lt, TreeNode rt )
	{
		distance = dist;
		element  = theElement;
		left     = lt;
		right    = rt;
	}
	
	public int compareTo(Object o) {
		TreeNode alt = (TreeNode) o;
		return (int) (alt.distance - this.distance);
	}

	// Friendly data; accessible by other package routines
	double distance; // distance from parent
	AnyType element;      // The data in the node
	TreeNode left;         // Left child
	TreeNode right;        // Right child

}