package com.bharatonjava.therapymanager.aop;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class LoggingAspect {

	private static final Logger logger = LoggerFactory.getLogger(LoggingAspect.class);
	
	@Before("execution(* com.bharatonjava.therapymanager.web..*(..))")
	public void logAfter(JoinPoint joinPoint) {

		Object[] args = joinPoint.getArgs();
		String argsString = "";
		for(Object o : args){
			argsString = argsString + o + ", ";
		}
		if(StringUtils.isBlank(argsString)){
			logger.info("Executing METHOD {}", joinPoint.getSignature().getName());
		}else{
			logger.info("Executing METHOD {} WITH ARGS: {}", joinPoint.getSignature().getName(), argsString );
		}
		
	}
}