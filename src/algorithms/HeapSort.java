package algorithms;

public class HeapSort {
	
	public static void maxHeapify(int A[], int root, int bottom) {

		int largest = root;
		int done = 0;
		int temp;
		int left;
		int right;
		
		do {

			left = 2 * root;
			right = 2 * root + 1;
			if (left < bottom && A[left] > A[root]) {
				largest = left;
			}

			if (right < bottom && A[right] > A[largest]) {
				largest = right;
			}

			if (largest != root) {
				temp = A[root];
				A[root] = A[largest];
				A[largest] = temp;
				root = largest;
				// maxHeapify(A,largest,bottom);
			} else {
				done = 1;
			}
		} while (done != 1);
	}
	
	public static void heapify(int A[]){
		
		int mid = A.length-1;
		for(int i=mid/2 ; i>=0; i--) {
			maxHeapify(A, i, A.length);
		}	
	}
	
	public static void insertFromHeap(int A[], int value){
		
	}
	
	public static void deleteFromHeap(int A[], int value){}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {4,23,65,12,87,56,98,34,67,45,76};
		heapify(A);
		int heapSize = A.length;
		for (int i=heapSize-1; i>=1; i--){
			int temp = A[i];
			A[i] = A[0];
			A[0] = temp;
			maxHeapify(A,0,i-1);
		}
		
		for(int j : A){
			System.out.println(j);
		}
			
	}
}
