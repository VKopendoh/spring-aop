package com.vkopendoh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {
	
	//add pointcut declaration
	@Pointcut("execution(* com.vkopendoh.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	//this is where we add all of our advices for logging
	
	//start with @Before advice
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on addAccount()...");
	}
	
}
