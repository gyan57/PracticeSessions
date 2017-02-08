package algorithms;

import java.util.ArrayList;

public class ArrayOfSubArray {
	
	public static class max_subarray {
		
		int left;
		int right;
		int sum;
		
	}
	
	public static ArrayList<max_subarray> findMaximumSubArray(int A[], int low, int high){
		ArrayList<max_subarray> max = new ArrayList<max_subarray>();
			
		for(int i= low+1; i<high; i++){
			if(max.isEmpty()) {
				System.out.println("1");
				max_subarray list = new max_subarray();
				list.left = low;
				list.right = low+1;
				list.sum = A[low];
				max.add(list);
			} else 
			if(max.get(max.size() - 1).sum < 0) {
				System.out.println("2");
				max_subarray list = new max_subarray();
				list.left = i;
				list.right = i+1;
				list.sum = A[i];
				max.add(list);
			} else {
				System.out.println("3");
				max_subarray list = new max_subarray();
				list.left = max.get(max.size() - 1).left;
				list.right = i +1;
				list.sum = max.get(max.size() - 1).sum + A[i];
				max.add(list);
			}
		}
			
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A[] = {0,3,5,-8,-5,-7,1,23,4,9,1,-4,2,9};
		
		ArrayList<max_subarray> res = new ArrayList<max_subarray>();
		
		res = findMaximumSubArray(A,0, A.length);
		
		for(int i=0; i<res.size(); i++)
		{
			System.out.println("[" + res.get(i).left + "," + res.get(i).right + "," + res.get(i).sum + "]");
		}
		
	}

}
