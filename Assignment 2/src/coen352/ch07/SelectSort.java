package coen352.ch07;

import coen352.ch4.list.*;


public class SelectSort {
	
	public static <E extends Comparable<? super E>> void sort(E[] A) {
		
	  for (int i=0; i<A.length-1; i++) { // Select i'th record
	    int lowindex = i;                // Remember its index
	    for (int j=A.length-1; j>i; j--) // Find the least value
	      if (A[j].compareTo(A[lowindex]) < 0)
	    	  	lowindex = j;                // Put it in place
	    DSutil.swap(A, i, lowindex);
	  
	    // System.out.println("i="+i+"\t"+lowindex);
	  }
	}
	
}
