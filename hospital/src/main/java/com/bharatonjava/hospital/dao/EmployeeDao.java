package com.bharatonjava.hospital.dao;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.Authority;
import com.bharatonjava.hospital.domain.Employee;
import com.bharatonjava.hospital.domain.User;

@Repository
public class EmployeeDao implements IEmployeeDao {

	private static final Logger log = LoggerFactory
			.getLogger(EmployeeDao.class);

	private SessionFactory sessionFactory;
	//private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	/*
	@Autowired
	public void setDataSource(DataSource dataSource) {

		this.jdbcTemplate = new JdbcTemplate(dataSource);
		try {
			this.jdbcTemplate.getDataSource().getConnection()
					.setAutoCommit(false);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/

	@Override
	public Long saveEmployee(Employee employee) {
		Session session = this.sessionFactory.getCurrentSession();
		Long employeeId = (Long) session.save(employee);
		log.info("Employee saved in database with employeeId: {}", employeeId);
		return employeeId;
	}

	@Override
	public List<Employee> getAllEmployees() {
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Employee");
		List<Employee> employees = query.list();
		return employees;
	}

	@Override
	public Employee getEmployeeById(Long employeeId) {
		Session session = this.sessionFactory.getCurrentSession();
		Employee employee = (Employee) session.get(Employee.class, employeeId);
		return employee;
	}

	@Override
	public List<Object[]> getEmployeesForDropdown() {
		log.info("Fetching all employees for dropdown.");
		
		Session session = this.sessionFactory.getCurrentSession();
		List<Object[]> emps = null;
		Criteria crit = session.createCriteria(Employee.class);
		crit.setProjection(Projections.projectionList()
				.add(Projections.property("personId")).add(Projections.property("firstName"))
				.add(Projections.property("lastName")).add(Projections.property("designation")));
		crit.addOrder(Order.asc("firstName"));
		emps = crit.list();
		
		for(Object[] arr : emps){
			log.info("Employee: {}", Arrays.toString(arr));
		}
		
		return emps;
	}

	@Override
	public User getUserByUsername(String username) {

		User user = null;
		
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", username));
		user = (User) criteria.uniqueResult();
		
		return user;
	}
	
	/**
	 * Fetches authorites for a given user
	 */
	@Override
	public List<Authority> getAuthorities(String userName) {
		
		log.info("fetching Authorities for username: {}", userName);
		List<Authority> authorities = null;

		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Authority.class);
		criteria.add(Restrictions.eq("authorityId.username", userName));
		authorities = criteria.list();
		
		log.info("Returning {} authorities", authorities != null? authorities.size() : 0);
		
		return authorities;
	}
}
