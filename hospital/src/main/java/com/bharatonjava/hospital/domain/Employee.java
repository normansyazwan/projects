package com.bharatonjava.hospital.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="EMPLOYEE")
@PrimaryKeyJoinColumn(name = "EMPLOYEE_ID", referencedColumnName = "PERSON_ID")
public class Employee extends Person{

	private String designation;
	private String salary;
	private Date dateOfJoining;
	private Date dateOfRelieving;
	private String comments;
	
	public Employee() {
	}
	
	@Column(name = "DESIGNATION", length = 100)
	public String getDesignation() {
		return designation;
	}
	
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	@Column(name = "SALARY", nullable = true, precision = 10, scale = 2)
	public String getSalary() {
		return salary;
	}
	
	public void setSalary(String salary) {
		this.salary = salary;
	}
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "DATE_OF_JOINING")
	public Date getDateOfJoining() {
		return dateOfJoining;
	}
	
	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "DATE_OF_RELIEVING")
	public Date getDateOfRelieving() {
		return dateOfRelieving;
	}
	
	public void setDateOfRelieving(Date dateOfRelieving) {
		this.dateOfRelieving = dateOfRelieving;
	}
	
	
	@Column(name = "COMMENTS", length = 500)
	public String getComments() {
		return comments;
	}
	
	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "Employee [designation=" + designation + ", salary=" + salary
				+ ", dateOfJoining=" + dateOfJoining + ", dateOfRelieving="
				+ dateOfRelieving + ", comments=" + comments + "]";
	}
	
}
