package com.cts.JUnitEx4;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AdditionTest {
	
	AdditionExample addition;

	@Before
	public void setUp(){
		addition=new AdditionExample();
	}

	@After
	public void tearDown(){
		addition=null;
	}

	@Test
	public void test() {
		int result=addition.add(15, 15);
		assertEquals(result, 15+15);
	}

}
