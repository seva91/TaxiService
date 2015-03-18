package ru.taxiservice.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import ru.taxiservice.taxi.dao.IServiceDAO;
import ru.taxiservice.taxi.domain.Service;
import ru.taxiservice.taxi.util.QueryCriteria;

@org.springframework.stereotype.Service("service")
public class ServiceService implements IServiceService {

	@Autowired
	private IServiceDAO serviceDAO;
	
	@Transactional
	@Override
	public List<Service> services() {
		return serviceDAO.find(new QueryCriteria());
	}

	@Transactional
	@Override
	public void addService(Service service) {
		serviceDAO.save(service);
	}

	@Transactional
	@Override
	public void editService(Service service) {
		serviceDAO.update(service);
	}

	@Transactional
	@Override
	public void removeService(Long id) {
		serviceDAO.remove(id);
	}

	@Transactional
	@Override
	public Service getService(Long id) {
		return serviceDAO.findById(id);
	}

}
