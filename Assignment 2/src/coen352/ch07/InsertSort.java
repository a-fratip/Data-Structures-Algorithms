package coen352.ch07;

import coen352.ch4.list.ADTList;

public class InsertSort {
	
	public static <E extends Comparable<? super E>> void sort(E[] A) {
	  for (int i=1; i<A.length; i++) { // Insert i'th record
	    for (int j=i; (j>0) && (A[j].compareTo(A[j-1])<0); j--)
	      DSutil.swap(A, j, j-1);
	  }
	  
	}
	
	public static <E extends Comparable<? super E>> void sort(ADTList<E> A) {
		  for (int i=1; i<A.length(); i++) { // Insert i'th record
		    for (int j=i; j>0; j--) {
		    	
		    	A.moveToPos(j);
		    	E value_j = A.getValue();
		    	A.moveToPos(j-1);
		    	E value_j_1 = A.getValue();
				if(value_j.compareTo(value_j_1)<0)
		    		DSutil.swap(A, j, j-1);
		    }
		  }
		  
	}
	
	
	
	
	
	public static <E extends Comparable<? super E>> 
	void sort(E[] A, int start, int len) {
	  for (int i=start+1; i<start+len; i++)  // Insert i'th record
	    for (int j=i; (j>start) && (A[j].compareTo(A[j-1])<0); j--)
	    	DSutil.swap(A, j, j-1);
	}


}
