package dataStructures;

public class CDLList {
	
	DNode head;
	
	public CDLList () {
		head = null;
	}
	
	public void addNode(Object x) {
		
		if(head == null) {
			DNode newNode = new DNode();
			newNode.data = x;
			head = newNode;
			newNode.prev = head;
			newNode.next = head;
		} else {
			DNode temp = head;
			while(temp.next != head){
				temp = temp.next;
			}
			DNode newNode = new DNode();
			newNode.data = x;
			newNode.prev = temp;
			newNode.next = head;
			temp.next = newNode;
		}
	}
	
	public void addNodeAtFirst(Object x) {
		
		if(head == null) {
			DNode newNode = new DNode();
			newNode.data =x;
			head = newNode;
			newNode.next = head;
			newNode.prev = head;
		} else {			
			DNode newNode = new DNode();
			newNode.data = x;
			DNode temp = head;
			while (temp.next != head) {
				temp =  temp.next;
			}		
			newNode.next = head;
			newNode.prev = head;
			head = newNode;
			temp.next = head;
		}
	}
	
	public void deleteNodeAt(int x) {
		DNode temp = head;
		for(int i=1; i<x-1; i++) {
			temp = temp.next;
		}
		temp.next = temp.next.next;
		temp.next.prev = temp;
	}
	
	public void print() {
		System.out.print("\nhead");
		DNode temp = head;
		while(true) {
			System.out.print("->");
			System.out.print(temp.data);
			if(temp.next != head) {
				temp = temp.next;
			} else{
				break;
			}
			
		}
	}

}
