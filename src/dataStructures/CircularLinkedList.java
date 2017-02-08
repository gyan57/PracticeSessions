package dataStructures;

public class CircularLinkedList {
	
	Node head;
	
	public CircularLinkedList() {
		// TODO Auto-generated constructor stub
		head = null;
	}
	
	public CircularLinkedList (Object x) {
		head.data = x;
		head.node =null;
	}
	
	public void insertNode (Object x) {
		
		if(head == null) {
			Node newNode = new Node();
			newNode.data =x;
			head = newNode;
			newNode.node = head;
		} else {
			Node temp = head;
			while( temp.node != head) {
				temp = temp.node;
			}
			Node newNode = new Node();
			newNode.data =x;
			newNode.node = head;
			temp.node = newNode;
		}	
	}
	
	
	
	
	

}
