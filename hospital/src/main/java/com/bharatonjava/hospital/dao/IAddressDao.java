package com.bharatonjava.hospital.dao;

import com.bharatonjava.hospital.domain.Address;

public interface IAddressDao {
	
	public Long saveAddress(Address address);
	
	public Address getAddressById(Long addressId);
	
}
