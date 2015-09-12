package com.bharatonjava.hospital.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bharatonjava.hospital.dao.IEmployeeDao;
import com.bharatonjava.hospital.domain.Employee;

@Service
public class EmployeeService {

	@Autowired
	private IEmployeeDao employeeDao;
	
	public void setEmployeeDao(IEmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}
	
	@Transactional
	public Long saveEmployee(Employee employee){
		return this.employeeDao.saveEmployee(employee);
	}
}
