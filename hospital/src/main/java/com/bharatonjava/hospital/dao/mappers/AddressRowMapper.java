package com.bharatonjava.hospital.dao.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.bharatonjava.hospital.domain.Address;
import com.bharatonjava.hospital.domain.HospitalEnum;

public class AddressRowMapper implements RowMapper<Address>{

	@Override
	public Address mapRow(ResultSet rs, int rowNum) throws SQLException {
		Address a = new Address();
		a.setAddressId(rs.getLong("ADDRESS_ID"));
		a.setApartment(rs.getString("APARTMENT"));
		a.setStreet(rs.getString("STREET"));
		a.setArea(rs.getString("AREA"));
		HospitalEnum city = new HospitalEnum();
		city.setEnumId(rs.getLong("city"));
		a.setCity(city);
		return a;
	}

}
