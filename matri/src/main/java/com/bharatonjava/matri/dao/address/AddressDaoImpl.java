package com.bharatonjava.matri.dao.address;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.bharatonjava.matri.domain.Address;

public class AddressDaoImpl implements AddressDao{

	private static final Logger logger = LoggerFactory.getLogger(AddressDaoImpl.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public int saveAddress(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateAddress(Address address) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAddress(Long addressId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteAddAddressesForProfile(Long profileId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Address getAddressByProfileId(Long profileId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Address getAddressByAddressId(Long addressId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Address> getAddressesForProfile(Long profileId) {
		// TODO Auto-generated method stub
		return null;
	}

}
