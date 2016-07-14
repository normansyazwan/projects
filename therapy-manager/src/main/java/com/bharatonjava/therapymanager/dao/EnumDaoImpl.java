package com.bharatonjava.therapymanager.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.bharatonjava.therapymanager.domain.HospitalEnum;

@Component(value = "enumDao")
public class EnumDaoImpl implements EnumDao{

	private static final Logger logger = LoggerFactory.getLogger(EnumDaoImpl.class);
	
	private JdbcTemplate jdbcTemplate;

	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	
	@Override
	public void insertHospitalEnum(HospitalEnum hospitalEnum) {
		
		String sql = "INSERT INTO HOSPITAL_ENUMS(ENUM_ID,ENUM_GROUP,ENUM_VALUE) VALUES"
				+ " (?,?,?)";
		
	}

	
	@Override
	public HospitalEnum getHospitalEnumById(Long enumId) {
		String sql = "SELECT ENUM_ID,ENUM_GROUP,ENUM_VALUE FROM HOSPITAL_ENUMS WHERE ENUM_ID = ?";
		HospitalEnum hospitalEnum = (HospitalEnum) this.jdbcTemplate.query(sql, new HospitalEnumRowMapper(), enumId);
		return hospitalEnum;
	}

	
	@Override
	public List<HospitalEnum> getHospitalEnumByGroup(String enumGroup) {
		String sql = "SELECT ENUM_ID,ENUM_GROUP,ENUM_VALUE FROM HOSPITAL_ENUMS WHERE ENUM_GROUP = ?";
		List<HospitalEnum> hospitalEnums = this.jdbcTemplate.query(sql, new HospitalEnumRowMapper(), enumGroup);
		return hospitalEnums;
	}

	
	@Override
	public List<HospitalEnum> getAllHospitalEnums() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
