package com.cts.slf4jEx1;

import org.slf4j.LoggerFactory;

public class LoggingExample {
	private static final org.slf4j.Logger logger=LoggerFactory.getLogger(LoggingExample.class);
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		logger.warn("this is a warning message");
		logger.error("this is an error message");
	}

}
