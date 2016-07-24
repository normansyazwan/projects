package com.bharatonjava.therapymanager.web.patient;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bharatonjava.therapymanager.domain.Assesment;
import com.bharatonjava.therapymanager.domain.HospitalEnum;
import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.domain.Prescription;
import com.bharatonjava.therapymanager.services.PatientService;
import com.bharatonjava.therapymanager.utils.Constants;

@Controller
@RequestMapping(value = "/patients")
public class PatientController {

	private static final Logger logger = LoggerFactory
			.getLogger(PatientController.class);

	private PatientValidator patientValidator;
	private PatientService patientService;
	private AssesmentValidator assesmentValidator;

	@Autowired
	public void setPatientValidator(PatientValidator patientValidator) {
		this.patientValidator = patientValidator;
	}

	@Autowired
	public void setPatientService(PatientService patientService) {
		this.patientService = patientService;
	}
	
	@Autowired
	public void setAssesmentValidator(AssesmentValidator assesmentValidator) {
		this.assesmentValidator = assesmentValidator;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// CONVERT empty date to null
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_FORMAT_SLASHED);
		dateFormat.setLenient(false);
		// true passed to CustomDateEditor constructor means convert empty
		// String to null
		/*
		 * binder.registerCustomEditor(LocalDate.class, new CustomDateEditor(
		 * dateFormat, true));
		 */
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				new SimpleDateFormat("dd/MM/yyyy"), true, 10));
	}

	@ExceptionHandler(Exception.class)
	public String defaultExceptionHandler(Exception ex) {
		logger.error("Exception occured in PatientController. ", ex);
		return "error";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView registerPatient() {

		ModelAndView mav = new ModelAndView();
		Patient patient = new Patient();

		List<HospitalEnum> bloodGroups = this.patientService.getBloodGroups();

		logger.info("bloodGroups : {} ", bloodGroups);
		mav.addObject("patient", patient);
		mav.addObject("bloodGroups", bloodGroups);

		mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);

		return mav;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerPatientHandler(
			@ModelAttribute("patient") Patient patient, BindingResult result,
			ModelMap model) {

		logger.info("Inside registerPatientHandler() : {}", patient);
		ModelAndView mav = new ModelAndView();

		patientValidator.validate(patient, result);

		if (result.hasErrors()) {
			logger.debug("Errors in paient form:  {} ", result.getAllErrors());
			// for blood group drop down
			List<HospitalEnum> bloodGroups = this.patientService
					.getBloodGroups();
			mav.addObject("bloodGroups", bloodGroups);
			mav.addObject("patient", patient);
			mav.setViewName(Constants.VIEW_PATIENT_REGISTER_FORM);
			return mav;
		}

		Long patientId = patientService.registerNewPatient(patient);
		model.addAttribute("insertStatus", "success");
		mav.setViewName("redirect:/patients/" + patientId + "/profile");
		return mav;
	}

	
	@RequestMapping(value = "/{patientId}/profile", method = RequestMethod.GET)
	public ModelAndView patientProfile(@PathVariable("patientId") Long patientId) {

		Patient patient = this.patientService.getPatientById(patientId);

		ModelAndView mav = new ModelAndView();
		mav.addObject("patient", patient);
		mav.setViewName(Constants.VIEW_PATIENT_PROFILE);
		return mav;
	}

	
	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String preparePatientEditForm(@PathVariable("id") Long patientId,
			Model model) {

		Patient patient = patientService.getPatientById(patientId);
		List<HospitalEnum> bloodGroups = this.patientService.getBloodGroups();
		model.addAttribute("bloodGroups", bloodGroups);
		model.addAttribute("patient", patient);
		return Constants.VIEW_PATIENT_REGISTER_FORM;

	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.POST)
	public String processPatientEditForm(
			@ModelAttribute("patient") Patient patient,
			@PathVariable("id") Long patientId, BindingResult result,
			ModelMap model) {

		logger.info("patient update: {}", patient);
		
		if (patientId != null && patientId > 0L && patientId.equals(patient.getPatientId())) {
			patientService.updatePatient(patient);
			patient = null;
			patient = this.patientService.getPatientById(patientId);
		} else {
			logger.error(
					"Unexpected value of patientId in URL in patient edit form: {} and patient record was {}",
					patientId, patient);
			List<HospitalEnum> bloodGroups = this.patientService.getBloodGroups();
			model.addAttribute("bloodGroups", bloodGroups);
			model.addAttribute("patient", patient);
			return Constants.VIEW_PATIENT_REGISTER_FORM;
		}

		
		model.addAttribute("patient", patient);
		return Constants.VIEW_PATIENT_PROFILE;

	}

	/**
	 * Displays new prescription form
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/{id}/prescription", method = RequestMethod.GET)
	public String showPrescriptionForm(
			@PathVariable("id") Long id,
			@RequestParam(value = "prescriptionId", defaultValue = "0", required = false) Long prescriptionId,
			@RequestParam(value = "action", defaultValue = Constants.ACTION_NEW, required = false) String action,
			Model model) {

		logger.info("showPrescriptionForm: action = {}", action);

		if (action == null || action.equals(Constants.ACTION_NEW)) {

			Patient patient = patientService.getPatientById(id);
			model.addAttribute("patient", patient);
			model.addAttribute("prescription", new Prescription());

		} else if (action != null && action.equals(Constants.ACTION_EDIT)) {

			Prescription prescription = patientService
					.getPrescription(prescriptionId);
			model.addAttribute("prescription", prescription);
			Patient patient = patientService.getPatientById(prescription
					.getPatientId());
			model.addAttribute("patient", patient);

		}

		return Constants.VIEW_PATIENT_PRESCRIPTION_FORM;
	}

	
	@RequestMapping(value = "/{id}/assesment", method = RequestMethod.GET)
	public String showAssesmentForm(
			@PathVariable("id") Long patientId,
			@RequestParam(value = "assesmentId", defaultValue = "0", required = false) Long assesmentId,
			@RequestParam(value = "action", defaultValue = Constants.ACTION_NEW, required = false) String action,
			Model model) {

		logger.info("assesmentId: action = {}", action);
		Assesment assesment = new Assesment();
		model.addAttribute("assesment", assesment);

		return Constants.VIEW_PATIENT_ASSESMENT_FORM;
	}
	
	
	@RequestMapping(value = "/{id}/assesment", method = RequestMethod.POST)
	public String processAssesmentForm(
			@ModelAttribute("assesment") Assesment assesment,
			@PathVariable("id") Long patientId,
			@RequestParam(value = "assesmentId", defaultValue = "0", required = false) Long assesmentId,
			@RequestParam(value = "action", defaultValue = Constants.ACTION_NEW, required = false) String action,
			Model model, BindingResult result) {

		logger.info("assesmentId: action = {}", action);
		logger.info("patientId:{}, assesment: {}", patientId, assesment);
		
		assesmentValidator.validate(assesment, result);
		
		if (result.hasErrors()) {
			logger.info("Errors in assesment form:  {} ", result.getAllErrors());
			return Constants.VIEW_PATIENT_ASSESMENT_FORM;
		}
		// save assessment record to database and send user to add treatment page.
		assesment.setPatientId(patientId);
		Long persistedAssesmentId = patientService.createNewAssesment(assesment);
		logger.info("Assesment saved with assesmentId:{}", persistedAssesmentId);
		
		return "redirect:/patients/"+patientId+"/treatment";
	}
	
	
	@RequestMapping(value = "/{id}/treatment", method = RequestMethod.GET)
	public ModelAndView patientTreatmentForm(
			@PathVariable("id") Long patientId,
			ModelAndView mav, BindingResult result) {
		
		// fetch patient
		Patient p = patientService.getPatientById(patientId);
		mav.addObject("patient", p);
		
		// fetch active assessments
		List<Assesment> assesments = this.patientService.getAssessmentsForPatient(patientId, true);
		mav.addObject("assesments", assesments);
		
		mav.setViewName(Constants.VIEW_PATIENT_TREATMENT_VIEW);
		
		return mav;
	
	
	}
	
}
