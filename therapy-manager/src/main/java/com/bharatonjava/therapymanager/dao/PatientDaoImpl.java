package com.bharatonjava.therapymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bharatonjava.therapymanager.domain.Assesment;
import com.bharatonjava.therapymanager.domain.Patient;
import com.bharatonjava.therapymanager.domain.Sitting;

@Repository
public class PatientDaoImpl implements PatientDao{

	private static final Logger logger = LoggerFactory.getLogger(PatientDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	// Default constructor
	public PatientDaoImpl() {
	}
	
	@Override
	public Long createPatient(Patient patient) {
		logger.info("patient inside dao : {}", patient);

		Long returnValue = 0L;
		String sql = "INSERT INTO PATIENTS (FIRST_NAME,LAST_NAME,GENDER,DATE_OF_BIRTH,BLOOD_GROUP,"
				+ "EXISTING_AILMENTS,ALLERGIES,MOBILE,EMAIL,OCCUPATION,ADDRESS_ID)"
				+ " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				
				final PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, patient.getFirstName());
				ps.setString(2, patient.getLastName());
				ps.setString(3, patient.getGender());
				ps.setDate(4, new java.sql.Date(patient.getDob().getTime()));
				ps.setString(5, patient.getBloodGroup());
				ps.setString(6, patient.getExistingAilments());
				ps.setString(7, patient.getAllergies());
				ps.setString(8, patient.getMobile());
				ps.setString(9, patient.getEmail());
				ps.setString(10, patient.getOccupation());
				ps.setLong(11, patient.getAddress().getAddressId());
				
				return ps;
			}
			
		}, keyHolder);
		
		
		if (keyHolder.getKey() != null) {
			returnValue = keyHolder.getKey().longValue();
			
		} 
		
		logger.info("Patient persisted with patientId : {}", returnValue);
		return returnValue;
		
	}

	/**
	 * Updates a patient's record
	 */
	@Override
	public int updatePatient(Patient patient) {
		
		String sql = "UPDATE PATIENTS SET FIRST_NAME=?, LAST_NAME=?,GENDER=?,DATE_OF_BIRTH=?,"
				+ "BLOOD_GROUP=?,EXISTING_AILMENTS=?,ALLERGIES=?,MOBILE=?,EMAIL=?,OCCUPATION=?"
				+ " WHERE PATIENT_ID=?";
		
		int recordCount = this.jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, patient.getFirstName());
				ps.setString(2, patient.getLastName());
				ps.setString(3, patient.getGender());
				ps.setDate(4, new java.sql.Date(patient.getDob().getTime()));
				ps.setString(5, patient.getBloodGroup());
				ps.setString(6, patient.getExistingAilments());
				ps.setString(7, patient.getAllergies());
				ps.setString(8, patient.getMobile());
				ps.setString(9, patient.getEmail());
				ps.setString(10, patient.getOccupation());
				ps.setLong(11, patient.getPatientId());
				
				return ps;
			}
		});
		
		// update patient's address
		
		String addressUpdateSql = "UPDATE ADDRESSES SET APARTMENT=?,STREET=?,AREA=?,CITY=?"
				+ " WHERE ADDRESS_ID=?";
		
		int addressUpdateCount = this.jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				
				PreparedStatement ps = con.prepareStatement(addressUpdateSql);
				ps.setString(1, patient.getAddress().getApartment());
				ps.setString(2, patient.getAddress().getStreet());
				ps.setString(3, patient.getAddress().getArea());
				ps.setString(4, patient.getAddress().getCity());
				ps.setLong(5, patient.getAddress().getAddressId());
				
				return ps;
			}
			
		});
		
		logger.info("patientUpdateCount={}, addressUpdateCount={}", recordCount,addressUpdateCount);
		
		return recordCount;
	}

	@Override
	public int deletePatient(Long patientId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Patient getPatient(Long patientId) {
		
		String sql = "SELECT PATIENT_ID, FIRST_NAME,LAST_NAME,GENDER,DATE_OF_BIRTH,BLOOD_GROUP,"
				+ "EXISTING_AILMENTS,ALLERGIES,MOBILE,EMAIL,OCCUPATION,ADDRESS_ID"
				+ " FROM PATIENTS WHERE PATIENT_ID=?";
		
		Patient patient = this.jdbcTemplate.queryForObject(sql, new Object[]{patientId}, new PatientRowMapper());
		return patient;
	}

	@Override
	public List<Patient> getPatients(){
		List<Patient> patients = null;
		String sql = "SELECT PATIENT_ID, FIRST_NAME,LAST_NAME,GENDER,DATE_OF_BIRTH,BLOOD_GROUP,"
				+ "EXISTING_AILMENTS,ALLERGIES,MOBILE,EMAIL,OCCUPATION,ADDRESS_ID"
				+ " FROM PATIENTS";
		patients = this.jdbcTemplate.query(sql, new PatientRowMapper());
		return patients;
	}
	
	@Override
	public Long getPatientCount(){
		Long count = 0L;
		String sql = "SELECT COUNT(1) FROM PATIENTS";
		count = (Long) this.jdbcTemplate.queryForObject(sql, Long.class);
		return count;
	}
	
	@Override
	public List<Patient> searchPatients(String query) {
		
		List<Patient> patients = null;
		
		String sql = "SELECT PATIENT_ID, FIRST_NAME,LAST_NAME,GENDER,DATE_OF_BIRTH,BLOOD_GROUP,"
				+ "EXISTING_AILMENTS,ALLERGIES,MOBILE,EMAIL,OCCUPATION,ADDRESS_ID"
				+ " FROM PATIENTS WHERE FIRST_NAME like ? or LAST_NAME like ?"
				+ " or MOBILE like ? or EMAIL like ?";
		
		patients = this.jdbcTemplate.query(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
			
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, "%"+query+ "%");
				ps.setString(2, "%"+query+ "%");
				ps.setString(3, "%"+query+ "%");
				ps.setString(4, "%"+query+ "%");
				
				return ps;
			}
		}, new PatientRowMapper());
		
		return patients;
	}
	
	@Override
	public Long createNewAssesment(Assesment assesment){
		
		Long returnValue = 0L;
		
		String sql = "INSERT INTO ASSESMENTS (PATIENT_ID,PRESENT_CONDITION,ONSET,DURATION,"
				+ "SURGICAL_HISTORY,RED_FLAG,PHYSIOTHREAPY_TREATMENT_HISTORY,CURRENT_EXERCISES,"
				+ "HOBBIES_AND_SPORTS,FAMILY_HISTORY,SWELLING,AREA_OF_PAIN,DEFORMITY,GAIT,"
				+ "BUILT,WARMTH,MUSCLE_SPASM,TENDERNESS,VAS_SCALE,AGGRIVATING_FACTORS,ROM,"
				+ "END_FEEL,MMT,SPECIAL_TESTS,NEUROLOGICAL,CARDIORESPIRATORY,FUNCTIONAL_ASSESMENT,"
				+ "WELLNESS_ASSESMENT,RECOVERY_POTENTIAL,THERAPY_PLAN) VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				
				final PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				ps.setLong(1, assesment.getPatientId());
				ps.setString(2, assesment.getPresentCondition());
				ps.setString(3, assesment.getOnset());
				ps.setString(4, assesment.getDuration());
				ps.setString(5, assesment.getSurgicalHistory());
				ps.setString(6, assesment.getRedFlag());
				ps.setString(7, assesment.getPhysiotherapyTreatmentHistory());
				ps.setString(8, assesment.getCurrentExercises());
				ps.setString(9, assesment.getHobbiesAndSports());
				ps.setString(10, assesment.getFamilyHistory());
				ps.setString(11, assesment.getSwelling());
				ps.setString(12, assesment.getAreaOfPain());
				ps.setString(13, assesment.getDeformity());
				ps.setString(14, assesment.getGait());
				ps.setString(15, assesment.getBuilt());
				ps.setString(16, assesment.getWarmth());
				ps.setString(17, assesment.getMuscleSpasm());
				ps.setString(18, assesment.getTenderness());
				ps.setString(19, assesment.getVasScale());
				ps.setString(20, assesment.getAggrevatingFactors());
				ps.setString(21, assesment.getRom());
				ps.setString(22, assesment.getEndFeel());
				ps.setString(23, assesment.getMmt());
				ps.setString(24, assesment.getSpecialTests());
				ps.setString(25, assesment.getNeurological());
				ps.setString(26, assesment.getCardiorespiratory());
				ps.setString(27, assesment.getFunctionalAssesment());
				ps.setString(28, assesment.getWellnessAssesment());
				ps.setString(29, assesment.getRecoveryPotential());
				ps.setString(30, assesment.getTherapyPlan());
				
				return ps;
			}
			
		}, keyHolder);
		
		
		if (keyHolder.getKey() != null) {
			returnValue = keyHolder.getKey().longValue();
			
		} 
		
		logger.info("Assesment persisted with assesmentId : {}", returnValue);
		
		return returnValue;
	}
	
	@Override
	public List<Assesment> getAssessmentsForPatient(Long patientId, boolean activeOnly){
		
		List<Assesment> assesments = null;
		
		String sql = "SELECT ASSESMENT_ID,PATIENT_ID,PRESENT_CONDITION,ONSET,DURATION,"
				+ "SURGICAL_HISTORY,RED_FLAG,PHYSIOTHREAPY_TREATMENT_HISTORY,CURRENT_EXERCISES,"
				+ "HOBBIES_AND_SPORTS,FAMILY_HISTORY,SWELLING,AREA_OF_PAIN,DEFORMITY,GAIT,"
				+ "BUILT,WARMTH,MUSCLE_SPASM,TENDERNESS,VAS_SCALE,AGGRIVATING_FACTORS,ROM,"
				+ "END_FEEL,MMT,SPECIAL_TESTS,NEUROLOGICAL,CARDIORESPIRATORY,FUNCTIONAL_ASSESMENT,"
				+ "WELLNESS_ASSESMENT,RECOVERY_POTENTIAL,THERAPY_PLAN,IS_ACTIVE,CREATED_DATE,UPDATED_DATE"
				+ " FROM ASSESMENTS WHERE PATIENT_ID=? AND IS_ACTIVE=? ORDER BY CREATED_DATE,UPDATED_DATE DESC";
		
		String type = "N";
		if(activeOnly){
			type = "Y";
		}else{
			type = "N";
		}
		
		Object[] args = new Object[]{patientId, type};
		assesments = this.jdbcTemplate.query(sql, args, new AssesmentRowMapper());
		
		return assesments;
	}
	
	
	@Override
	public int addNewSittingToAssessment(Sitting sitting){
		String sql = "INSERT INTO SITTINGS(ASSESMENT_ID,TREATMENT,FEE,CREATED_DATE)"
				+ " VALUES (?,?,?,?)";
		int count = 0;
		
		GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
		count = this.jdbcTemplate.update(new PreparedStatementCreator() {
			
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, sitting.getAssessmentId());
				ps.setString(2, sitting.getTreatment());
				ps.setDouble(3, sitting.getFees());
				ps.setDate(4, new java.sql.Date(sitting.getCreatedDate().getTime()));
				return ps;
			}
		}, generatedKeyHolder);
		
		return count;
	}
	
	public List<Sitting> getSittingsForAssessment(Long assessmentId){
		String sql = "SELECT SITTING_ID,ASSESMENT_ID,TREATMENT,FEE,CREATED_DATE FROM SITTINGS WHERE ASSESMENT_ID=?"
				+ " ORDER BY CREATED_DATE, SITTING_ID DESC";
		List<Sitting> sittings = this.jdbcTemplate.query(sql, new SittingRowMapper(), new Object[]{assessmentId});
		return sittings;
	}
}
