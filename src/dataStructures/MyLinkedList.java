package dataStructures;

public class MyLinkedList {
	
	Node head;
	int size;
	
	public MyLinkedList(){
		head = null;
		size = 0;
	}
	
	public void insertFisrtNode(Object x) {
		if(isEmpty()){
			Node firstNode = new Node();
			firstNode.setData(x);
			firstNode.node = head;
			head = firstNode;
		} else {
			System.out.println("The List is not empty");
		}
		
	}
	
	public void insertAtFirst(Object x) {
		
		if(isEmpty()) {
			insertFisrtNode(x);
		} else {
			Node nextFirstNode = new Node();
			nextFirstNode.setData(x);
			nextFirstNode.node = head;
			head = nextFirstNode;
		}
		size++;
	}
	
	public void insertAtLast(Object x) {
		
		if(isEmpty()) {
			insertFisrtNode(x);
		} else if(head.node == null){
			Node nextLastNode = new Node();
			nextLastNode.setData(x);
			nextLastNode.node = null;
			head.node = nextLastNode;
		} else {
			Node temp = head;
			while(temp.node != null)
				temp = temp.node;
			Node nextLastNode = new Node();
			nextLastNode.setData(x);
			nextLastNode.node = null;
			temp.node = nextLastNode;
		}
		size++;
			
	}
	
	public void insertAfterNth(int x, Object y) {
		
		if(x > size) {
			System.out.println("Not found");
		} else if (x == 0) {
			insertFisrtNode(y);
			size++;
		} else {
			Node temp = head;
			for(int i = 1; i<x; i++) {
				temp = temp.node;
			}
			Node nextNode = new Node();
			nextNode.data = y;
			nextNode.node = temp.node;
			temp.node = nextNode;
			size++;
		}
		
	}
	
	public void deleteFirstNode() {
		
		head = head.node;
		size--;
		
	}
	
	public void deleteLastNode() {
		
		Node temp = head;
		for(int i=1; i<size -1; i++){
			temp = temp.node;
		}
		temp.node = null;
		size--;
		
	}

	public void deleteAfterNth(int x) {
		
		Node prev = head;
		if(x >= size) {
			System.out.println("Not found");
		} else {
			for(int i = 1; i<x; i++) {
				prev = prev.node;
			}
			prev.node = prev.node.node;
			size--;
		}
		
	}
	
	public void findValueAtNthNode(int x){
		
		Node temp = head;
		for (int i=1; i<x; i++){
			temp = temp.node;
		}
		System.out.print("Value of " + x + "th node is " + temp.data);
		
	}
	
	public void reverseUsingIterative(){
		
		Node temp = head;
		Node reverseNode = new Node();
		Node currentNode = new Node();
		
		reverseNode.data  = temp.data;
		reverseNode.node = null;

		while(true) {
			if(temp.node != null) {
				temp = temp.node;
			} else {
				break;
			}
			currentNode.data = temp.data;
			currentNode.node = reverseNode;
			reverseNode = currentNode;
			currentNode = new Node();
			
		}
		head = reverseNode;
		
	}
	
	public void reverseUsingRecursion() {
		
	}
	
	public void findSize() {
		System.out.print("\nThere are " + size + " Elements in Linked List");
	}
	
	public boolean isEmpty() {
		return head==null;
	}
	
	public void print () {
		System.out.print("\nhead");
		Node temp = head;
		if (head == null){
	        return;
	    }
	    while(true){
	    	System.out.print("->");
	        System.out.print(temp.data);
	        if (temp.node != null){
	            temp = temp.node;
	        }
	        else {
	            break;
	        }
	    }
	}
	
}
