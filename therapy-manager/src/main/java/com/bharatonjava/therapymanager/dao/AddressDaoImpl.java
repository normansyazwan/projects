package com.bharatonjava.therapymanager.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bharatonjava.therapymanager.domain.Address;

@Repository
public class AddressDaoImpl implements AddressDao {
	
	private static final Logger logger = LoggerFactory.getLogger(AddressDaoImpl.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int createAddress(Address address) {
		int returnValue = 0;
		String sql = "INSERT INTO ADDRESSES (APARTMENT,STREET,AREA,CITY)"
				+ " VALUES(?,?,?,?)";
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		
		this.jdbcTemplate.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection conn)
					throws SQLException {
				
				final PreparedStatement ps =conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				
				ps.setString(1, address.getApartment());
				ps.setString(2, address.getStreet());
				ps.setString(3, address.getArea());
				ps.setString(4, address.getCity());
				
				return ps;
			}
			
		}, keyHolder);
		
		
		if (keyHolder.getKey() != null) {
			returnValue = keyHolder.getKey().intValue();
			
		} 
		
		logger.info("Address persisted with address_id : {}", returnValue);
		return returnValue;
		
	}

	@Override
	public Address getAddressById(Integer addressId) {
		
		String sql = "SELECT ADDRESS_ID,APARTMENT,STREET,AREA,CITY"
				+ " FROM ADDRESSES WHERE ADDRESS_ID=?";
		Address address = this.jdbcTemplate.queryForObject(sql, new Object[]{addressId}, new AddressRowMapper());
		
		return address;
	}
}
