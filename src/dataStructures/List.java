package dataStructures;

public class List {
	
	private int size;
	private int end;
	private Object array[];
	
	public List(int n) {
		size = n;
		end = -1;
		array = new String[size];
	}
	
	public void insert(String x) {
		if(end >= size-1) {
			System.out.println("List is Full");
		} else {
			array[++end] = x;
		}
	}
	
	public void insert(String x, int y) {
		if(end >= size -1) {
			System.out.println("List is Full");
		} else {
			if(y > end) {
				System.out.println("cannot insert data, as index provided is far beyond reach");
			} else {
				++end;
				for(int i=y; i<=end; i ++) {
					array[i+1] = array[i];
				}
				array[y] = x;
			}
		}
	}
	
	public void remove(int x) {
		if(x > end) {
			System.out.println("cannot delete data, as index provided is far beyond reach");
		} else {
			--end;
			for(int i=x;i<=end;i++){
				array[i] = array[i+1];
			}
		}
	}
	
	public void print(){
		for(int i=0; i<=end; i++){
			System.out.print(" ");
			System.out.print(array[i]);
			System.out.print(" ");
		}
	}

}
