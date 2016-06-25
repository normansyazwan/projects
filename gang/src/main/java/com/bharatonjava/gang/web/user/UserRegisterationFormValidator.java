package com.bharatonjava.gang.web.user;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.bharatonjava.gang.domain.User;
import com.bharatonjava.gang.utils.Constants;

public class UserRegisterationFormValidator implements Validator {

	private Pattern pattern;
	private Matcher matcher;

	@Override
	public boolean supports(Class<?> arg0) {

		return false;
	}

	@Override
	public void validate(Object user, Errors err) {
		User u = null;
		if (user instanceof User) {
			u = (User) user;
		}

		if (StringUtils.isBlank(u.getFirstName())) {
			err.rejectValue("firstName", "user.firstName.blank",
					"First Name is required");
		}

		if (StringUtils.isBlank(u.getGender())) {
			err.rejectValue("gender", "user.gender.blank", "Gender is required");
		}

		if (u.getDateOfBirth() == null) {
			err.rejectValue("dateOfBirth", "user.dob.null",
					"Date of Birth is required");
		} else if (u.getDateOfBirth().isAfter(LocalDate.now())) {
			err.rejectValue("dateOfBirth", "user.dob.future",
					"Date of Birth should be in the past");
		}

		if (StringUtils.isNotBlank(u.getMobileNumber())) {
			if (u.getMobileNumber().length() != 10) {
				err.rejectValue("mobileNumber", "user.mobile.invalid",
						"Mobile number should be 10 digit");
			}
		}

		// email validation in spring
		if (StringUtils.isNotBlank(u.getEmail())) {
			pattern = Pattern.compile(Constants.EMAIL_PATTERN);
			matcher = pattern.matcher(u.getEmail());
			if (!matcher.matches()) {
				err.rejectValue("email", "email.incorrect", "Incorrect email");
			}
		} else {
			err.rejectValue("email", "email.required", "Email is required");
		}

		// password validation
		if (StringUtils.isBlank(u.getPasswd())) {
			err.rejectValue("passwd", "user.passwd.required",
					"Password is required");
		} else {
			if (u.getPasswd().length() < 8) {
				err.rejectValue("passwd", "user.passwd.length",
						"Password should be atleast 8 character long");
			} else if (StringUtils.isNumeric(u.getPasswd())
					|| StringUtils.isAlpha(u.getPasswd())) {
				err.rejectValue("passwd", "user.passwd.alphanumeric",
						"Password should contain alphabets and digits");
			}
		}

		// locality
		if (StringUtils.isBlank(u.getAddress().getLocality())) {
			err.rejectValue("address.locality", "address.locality.required",
					"Locality is required");
		}
		// state
		if (StringUtils.isBlank(u.getAddress().getState())) {
			err.rejectValue("address.state", "address.state.required",
					"State is required");
		}

	}

}
