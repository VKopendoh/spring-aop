package com.vkopendoh.aopdemo;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vkopendoh.aopdemo.dao.AccountDAO;
import com.vkopendoh.aopdemo.dao.MembershipDAO;
import com.vkopendoh.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	private static Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(DemoConfig.class);
		
		//get the bean from spring container
	TrafficFortuneService fortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);		
		
		myLogger.info("\n\n Main program AroundDemoApp ");
		
		String fortune = fortuneService.getFortune();
		
		myLogger.info("Fortune: " + fortune);
		
		myLogger.info("Finished");
		//close context
		context.close();

	}

}
