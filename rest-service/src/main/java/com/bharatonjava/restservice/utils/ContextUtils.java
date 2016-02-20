package com.bharatonjava.restservice.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ContextUtils implements ApplicationContextAware{

	private static final Logger log = LoggerFactory
			.getLogger(ContextUtils.class);
	private static ApplicationContext applicationContext;
	
	@Override
	public void setApplicationContext(ApplicationContext localApplicationContext)
			throws BeansException {
		applicationContext = localApplicationContext;
		log.info("Spring Context is set in ContextUtils");
	}
	
	public static Object getBean(String name){
		return applicationContext.getBean(name);
	}

}
