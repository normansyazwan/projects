package com.bharatonjava.hospital.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HOSPITAL_ENUMS")
public class HospitalEnum {
	
	private Long enumId;
	private String enumGroup;
	private String enumValue;
	
	public HospitalEnum() {
	}

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ENUM_ID")
	public Long getEnumId() {
		return enumId;
	}

	public void setEnumId(Long enumId) {
		this.enumId = enumId;
	}

	@Column(name = "ENUM_GROUP")
	public String getEnumGroup() {
		return enumGroup;
	}

	public void setEnumGroup(String enumGroup) {
		this.enumGroup = enumGroup;
	}

	@Column(name = "ENUM_VALUE")
	public String getEnumValue() {
		return enumValue;
	}

	public void setEnumValue(String enumValue) {
		this.enumValue = enumValue;
	}

	@Override
	public String toString() {
		return "HospitalEnum [enumId=" + enumId + ", enumGroup=" + enumGroup
				+ ", enumValue=" + enumValue + "]";
	}
	
}
