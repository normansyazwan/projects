package com.bharatonjava.therapymanager.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.bharatonjava.therapymanager.domain.Treatment;
import com.bharatonjava.therapymanager.utils.Utils;


@Repository
public class SettingsDaoImpl implements SettingsDao{

	private static final Logger logger = LoggerFactory.getLogger(SettingsDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<Treatment> getAllTreatments() {
		String sql = "SELECT TREATMENT_ID, TREATMENT_NAME,FEE FROM TREATMENTS ORDER BY TREATMENT_ID";
		
		List<Treatment> treatments = this.jdbcTemplate.query(sql, new TreatmentRowMapper());
		logger.info("Returning list of {} Treatments", Utils.size(treatments));
		return treatments;
	}

	@Override
	public Treatment getTreatment(Long treatmentId) {
		String sql = "SELECT TREATMENT_ID, TREATMENT_NAME,FEE FROM TREATMENTS WHERE TREATMENT_ID=?";
		Treatment t = this.jdbcTemplate.queryForObject(sql,new Object[]{treatmentId}, new TreatmentRowMapper());
		logger.info("Returning Treatment: {}", t);
		return t;
	}

	@Override
	public int deleteTreatment(Long treatmentId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateTreatment(Treatment treatment) {
		String sql = "update TREATMENTS SET TREATMENT_NAME=?, FEE=? WHERE TREATMENT_ID=?";
		int count = this.jdbcTemplate.update(sql, new Object[]{treatment.getName(), treatment.getFees(), treatment.getTreatmentId()});
		logger.info("record updated: {}", count);
		return count;
	}
	
	@Override
	public Long getMaxTreatmentId(){
		String sql = "select max(TREATMENT_ID) FROM TREATMENTS";
		Long id = this.jdbcTemplate.queryForObject(sql, Long.class);
		logger.info("max treatmentId={}", id);
		return id;
	}

	
}
