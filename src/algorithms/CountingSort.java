package algorithms;

import java.util.Arrays;

public class CountingSort {

	public static void countingSort(int A[]){
		
		int length = A.length;		
		int low = A[0];
		int high = 0;
		
		for(int i=0; i<length-1; i++){
			
			if(high < A[i]){
				high = A[i];
			}
			if(low > A[i]){
				low = A[i];
			}	
		}
		
		int[] B, C;
		
		B = new int[length+1];
		
		C = new int[high+1];
		
		Arrays.fill(C, 0);
		
		//Similar code as below
		/*for(int i=0; i<A.length; i++){
			
			for(int j=0;j<C.length;j++){
			
				if(A[i] == j)
					C[A[i]] = C[A[i]] + 1;
			}	
		}*/
		
		for(int i=0; i<A.length; i++){
			C[A[i]]++;
		}
		
		for(int i=1;i<C.length; i++)
			C[i] += C[i-1];
		
		for(int i=A.length-1; i>=0; i--){
			B[--C[A[i]]] = A[i];		
		}
		
		for(int i=0;i<A.length;i++)
		{
			A[i] = B[i];
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {4,23,65,12,87,56,98,34,67,45,76};
		long start = System.currentTimeMillis();
		countingSort(A);
		long end = System.currentTimeMillis();
		for(int j : A){
			System.out.println(j);
		}
		System.out.println(end-start);
		
	}

}
