package coen352.ch07;
public class ShellSort {
	
	public static <E extends Comparable<? super E>> void sort(E[] A) {
	  for (int i=A.length/2; i>2; i/=2) // For each increment
	    for (int j=0; j<i; j++)         // Sort each sublist
	      inssort2(A, j, i);
	  inssort2(A, 0, 1);     // Could call regular inssort here
	}

	/** Modified Insertion Sort for varying increments */
	public static <E extends Comparable<? super E>> void inssort2(E[] A, int start, int incr) {
		
	  for (int i=start+incr; i<A.length; i+=incr)
	    for (int j=i; (j>=incr) && (A[j].compareTo(A[j-incr])<0); j-=incr)
	      DSutil.swap(A, j, j-incr);
	}

}
