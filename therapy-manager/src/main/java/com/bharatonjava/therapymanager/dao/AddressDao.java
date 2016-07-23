package com.bharatonjava.therapymanager.dao;

import com.bharatonjava.therapymanager.domain.Address;

public interface AddressDao {

	public Long createAddress(Address address);
	
	public Address getAddressById(Long addressId);
}
