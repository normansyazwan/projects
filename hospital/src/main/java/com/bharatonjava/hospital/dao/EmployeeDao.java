package com.bharatonjava.hospital.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.Employee;

@Repository
public class EmployeeDao implements IEmployeeDao{


	private static final Logger log = LoggerFactory.getLogger(EmployeeDao.class);

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	
	@Override
	public Long saveEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		Long employeeId = (Long) session.save(employee);
		log.info("Employee saved in database with employeeId: {}", employeeId);
		return employeeId;
	}
	
	@Override
	public List<Employee> getAllEmployees(){
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		return employees;
	}

	public Employee getEmployeeById(Long employeeId){
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		return employee;
	}
	
}
