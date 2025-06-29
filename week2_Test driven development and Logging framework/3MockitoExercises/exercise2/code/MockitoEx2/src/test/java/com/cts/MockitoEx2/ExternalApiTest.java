package com.cts.MockitoEx2;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mockito;

public class ExternalApiTest {

	@Test
	public void test() {
		ExternalApi mock=Mockito.mock(ExternalApi.class);
				
		when(mock.getData(10)).thenReturn(100);
		
		Service service=new Service(mock);
		
		int result=service.getData(10);
		assertEquals(result,10*10);
		
		verify(mock).getData(10);

	}

}
