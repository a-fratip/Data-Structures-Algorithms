package coen352.ch07;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coen352.ch4.list.*;



public class SortTest {
	
	final static int testsize = 100;
	static Double A[];
	static int THRESHOLD = 8;
	
	 private static ADTList<Integer> list;

	@SuppressWarnings("removal")
	@BeforeEach
	void setUp() throws Exception {
		A = new Double[testsize];
	    for (int i=0; i<testsize; i++)
	      A[i] = new Double(DSutil.random(32003));// return int basic type, new Integer from int. 
	   
	  
	    //list = new DList<Integer>();
	    list = new LList<Integer>();
	   
	   // list = new AList<Integer>();
	
	
	
	}

	@Test
	void testLListMergeSort() {
		Link head = new Link(7,null);
        Link temp = head;
        temp.setNext(new Link(10,null));
        temp = temp.next();
        temp.setNext(new Link(5,null));
        temp = temp.next();
        temp.setNext(new Link(20,null));
        temp = temp.next();
        temp.setNext (new Link(3,null));
        temp = temp.next();
        temp.setNext(new Link(2,null));
        temp = temp.next();
 
        // Apply merge Sort
        head = LListMergeSort.mergeSort(head);
        assertEquals("2 3 5 7 10 20 ",LListMergeSort.toString(head));
	}

	//@Test
	void testInsert() {
		InsertSort.sort(A);
	    for (int i=1; i<testsize; i++)
	      assert A[i-1].compareTo(A[i]) <= 0 : "Array not sorted";
	}
	
	//@Test
	void testInsertList() {
		list.insert(5);
		list.insert(3);
		list.insert(10);
		list.insert(20);
		list.insert(8);
		InsertSort.sort(list);
	    assertEquals("",list.toString());
	}
	
	//@Test
	void testShell() {
		
		
		
		 ShellSort.sort(A);
		 for (int i=1; i<testsize; i++)
		      assert A[i-1].compareTo(A[i]) <= 0 : "Array not sorted";
		 
	}
	
	//@Test
	void testBubble() {
		
		 BubbleSort.sort(A);
		
		 
		 for (int i=1; i<testsize; i++)
		      assert A[i-1].compareTo(A[i]) <= 0 : "Array not sorted";
		 
		 
		 list.clear();
		 list.insert(25);
		 list.insert(2);
		 list.insert(3); 
		 
		 BubbleSort.sort(list);
		 for (int i=1; i<list.length(); i++)
		      assert list.getValue(i-1).compareTo(list.getValue(i)) <= 0 : "Array not sorted";
		 
	}
	
	//@Test
	void testSelect() {
		 SelectSort.sort(A);
		 for (int i=1; i<testsize; i++)
		      assert A[i-1].compareTo(A[i]) <= 0 : "Array not sorted";
		 
	}
	
	//@Test
	void testMerge() {
		 MergeSort.sort(A);
		 for (int i=1; i<testsize; i++)
		      assert A[i-1].compareTo(A[i]) <= 0 : "Array not sorted";
		 
		 
		 list.clear();
		 list.insert(25);
		 list.insert(2);
		 list.insert(3);
		 list.insert(5);
		 list.insert(100);
		 
		
		 MergeSort.sort(list);
		 assertEquals("< | 2 3 5 25 100 >", list.toString());
		 
		 for (int i=1; i<list.length(); i++)
		      assert list.getValue(i-1).compareTo(list.getValue(i)) <= 0 : "Array not sorted";
		 
		 
	}
	
	//@Test
	void testOptMerge() {
		 OptMergeSort.sort(A);
		 for (int i=1; i<testsize; i++)
		      assert A[i-1].compareTo(A[i]) <= 0 : "Array not sorted";
		 
		 assertEquals(16, OptMergeSort.insertCount);
	}
	
	//@Test
	void testQuick() {
		 QuickSort.sort(A);
		 for (int i=1; i<testsize; i++)
		      assert A[i-1].compareTo(A[i]) <= 0 : "Array not sorted";
	}
	
	
	
	//@Test
	void testSwap() {
		
		list.clear();
	    list.insert(25);
	    list.insert(2);
	    list.insert(3); 
	        
	    assertEquals("< | 3 2 25 >", list.toString());
	    
	    DSutil.swap(list, 1, 2);
	    
	    assertEquals("< | 3 25 2 >", list.toString());
	    

	}

}
