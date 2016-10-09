package com.bharatonjava.matri.dao.address;

import java.util.List;

import com.bharatonjava.matri.domain.Address;

public interface AddressDao {

	public int saveAddress(Address address);
	public int updateAddress(Address address);
	public int deleteAddress(Long addressId);
	public int deleteAddAddressesForProfile(Long profileId);
	public Address getAddressByProfileId(Long profileId);
	public Address getAddressByAddressId(Long addressId);
	public List<Address> getAddressesForProfile(Long profileId);
	
}
