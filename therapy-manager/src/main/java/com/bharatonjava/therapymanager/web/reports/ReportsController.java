package com.bharatonjava.therapymanager.web.reports;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.therapymanager.services.ReportService;
import com.bharatonjava.therapymanager.utils.Constants;

@Controller
@RequestMapping(value = "/reports")
public class ReportsController {
	
	private ReportService reportService;
	
	@Autowired
	public void setReportService(ReportService reportService) {
		this.reportService = reportService;
	}
	
	@RequestMapping(value = "/dailyEarnings", method = RequestMethod.GET)
	public ModelAndView getDailyEarningsReport(){
		ModelAndView mav  = new ModelAndView();
		
		mav.addObject("dailyEarnings", this.reportService.getDailyEarnings());
		
		mav.setViewName(Constants.VIEW_DAILY_EARNINGS);
		return mav;
	}
}
