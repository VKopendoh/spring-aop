package com.vkopendoh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vkopendoh.aopdemo.dao.AccountDAO;
import com.vkopendoh.aopdemo.dao.MembershipDAO;

public class AfterReturningDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
				
		// call business method
		List<Account> accounts =  theAccountDAO.findAccounts();		
		
		System.out.println("\n\n Main program AfterReturningDemoApp ");
		System.out.println("Accounts: " + accounts);
		
		//close context
		context.close();

	}

}
