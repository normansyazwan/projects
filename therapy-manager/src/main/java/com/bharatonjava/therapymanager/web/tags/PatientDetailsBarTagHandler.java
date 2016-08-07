package com.bharatonjava.therapymanager.web.tags;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import com.bharatonjava.therapymanager.domain.Patient;

public class PatientDetailsBarTagHandler  extends SimpleTagSupport {

	private Patient patient;
	
	public Patient getPatient() {
		return patient;
	}
	
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	@Override
	public void doTag() throws JspException, IOException {

		try {
			
			PageContext context = (PageContext) getJspContext();
			//JspWriter out = getJspContext().getOut();
			context.getRequest().setAttribute("patient", patient);
			context.include("/WEB-INF/views/patient/patientDetailsTag.jsp", true);
		} catch (Exception e) {

		}
	}
	
}
