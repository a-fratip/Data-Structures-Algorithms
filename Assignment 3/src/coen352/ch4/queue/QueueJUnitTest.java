package coen352.ch4.queue;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import coen352.ch4.stack.*;

class QueueJUnitTest {
	
	private ADTQueue<Integer> Q1;
	private ADTQueue<Integer> Q2;
	private ADTStack<Integer> S;
	

	@BeforeEach
	void setUp() throws Exception {
		
		Q1 = new DQueue<Integer>();
		Q2 = new DQueue<Integer>();
		S = new AStack<Integer>(20);
		
	}

	@Test
	public void testGeneral() {
		int temp;
		
		Q2.enqueue(10);
		Q2.enqueue(20);
		Q2.enqueue(15);
		assertEquals("< 10 20 15 >", Q2.toString());
		
		while(Q2.length() > 0) {
		  temp = Q2.dequeue();
		  Q1.enqueue(temp);
		}
		assertEquals("< >", Q2.toString());
		assertEquals("< 10 20 15 >", Q1.toString());

	}
	
	@Test
	public void testReverse() {
		Q1.clear();
		Q1.enqueue(1);
		Q1.enqueue(2);
		Q1.enqueue(3);
		Q1.enqueue(4);
		Q1.enqueue(5);
		
		int size = Q1.length();
		
		for (int i=0; i<size;i++) {
			S.push(Q1.dequeue());
		}
		assertEquals("< 5 4 3 2 1 >", S.toString()); 
		
		for (int i=0; i<size;i++) {
			Q1.enqueue(S.pop());
		}
		
		assertEquals("< 5 4 3 2 1 >", Q1.toString()); 
		
		
	}

		
}
