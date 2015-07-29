package com.bharatonjava.hospital.web.validators;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bharatonjava.hospital.domain.Patient;

@Component
public class PatientValidator implements Validator{

	
	private static final Logger log = LoggerFactory.getLogger(PatientValidator.class);
	
	@Override
	public boolean supports(Class<?> patient) {
		return Patient.class.isAssignableFrom(patient);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Patient p = null;
		if(target instanceof Patient){
			p = (Patient) target;
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "fieldIsRequired","First Name is required.");
		
		if(p.getGender() == null || !(p.getGender().equals("Male") || p.getGender().equals("Female"))){
			errors.rejectValue("gender", "patient.gender.required", "Please select Gender");
		}
		
		if(p.getDateOfBirth() == null)
		{
			errors.rejectValue("dateOfBirth", "patient.dob.null", "Date of Birth is required.");
		}else if (p.getDateOfBirth().after(new Date())){
			errors.rejectValue("dateOfBirth", "patient.dob.future", "Date of Birth should be in the past.");
		}
		
		if(p.getMobile() != null && p.getMobile().trim().length() != 0){
			if(p.getMobile().matches("\\d+") || p.getMobile().length() != 10){
				errors.rejectValue("mobile", "patient.mobile", "Mobile number should be 10 digit");
			}
		}
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "dateOfBirthIsRequired");
		// TODO: more validation to be added here
	}

}
