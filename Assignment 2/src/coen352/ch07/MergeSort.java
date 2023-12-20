package coen352.ch07;

import coen352.ch4.list.*;


public class MergeSort {
	
	@SuppressWarnings("unchecked") // Generic array allocation
	public static <E extends Comparable<? super E>> void sort(E[] A) {
	  E[] temp = (E[])new Comparable[A.length];
	  mergesort(A, temp, 0, A.length-1); //taking the double space as the original;
	}
	
	public static <E extends Comparable<? super E>> void sort(ADTList<E> list) {
		 
		E[] temp = (E[])new Comparable[list.length()];
		
		  mergesort(list, temp, 0, list.length()-1);
	}
	
	
	public static <E extends Comparable<? super E>> void mergesort(E[] A, E[] temp, int l, int r) {
		
		int mid = (l+r)/2; // Select midpoint
		
		if (l == r) { 
		
			return; // List has one element
		}
		
		mergesort(A, temp, l, mid); // Mergesort first half
		
		mergesort(A, temp, mid+1, r); // Mergesort second half
		
		//SelectSort.sort(A);  //aggregation 
		//InsertSort.sort(A);
		//BubbleSort.sort(A); 
		
		
		/*The rest of the code is doing the aggregation to merge the 
		 data to tempory space temp in order*/
		
		for (int i=l; i<=r; i++) // Copy subarray to temp
			temp[i] = A[i];
		
		// Do the merge operation back to A
		int i1 = l; int i2 = mid + 1;
		for (int curr=l; curr<=r; curr++) {
			
			if ((i1< mid+1) && (i2<=r)) {
				 if (temp[i1].compareTo(temp[i2])<0) // Get smaller
						A[curr] = temp[i1++];
				 else 
					 A[curr] = temp[i2++];
				
			}
			else if ((i1==mid+1) && (i2 <= r) ){ // Left sublist exhausted
				A[curr] = temp[i2++];
			}
			else if (i2 > r) { // Right sublist exhausted
			    A[curr] = temp[i1++];
			}
		}
		
	 
	}
	
	
	public static <E extends Comparable<? super E>> void mergesort 
							(ADTList<E> list, E[] temp, int l, int r) {
		
		int mid = (l+r)/2; // Select midpoint
		if (l == r) { 
		
			return; // List has one element
		}
		
		mergesort(list, temp, l, mid); // Mergesort first half
		mergesort(list, temp, mid+1, r); // Mergesort second half
		
		BubbleSort.sort(list);
		
		
		/*
		for (int i=l; i<=r; i++) {// Copy subarray to temp
			
			int list_curr = list.currPos();
			list.moveToPos(i);
			
			temp[i]= (list.getValue(i));
			
			list.moveToPos(list_curr);
		}
		
		// Do the merge operation back to A
		int i1 = l; int i2 = mid + 1;
		for (int curr=l; curr<=r; curr++) {
			
			int origin = list.currPos();
			list.moveToPos(curr);
			
			if ((i1< mid+1) && (i2<=r)) {
				 if (temp[i1].compareTo(temp[i2])<0) {  // Get smaller
					list.setValue( temp[i1++] );
				 }		
				 else { 
					list.setValue( temp[i2++] );
				 } 
				
			}
			else if ((i1==mid+1) && (i2 <= r) ){ // Left sublit exhausted
				list.setValue( temp[i2++] );
			}
			else if (i2 > r) { // Right sublist exhausted
			    list.setValue( temp[i1++] );
			}
			
			list.moveToPos(origin);
		}
		
	  */
	}
	

}
