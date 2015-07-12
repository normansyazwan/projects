package com.bharatonjava.bms.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Employee extends User {
	
	private String designation;
	private Date dateOfJoining;
	private Date dateOfLeaving;
	
	public Employee() {
	}

	@Column(name = "DESIGNATION")
	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	@Column(name = "DATE_OF_JOINING")
	public Date getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Column(name = "DATE_OF_LEAVING")
	public Date getDateOfLeaving() {
		return dateOfLeaving;
	}

	public void setDateOfLeaving(Date dateOfLeaving) {
		this.dateOfLeaving = dateOfLeaving;
	}
	
}
