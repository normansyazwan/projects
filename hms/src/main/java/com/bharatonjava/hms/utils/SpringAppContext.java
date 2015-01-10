package com.bharatonjava.hms.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class SpringAppContext implements ApplicationContextAware{

	private static ApplicationContext  applicationContext;
	
	public SpringAppContext() {
		System.out.println("-------------------Application Context intiailized..");
	}
	
	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		applicationContext = context;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

}
