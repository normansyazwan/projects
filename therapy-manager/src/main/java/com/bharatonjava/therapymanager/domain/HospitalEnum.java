package com.bharatonjava.therapymanager.domain;

public class HospitalEnum {

	private Long enumId;
	private String enumGroup;
	private String enumValue;
	
	public HospitalEnum() {
	}

	public Long getEnumId() {
		return enumId;
	}

	public void setEnumId(Long enumId) {
		this.enumId = enumId;
	}

	public String getEnumGroup() {
		return enumGroup;
	}

	public void setEnumGroup(String enumGroup) {
		this.enumGroup = enumGroup;
	}

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
