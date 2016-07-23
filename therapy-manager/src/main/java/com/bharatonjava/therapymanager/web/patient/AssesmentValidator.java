package com.bharatonjava.therapymanager.web.patient;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bharatonjava.therapymanager.domain.Assesment;

@Component(value="assesmentValidator")
public class AssesmentValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> clazz) {
		return Assesment.class.isAssignableFrom(clazz);
		
	}
	
	@Override
	public void validate(Object assesment, Errors err) {
		
		Assesment a = null;
		if(assesment instanceof Assesment){
			a = (Assesment) assesment;
		}
		
		if(StringUtils.isBlank(a.getPresentCondition())){
			err.rejectValue("presentCondition", "assesment.presentCondition.blank",
					"Present Condition is required");
		}
		
		if(StringUtils.isBlank(a.getDuration())){
			err.rejectValue("duration", "assesment.duration.blank",
					"Duration is required");
		}
		
		if(StringUtils.isBlank(a.getTherapyPlan())){
			err.rejectValue("therapyPlan", "assesment.therapyPlan.blank",
					"Therapy Plan is required");
		}
	}

	

}
