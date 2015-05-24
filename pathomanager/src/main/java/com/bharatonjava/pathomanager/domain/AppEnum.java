package com.bharatonjava.pathomanager.domain;

public class AppEnum {

	private long enumId;
	private String enumGroup;
	private String enumValue;
	
	public AppEnum() {
	
	}

	public AppEnum(long enumId, String enumGroup, String enumValue) {
		super();
		this.enumId = enumId;
		this.enumGroup = enumGroup;
		this.enumValue = enumValue;
	}

	public long getEnumId() {
		return enumId;
	}

	public void setEnumId(long enumId) {
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
		return "Enums [enumId=" + enumId + ", enumGroup=" + enumGroup
				+ ", enumValue=" + enumValue + "]";
	}
}
