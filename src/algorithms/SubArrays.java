package algorithms;

public class SubArrays {
	
	public static class max_subarray {
		int left;
		int right;
		int sum;
	}
	
	public static max_subarray findMaxSubarrayBruteforce(int A[], int low, int high) {
		
		max_subarray result = new max_subarray();
		
		for(int i=low; i< high; i++) {
			
			int current_sum = 0;
			for(int j = i; j<high; j++) {
				current_sum += A[j];
				if(result.sum < current_sum) {
					result.left = i+1;
					result.right = j + 1;
					result.sum = current_sum;
				}
			}
		}		
		return result;		
	}
	
	public static max_subarray findMaxCrossingSubArray(int A[], int low, int mid, int high){
		max_subarray result = new max_subarray();
		
		int sum = 0, left_sum = 0, right_sum = 0;
		
		for(int i = mid-1; i>=low; i--){
			sum += A[i];
			if(sum > left_sum) {
				left_sum = sum;
				result.left = i+1;
			}
		}
		
		sum = 0;
		
		for(int j=mid; j<high; j++) {
			
			sum += A[j];
			if(sum > right_sum) {
				right_sum = sum;
				result.right = j+1;
			}			
		}
		
		result.sum  = right_sum + left_sum;
		
		return result;
	}
	
	public static max_subarray findMaxSubArray(int A[], int low, int high){
		if (high == low + 1) {
		max_subarray result = new max_subarray();
		result.left = low;
		result.right = high;
		result.sum = A[low];
		
		return result;
		}
		
		else {
			int mid = (low + high)/2;
			
			max_subarray left = findMaxSubArray(A, low, mid);
			max_subarray right = findMaxSubArray(A,mid,high);
			max_subarray cross = findMaxCrossingSubArray(A,low,mid,high);
			
			if(left.sum >= right.sum && left.sum >= cross.sum)
			{return left;}
			else if (right.sum >= left.sum && right.sum >= cross.sum)
			{return right;}
			else {return cross;}
					
		}
		
	}
	
	public static max_subarray kadaneArray(int A[]){
		max_subarray result = new max_subarray();
		
		int max_so_far = 0;
		int max_ending_here = 0;
		
		for(int i=0; i<A.length; i++) {
			
			max_ending_here = max_ending_here + A[i];
			
			if(max_ending_here < 0) {
				max_ending_here = 0;
				result.left = i;
			} else if(max_so_far < max_ending_here){
				max_so_far = max_ending_here;
				result.right = i;
				result.sum = max_so_far;
			}
		}
		
		return result;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[] = {0,3,5,-8,-5,7,1,23,4,9,1,-4,2,9};
		int B[] = {5,-6,-1,2,-7,5,3};
		
		max_subarray resBrute = new max_subarray();
		
		max_subarray resDiv = new max_subarray();
		
		max_subarray reskad = new max_subarray();
		
		reskad = kadaneArray(A);
		System.out.println("Results using Kadane algorithm");
		System.out.println(reskad.left);
		System.out.println(reskad.right);
		System.out.println(reskad.sum);
		
		resBrute = findMaxSubarrayBruteforce(B, 0, B.length);
		System.out.println("Results using Brute force algorithm");
		System.out.println(resBrute.left);
		System.out.println(resBrute.right);
		System.out.println(resBrute.sum);
		
		resDiv = findMaxSubArray(B,0,B.length);
		System.out.println("Results using Div algorithm");
		System.out.println(resDiv.left);
		System.out.println(resDiv.right);
		System.out.println(resDiv.sum);
		
		
	}

}
