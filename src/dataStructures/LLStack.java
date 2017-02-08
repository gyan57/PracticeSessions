package dataStructures;

public class LLStack {
	
	Node head;
	
	public LLStack() {
		head = null;
	}
	
	public void push(Object x) {
		
		if(head == null) {
			Node newNode = new Node();
			newNode.data = x;
			newNode.node = null;
			head = newNode;
		} else {
			Node temp = head;
			while (temp.node != null) {
				temp = temp.node;
			}
			Node newNode = new Node();
			newNode.data =x;
			newNode.node = null;
			temp.node = newNode;
		}
	}
	
	public Object pop() {
		
		Node temp = head;
		Object x = new Object();
		if(head == null) {
			System.out.println("No node to be poped");
		} else {
			while(temp.node.node != null) {
				temp = temp.node;
			}
			x = temp.node.data;
			temp.node = null;
		}
		
		return x;
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
