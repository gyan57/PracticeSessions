package algorithms;

import java.util.Arrays;

public class BubbleSort {
	
	public static void bubbleSort(int A[]) {
		
		int x=0;
		
		for(int i = 0; i <A.length -1; i++){
			System.out.println(Arrays.toString(A));
		
			for(int j=1; j<A.length -i; j++) {
				if(A[j] < A[j-1]) {
					int temp = A[j-1];
					A[j-1] = A[j];
					A[j] = temp;
					x++;
				}
			}
		}
		System.out.println(x);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {4,23,65,12,87,56,98,34,67,45,76};
		//int A[] = {2,1,3,1,2};
		long start = System.currentTimeMillis();
		bubbleSort(A);
		long end = System.currentTimeMillis();
		for(int j : A){
			System.out.print(" ");
			System.out.print(j);
		}
		System.out.println(end-start);
	}
}
