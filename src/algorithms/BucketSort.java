package algorithms;

import java.util.ArrayList;
import java.util.List;

public class BucketSort {
	
	public static void bucketSort(int A[], int bucketsize){
		if(A.length <=1)
			return;
	
		int max = A[0];
		int min = A[0];
		for(int i=0; i< A.length; i++){
			if(A[i] > max)
				max = A[i];
			if(A[i] < min)
				min =A[i];
		}
		
		int bucketcount = (max -min)/bucketsize +1;
		
		List<List<Integer>> bucket = new ArrayList<List<Integer>>(bucketcount);
		
		for(int i=0; i< bucketcount; i++){
			bucket.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<A.length; i++){
			bucket.get((A[i]-min) / bucketsize).add(A[i]);
		}
		
		int currentIndex=0;
		for(int i=0; i<bucket.size(); i++){
			Integer[] bucketarray = new Integer[bucket.get(i).size()];
			bucketarray = bucket.get(i).toArray(bucketarray);
			//algorithms.HeapSort.heapify(bucketarray);
			for(int j=0; j<bucketarray.length;j++){
				A[currentIndex++] = bucketarray[j];
			}
		}
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
