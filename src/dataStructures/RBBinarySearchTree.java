package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

import dataStructures.RBNode.nodeColor;

public class RBBinarySearchTree {
	
	public RBNode insertNode(RBNode root, int x) {
		
		RBNode newNode = new RBNode();
		newNode.data = x;
		root = insertBTNode(root, newNode);
		root = adjustColor(root, newNode);
		return root;
	}
	
	public RBNode insertBTNode(RBNode root, RBNode newNode) {
		
		if(root == null) {
			newNode.color = nodeColor.BLACK;
			root = newNode;
		} else {
			RBNode current;
			newNode.color = nodeColor.RED;
			if(newNode.data > root.data) {
				if(root.right == null) {
					newNode.parent = root;
					root.right = newNode;
				} else {
					current = insertBTNode(root.right, newNode);
					root.right = current;
					
				}
			}
			if(newNode.data < root.data){
				if(root.left == null){
					newNode.parent = root;
					root.left = newNode;
				} else {
					current = insertBTNode(root.left, newNode);
					root.left = current;
				}
			}
		}
		return root;
	}
	
	public RBNode adjustColor(RBNode root, RBNode newNode) {
		
		RBNode parent = newNode.parent;
		RBNode grandParent = new RBNode();
		RBNode uncle = new RBNode();
		if(parent != null) {
			if(parent.parent != null) {
				grandParent = parent.parent;
				if(parent.data > grandParent.data) {
					uncle = grandParent.left;
				} else {
					uncle = grandParent.right;
				}
			}
		}
		
		if(grandParent != null) {
			if(isRed(parent) && isRed(newNode)) {
				if(!isRed(uncle)) {
					if(parent.data > newNode.data) {		
						if(parent.data > grandParent.data){
							parent = rotationRight(parent);
							grandParent.right = parent;
							grandParent = rotationLeft(grandParent);
							grandParent.color = nodeColor.BLACK;
							grandParent.left.color = nodeColor.RED;
							grandParent.right.color = nodeColor.RED;
							if(grandParent.parent == null) {
								return grandParent;
							} else {
								return root;
							}
						} else {
							grandParent = rotationLeft(grandParent);
							grandParent.color = nodeColor.BLACK;
							grandParent.left.color = nodeColor.RED;
							grandParent.right.color = nodeColor.RED;
							if(grandParent.parent == null) {
								return grandParent;
							} else {
								return root;
							}
						}	
					} else {
						if(parent.data < grandParent.data){
							parent = rotationLeft(parent);
							grandParent.left = parent;
							grandParent = rotationRight(grandParent);
							grandParent.color = nodeColor.BLACK;
							grandParent.left.color = nodeColor.RED;
							grandParent.right.color = nodeColor.RED;
							if(grandParent.parent == null) {
								return grandParent;
							} else {
								return root;
							}
						} else {
							grandParent = rotationRight(grandParent);
							grandParent.color = nodeColor.BLACK;
							grandParent.left.color = nodeColor.RED;
							grandParent.right.color = nodeColor.RED;
							if(grandParent.parent == null) {
								return grandParent;
							} else {
								return root;
							}
						}
					}
				} else {
					grandParent.color = nodeColor.RED;
					grandParent.left.color = nodeColor.BLACK;
					grandParent.right.color = nodeColor.BLACK;
					if(grandParent.parent == null) {
						grandParent.color = nodeColor.BLACK;
						return grandParent;
					} else {
						if(grandParent.color == nodeColor.RED && grandParent.parent.color == nodeColor.RED) {
							root = adjustColor(root, grandParent);
							return root;
						}
					}
				}
			}
		}
		return root;
	}
	
	public boolean isRed(RBNode root) {
		if(root == null) {
			return false;
		} else {
			return root.color == nodeColor.RED;
		}
	}
	
	public RBNode rotationLeft(RBNode root) {
		
		RBNode left = root.left;
		RBNode right = root.right;
		if(left == null) {
			right.parent = root.parent;
			root.right = right.left;
			right.left = root;
			root.parent = right;
			return right;
		}
		RBNode parent = root.parent;
		RBNode leftRight = left.right;
		
		left.parent = parent;
		if(root.parent != null) {
			if(parent.data > root.data) {
				parent.left = root.left;
			} else {
				parent.right = root.left;
			}
		}
		//Setting Left node with root
		left.right = root;
		root.parent = left;
		
		//Setting root node parent and right value
		root.left = leftRight;
		if(leftRight != null) {
			leftRight.parent = root;
		}

		return left;
	}
	
	public RBNode rotationRight(RBNode root) {
		
		RBNode right = root.right;
		RBNode left = root.left;
		if(right == null) {
			left.parent = root.parent;
			root.left = left.right;
			left.right = root;
			root.parent = left;
			return left;
		}
		RBNode parent = root.parent;
		RBNode rightLeft = right.left;
		
		right.parent = parent;
		if(parent != null) {
			if(parent.data > root.data) {
				parent.left = root.right;
			} else {
				parent.right = root.right;
			}
		}
		//Setting up right node as root and its childs
		right.left = root;
		root.parent = right;
		
		//Setting up root as left node and its childs
		root.right = rightLeft;
		if(rightLeft != null) {
			rightLeft.parent = root;
		}
		
		return right;
	}
	
	public void inOrder(RBNode root){
		
		if(root == null) {
			System.out.println("Nothing to print");
		} else {
			RBNode current = root;
			if(current.left != null) {
				inOrder(current.left);
			}
			System.out.print(" " + current.data + current.color);
			if(current.right != null){
				inOrder(current.right);
			}
		}
	}
	
	public void leverOrder(RBNode root) {
		if(root == null) {
			System.out.println("Nothing to print");
		} else {
			Queue<RBNode> nodeQueue = new LinkedList<RBNode>();
			nodeQueue.add(root);
			while(!nodeQueue.isEmpty()) {
				RBNode current = nodeQueue.peek();
				if(current.left != null) {
					nodeQueue.add(current.left);
				}
				if(current.right != null) {
					nodeQueue.add(current.right);
				}
				RBNode removeNode = nodeQueue.remove();
				System.out.print(" " + removeNode.data + removeNode.color);
			}
		}
	}
}
