package com.bharatonjava.gang.web.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static com.bharatonjava.gang.utils.Constants.VIEW_HOMEPAGE;

@Controller
public class HomeController {

	@RequestMapping(method = RequestMethod.GET, path = "/")
	public String showHomePage(){
		return VIEW_HOMEPAGE;
	}
}
