package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bharatonjava.therapymanager.domain.DailyEarningsDto;

@Repository
public class ReportDaoImpl implements ReportDao{

	private static final Logger logger = LoggerFactory.getLogger(ReportDaoImpl.class);
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<DailyEarningsDto> getEarnings(Integer year, Integer month) {
		
		logger.info("year: {}, month: {}", year, month);
		String sql = "select S.CREATED_DATE, SUM(S.FEE) AS FEE "
				+ "FROM PATIENTS P LEFT JOIN ASSESMENTS A ON P.PATIENT_ID=A.PATIENT_ID "
				+ "LEFT JOIN SITTINGS S ON A.ASSESMENT_ID=S.ASSESMENT_ID "
				+ "WHERE S.CREATED_DATE IS NOT NULL and EXTRACT(YEAR FROM S.CREATED_DATE) = ?"
				+ " and EXTRACT(MONTH FROM S.CREATED_DATE) = ?"
				+ " GROUP BY S.CREATED_DATE"
				+ " ORDER BY S.CREATED_DATE DESC";
		
		List<DailyEarningsDto> list = this.jdbcTemplate.query(sql, new Object[]{year, month},new RowMapper<DailyEarningsDto>(){

			@Override
			public DailyEarningsDto mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				DailyEarningsDto d = new DailyEarningsDto();
				d.setCreatedDate(new java.util.Date(rs.getDate("CREATED_DATE").getTime()));
				d.setFees(rs.getDouble("FEE"));
				return d;
			}
			
			
		});
		
		logger.info("Returning a list of {} DailyEarningsDto", list.size());
		
		return list;
	}

	@Override
	public List<Long> getYearsForSittings(){
		String sql = "SELECT DISTINCT EXTRACT(YEAR FROM CREATED_DATE) FROM SITTINGS";
		List<Long> years = this.jdbcTemplate.queryForList(sql, Long.class);
		logger.info("Returning list of {} years", years.size());
		return years;
	}
	
}
