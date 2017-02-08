package algorithms;

public class QuickSort {
	
	public static int quickPartition (int A[], int low, int high){
		
		int pivot = (low + high)/2;
		
		int i = low;
		int j = high;
		
		while(i <= j){
			while(A[i] < A[pivot])
				i++;
			while(A[j] > A[pivot])
				j--;
			if(i<=j){
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				i++;
				j--;
			}
		}
		
		return i;
	}
	
	public static int partition(int A[], int low, int high){
		
		int pivot = A[high];
		int i=low;
		
		for(int j=low; j<high; j++){
			
			if(A[j] <= pivot){
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				i++;
			}
		}
		int temp = A[high];
		A[high] = A[i];
		A[i] = temp;
			
		return i;
	}
	
	public static void quickSort(int A[], int low, int high){
		if(low<high){
			
			//int pivot = quickPartition(A, low, high);
			int pivot = partition(A, low, high);
			
			if(low < pivot -1)
				quickSort(A, low, pivot-1);
			if(high > pivot)
				quickSort(A, pivot, high);
			
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {4,23,65,12,87,56,98,34,67,45,76};

		quickSort(A, 0, A.length-1);
		
		for(int j=0;j <A.length; j++){
			System.out.println(A[j]);
		}
		
	}

}
