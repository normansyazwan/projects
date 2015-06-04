package com.bharatonjava.hospital.web.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bharatonjava.hospital.domain.Patient;

@Component
public class PatientValidator implements Validator{

	@Override
	public boolean supports(Class<?> patient) {
		return Patient.class.isAssignableFrom(patient);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "fieldIsRequired");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dateOfBirth", "dateOfBirthIsRequired");
		// TODO: more validation to be added here
	}

}
