package com.bharatonjava.therapymanager.interceptors;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoggingInterceptor implements HandlerInterceptor{

	private static final Logger logger = LoggerFactory.getLogger(LoggingInterceptor.class);
	
	private static Set<String> ipAddresses = new HashSet<String>();
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		// log client's IP address for tracking purpose:
		
		//is client behind something?
		String remoteIp = request.getHeader("X-FORWARDED-FOR");
		if (remoteIp == null) {
			remoteIp = request.getRemoteAddr();
		}
		
		String remoteUser = request.getRemoteUser();
		String remoteHost = request.getRemoteHost();
		
		if(!ipAddresses.contains(remoteIp)){
			ipAddresses.add(remoteIp);
			logger.info("<<<<< REMOTE_USER_DETAILS: IP={}, user={}, host={}", remoteIp, remoteUser, remoteHost);	
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
