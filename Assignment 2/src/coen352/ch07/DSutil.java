package coen352.ch07;
/** Source code example for "A Practical Introduction to Data
    Structures and Algorithm Analysis, 3rd Edition (Java)" 
    by Clifford A. Shaffer
    Copyright 2008-2011 by Clifford A. Shaffer
*/

import java.util.*;

import coen352.ch4.list.*;

/** A bunch of utility functions. */
public class DSutil<E> {

	  /** Swap two Objects in an array
	      @param A The array
	      @param p1 Index of one Object in A
	      @param p2 Index of another Object A
	  */
	  public static <E> void swap(E[] A, int p1, int p2) {
	    E temp = A[p1];
		A[p1] = A[p2];
		A[p2] = temp;
	  }
	  
	  
	  public static <E> void swap(ADTList<E> list, int p1, int p2) {
		  
		  int curr = list.currPos();
		  
		  E temp1 = list.getValue(p1);
		  E temp2 = list.getValue(p2);
		  
		  list.moveToPos(p1);
		  list.setValue(temp2);
		  
		  list.moveToPos(p2);
		  list.setValue(temp1);
		
		  list.moveToPos(curr);
		 
	  }
	
	  /** Randomly permute the Objects in an array.
	      @param A The array
	  */
	
	// int version
	// Randomly permute the values of array "A"
	static void permute(int[] A) {
	  for (int i = A.length; i > 0; i--) // for each i
	    swap(A, i-1, DSutil.random(i));  //   swap A[i-1] with
	}                                    //   a random element
	
	  public static void swap(int[] A, int p1, int p2) {
	    int temp = A[p1];
		A[p1] = A[p2];
		A[p2] = temp;
	  }
	
	/** Randomly permute the values in array A */
	static <E> void permute(E[] A) {
	  for (int i = A.length; i > 0; i--) // for each i
	    swap(A, i-1, DSutil.random(i));  //   swap A[i-1] with
	}                                    //   a random element
	
	  /** Initialize the random variable */
	  static private Random value = new Random(); // Hold the Random class object
	
	  /** Create a random number function from the standard Java Random
	      class. Turn it into a uniformly distributed value within the
	      range 0 to n-1 by taking the value mod n.
	      @param n The upper bound for the range.
	      @return A value in the range 0 to n-1.
	  */
	  static int random(int n) {
		return Math.abs(value.nextInt()) % n;
	  }

}