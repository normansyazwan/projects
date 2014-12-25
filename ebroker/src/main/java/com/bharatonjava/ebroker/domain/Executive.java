package com.bharatonjava.ebroker.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EXECUTIVES")
public class Executive {
	
	private Long executiveId;
	private String executiveName;
	private String phoneNo;
	private String mobileNo;
	private String email;
	private String address;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EXECUTIVE_ID")
	public Long getExecutiveId() {
		return executiveId;
	}

	@Column(name = "NAME")
	public String getExecutiveName() {
		return executiveName;
	}

	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}

	@Column(name = "PHONE_NO")
	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	@Column(name = "MOBILE_NO")
	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ADDRESS")
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setExecutiveId(Long executiveId) {
		this.executiveId = executiveId;
	}

	@Override
	public String toString() {
		return "Executive [executiveId=" + executiveId + ", executiveName="
				+ executiveName + ", phoneNo=" + phoneNo + ", mobileNo="
				+ mobileNo + ", email=" + email + ", address=" + address + "]";
	}
	
}
