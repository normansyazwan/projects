package com.bharatonjava.hospital.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bharatonjava.hospital.domain.BillableItem;
import com.bharatonjava.hospital.domain.BillingRecord;
import com.bharatonjava.hospital.domain.HospitalEnum;
import com.bharatonjava.hospital.domain.Patient;
import com.bharatonjava.hospital.services.BillableItemService;
import com.bharatonjava.hospital.services.EnumService;
import com.bharatonjava.hospital.services.PatientService;
import com.bharatonjava.hospital.utils.Constants;
import com.bharatonjava.hospital.web.validators.PatientValidator;

@Controller
//@RequestMapping(value="/patient")
public class PatientController {

	private static final Logger log = LoggerFactory.getLogger(PatientController.class);
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private PatientValidator patientValidator;
	
	@Autowired
	private EnumService enumService;
	
	@Autowired
	private BillableItemService billableItemService;
	
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	public void setPatientValidator(PatientValidator patientValidator) {
		this.patientValidator = patientValidator;
	}
	
	public void setEnumService(EnumService enumService) {
		this.enumService = enumService;
	}
	
	public void setBillableItemService(BillableItemService billableItemService) {
		this.billableItemService = billableItemService;
	}
	
	@RequestMapping(value="/patient/add", method = RequestMethod.GET)
	public String patientShowForm(Model model){
		Patient patient = new Patient();
		model.addAttribute("patient", patient);
		List<HospitalEnum> hospEnums = this.enumService.getEnumsByGroup("CITY");
		model.addAttribute("hospEnums", hospEnums);
		return "patientRegistration";
	}
	
	/**
	 * This method will handle patient Add and Edit cases
	 * @param model
	 * @param patient
	 * @param errors
	 * @return
	 */
	@RequestMapping(value="/patient/add", method = RequestMethod.POST)
	public String patientSubmit(@ModelAttribute("patient") Patient patient, BindingResult result, ModelMap model){
		log.info("Patient: "+patient);
		Long savedPatientId = 0L;
		int updateCount = 0;
		
		patientValidator.validate(patient, result);
		
		if(result.hasErrors())
		{
			log.info("Errors:  {} ",result.getAllErrors());
			List<HospitalEnum> hospEnums = this.enumService.getEnumsByGroup("CITY");
			model.addAttribute("hospEnums", hospEnums);
			return "patientRegistration";
		}
		
		Long patientId = null;
		if(patient.getPersonId() != null)
		{
			log.info("Updating patient");
			patientService.updatePatient(patient);
		}else{
			log.info("Inserting patient");
			patientId = patientService.savePatient(patient);
		}
		
		model.addAttribute("status", "success");
		model.addAttribute("patientId", patientId);
			
		return "redirect:/patient/add";
	}
	
	/**
	 * Patient profile edit
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/patient/edit/{id}", method = RequestMethod.GET)
	public String preparePatientEditForm(@PathVariable Long id, Model model){
		
		Patient patient = patientService.getPatientById(id);
		List<HospitalEnum> hospEnums = this.enumService.getEnumsByGroup("CITY");
		model.addAttribute("hospEnums", hospEnums);
		model.addAttribute("patient", patient);
		return Constants.PATIENT_REGISTRATION_PAGE;
	}
	
	/**
	 * Patient List
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/patients", method = RequestMethod.GET)
	public String allPatients(Model model){

		model.addAttribute("patients", patientService.getAllPatients());
		
		return "listPatients";
	}

	/**
	 * Patient Profile 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/patients/{id}", method = RequestMethod.GET)
	public String getPatientById(@PathVariable Long id, Model model){
		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);
		return "patientProfile";
	}
	
	/**
	 * handles patient billing
	 */
	@RequestMapping(value="/patient/billing/{id}", method = RequestMethod.GET)
	public String patientBilling(@PathVariable Long id, Model model){

		Patient patient = patientService.getPatientById(id);
		model.addAttribute("patient", patient);
	
		List<BillableItem> billableItems = billableItemService.getBillableItems();
		model.addAttribute("billableItems", billableItems);
		
		BillingForm billingForm = new BillingForm();
		
		BillingRecord br = new BillingRecord();
		BillingRecord br2 = new BillingRecord();
		billingForm.getBillingRecords().add(br);
		billingForm.getBillingRecords().add(br2);
		
		model.addAttribute("billingForm", billingForm);
		
		return "patientBilling";
	}
	
	@RequestMapping(value="/patient/billing/{id}", method = RequestMethod.POST)
	public String processPatientBilling(@ModelAttribute("billingForm") BillingForm billingForm, Long id, BindingResult result, Model model){
		
		log.info("billingForm : "+ billingForm);
		
		return "patientBilling";
	}
	
	/**
	 * Default exception handler 
	 */
	@ExceptionHandler(Exception.class)
	public String defaultExceptionHandler(Exception ex){
		log.error("Exception occured in PatientController. ", ex);
		return "error";
	}
	
	/**
	 * handles ajax request to add a new row in patient billing form
	 */
	@RequestMapping(value = "/ajax/patientBillingFormRow", method = RequestMethod.GET)
	public String getPatientBillingFormRow(){
		
		return "patientBillRowAjaxRequest";
	}

}
