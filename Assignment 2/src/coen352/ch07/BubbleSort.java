package coen352.ch07;

import coen352.ch4.list.ADTList;

public class BubbleSort  {

	public static <E extends Comparable<? super E>> void sort(E[] A) {
	  for (int i=0; i<A.length-1; i++) // Bubble up i'th record
	    for (int j=A.length-1; j>i; j--)
	      if ((A[j].compareTo(A[j-1]) < 0))
	        DSutil.swap(A, j, j-1);
	}
	
	
	
	
	public static <E extends Comparable<? super E>> void sort(ADTList<E> list) {
		  
		for (int i=0; i< list.length()-1; i++) // Bubble up i'th record
		    for (int j=list.length()-1; j>i; j--) {
		    	E _val_j = list.getValue(j);
		    	E _val_j_pre = list.getValue(j-1);
		    	if (_val_j.compareTo(_val_j_pre) < 0) {
		    		 DSutil.swap(list, j, j-1);
		    	}
		    }
		    	
		    	
	}
	
	


	
}
