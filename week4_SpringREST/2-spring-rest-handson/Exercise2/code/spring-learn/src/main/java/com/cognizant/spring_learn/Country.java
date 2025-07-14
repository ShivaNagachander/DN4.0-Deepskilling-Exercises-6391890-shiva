package com.cognizant.spring_learn;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Country {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(Country.class);
	
	private String code;
	private String name;
	public Country() {
		LOGGER.debug("inside the constructor of Country class");
	}
	public String getCode() {
		LOGGER.debug("inside getter of code");
		return code;
	}
	public void setCode(String code) {
		LOGGER.debug("inside setter of code");
		this.code = code;
	}
	public String getName() {
		LOGGER.debug("inside getter of name");
		return name;
	}
	public void setName(String name) {
		LOGGER.debug("inside setter of name");
		this.name = name;
	}
	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}
	
	
	
}
