package com.bharatonjava.gang.web.user;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.gang.domain.User;
import com.bharatonjava.gang.utils.Constants;


@Controller
@RequestMapping(value = "/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	private UserRegisterationFormValidator userRegisterationFormValidator;
	
	@Autowired
	public void setUserRegisterationFormValidator(
			UserRegisterationFormValidator userRegisterationFormValidator) {
		this.userRegisterationFormValidator = userRegisterationFormValidator;
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    
	    // CONVERT empty date to null
	    SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT_SLASHED);
	    dateFormat.setLenient(false);
	    // true passed to CustomDateEditor constructor means convert empty String to null
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    
	}
	
	
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerUser(){
	
		
		ModelAndView mav = new ModelAndView();
		User user = new User();
		mav.addObject("user", user);
		mav.setViewName(Constants.VIEW_USER_REGISTER_FORM);
		
		return mav;
	}


	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUserHandler(@ModelAttribute("user") User user,
			BindingResult result, ModelMap model){

		logger.info("Inside registerUserHandler() method"); 
		ModelAndView mav = new ModelAndView();
		
		userRegisterationFormValidator.validate(user, result);
		if (result.hasErrors()) {
			logger.info("Errors:  {} ", result.getAllErrors());
			mav.setViewName(Constants.VIEW_USER_REGISTER_FORM);
			return mav;
		}
		
		
		mav.setViewName(Constants.VIEW_USER_REGISTER_FORM);
		return mav;
	}
}
