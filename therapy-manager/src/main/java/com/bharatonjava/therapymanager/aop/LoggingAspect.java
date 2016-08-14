package com.bharatonjava.therapymanager.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@After("execution(* com.bharatonjava.therapymanager.web..*(..))")
	public void logAfter(JoinPoint joinPoint) {

		Object[] args = joinPoint.getArgs();
		String argsString = "";
		for(Object o : args){
			argsString = argsString + o + ", ";
		}
		logger.info("Executing METHOD {} WITH ARGS: {}", joinPoint.getSignature().getName(), argsString );

	}
}