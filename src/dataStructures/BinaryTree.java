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
	
	public BinaryNode maxNode(BinaryNode root){
		
		BinaryNode maxdata = null;
		if(root == null) {
			System.out.print("No elements in the tree.");
		} else {
			if(root.right != null) {
				maxdata = maxNode(root.right);
			} else {
				maxdata = root;
			}
		}
		return maxdata;
	}
	
	public BinaryNode minNode(BinaryNode root) {
		
		BinaryNode minnode = null;
		if(root == null){
			System.out.print("No elements in the tree.");
		} else {
			if(root.left != null){
				minnode = minNode(root.left);
			} else {
				minnode = root;
			}
		}
		return minnode;
	}
	
	public BinaryNode deleteNode(BinaryNode root, int x) {
		
		if(root == null) {
			System.out.println("No Leafs in the tree");
		} else {
			if(root.data == x) {
				if(root.left == null && root.right == null) {
					root = null;
				} else if(root.left == null && root.right != null) {
					root = root.right;
				} else if(root.left != null && root.right == null) {
					root = root.left;
				} else if(root.left != null && root.right != null) {
					BinaryNode temp = predecessorNode(root);
					root.data = temp.data;
					root.left = deleteNode(root.left, root.data);
				}
			} else if(root.data > x) {
				root.left = deleteNode(root.left, x);
			} else if(root.data < x) {
				root.right = deleteNode(root.right, x);
			}
		}
		return root;
	}
	
	public BinaryNode predecessorNode(BinaryNode root) {
		
		if(root == null) {
			return root;
		} else {
			return maxNode(root.left);
		}
	}
}
