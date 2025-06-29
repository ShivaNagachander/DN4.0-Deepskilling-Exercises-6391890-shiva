package com.cts.MockitoEx1;

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
