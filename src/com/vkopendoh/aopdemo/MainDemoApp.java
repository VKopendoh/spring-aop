package com.vkopendoh.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vkopendoh.aopdemo.dao.AccountDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// call business method
		theAccountDAO.addAccount();
		
		//close context
		context.close();

	}

}
