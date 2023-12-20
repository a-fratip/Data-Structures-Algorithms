package coen352.ch5.bitree;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BSTTraverseTest {

	
	
	
	
	private static BSTDictionary<Integer, String> dict;
	
	@BeforeEach
	void init() {
		
		dict = new BSTDictionary<Integer, String>();
	}
	
	
	
	@Test
	  public void testPreorder() {
		  
			  
		  	dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			
			BSTTraverse.clear();
			BSTTraverse.preorderTraverse(dict.getRoot());
			//Dev
			//assertEquals(" 10 2 3 15 ", BSTTraverse.print());
			
			//QA
			//assertEquals(" 10-2-3-15 ", BSTTraverse.print());
			
			BSTTraverse.clear();
			BSTTraverse.inorderTraverse(dict.getRoot());
			assertEquals(" 2 3 10 15 ", BSTTraverse.print());
			
			BSTTraverse.clear();
			BSTTraverse.postorderTraverse(dict.getRoot());
			assertEquals(" 3 2 15 10 ", BSTTraverse.print());
			
			
	  }
	
	
	
	
	
	
	@Test
	  public void testHeight() {
		  
			  
		  	dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			dict.insert(1,"1");
			dict.insert(12, "12");
			dict.insert(17, "17");
			dict.insert(5,"5");
			dict.insert(6,"6");
			dict.insert(13, "13");
			dict.insert(7,"7");
			dict.insert(4,"4");
			
			assertEquals(6, BSTTraverse.getHeight(dict.getRoot()));
			
			
			
	}
	
	@Test
	  public void testLeavesCount() {
		  
			  
		  	dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			dict.insert(1,"1");
			dict.insert(12, "12");
			dict.insert(17, "17");
			dict.insert(5,"5");
			dict.insert(6,"6");
			dict.insert(13, "13");
			dict.insert(7,"7");
			dict.insert(4,"4");
			
			
			assertEquals(5, BSTTraverse.getLeavesCount(dict.getRoot()));
			
	}
	
	
	@Test
	  public void testLevelOrder() {
		  
			  
		  	dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			dict.insert(1,"1");
			dict.insert(12, "12");
			dict.insert(17, "17");
			dict.insert(5,"5");
			dict.insert(6,"6");
			dict.insert(13, "13");
			dict.insert(7,"7");
			dict.insert(4,"4");
			
		
			
			BSTTraverse.clear();
			BSTTraverse.levelorder(dict.getRoot());
			assertEquals(" 10 2 15 1 3 12 17 5 13 4 6 7 ", BSTTraverse.print());
			
			
	}
	

	  @Test
	  public void testDFT() {
		  
			  
		  	dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			BSTTraverse.clear();
			BSTTraverse.depthFirstTraverse(dict.getRoot());
		    
		  
			assertEquals(BSTTraverse.print(), " 2 3 10 15 ");
	  }
      
	  @Test
	  public void testBFT() {
		
		    dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
		
			BSTTraverse.clear();

			BSTTraverse.breathFirstTraverse(dict.getRoot());
		    
		  
			assertEquals("10 2 3 15 ",BSTTraverse.print());
	  }

	  @Test	
	  public void testCount() {
		  dict.insert(10, "10");
			dict.insert(2,"2");
			dict.insert(3, "3");
			dict.insert(15,"15");
			
			BSTTraverse.clear();

	   
	    assertEquals(4, BSTTraverse.count(dict.getRoot()));
	  }

	  // The following tests for checkBST are a little dicey. The book
	  // code uses a simple BinNode abstract class. Syntactically, this
	  // works fine since the function uses only base class
	  // functionality. But logically, this works only so long as the key
	  // and element of the BSTNode are the same (since BinNode.element()
	  // returns the element, not the key). 

	  @Test
	  public void testBSTa() {
		dict.insert(10, "10");
		dict.insert(2,"2");
		dict.insert(3, "3");
		dict.insert(15,"15");
		
		BSTTraverse.clear();

	   
	    assertEquals(true, 
	    		BSTTraverse.checkBST(dict.getRoot(), 
	    				Integer.valueOf(-1), Integer.valueOf(1000)));
	  }
      
	 
	
}
