package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.domain.Service;

public interface IServiceService {

	List<Service> services();
	
	void addService(Service service);
	
	void editService(Service service);
	
	void removeService(Long id);
	
	Service getService(Long id);
	
}
