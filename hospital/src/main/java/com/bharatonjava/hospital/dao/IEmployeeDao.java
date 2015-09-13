package com.bharatonjava.hospital.dao;

import java.util.List;

import com.bharatonjava.hospital.domain.Employee;

public interface IEmployeeDao {

	public Long saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long employeeId);
	
}
