package com.cognizant.spring_learn;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class SpringLearnApplication {

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(SpringLearnApplication.class, args);
		
		displayDate("31/12/2018");
	}
	
	public static void displayDate(String date) throws ParseException
	{
		ApplicationContext context=new ClassPathXmlApplicationContext("date-format.xml");
		
		SimpleDateFormat format=context.getBean("dateFormat",SimpleDateFormat.class);
		
		System.out.println("parsed date : "+format.parse(date));
	}

}
