package com.bharatonjava.hospital.dao;

import java.util.List;

import com.bharatonjava.hospital.domain.Employee;
import com.bharatonjava.hospital.domain.User;

public interface IEmployeeDao {

	public Long saveEmployee(Employee employee);
	
	public List<Employee> getAllEmployees();
	
	public Employee getEmployeeById(Long employeeId);
	
	public List<Object[]> getEmployeesForDropdown();
	
	public User getUserByUsername(String username);
}
