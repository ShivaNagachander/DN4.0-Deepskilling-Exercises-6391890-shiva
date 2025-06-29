package com.cts.MockitoEx2;

public class Service {

	private ExternalApi external;

	public Service(ExternalApi external) {
		this.external = external;
	}
	
	public int getData(int a)
	{
		return external.getData(a);
	}

	
}
