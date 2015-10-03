package com.bharatonjava.hospital.utils;

public interface Constants {

	String PATIENTS_PAGE = "patients";
	String PATIENT_PROFILE_PAGE = "patientProfile";
	String PATIENT_REGISTRATION_PAGE = "patientRegistration";
	
	Long PAGE_SIZE = 20L;
	
	String DATE_FORMAT = "dd-MM-yyyy";
	String DATE_FORMAT_SLASHED = "dd/MM/yyyy";
	int MAX_SEARCH_RESULTS = 20;
	int DEFAULT_PATIENT_VISIT_STATS_DAYS = 30;
	
	
	String VIEW_PATIENT_DAILY_VISIT_STATS = "dailyVisitStats";
	String VIEW_PRESCRIPTION_DETAILS = "prescriptionDetailsView";
	
	String VIEW_NEW_EMPLOYEE_FORM = "newEmployeeForm";
	String VIEW_LIST_EMPLOYEES = "employees";
	String VIEW_EDIT_EMPLOYEE = "editEmployee";
	String VIEW_DELETE_EMPLOYEE = "deleteEmployee";
	String VIEW_EMPLOYEE_PROFILE = "viewEmployeeProfile";
	
	String VIEW_SHOW_EMPLOYEE_ACCESS_PAGE = "employeeAccess";
	
	
	
	String ACTION_NEW = "new";
	String ACTION_VIEW = "view";
	String ACTION_EDIT = "edit";
	String ACTION_DELETE = "delete";
	String ACTION_UPDATE = "update";
	String ACTION_INSERT = "insert";
	String ACTION_LIST = "list";
	
	String PHASE_STAGE = "stage";
	String PHASE_CONFIRM = "confirm";
	String PHASE_CANCEL = "cancel";
	
	String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"  
			   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"; 
}
