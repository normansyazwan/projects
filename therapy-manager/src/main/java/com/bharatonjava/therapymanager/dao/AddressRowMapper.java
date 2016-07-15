package com.bharatonjava.therapymanager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.therapymanager.domain.Address;

public class AddressRowMapper implements RowMapper<Address>{

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {

		Address a = new Address();
		a.setAddressId(rs.getInt("ADDRESS_ID"));
		a.setApartment(rs.getString("APARTMENT"));
		a.setStreet(rs.getString("STREET"));
		a.setArea(rs.getString("AREA"));
		a.setCity(rs.getString("CITY"));
		
		return a;
	}

}
