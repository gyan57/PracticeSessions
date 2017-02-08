package algorithms;

import java.util.Arrays;

public class InsertionSort {
	
	public static void insertionSort(int A[]) {
		
		int x = 0;
		System.out.println(Arrays.toString(A));
		for(int j = 1; j<A.length; j++){
			for(int i=j; i>0; i--){
				if(A[i] < A[i-1]) {
					int temp = A[i];
					A[i] = A[i-1];
					A[i-1] = temp;
					x++;
				}
			}
			System.out.println(Arrays.toString(A));
		}
		
		System.out.println(x);
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {4,23,65,12,87,56,98,34,67,45,76};
		//int A[] = {2,1,3,1,2};
		long start = System.currentTimeMillis();
		insertionSort(A);
		long end = System.currentTimeMillis();
		for(int j : A){
			System.out.print(j);
		}
		System.out.println(end-start);
	}
}
