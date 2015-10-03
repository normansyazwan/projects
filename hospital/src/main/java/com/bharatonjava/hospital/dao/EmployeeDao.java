package com.bharatonjava.hospital.dao;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.domain.Employee;
import com.bharatonjava.hospital.domain.Person;
import com.bharatonjava.hospital.domain.User;

@Repository
public class EmployeeDao implements IEmployeeDao {

	private static final Logger log = LoggerFactory
			.getLogger(EmployeeDao.class);

	private SessionFactory sessionFactory;
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

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

		try {

			this.jdbcTemplate.getDataSource().getConnection()
					.setAutoCommit(false);

			String sql = "SELECT * FROM users u left join authorities a on u.username = a.username where u.username = ?";

			user = (User) this.jdbcTemplate.query(sql,
					new UserResultSetExtractor(), new Object[] { username });

			log.info("Got user {}", user);

			// this.jdbcTemplate.getDataSource().getConnection().commit();

		} catch (SQLException e) {

			log.error("exception occured while getting user ({}) information.",
					username, e);
			/*
			 * try {
			 * this.jdbcTemplate.getDataSource().getConnection().rollback(); }
			 * catch (SQLException e1) { log.error("Exception in rollback", e1);
			 * }
			 */

		}
		return user;
	}
}
