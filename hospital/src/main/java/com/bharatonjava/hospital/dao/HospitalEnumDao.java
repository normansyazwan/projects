package com.bharatonjava.hospital.dao;

import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.dao.mappers.HospitalEnumRowMapper;
import com.bharatonjava.hospital.domain.HospitalEnum;

@Repository
public class HospitalEnumDao implements IHospitalEnumDao{

	private static final Logger log = LoggerFactory.getLogger(AddressDao.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public HospitalEnum getEnumById(Long enumId) {
		String sql = "select * from HOSP_ENUMS where enum_id=?";
		HospitalEnum hospitalEnum = (HospitalEnum) this.jdbcTemplate.queryForObject(sql, new HospitalEnumRowMapper(), new Object[]{enumId});
		return hospitalEnum;
	}

	@Override
	public List<HospitalEnum> getEnumsByGroup(String enumGroup) {
		String sql = "select * from HOSP_ENUMS WHERE ENUM_GROUP=?";
		List<HospitalEnum> enums = this.jdbcTemplate.query(sql,new Object[]{enumGroup}, new HospitalEnumRowMapper());
		log.info("fetched {} enums for enum_group {} ", enums != null ?enums.size() : 0, enumGroup);
		return enums;
	}

}
