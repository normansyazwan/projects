package com.bharatonjava.therapymanager.web.patient;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.utils.Constants;

public class PatientValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	@Override
	public boolean supports(Class<?> clazz) {
		return Patient.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object patient, Errors err) {
		Patient p = null;
		if (patient instanceof Patient) {
			p = (Patient) patient;

			if (StringUtils.isBlank(p.getFirstName())) {
				err.rejectValue("firstName", "patient.firstName.blank",
						"First Name is required");
			}

			if (StringUtils.isBlank(p.getGender())) {
				err.rejectValue("gender", "patient.gender.blank",
						"Gender is required");
			}

			if (p.getDob() == null) {
				err.rejectValue("dob", "patient.dob.null",
						"Date of Birth is required");
			} else if (p.getDob().after(new Date())) {
				err.rejectValue("dob", "user.dob.future",
						"Date of Birth should be in the past");
			}

			if (StringUtils.isNotBlank(p.getMobile())) {
				if (p.getMobile().length() != 10) {
					err.rejectValue("mobile", "patient.mobile.invalid",
							"Mobile number should be 10 digit");
				} else if (!StringUtils.isNumeric(p.getMobile())) {
					err.rejectValue("mobile", "patient.mobile.notnumeric",
							"Mobile number should contain numbers only");
				}
			}

			// if email is provided, then validate it
			if (StringUtils.isNotBlank(p.getEmail())) {
				pattern = Pattern.compile(Constants.EMAIL_PATTERN);
				matcher = pattern.matcher(p.getEmail());
				if (!matcher.matches()) {
					err.rejectValue("email", "email.incorrect",
							"Incorrect email");
				}
			}

		}

	}

}
