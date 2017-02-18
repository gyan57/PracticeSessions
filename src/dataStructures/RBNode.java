package dataStructures;

public class RBNode {

	RBNode left;
	RBNode right;
	RBNode parent;
	int data;
	nodeColor color;
	
	public RBNode() {
		this.left = null;
		this.right = null;
		this.parent = null;
		this.data = -1;
		this.color = nodeColor.BLACK;
	}
	
	public enum nodeColor {
		RED,BLACK;
	}
}
