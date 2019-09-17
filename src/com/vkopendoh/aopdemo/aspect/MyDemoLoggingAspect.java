package com.vkopendoh.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.vkopendoh.aopdemo.Account;

@Aspect
@Component
@Order(-23)
public class MyDemoLoggingAspect {
	//this is where we add all of our advices for logging
	
	//start with @Before advice
	@Before("com.vkopendoh.aopdemo.aspect.LuvAopExp.forDaoPackage()")
	public void beforeAddAccountAdvice(JoinPoint joinPoint) {
		System.out.println("\n====>>> Executing @Before MyDemoLogging order -23 advice on com.vkopendoh.aopdemo.dao package...");
		
		//display method signature
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		System.out.println("====>Method: "+ methodSignature);
		
		//display method args
		Object[] args = joinPoint.getArgs();
		
		for(Object argument:args) {
			if(argument instanceof Account) {
				Account account = (Account) argument;
				System.out.println("====>Account name: " + account.getName() + " Level: " + account.getLevel());
			} else {
				System.out.println("====>Argument: " + argument);
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
		
		System.out.println("\n====> Exec @AfterReturning on method: " + method);		
		
		System.out.println("====>Result: " + result);
		
		//modify returning data
		
		convertNameToUpperCase(result);
		
		System.out.println("====>NEW result: " + result);
	}

	private void convertNameToUpperCase(List<Account> result) {
		for(Account account:result) {
			account.setName(account.getName().toUpperCase());			
		}
	}
}
