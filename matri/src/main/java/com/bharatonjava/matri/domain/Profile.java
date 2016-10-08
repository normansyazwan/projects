package com.bharatonjava.matri.domain;

import java.util.Date;

public class Profile {

	private Long profileId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String gender;
	private Date dateOfBirth;

	private String maritalStatus;
	private String haveChildren;
	private String motherToungue;
	private String religion;
	private String caste;
	private boolean casteNoBar;
	private String unlistedCaste;
	private String profileCreatedBy;

	// contact details
	private String mobile;
	private String mobile2;
	private String landline;
	private String email;

	// address
	private Address address;

	public Profile() {
	}

	public Long getProfileId() {
		return profileId;
	}

	public void setProfileId(Long profileId) {
		this.profileId = profileId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getMaritalStatus() {
		return maritalStatus;
	}

	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}

	public String getHaveChildren() {
		return haveChildren;
	}

	public void setHaveChildren(String haveChildren) {
		this.haveChildren = haveChildren;
	}

	public String getMotherToungue() {
		return motherToungue;
	}

	public void setMotherToungue(String motherToungue) {
		this.motherToungue = motherToungue;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getCaste() {
		return caste;
	}

	public void setCaste(String caste) {
		this.caste = caste;
	}

	public boolean isCasteNoBar() {
		return casteNoBar;
	}

	public void setCasteNoBar(boolean casteNoBar) {
		this.casteNoBar = casteNoBar;
	}

	public String getUnlistedCaste() {
		return unlistedCaste;
	}

	public void setUnlistedCaste(String unlistedCaste) {
		this.unlistedCaste = unlistedCaste;
	}

	public String getProfileCreatedBy() {
		return profileCreatedBy;
	}

	public void setProfileCreatedBy(String profileCreatedBy) {
		this.profileCreatedBy = profileCreatedBy;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobile2() {
		return mobile2;
	}

	public void setMobile2(String mobile2) {
		this.mobile2 = mobile2;
	}

	public String getLandline() {
		return landline;
	}

	public void setLandline(String landline) {
		this.landline = landline;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Profile [profileId=" + profileId + ", firstName=" + firstName + ", middleName=" + middleName
				+ ", lastName=" + lastName + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth + ", maritalStatus="
				+ maritalStatus + ", haveChildren=" + haveChildren + ", motherToungue=" + motherToungue + ", religion="
				+ religion + ", caste=" + caste + ", casteNoBar=" + casteNoBar + ", unlistedCaste=" + unlistedCaste
				+ ", profileCreatedBy=" + profileCreatedBy + ", mobile=" + mobile + ", mobile2=" + mobile2
				+ ", landline=" + landline + ", email=" + email + ", address=" + address + "]";
	}

}
