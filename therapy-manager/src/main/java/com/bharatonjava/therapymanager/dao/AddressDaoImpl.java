package com.bharatonjava.therapymanager.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bharatonjava.therapymanager.domain.Address;

@Repository
public class AddressDaoImpl implements AddressDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int createAddress(Address address) {

		return 0;
	}

}
