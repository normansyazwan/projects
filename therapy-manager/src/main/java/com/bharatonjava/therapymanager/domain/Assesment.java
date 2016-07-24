package com.bharatonjava.therapymanager.domain;

import java.util.Date;

public class Assesment {

	private Long assesmentId;
	private Long patientId;

	// history fields
	private String presentCondition;
	private String onset;
	private String duration;
	private String surgicalHistory;
	private String redFlag;
	private String physiotherapyTreatmentHistory;
	private String currentExercises;
	private String hobbiesAndSports;
	private String familyHistory;

	// observation fields
	private String swelling;
	private String areaOfPain;
	private String deformity;
	private String gait;
	private String built;

	// palpation fields
	private String warmth;
	private String muscleSpasm;
	private String tenderness;

	// examination fields
	private String vasScale;
	private String aggrevatingFactors;
	private String rom;
	private String endFeel;
	private String mmt;
	private String specialTests;
	private String neurological;
	private String cardiorespiratory;
	private String functionalAssesment;
	private String wellnessAssesment;
	private String recoveryPotential;
	private String therapyPlan;

	private String isActive;
	// audit fields
	private Date createdDate;
	private Date updatedDate;

	public Assesment() {
	}

	public Long getAssesmentId() {
		return assesmentId;
	}

	public void setAssesmentId(Long assesmentId) {
		this.assesmentId = assesmentId;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public String getPresentCondition() {
		return presentCondition;
	}

	public void setPresentCondition(String presentCondition) {
		this.presentCondition = presentCondition;
	}

	public String getOnset() {
		return onset;
	}

	public void setOnset(String onset) {
		this.onset = onset;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getSurgicalHistory() {
		return surgicalHistory;
	}

	public void setSurgicalHistory(String surgicalHistory) {
		this.surgicalHistory = surgicalHistory;
	}

	public String getRedFlag() {
		return redFlag;
	}

	public void setRedFlag(String redFlag) {
		this.redFlag = redFlag;
	}

	public String getPhysiotherapyTreatmentHistory() {
		return physiotherapyTreatmentHistory;
	}

	public void setPhysiotherapyTreatmentHistory(
			String physiotherapyTreatmentHistory) {
		this.physiotherapyTreatmentHistory = physiotherapyTreatmentHistory;
	}

	public String getCurrentExercises() {
		return currentExercises;
	}

	public void setCurrentExercises(String currentExercises) {
		this.currentExercises = currentExercises;
	}

	public String getHobbiesAndSports() {
		return hobbiesAndSports;
	}

	public void setHobbiesAndSports(String hobbiesAndSports) {
		this.hobbiesAndSports = hobbiesAndSports;
	}

	public String getFamilyHistory() {
		return familyHistory;
	}

	public void setFamilyHistory(String familyHistory) {
		this.familyHistory = familyHistory;
	}

	public String getSwelling() {
		return swelling;
	}

	public void setSwelling(String swelling) {
		this.swelling = swelling;
	}

	public String getAreaOfPain() {
		return areaOfPain;
	}

	public void setAreaOfPain(String areaOfPain) {
		this.areaOfPain = areaOfPain;
	}

	public String getDeformity() {
		return deformity;
	}

	public void setDeformity(String deformity) {
		this.deformity = deformity;
	}

	public String getGait() {
		return gait;
	}

	public void setGait(String gait) {
		this.gait = gait;
	}

	public String getBuilt() {
		return built;
	}

	public void setBuilt(String built) {
		this.built = built;
	}

	public String getWarmth() {
		return warmth;
	}

	public void setWarmth(String warmth) {
		this.warmth = warmth;
	}

	public String getMuscleSpasm() {
		return muscleSpasm;
	}

	public void setMuscleSpasm(String muscleSpasm) {
		this.muscleSpasm = muscleSpasm;
	}

	public String getTenderness() {
		return tenderness;
	}

	public void setTenderness(String tenderness) {
		this.tenderness = tenderness;
	}

	public String getVasScale() {
		return vasScale;
	}

	public void setVasScale(String vasScale) {
		this.vasScale = vasScale;
	}

	public String getAggrevatingFactors() {
		return aggrevatingFactors;
	}

	public void setAggrevatingFactors(String aggrevatingFactors) {
		this.aggrevatingFactors = aggrevatingFactors;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getEndFeel() {
		return endFeel;
	}

	public void setEndFeel(String endFeel) {
		this.endFeel = endFeel;
	}

	public String getMmt() {
		return mmt;
	}

	public void setMmt(String mmt) {
		this.mmt = mmt;
	}

	public String getSpecialTests() {
		return specialTests;
	}

	public void setSpecialTests(String specialTests) {
		this.specialTests = specialTests;
	}

	public String getNeurological() {
		return neurological;
	}

	public void setNeurological(String neurological) {
		this.neurological = neurological;
	}

	public String getCardiorespiratory() {
		return cardiorespiratory;
	}

	public void setCardiorespiratory(String cardiorespiratory) {
		this.cardiorespiratory = cardiorespiratory;
	}

	public String getFunctionalAssesment() {
		return functionalAssesment;
	}

	public void setFunctionalAssesment(String functionalAssesment) {
		this.functionalAssesment = functionalAssesment;
	}

	public String getWellnessAssesment() {
		return wellnessAssesment;
	}

	public void setWellnessAssesment(String wellnessAssesment) {
		this.wellnessAssesment = wellnessAssesment;
	}

	public String getRecoveryPotential() {
		return recoveryPotential;
	}

	public void setRecoveryPotential(String recoveryPotential) {
		this.recoveryPotential = recoveryPotential;
	}

	public String getTherapyPlan() {
		return therapyPlan;
	}

	public void setTherapyPlan(String therapyPlan) {
		this.therapyPlan = therapyPlan;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}
	
	public String getIsActive() {
		return isActive;
	}
	
	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Override
	public String toString() {
		return "Assesment [assesmentId=" + assesmentId + ", patientId="
				+ patientId + ", presentCondition=" + presentCondition
				+ ", onset=" + onset + ", duration=" + duration
				+ ", surgicalHistory=" + surgicalHistory + ", redFlag="
				+ redFlag + ", physiotherapyTreatmentHistory="
				+ physiotherapyTreatmentHistory + ", currentExercises="
				+ currentExercises + ", hobbiesAndSports=" + hobbiesAndSports
				+ ", familyHistory=" + familyHistory + ", swelling=" + swelling
				+ ", areaOfPain=" + areaOfPain + ", deformity=" + deformity
				+ ", gait=" + gait + ", built=" + built + ", warmth=" + warmth
				+ ", muscleSpasm=" + muscleSpasm + ", tenderness=" + tenderness
				+ ", vasScale=" + vasScale + ", aggrevatingFactors="
				+ aggrevatingFactors + ", rom=" + rom + ", endFeel=" + endFeel
				+ ", mmt=" + mmt + ", specialTests=" + specialTests
				+ ", neurological=" + neurological + ", cardiorespiratory="
				+ cardiorespiratory + ", functionalAssesment="
				+ functionalAssesment + ", wellnessAssesment="
				+ wellnessAssesment + ", recoveryPotential="
				+ recoveryPotential + ", therapyPlan=" + therapyPlan
				+ ", isActive=" + isActive + ", createdDate=" + createdDate
				+ ", updatedDate=" + updatedDate + "]";
	}
	
}
