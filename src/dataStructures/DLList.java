package dataStructures;

public class DLList {
	
	DNode head;
	DNode tail;
	int size = 0;;
	
	public DLList () {
		head = null;
	}
	
	public void insertNode (Object x) {
		
		if(isEmpty()) {
			DNode newNode = new DNode();
			newNode.next = null;
			newNode.data = x;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
		} else {
			DNode temp = head;
			while(temp.next !=null) {
				temp = temp.next;
			}
			DNode newNode = new DNode();
			newNode.data = x;
			newNode.prev = temp;
			newNode.next = null;
			temp.next = newNode;
			tail = newNode;
		}
		size++;
	}
	
	public void insertNodeAtFirst(Object x) {
		
		if(isEmpty()) {
			DNode newNode = new DNode();
			newNode.data =x;
			newNode.next = null;
			newNode.prev = null;
			head = newNode;
			tail = newNode;
		} else {
			DNode newNode = new DNode();
			newNode.data = x;
			newNode.next = head;
			newNode.prev = null;
			head.prev = newNode;
			head = newNode;
		}
		size++;		
	}
	
	public void deleteNodeAt(int x) {
		
		if(isEmpty()) {
			System.out.println("Nothing to delete from");
		} else if(x == 1) { 
			DNode temp = head;
			temp = temp.next;
			temp.prev = null;
			head = temp;
		} else {
			DNode temp = head;
			for(int i = 1;i<x-1; i++) {
				temp = temp.next;
			}
			if( temp.next.next ==  null) {
				temp.next = null;
			} else {
				temp.next = temp.next.next;
				temp.next.prev = temp;
			}
		}
		
	}
	
	public boolean isEmpty(){
		return head==null;
	}
	
	public void printList() {
		System.out.print("\n");
		if(isEmpty()) {
			System.out.println("No List to print");
		} else {
			DNode temp = head;
			while(true) {
				System.out.print("->");
				System.out.print(temp.data);
				if(temp.next != null) {
					temp = temp.next;
				} else {
					break;
				}
			}
		}
	}
}
