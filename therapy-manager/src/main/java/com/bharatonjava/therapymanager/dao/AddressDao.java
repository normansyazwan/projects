package com.bharatonjava.therapymanager.dao;

import com.bharatonjava.therapymanager.domain.Address;

public interface AddressDao {

	public int createAddress(Address address);
	
	public Address getAddressById(Integer addressId);
}
