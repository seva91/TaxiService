package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.domain.Address;

public interface IAddressService {

	List<Address> addresses();
	
	void addAddress(Address home);
	
	void editAddress(Address home);
	
	void removeAddress(Long id);
	
	Address getAddress(Long id);
	
}
