package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class AVLBTree {

	//Insert and correct nodes
	public AVLNode insertNode(AVLNode root, int x) {
		
		AVLNode newNode = new AVLNode();
		newNode.data = x;
		newNode.height = 0;
		
		root = insertAVLNode(root, newNode);
		calculateHeightOfNodes(root,newNode);
		root = correctHeight(root, newNode);
		
		return root;
	}
	
	public AVLNode insertAVLNode(AVLNode root, AVLNode newNode) {
		
		if(root == null) {
			root = newNode;
		} else {
			AVLNode current = new AVLNode();
			if(newNode.data > root.data) {
				if(root.right == null) {
					newNode.parent = root;
					root.right = newNode;
				} else {
					current = insertAVLNode(root.right, newNode);
					root.right = current;	
				}		
			} else if (newNode.data < root.data) { 
				if(root.left == null) {
					newNode.parent = root;
					root.left = newNode;
				} else {
					current = insertAVLNode(root.left, newNode);
					root.left = current;
				}
			}
		}
		return root;
	}
	//Calcualte height of Nodes 
	public void calculateHeightOfNodes(AVLNode root,AVLNode newNode) {
		if(newNode == root) {
			if(newNode.left == null && newNode.right == null)
				newNode.height = 0;
			if(newNode.left != null && newNode.right == null)
				newNode.height = newNode.left.height + 1;
			if(newNode.left == null && newNode.right != null) 
				newNode.height = newNode.right.height + 1;
			if(newNode.left != null && newNode.right != null) 
				newNode.height = Math.max(newNode.left.height, newNode.right.height) + 1;
		} else if(newNode != null) {
			if(newNode.left == null && newNode.right == null)
				newNode.height = 0;
			if(newNode.left != null && newNode.right == null)
				newNode.height = newNode.left.height + 1;
			if(newNode.left == null && newNode.right != null) 
				newNode.height = newNode.right.height + 1;
			if(newNode.left != null && newNode.right != null) 
				newNode.height = Math.max(newNode.left.height, newNode.right.height) + 1;
			calculateHeightOfNodes(root,newNode.parent);
		}

	}
	//correct height of nodes
	public AVLNode correctHeight(AVLNode root, AVLNode newNode){
		
		AVLNode parent = newNode.parent;
		AVLNode grandParent = null;
		AVLNode uncle = null;
		
		if(parent == null) {
			return root;
		}
		
		if(parent.parent != null) {
			grandParent = parent.parent;
			if(isLeftChild(parent))
				uncle = grandParent.right;
			if(isRightChild(parent))
				uncle = grandParent.left;
		}	
		
		if(grandParent ==  null) {
			return root;
		}
		
		if(isRightChild(parent) && isRightChild(newNode)) {
			if(uncle == null) {
				grandParent = rotateLeft(grandParent);
			} else if((grandParent.height-uncle.height) >= 2) {
				grandParent = rotateLeft(grandParent);
			}
			calculateHeightOfNodes(grandParent.left,grandParent.left);
			calculateHeightOfNodes(grandParent.right,grandParent.right);
			calculateHeightOfNodes(root,grandParent);
			if(grandParent.parent == null) {
				return grandParent;
			} else {
				root = correctHeight(root, grandParent);
				return root;
			}
		} 
		if(isRightChild(parent) && isLeftChild(newNode)) {
			if(uncle == null) {
				parent = rotateRight(parent);
				grandParent.right = parent;
				grandParent = rotateLeft(grandParent);
			}
			if((grandParent.height-uncle.height) >= 2) {
				parent = rotateRight(parent);
				grandParent.right = parent;
				grandParent = rotateLeft(grandParent);
			}
			calculateHeightOfNodes(grandParent.left,grandParent.left);
			calculateHeightOfNodes(grandParent.right,grandParent.right);
			calculateHeightOfNodes(root,grandParent);
			if(grandParent.parent == null) {
				return grandParent;
			} else {
				root = correctHeight(root, grandParent);
				return root;
			}
		} 
		if(isLeftChild(parent) && isLeftChild(newNode)) {
			if(uncle == null) {
				grandParent = rotateRight(grandParent);
			}
			if((grandParent.height-uncle.height) >= 2) {
				grandParent = rotateRight(grandParent);
			}
			calculateHeightOfNodes(grandParent.left,grandParent.left);
			calculateHeightOfNodes(grandParent.right,grandParent.right);
			calculateHeightOfNodes(root,grandParent);
			if(grandParent.parent == null) {
				return grandParent;
			} else {
				root = correctHeight(root, grandParent);
				return root;
			}
		}
		if(isLeftChild(parent) && isRightChild(newNode)) {
			if(uncle == null) {
				parent = rotateLeft(parent);
				grandParent.left = parent;
				grandParent = rotateRight(grandParent);
				calculateHeightOfNodes(grandParent.left,grandParent.left);
				calculateHeightOfNodes(grandParent.right,grandParent.right);
				calculateHeightOfNodes(root,grandParent);
			}
			if((grandParent.height-uncle.height) >= 2) {
				parent = rotateLeft(parent);
				grandParent.left = parent;
				grandParent = rotateRight(grandParent);
			}
			calculateHeightOfNodes(grandParent.left,grandParent.left);
			calculateHeightOfNodes(grandParent.right,grandParent.right);
			calculateHeightOfNodes(root,grandParent);
			if(grandParent.parent == null) {
				return grandParent;
			} else {
				root = correctHeight(root, grandParent);
				return root;
			}
		}
		return root;
	}
	
	//Tree rotation section
	public AVLNode rotateRight(AVLNode node) {
		
		AVLNode left = node.left;
		
		if(left == null) {
			System.out.println("Node cannot be rotated");
			return node;
		}
		
		node.left = left.right;
		if(left.right != null){
			left.right.parent = node;
		}
		
		left.parent = node.parent;
		
		if(node.parent != null) {
			if(isLeftChild(node)) {
				node.parent.left = left;
			} else if (isRightChild(node)) {
				node.parent.right = left;
			}
		}
		left.right = node;
		node.parent = left;

		return left;
	}
	
	public AVLNode rotateLeft(AVLNode node) {
		
		AVLNode right = node.right; 
		
		node.right = right.left;
		if(right.left != null){
			right.left.parent = node;
		}
		
		right.parent = node.parent;
		if(node.parent != null) {
			if(isLeftChild(node)) {
				node.parent.left = right;
			} else if (isRightChild(node)) {
				node.parent.right = right;
			}
		} 
		right.left = node;
		node.parent = right;
		
		return right;
	}
	
	
	//verification section
	public boolean isLeftChild(AVLNode newNode) {
		
		if(newNode.parent.left == newNode)
			return true;
			
		return false;
	}
	
	public boolean isRightChild(AVLNode newNode) {
		
		if(newNode.parent.right == newNode)
			return true;
			
		return false;
	}
	
	//Tree ordered display section
	public void inOrderDisplay(AVLNode root) {
		
		if(root == null) {
			System.out.println("NO nodes to be  printed");
		} else {
			if(root.left != null)
				inOrderDisplay(root.left);
			System.out.print("{"+root.data + " " + root.height + "}");
			if(root.right != null)
				inOrderDisplay(root.right);
		}
	}
	
	public void levelOrderDisply(AVLNode root) {
		
		if(root == null) {
			System.out.println("NO nodes to be  printed");
		} else {
			Queue<AVLNode> queueNode = new LinkedList<AVLNode>();
			queueNode.add(root);
			while(!queueNode.isEmpty()) {
				AVLNode current = queueNode.peek();
				System.out.print("{"+current.data + " " + current.height + "}");
				if(current.left != null) 
					queueNode.add(current.left);
				if(current.right != null)
					queueNode.add(current.right);
				queueNode.remove();
			}
			
		}
		
	}
}
