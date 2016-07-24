package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.therapymanager.domain.Assesment;

public class AssesmentRowMapper implements RowMapper<Assesment>{

	@Override
	public Assesment mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Assesment a = new Assesment();
		
		a.setPatientId(rs.getLong("PATIENT_ID"));
		a.setAssesmentId(rs.getLong("ASSESMENT_ID"));
		
		a.setPresentCondition(rs.getString("PRESENT_CONDITION"));
		a.setOnset(rs.getString("ONSET"));
		a.setDuration(rs.getString("DURATION"));
		a.setSurgicalHistory(rs.getString("SURGICAL_HISTORY"));
		a.setRedFlag(rs.getString("RED_FLAG"));
		a.setPhysiotherapyTreatmentHistory(rs.getString("PHYSIOTHREAPY_TREATMENT_HISTORY"));
		a.setCurrentExercises(rs.getString("CURRENT_EXERCISES"));
		a.setHobbiesAndSports(rs.getString("HOBBIES_AND_SPORTS"));
		a.setFamilyHistory(rs.getString("FAMILY_HISTORY"));
		a.setSwelling(rs.getString("SWELLING"));
		a.setAreaOfPain(rs.getString("AREA_OF_PAIN"));
		a.setDeformity(rs.getString("DEFORMITY"));
		a.setGait(rs.getString("GAIT"));
		a.setBuilt(rs.getString("BUILT"));
		a.setWarmth(rs.getString("WARMTH"));
		a.setMuscleSpasm(rs.getString("MUSCLE_SPASM"));
		a.setTenderness(rs.getString("TENDERNESS"));
		a.setVasScale(rs.getString("VAS_SCALE"));
		a.setAggrevatingFactors(rs.getString("AGGRIVATING_FACTORS"));
		a.setRom(rs.getString("ROM"));
		a.setEndFeel(rs.getString("END_FEEL"));
		a.setMmt(rs.getString("MMT"));
		a.setSpecialTests(rs.getString("SPECIAL_TESTS"));
		a.setNeurological(rs.getString("NEUROLOGICAL"));
		a.setCardiorespiratory(rs.getString("CARDIORESPIRATORY"));
		a.setFunctionalAssesment(rs.getString("FUNCTIONAL_ASSESMENT"));
		a.setWellnessAssesment(rs.getString("WELLNESS_ASSESMENT"));
		a.setRecoveryPotential(rs.getString("RECOVERY_POTENTIAL"));
		a.setTherapyPlan(rs.getString("THERAPY_PLAN"));
		a.setIsActive(rs.getString("IS_ACTIVE"));
		
		java.sql.Date createdDate  = rs.getDate("CREATED_DATE");
		if(createdDate != null){
			a.setCreatedDate(new Date(createdDate.getTime()));
		}
		
		java.sql.Date updatedDate  = rs.getDate("UPDATED_DATE");
		if(updatedDate != null){
			a.setUpdatedDate(new Date(updatedDate.getTime()));
		}
		
		return a;
	}

}
