package ru.taxiservice.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.taxiservice.taxi.dao.ICityDAO;
import ru.taxiservice.taxi.domain.City;
import ru.taxiservice.taxi.util.QueryCriteria;
import ru.taxiservice.taxi.util.QueryCriteria.FilterCriteriaList;
import ru.taxiservice.taxi.util.QueryCriteria.OrderingCriteria;

@Service("cityService")
public class CityService implements ICityService {

	@Autowired
	private ICityDAO cityDAO;
	
	@Transactional
	@Override
	public List<City> cities() {
		QueryCriteria qc = new QueryCriteria();
		OrderingCriteria oc = qc.new OrderingCriteria("name", true);
		qc.setOrdering(oc);
		return cityDAO.find(qc);
	}
	
	@Transactional
	@Override
	public List<City> cities(String term) {
		QueryCriteria qc = new QueryCriteria();
		FilterCriteriaList fcl = qc.new FilterCriteriaList();
		OrderingCriteria oc = qc.new OrderingCriteria("name", true);
		
		fcl.getConditions().add(qc.new FilterCriteria(null, null, qc.new FilterAtom("name", "ilike", term)));
		
		qc.setOrdering(oc);
		qc.setFilter(fcl);
		
		return cityDAO.find(qc);
	}

	@Transactional
	@Override
	public void addCity(City city) {
		cityDAO.save(city);
	}

	@Transactional
	@Override
	public void editCity(City city) {
		cityDAO.update(city);
	}

	@Transactional
	@Override
	public void removeCity(Integer id) {
		cityDAO.remove(id);
	}

	@Transactional
	@Override
	public City getCity(Integer id) {
		return cityDAO.findById(id);
	}

}
