package com.vkopendoh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vkopendoh.aopdemo.dao.AccountDAO;
import com.vkopendoh.aopdemo.dao.MembershipDAO;

public class AfterDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		List<Account> accounts = null;
		
		try {
			// call business method
			//add flag to simulate exception
			boolean triWire = false;
			accounts =  theAccountDAO.findAccounts(triWire);
			
			triWire = true;
			accounts =  theAccountDAO.findAccounts(triWire);		
		}catch(Exception e) {
			System.out.println("\n Main program caught exception: " + e);
		}
		
		
		System.out.println("\n\n Main program AfterThrowingDemoApp ");
		System.out.println("Accounts: " + accounts);
		
		//close context
		context.close();

	}

}
