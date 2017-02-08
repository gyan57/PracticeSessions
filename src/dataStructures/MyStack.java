package dataStructures;

public class MyStack {
	
	private int size;
	private int top;
	private Object array[];
	
	public MyStack(int n) {
		
		size = n;
		top = -1;
		array = new String[size];
	}
	
	public void push(String str) {
		
		if(top >= size - 1) {
			System.out.println("MyStack overflow.. Icreasing size of stack");
			resize();
			array[++top] = str;
		} else {
			array[++top] = str;
		}
	}
	
	public void resize() {
		Object temp[] = array;
		size = size*2;
		array = new String[size];
		for(int i=0; i<= top; i++) {
			array[i] = temp[i];
		}
	}
	
	public void pop() {
		if(isEmpty()) {
			System.out.println("MyStack is empty");
		} else {
			top--;
		}
	}
	
	public boolean isEmpty() {
		if(top == -1) {
			return true;
		} else {
			return false;
		}
	}
	
	public void print() {
		for(int i=0; i <= top; i++){
			System.out.print(" ");
			System.out.print(array[i]);
			System.out.print(" ");
		}
	}
}
