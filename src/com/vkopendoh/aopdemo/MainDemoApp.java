package com.vkopendoh.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vkopendoh.aopdemo.dao.AccountDAO;
import com.vkopendoh.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		MembershipDAO membershipDAO = context.getBean("membershipDAO", MembershipDAO.class);		
		
		// call business method
		theAccountDAO.addAccount(new Account(),true,"name");		
		
		// do it again
		membershipDAO.addSillyMethod();
		
		theAccountDAO.getTheName();
		
		theAccountDAO.setCheck(true);
		
		theAccountDAO.doWork();
		//close context
		context.close();

	}

}
