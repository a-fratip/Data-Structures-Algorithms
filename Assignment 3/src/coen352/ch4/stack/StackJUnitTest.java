package coen352.ch4.stack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StackJUnitTest {
	
	private ADTStack<Integer> stack1;

	@BeforeEach
	void setUp() throws Exception {
		stack1 = new AStack<Integer>();
	}

	@Test
	void test() {
		stack1.push(10);
		stack1.push(20);
		stack1.push(30);
		
		assertEquals("< 30 20 10 >", stack1.toString());
		
		stack1.pop();
		stack1.pop();
		assertEquals("< 10 >", stack1.toString());
	}

}
