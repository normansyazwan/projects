package com.bharatonjava.elite.domain;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "PATIENT")
public class Patient {

	private Long patientId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;
	private String bloodGroup;
	private String email;
	private String mobile;
	private String phone;

	private Address address;

	public Patient() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="PATIENT_ID")
	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	@Column(name="FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="GENDER")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	@Column(name="DOB")
	@Temporal(value = TemporalType.DATE)
	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Column(name="BLOOD_GROUP")
	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="MOBILE", length = 10)
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	@Column(name="PHONE")
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinColumn(name= "ADDRESS_ID" )
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Transient
	public int getAge() {

		Date d = this.getDateOfBirth();
		int age = 0;

		if (d != null) {

			Calendar dob = Calendar.getInstance();
			dob.setTime(d);
			Calendar today = Calendar.getInstance();

			age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
			if (today.get(Calendar.MONTH) < dob.get(Calendar.MONTH)) {
				age--;
			} else if (today.get(Calendar.MONTH) == dob.get(Calendar.MONTH)
					&& today.get(Calendar.DAY_OF_MONTH) < dob
							.get(Calendar.DAY_OF_MONTH)) {
				age--;
			}
		}

		return age;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender
				+ ", dateOfBirth=" + dateOfBirth + ", bloodGroup=" + bloodGroup
				+ ", email=" + email + ", mobile=" + mobile + ", phone="
				+ phone + ", address=" + address + "]";
	}

}
