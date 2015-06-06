package com.bharatonjava.hospital.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.bharatonjava.hospital.dao.mappers.AddressRowMapper;
import com.bharatonjava.hospital.domain.Address;

@Repository
public class AddressDao implements IAddressDao{

	private static final Logger log = LoggerFactory.getLogger(AddressDao.class);
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Long saveAddress(final Address address) {
		
		KeyHolder keyHolder = new GeneratedKeyHolder();
		//int count = this.jdbcTemplate.update(sql, new Object[]{address.getApartment(), address.getStreet(), address.getArea(), address.getCity().getEnumId()});
		this.jdbcTemplate.update(new PreparedStatementCreator() {
			String sql = "INSERT INTO ADDRESSES(APARTMENT, STREET, AREA, CITY) values"
					+ "(?,?,?,?)";
			@Override
			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, new String[]{"address_id"});
				ps.setString(1, address.getApartment());
				ps.setString(2, address.getStreet());
				ps.setString(3, address.getArea());
				if(address.getCity() != null){
					ps.setLong(4, address.getCity().getEnumId());
				}else{
					ps.setLong(4, 0L);
				}
				return ps;
			}
		}, keyHolder);
		return (Long) keyHolder.getKey();
	}

	@Override
	public Address getAddressById(Long addressId) {
		String sql = "SELECT * FROM ADDRESSES WHERE ADDRESS_ID=?";
		Address address = this.jdbcTemplate.queryForObject(sql, new AddressRowMapper(), new Object[]{addressId});
		return address;
	}

}
