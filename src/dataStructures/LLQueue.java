package dataStructures;

public class LLQueue {
	
	Node head;
	
	public LLQueue (){
		
		head = null;
	}
	
	public void push(Object x) {
		
		if(isEmpty()) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.node = null;
			head = newNode;
		} else {
			Node temp = head;
			while(temp.node != null) {
				temp = temp.node;
			}
			Node newNode = new Node();
			newNode.data = x;
			newNode.node = null;
			temp.node = newNode;
		}
		
	}
	
	public Object pop() {
		
		Object x = new Object();
		if(isEmpty()) {
			System.out.println("MyQueue is empty");
		} else {
			x = head.data;
			head = head.node;
		}
		return x;
	}
	
	public Object headElement() {
		
		Object x = new Object();
		if(isEmpty()) {
			System.out.println("MyQueue is empty");
		} else {
			x = head.data;
		}
		System.out.println(x);
		return x;
	}
	
	public Object tailElement() {
		
		Object x = new Object();
		if(isEmpty()) {
			System.out.println("MyQueue is empty");
		} else {
			Node temp = head;
			while (temp.node != null) {
				temp = temp.node;
			}
			x = temp.data;
		}
		System.out.println(x);
		return x;
	}
	
	public boolean isEmpty() {
		return (head == null);
	}
	
	public void print() {
		
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
