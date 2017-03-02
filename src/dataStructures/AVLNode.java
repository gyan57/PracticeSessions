package dataStructures;

public class AVLNode {
	
	int data;
	AVLNode parent;
	AVLNode left;
	AVLNode right;
	int height;
	
	public AVLNode() {
		
		this.parent = null;
		this.left = null;
		this.right = null;
		this.height = -1;
		this.data = -1;
	}
	

}
