package dataStructures;

public class CircularQueue {

	private int size;
	private int head;
	private int tail;
	private Object array[];
	
	public CircularQueue(int n) {
		
		head = -1;
		tail = -1;
		size = n;
		array = new String[size];
	}
	
	public void push (String str) {
		if((head+1) % size == tail) {
			System.out.println("MyQueue overflow");
		} else if(isEmpty()) {
			head = 0;
			tail = 0;
			array[head] = str;
		}
		else {
			array[(++head)%size] = str;
		}
	}
	
	public void pop(){
		if (isEmpty()) {
			System.out.println("MyQueue is empty");
		} else if(tail == head) {
			tail = -1;
			head = -1;
		} else {
			tail = (1+tail)%size;
		}
	}
	
	public boolean isEmpty() {
		if(tail == -1 && head ==  -1){
			return true;
		} else {
			return false;
		}
	}

	public void print() {
		for(int i = tail; i <= head; i++) {
			System.out.print(" ");
			System.out.print(array[i]);
			System.out.print(" ");
		}
	}
}
