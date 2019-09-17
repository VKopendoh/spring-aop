package com.vkopendoh.aopdemo.aspect;

import java.util.List;
import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vkopendoh.aopdemo.Account;
import com.vkopendoh.aopdemo.AroundWithLoggerDemoApp;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspect {
	private Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());
	//this is where we add all of our advices for logging
	
	//start with @Before advice
	@Before("com.vkopendoh.aopdemo.aspect.LuvAopExp.forDaoPackage()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		myLogger.info("\n====>>> Executing @Before MyDemoLogging order -23 advice on com.vkopendoh.aopdemo.dao package...");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		myLogger.info("====>Method: "+ methodSignature);
		
		//display method args
		Object[] args = joinPoint.getArgs();
		
		for(Object argument:args) {
			if(argument instanceof Account) {
				Account account = (Account) argument;
				myLogger.info("====>Account name: " + account.getName() + " Level: " + account.getLevel());
			} else {
				myLogger.info("====>Argument: " + argument);
			}
			
		}
		
	}
	
	@AfterReturning(
			pointcut = "execution(* com.vkopendoh.aopdemo.dao.AccountDAO.findAccounts(..))", 
			returning = "result"
			)
	public void afterRetFindAccountAdvise(
			JoinPoint joinPoint,
			List<Account> result ) {
		String method = joinPoint.getSignature().toShortString();
		
		myLogger.info("\n====> Exec @AfterReturning on method: " + method);		
		
		myLogger.info("====>Result: " + result);
		
		//modify returning data
		
		convertNameToUpperCase(result);
		
		myLogger.info("====>NEW result: " + result);
	}
	
	@AfterThrowing(
			pointcut = "execution(* com.vkopendoh.aopdemo.dao.AccountDAO.findAccounts(..))",
			throwing = "exception"
			)
	public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exception) {
		myLogger.info("\n===> @AfterThrowing on method we are advising: " + joinPoint.getSignature().toShortString());
		
		myLogger.info("===>Send SMS to DevOps - here is exception happens: " + exception);
		
	}
	
	@After("execution(* com.vkopendoh.aopdemo.dao.AccountDAO.findAccounts(..))")
	public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
		
		myLogger.info("\n===> @After (finally) on method we are advising: " + joinPoint.getSignature().toShortString());
		
		
	}
	
	@Around("execution(* com.vkopendoh.aopdemo.service.*.getFortune(..))")
	public Object aroundGetFortuneAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		myLogger.info("\n===> @Around on method we are advising: " + proceedingJoinPoint.getSignature().toShortString());
		
		//get begin timestamp
		long begin = System.currentTimeMillis();
		
		//exec method
		Object result = null;
		
		try {
			result =  proceedingJoinPoint.proceed();
		}catch(Exception e) {
			//log the exception
			myLogger.warning(e.getMessage());
			
			//give user custom message
			result = "Bad accident, but don't worry help on the way!";
		}
		
		
		//get end timestamp
		long end = System.currentTimeMillis();
		
		//duration
		long duration = end - begin;
		myLogger.info("\n====> Duration: " + duration/1000.0 + " seconds");		
		
		return result;
	}

	private void convertNameToUpperCase(List<Account> result) {
		for(Account account:result) {
			account.setName(account.getName().toUpperCase());			
		}
	}
}
