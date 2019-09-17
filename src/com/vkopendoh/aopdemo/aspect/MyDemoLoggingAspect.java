package com.vkopendoh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspect {
	//this is where we add all of our advices for logging
	
	//start with @Before advice
	@Before("com.vkopendoh.aopdemo.aspect.LuvAopExp.forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before MyDemoLogging order -23 advice on com.vkopendoh.aopdemo.dao package...");
	}
		
}
