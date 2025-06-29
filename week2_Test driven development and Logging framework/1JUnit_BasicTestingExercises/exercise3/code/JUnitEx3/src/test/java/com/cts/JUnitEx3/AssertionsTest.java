package com.cts.JUnitEx3;

import static org.junit.Assert.*;

import org.junit.Test;

public class AssertionsTest {

	@Test
	public void assertionTest() {
		
		assertEquals(10, 50-40);
		
		assertTrue("abcd".equals("abcd"));
		assertFalse(5<3);
		
		int[] arr1= {1,2,3,4};
		int[] arr2= {1,2,3,4};
		assertArrayEquals(arr1,arr2);
		
		assertNull(null);
		assertNotNull("string");
		
		Object ob1=new String("abcd");
		Object ob2=ob1;
		
		assertSame(ob1,ob2);
		
	}

}
