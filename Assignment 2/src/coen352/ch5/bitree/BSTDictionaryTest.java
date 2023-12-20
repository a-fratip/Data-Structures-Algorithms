package coen352.ch5.bitree;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;



class BSTDictionaryTest {

	
	private static ADTDictionary<Integer, String> dict;
	
	@BeforeEach
	void init() {
		
		dict = new BSTDictionary<Integer, String>();
	}
	
	//@Test
	void testBSTDictionary() {
		fail("Not yet implemented");
	}

	//@Test
	void testClear() {
		fail("Not yet implemented");
	}

	//@Test
	void testInsert() {
		dict.insert(10, "10");
		dict.insert(2,"2");
		dict.insert(3, "3");
		dict.insert(15,"15");
		
		
		
		assertEquals("",dict.toString());
	}

	//@Test
	void testRemove() {
		fail("Not yet implemented");
	}

	//@Test
	void testToString() {
		fail("Not yet implemented");
	}

	//@Test
	void testRemoveAny() {
		fail("Not yet implemented");
	}

	//@Test
	void testFind() {
		fail("Not yet implemented");
	}

	//@Test
	void testSize() {
		fail("Not yet implemented");
	}
	
	@Test
	void testFall2022() {
		dict.insert(25,"25");
		dict.insert(15, "15");
		dict.insert(50, "50");
		dict.insert(10, "10");
		dict.insert(22, "22");
		dict.insert(35, "35");
		dict.insert(70, "70");
		dict.insert(4, "4");
		dict.insert(12, "12");
		dict.insert(18 , "18");
		dict.insert(24 , "24");
		dict.insert(31 , "31");
		dict.insert(44 , "44");
		dict.insert(66 , "66");
		dict.insert(90 , "90");
		
		dict.remove(50);
		
		assertEquals("4 10 12 15 18 22 24 25 31 35 44 66 70 90",dict.toString());
		
	}

}
