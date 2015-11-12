package com.bharatonjava.hospital.web;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import com.bharatonjava.hospital.domain.Authority;
import com.bharatonjava.hospital.domain.Employee;
import com.bharatonjava.hospital.services.EmployeeService;
import com.bharatonjava.hospital.utils.Constants;
import com.bharatonjava.hospital.web.validators.EmployeeValidator;

@Controller
public class EmployeeController {

	private static final Logger log = LoggerFactory
			.getLogger(EmployeeController.class);

	private EmployeeValidator employeeValidator;
	private EmployeeService employeeService;
	
	@Value(value = "")
	private String availableEntiltements;

	public void setAvailableEntiltements(String availableEntiltements) {
		this.availableEntiltements = availableEntiltements;
	}
	
	
	@Autowired
	public void setEmployeeValidator(EmployeeValidator employeeValidator) {
		this.employeeValidator = employeeValidator;
	}

	@Autowired
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		// CONVERT empty date to null
		SimpleDateFormat dateFormat = new SimpleDateFormat(
				Constants.DATE_FORMAT_SLASHED);
		dateFormat.setLenient(false);
		// true passed to CustomDateEditor constructor means convert empty
		// String to null
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));

	}

	@ExceptionHandler(Exception.class)
	public String defaultExceptionHandler(Exception ex) {
		log.error("Exception occured in PatientController. ", ex);
		return "error";
	}

	/**
	 * List all Employees in hospital
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public String listEmployees(Model model) {

		List<Employee> employees = this.employeeService.getAllEmployees();
		model.addAttribute("employees", employees);
		return Constants.VIEW_LIST_EMPLOYEES;
	}

	/**
	 * Show Employee registration form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/employee/new", method = RequestMethod.GET)
	public String showNewEmployeeForm(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return Constants.VIEW_NEW_EMPLOYEE_FORM;
	}

	/**
	 * Process employee registration form
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/employee/new", method = RequestMethod.POST)
	public String processNewEmployeeForm(
			@ModelAttribute("employee") Employee employee,
			BindingResult result, ModelMap model) {

		log.info("Employee: {}", employee);

		employeeValidator.validate(employee, result);
		if (result.hasErrors()) {
			log.info("Errors:  {} ", result.getAllErrors());
			return Constants.VIEW_NEW_EMPLOYEE_FORM;
		}
		// save employee to database
		Long employeeId = this.employeeService.saveEmployee(employee);
		model.addAttribute("employeeId", employeeId);
		return "redirect:/" + Constants.VIEW_LIST_EMPLOYEES;
	}

	/**
	 * Show employee profile
	 * 
	 * @param employeeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public String viewEmployeeProfile(@PathVariable("id") Long employeeId,
			Model model) {
		Employee employee = this.employeeService.getEmployeeById(employeeId);
		model.addAttribute("employee", employee);
		return Constants.VIEW_EMPLOYEE_PROFILE;
	}

	/**
	 * Delete employee
	 * 
	 * @param employeeId
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.GET)
	public String listEmployees(@PathVariable("id") Long employeeId, Model model) {

		return Constants.VIEW_LIST_EMPLOYEES;
	}

	@RequestMapping(value = "/employee/edit/{id}", method = RequestMethod.GET)
	public String editEmployee(@PathVariable("id") Long employeeId, Model model) {

		return Constants.VIEW_LIST_EMPLOYEES;
	}

	@RequestMapping(value = "/employee/access", method = RequestMethod.GET)
	public String showEmployeeAccessForm(Model model) {
		log.info("Came here to setup access.");

		/*
		 * get list of all employees with id, name, and designation to show in
		 * dropdown. user then selects one employee and we display form for
		 * setting that employee's access.
		 */
		
		List<Object[]> employees = this.employeeService.getEmployeesForDropdown();
		
		model.addAttribute("employees", employees);
		
		// check if this is a valid employee
		
		return Constants.VIEW_SHOW_EMPLOYEE_ACCESS_PAGE;
	}
	
	@RequestMapping(value = "/employee/access", method = RequestMethod.POST)
	public String processEmployeeAccessForm(Model model, Long personId) {
		log.info("inside processEmployeeAccessForm method");

		Map<String, Object> map = model.asMap();
		log.info("personId: "+ personId);
		for(String key: map.keySet()){
			log.info("{key} = {}", key, map.get(key));
		}
		
		List<Object[]> employees = this.employeeService.getEmployeesForDropdown();
		
		model.addAttribute("employees", employees);
		model.addAttribute("selected", personId);
		
		// check if this is a valid employee
		Employee employee = this.employeeService.getEmployeeById(personId);
		
		List<Authority> authorities = this.employeeService.getAuthorities(employee.getEmail());
		model.addAttribute("authorities", authorities);
		
		return Constants.VIEW_SHOW_EMPLOYEE_ACCESS_PAGE;
	}
}
