package coen352.ch4.list;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;




public class ListJUnitTest {

	  private static ADTList<Integer> La;
	  private static ADTList<Integer> Ll;
	  private static ADTList<Object> Ld;
	  
	
	  
	  /**
	   * This method is automatically called once before each test case method,
	   * so that all the variables are cleanly initialized for each test.
	   */
	  @BeforeAll
	  public static void setUp()
	  {
		La = new AList<Integer>(15);  
	    
		Ll = new LList<Integer>();
	    
	    Ld = new DList<Object>();
	    
	   
	    
	  }
	  
	
	@Test
	  public void testSetValue() {
		  
		  
		 ADTList<Integer> list =  new DList<Integer>();
		 list.clear();
		 list.insert(Integer.valueOf(25));
		 list.insert(Integer.valueOf(3));
		 list.insert(Integer.valueOf(2));
		 String s = list.toString();
		 
//		 Integer temp1 = list.getValue(0);
//		 Integer temp2 = list.getValue(2);
//		 int curr = list.currPos();
//		
//		  list.moveToPos(0);
//		  list.setValue(temp2);
//		 
//		  list.moveToPos(2);
//		  list.setValue(temp1);
//		  list.moveToPos(curr);
		 		 
		 assertEquals("< | 2 3 25 >", list.toString());
		    
		  
	  }
	  
	  
	  
	
	
	  /** @return True if k is in list L, false otherwise */
	
	 @Test
	  public static boolean find(ADTList<Integer> L, int k) {
	     int origin = L.currPos();
	     
		 for (L.moveToStart(); L.currPos()<L.length(); L.next()) {
			 if (k == L.getValue()) {
				 L.moveToPos(origin);
				 return true;    // Found k
			 }
	     }
		 
		 L.moveToPos(origin);
		 return false;                            // k not found
	}
	 
	 
	 @Test
	  public void testInsert()
	  {
		La.clear(); 
	    La.insert(25);
	    La.insert(2);
	    La.insert(3); 
	    
	    Ld.clear();
	    Ld.insert(25);
	    Ld.insert(2);
	    Ld.insert(3);
	    Ld.remove();
	    Ld.remove();
	    Ld.insert(10);
	    assertEquals("< | 10 25 >", Ld.toString());
	   
	  }
	 
	 @Test
	  public void test()
	  {
		Ll.clear(); 
		Ll.insert(15);
		Ll.moveToPos(1);
		Ll.insert(20);
		Ll.insert(25);
		assertEquals(25,Ll.remove());
		
		
		Ll.clear(); 
		Ll.insert(15);
		Ll.insert(20);
		Ll.insert(25);
		Ll.insert(30);
		Ll.remove();
		Ll.remove();
		Ll.insert(40);
		assertEquals(40,Ll.remove());
		
	   // L2.append(1);
	   // assertEquals("< | 1 >", L2.toString());
	   // assertEquals(1, (int)L2.remove());
	   //assertEquals("< | >", L2.toString());
	    //assertEquals(null, L2.remove());
	  }
	 
	 @Test
	  public void testAppend()
	  {
		Ll.clear(); 
		Ll.append(10);
	    assertEquals("< | 10 >", Ll.toString());
	    Ll.append(20);
	    Ll.append(15);
	    assertEquals("< | 10 20 15 >", Ll.toString());
	  }

	 @Test
	  public void testFind()
	  {
	    La.clear();
		La.moveToStart();
	    La.insert(39);
	    La.next();
	    La.insert(9);
	    La.insert(5);
	    La.append(4);
	    La.append(3);
	    La.append(2);
	    La.append(1);
	    assertEquals("< 39 | 5 9 4 3 2 1 >", La.toString());
	    assertEquals(7, La.length());

	    assertEquals(true, find(La, 3));
	    assertEquals(false, find(La, 29));
	    assertEquals(true, find(La, 5));
	  }
	 
	 @Test
	  public void testFindPos()
	  {
	    Ll.clear();
		Ll.moveToStart();
	    Ll.insert(39);
	    Ll.next();
	    Ll.insert(9);
	    Ll.insert(5);
	    Ll.append(4);
	    Ll.append(3);
	    Ll.append(2);
	    Ll.append(1);
	    assertEquals("< 39 | 5 9 4 3 2 1 >", Ll.toString());
	    assertEquals(7, Ll.length());

	   // assertEquals(6, L2.find(20));
	    
	    
	  }


	 @Test
	  public void testListOfObjects()
	  {
	     Ld.clear();
		 assertEquals("< | >", Ld.toString());
	    Ld.insert(3);
	    assertEquals("< | 3 >", Ld.toString());
	    Ld.insert("Hello");
	    assertEquals("< | Hello 3 >", Ld.toString());
	  }

	 @Test
	  public void testNext() {
		 
		Ll.clear();
	    Ll.append(10);
	    Ll.append(20);
	    Ll.append(15);
	    Ll.moveToStart();
	    Ll.next();
	    assertEquals(20, (int)Ll.getValue());
	  }

	 @Test
	  public void testMore() {
		LList<Integer>Ll = new LList<Integer>();
	    Ll.clear();
	    Ll.moveToStart();
	    Ll.insert(15);
	    Ll.insert(27);
	    Ll.moveToPos(2);
	    Ll.insert(33);
	  
	    assertEquals("< 27 15 | 33 >", Ll.toString());
	  }
	 
	 @Test
	 public void testExam() {
		 La.clear();
		 La.append(20);
		 La.append(10);
		 La.append(50);
		 La.insert(30);
		 La.next();
		 La.insert(40);
		 assertEquals("< 30 | 40 20 10 50 >" , La.toString());
	 }
	 
	 @Test
	 public void testAListInsert() {
		 La.clear();
		 La.insert(20);
		 La.insert(40);
		 assertEquals(1,La.find(20));
	 }

}
