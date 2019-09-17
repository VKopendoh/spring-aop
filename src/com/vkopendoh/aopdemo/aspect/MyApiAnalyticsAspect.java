package com.vkopendoh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(2)
@Component
public class MyApiAnalyticsAspect {

	
	//start with @Before advice
	@Before("com.vkopendoh.aopdemo.aspect.LuvAopExp.forDaoExceptGetAndSet()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n====>>> Executing Analytics order 2 @Before advice on com.vkopendoh.aopdemo.dao package... DO NOT apply to getters and setters");
	}
	
}
