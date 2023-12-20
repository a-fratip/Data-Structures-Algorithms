package coen352.ch07;

public class OptMergeSort {
	
	static int THRESHOLD = 8;
	static int insertCount = 0; 

	@SuppressWarnings("unchecked") // Generic array allocation
	public static <E extends Comparable<? super E>> void sort(E[] A) {
		E[] temp = (E[])new Comparable[A.length];
		mergesort(A, temp, 0, A.length-1);
	}
	
	static <E extends Comparable<? super E>> void mergesort(E[] A, E[] temp, int l, int r) {
		int i, j, k, mid = (l+r)/2; // Select the midpoint
		if (l == r) 
			return; // List has one element		
		
		if ((mid-l) >= THRESHOLD) 
			mergesort(A, temp, l, mid);
		else {
			InsertSort.sort(A, l, mid-l+1);	
			insertCount++;
		}
		
		if ((r-mid) > THRESHOLD) 
			mergesort(A, temp, mid+1, r);
		else {
			InsertSort.sort(A, mid+1, r-mid);
			insertCount++;
		}
		// Do the merge operation. First, copy 2 halves to temp.
		
		for (i=l; i<=mid; i++) 
			temp[i] = A[i];
		
		for (j=1; j<=r-mid; j++) 
			temp[r-j+1] = A[j+mid];
		
		// Merge sublists back to array
		for (i=l,j=r,k=l; k<=r; k++) {
			if (temp[i].compareTo(temp[j])<0) 
				A[k] = temp[i++];
			else A[k] = temp[j--];
		}
	}

}
