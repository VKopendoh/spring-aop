package com.vkopendoh.aopdemo;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vkopendoh.aopdemo.dao.AccountDAO;
import com.vkopendoh.aopdemo.dao.MembershipDAO;
import com.vkopendoh.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
	TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);		
		
		System.out.println("\n\n Main program AroundDemoApp ");
		
		String fortune = fortuneService.getFortune();
		
		System.out.println("Fortune: " + fortune);
		
		System.out.println("Finished");
		//close context
		context.close();

	}

}
