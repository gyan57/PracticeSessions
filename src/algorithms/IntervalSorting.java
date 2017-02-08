package algorithms;

public class IntervalSorting {
	
	public static class interval {
		int left;
		int right;
	}
	
	public static boolean intersects(interval a, interval b){
		return a.left <= b.right && b.left <= a.right;
	}
	
	public static boolean before(interval a, interval b){
		return a.right < b.left;
	}
	
	public static boolean after(interval a, interval b){
		return a.left > b.right;
	}
	
	public static interval partition(interval A[], int p, int r){
		
		int s,t, i;
		interval intersection = new interval();
		intersection = A[r];
		
		for(i = p; i<r; i++){
			
			if(intersects(intersection, A[i])) {
				if(A[i].left > intersection.left)
					intersection.left = A[i].left;
				if(A[i].right <  intersection.right)
					intersection.right = A[i].right;
			}
		}
		
		for(i=s=p; i<r; i++){
			if(before(A[i],intersection)) {
				interval temp = new interval();
				temp = A[i];
				A[i] = A[s];
				A[s] = temp;
				s++;
			}
		}
		
		interval temp = new interval();
		temp = A[r];
		A[r] = A[s];
		A[s] = temp;
		
		for(t = s+1, i=r; t <=i;){
			if(intersects(A[i], intersection)) {
				temp = A[i];
				A[i] = A[t];
				A[t] = temp;
				t++;
			} else {
				i--;
			}
		}
		
		interval result = new interval();
		result.left = s;
		result.right = t;
		
		return result;
		
	}
	
	public static void fuzzySort(interval A[], int p, int r){
		if(p < r) {
			interval pivot = partition(A,p,r);
			fuzzySort(A, p, pivot.left);
			fuzzySort(A, pivot.right, r);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
