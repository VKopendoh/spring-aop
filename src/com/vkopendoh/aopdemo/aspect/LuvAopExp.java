package com.vkopendoh.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LuvAopExp {
	//add pointcut declarations
		@Pointcut("execution(* com.vkopendoh.aopdemo.dao.*.*(..))")
		public void forDaoPackage() {}
		
		@Pointcut("execution(* com.vkopendoh.aopdemo.dao.*.get*(..))")
		public void getter() {}
		
		@Pointcut("execution(* com.vkopendoh.aopdemo.dao.*.set*(..))")
		public void setter() {}
		
		@Pointcut("forDaoPackage() && !(getter() || setter())")
		public void forDaoExceptGetAndSet() {}
}
