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
	
	@Pointcut("execution(* com.vkopendoh.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	@Pointcut("execution(* com.vkopendoh.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	//this is where we add all of our advices for logging
	
	//start with @Before advice
	@Before("forDaoPackage() && !(getter() || setter())")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing @Before advice on com.vkopendoh.aopdemo.dao package... DO NOT apply to getters and setters");
	}
	
	@Before("forDaoPackage()")
	public void performApiAnalytics() {
		System.out.println("\n====>>> Perfom API analytics...");
	}
	
}
