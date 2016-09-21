package com.bharatonjava.web;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value="/profile")
public class ProfileController {

	private static final Logger logger = LoggerFactory.getLogger(ProfileController.class);
	
	@RequestMapping(value = "/{profileId}")
	public ModelAndView showProfile(@PathVariable("profileId") String profileId, ModelAndView mav){
		
		return mav;
	}
	
	@RequestMapping(value = {"/registration","/new"}, method = RequestMethod.GET)
	public ModelAndView showProfileForm(ModelAndView mav){
		logger.info("Inside showProfileForm method");
		
		mav.setViewName("profile.registration");
		return mav;
	}
	
}
