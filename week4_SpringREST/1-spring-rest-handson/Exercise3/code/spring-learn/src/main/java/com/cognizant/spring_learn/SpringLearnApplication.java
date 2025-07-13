package com.cognizant.spring_learn;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLearnApplication {
	
	private static final Logger LOGGER=LoggerFactory.getLogger(SpringLearnApplication.class);

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate("31/12/2018");
	}
	
	public static void displayDate(String date) throws ParseException
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("date-format.xml");
		
		SimpleDateFormat format=context.getBean("dateFormat",SimpleDateFormat.class);
		
		LOGGER.info("start");
		
		LOGGER.debug(String.valueOf(format.parse(date)));
		
		LOGGER.info("end");
		
		
	}


}
