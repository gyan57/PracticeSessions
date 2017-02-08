package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
	
	public BinaryNode insertBNode(BinaryNode root, int x) {
		
		if(root == null) {
			BinaryNode newNode = new BinaryNode(x);
			root = newNode;
		} else {
			BinaryNode current;
			if(root.data < x){ 
				if (root.right == null) {
					BinaryNode newNode = new BinaryNode(x);
					root.right = newNode;
				} else {
					current = root.right;
					current = insertBNode(current , x);
					root.right = current;
				}
			}
			  else if(root.data > x ) {
				  if (root.left == null) {
						BinaryNode newNode = new BinaryNode(x);
						root.left = newNode;
					} else {
						current = root.left;
						current = insertBNode(current ,x);
						root.left = current;
					}
			} 
		}		
		return root;
	}
	
	public BinaryNode insertBNodeHR(BinaryNode root, int x) {
		
		if(root == null) {
			BinaryNode newNode = new BinaryNode(x);
			root = newNode;
		} else {
			BinaryNode current;
			if(root.data < x){ 
				current = insertBNode(root , x);
				root.right = current;
			}
			  else if(root.data > x ) {
				current = insertBNode(root , x);
				root.left = current;
			} 
		}		
		return root;
	}
	
	public void inOrderTraversal(BinaryNode root) {
		
		if(root == null){
			System.out.println("No More leafs");
		} else {
			if(root.left != null) {
				inOrderTraversal(root.left);
			}
			System.out.print(" " + root.data);
			if(root.right != null) {
				inOrderTraversal(root.right);
			}
		}
	}
	
	public void preOrderTraversal(BinaryNode root) {
		
		if(root == null){
			System.out.println("No More leafs");
		} else {
			System.out.print(" " + root.data);
			if(root.left != null) {
				preOrderTraversal(root.left);
			}
			if(root.right != null) {
				preOrderTraversal(root.right);
			}
		}
		
	}
	
	public void postOrderTraversal(BinaryNode root) {
		
		if(root == null){
			System.out.println("No More leafs");
		} else {
			if(root.left != null) {
				postOrderTraversal(root.left);
			}
			if(root.right != null) {
				postOrderTraversal(root.right);
			}
			System.out.print(" " + root.data);
		}
	}
	
	public void levelOrderTraversal(BinaryNode root) {
		
		Queue<BinaryNode> queueNode = new LinkedList<BinaryNode>();
		
		if(root == null) {
			System.out.println("No More leafs");
		} else {
			queueNode.add(root);
			while(!queueNode.isEmpty()) {
				BinaryNode current = queueNode.peek();
				System.out.print(" " + current.data);
				if(current.left != null) 
					queueNode.add(current.left);
				if(current.right != null)
					queueNode.add(current.right);
				queueNode.remove();
			}
		}
		
	}

	public int depthOftree(BinaryNode root) {
		
		int counterLeft = 0;
		int counterRight = 0;
		
		if(root == null) {
			return 0;
		} else {
			if(root.left != null){
				counterLeft = 1;
				counterLeft += depthOftree(root.left);
			} 
			if(root.right != null) {
				counterRight = 1;
				counterRight += depthOftree(root.right);
			}
		}
		
		if(counterRight < counterLeft){
			return counterLeft;
		} else {
			return counterRight;
		}
	}
	
	public boolean searchNode(BinaryNode root,int x) {
		
		if(root == null){
			return false;
		} else {
			if(root.data == x) {
				return true;
			} else {
				if(root.left != null && x < root.data) {
					return searchNode(root.left, x);
				} else {
					return searchNode(root.right, x);
				}
			}
		}
	}
	
	public int maxNode(BinaryNode root){
		
		int maxData = 0;
		if(root == null) {
			System.out.print("No elements in the tree.");
		} else {
			if(root.right != null) {
				maxData = maxNode(root.right);
			} else {
				maxData = root.data;
			}
		}
		return maxData;
	}
	
	public int minNode(BinaryNode root) {
		int minData = 0;
		if(root == null){
			System.out.print("No elements in the tree.");
		} else {
			if(root.left != null){
				minData = minNode(root.left);
			} else {
				minData = root.data;
			}
		}
		return minData;
	}
	
	public void deleteNode(BinaryNode root, int x) {
		
		if(root == null) {
			System.out.println("No Leafs in the tree");
		} else {
			
		}
	}
}
