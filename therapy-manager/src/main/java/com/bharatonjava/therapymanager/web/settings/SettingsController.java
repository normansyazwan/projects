package com.bharatonjava.therapymanager.web.settings;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.domain.Treatment;
import com.bharatonjava.therapymanager.services.SettingsService;
import com.bharatonjava.therapymanager.utils.Constants;

@Controller
@RequestMapping(value = "/settings")
public class SettingsController {

	private static final Logger logger = LoggerFactory.getLogger(SettingsController.class);
	
	private SettingsService settingsService;
	
	@Autowired
	public void setSettingsService(SettingsService settingsService) {
		this.settingsService = settingsService;
	}
	
	public SettingsController() {
	}
	
	@RequestMapping(value = "/treatments", method = RequestMethod.GET)
	public ModelAndView prepareTreatmentsScreen(
			@RequestParam(name = "action", required = false, defaultValue = "") String action,
			@RequestParam(name = "treatmentId", required = false, defaultValue = "0") Long treatmentId) {

		ModelAndView mav = new ModelAndView();
		mav.addObject("treatments", this.settingsService.getAllTreatments());
		mav.setViewName(Constants.VIEW_SETTINGS_TREATMENTS);

		// edit
		logger.info("action={}, treatmentId={}", action, treatmentId);
		Treatment t = null;
		if(StringUtils.isNotBlank(action) && action.equals("edit") && treatmentId > 0){
			t = this.settingsService.getTreatment(treatmentId);
			mav.addObject("t", t);
		}else{
			mav.addObject("t", new Treatment());
		}
		
		
		return mav;
	}

	
	@RequestMapping(value = "/treatments", method = RequestMethod.POST)
	public ModelAndView processTreatmentsScreen(
			@RequestParam(name = "action", required = false, defaultValue = "") String action,
			@RequestParam(name = "treatmentId", required = false, defaultValue = "0") Long treatmentId,
			@ModelAttribute("t") Treatment treatment, BindingResult result) {

		logger.info("action={}, treatmentId={}", action, treatmentId);
		logger.info("Updating: {}", treatment);
		ModelAndView mav = new ModelAndView();

		
		if(treatment != null && treatment.getTreatmentId() != null && treatment.getTreatmentId() > 0L){
			// this is an edit request
			int count = this.settingsService.updateTreatment(treatment);
			if(count == 1){
				mav.addObject("action_status_success", "Record updated successfully.");
			}else{
				mav.addObject("action_status_error", "Record could not be updated");
			}
		}else if (treatment != null && (treatment.getTreatmentId() == null || treatment.getTreatmentId() == 0L)){
			// since treatmentId == 0, this is an add request.
			logger.info("Add request");
			treatment.setTreatmentId(this.settingsService.getMaxTreatmentId() + 1L);
			
		}
				
		mav.addObject("treatments", this.settingsService.getAllTreatments());
		
		mav.setViewName("redirect:treatments");
		return mav;
	}
}
