package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.dao.IAddressDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.taxiservice.taxi.domain.Address;
import ru.taxiservice.taxi.util.QueryCriteria;

@Service
public class AddressService implements IAddressService {

	@Autowired
	private IAddressDAO addressDao;
	
	@Transactional
	@Override
	public List<Address> addresses() {
		return addressDao.find(new QueryCriteria());
	}

	@Transactional
	@Override
	public void addAddress(Address home) {
		addressDao.save(home);
	}

	@Transactional
	@Override
	public void editAddress(Address home) {
		addressDao.update(home);
	}

	@Transactional
	@Override
	public void removeAddress(Long id) {
		addressDao.remove(id);
	}

	@Transactional
	@Override
	public Address getAddress(Long id) {
		return addressDao.findById(id);
	}

}
