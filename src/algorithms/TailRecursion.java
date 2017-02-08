package algorithms;

public class TailRecursion {
	
	public static int stackDepth = 0;
	public static int maxStackDepth = 0;
	
	public static void tailRecursiveQucikSort(int A[], int p, int r){
		
		incrementStackDepth();
		
		while(p<r){
			int q= partition(A,p,r);
			
			if(q < (p+r)/2) {
				tailRecursiveQucikSort(A, p, q);
				p=q;
			} else {
				tailRecursiveQucikSort(A, q+1,r);
				r=q-1;
			}
		}
		//decrementStackDepth();
	}
	
	public static int partition(int A[], int p, int r){
		
		int x = A[r];
		int i =p;
		
		for(int j = p; j < r; j++){
			if(A[j] <= x) {
				int temp = A[j];
				A[j] = A[i];
				A[i] = temp;
				i++;
			}
		}
		
		int temp = A[i];
		A[i] = A[r];
		A[r] = temp;
		
		return i;
		
	}

	public static void incrementStackDepth(){
		stackDepth++;
		if(maxStackDepth < stackDepth)
			maxStackDepth = stackDepth;
		
	}
	
	public static void decrementStackDepth(){
		stackDepth--;
	}
	
	public static void resetStackDepthCounter(){
		maxStackDepth = 0;
		stackDepth = 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {4,23,65,12,87,56,98,34,67,45,76};

		tailRecursiveQucikSort(A, 0, A.length-1);
		
		for(int j=0;j <A.length; j++){
			System.out.println(A[j]);
		}
		
		System.out.println(stackDepth);
	}

}
