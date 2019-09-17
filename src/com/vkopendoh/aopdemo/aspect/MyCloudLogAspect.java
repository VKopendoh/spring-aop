package com.vkopendoh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(1)
@Component
public class MyCloudLogAspect {	
	//this is where we add all of our advices for logging
	
	//start with @Before advice
	
	@Before("com.vkopendoh.aopdemo.aspect.LuvAopExp.forDaoExceptGetAndSet()")
	public void performCloudLog() {
		System.out.println("\n====>>> Perfom Cloud logging Order 1...");
	}
	
}
