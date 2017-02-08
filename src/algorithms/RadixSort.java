package algorithms;

public class RadixSort {

	public static void radixSort(int A[]){
		
		int max = A[0];
		int exp = 1; 
		int[] B = new int[A.length + 1];
		
		for(int i : A ){
			if(i >  max)
				max = i;
		
		}
		
		while(max/exp > 0)
		{
			int[] bucket = new int[10];
			
			for(int i=0; i <A.length; i++)
				bucket[(A[i]/exp) % 10]++;
			
			for(int i=1; i< 10; i++)
				bucket[i] += bucket[i-1];
			
			for(int i = A.length-1; i >=0; i--)
				B[--bucket[(A[i] / exp) % 10 ]] = A[i];
			
			for(int i = 0; i<A.length; i++)
				A[i] =B[i];
			
			exp *= 10;
		}
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {4,23,65,12,87,56,98,34,67,45,76};
		long start = System.currentTimeMillis();
		radixSort(A);
		long end = System.currentTimeMillis();
		for(int j : A){
			System.out.println(j);
		}
		System.out.println(end-start);
	}

}
