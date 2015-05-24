package com.bharatonjava.pathomanager.dao;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.bharatonjava.pathomanager.dao.mappers.AppEnumRowMapper;
import com.bharatonjava.pathomanager.domain.AppEnum;

@Repository
public class EnumerationDaoImpl implements EnumerationDao {

	private static final Logger log = LoggerFactory
			.getLogger(EnumerationDaoImpl.class);

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public EnumerationDaoImpl() {
	
	}
	
	public EnumerationDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int saveAppEnum(AppEnum appEnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAppEnum(AppEnum appEnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAppEnum(AppEnum appEnum) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAppEnum(Long enumId) {
		String sql = "delete from patho_enums where enum_id=?";
		int count = this.jdbcTemplate.update(sql, new Object[]{enumId});
		return count;
	}

	@Override
	public List<AppEnum> getAppEnumsByGroup(String enumGroup) {
		String sql = "select * from patho_enums where enum_group=?";
		List<AppEnum> appEnums = this.jdbcTemplate.query(sql,new Object[]{enumGroup}, new AppEnumRowMapper());
		log.info("Returning {} enums for Group {}", appEnums == null ? 0 : appEnums.size(), enumGroup);
		return appEnums;
	}
	
	@Override
	public AppEnum getAppEnumsById(Long enumId) {
		String sql = "select * from patho_enums where enum_id=?";
		AppEnum appEnum = this.jdbcTemplate.queryForObject(sql,new Object[]{enumId}, new AppEnumRowMapper());
		log.info("Returning  enum for enumId {} ", enumId);
		return appEnum;
	}

}
