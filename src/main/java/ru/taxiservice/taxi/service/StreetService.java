package ru.taxiservice.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.taxiservice.taxi.dao.IStreetDAO;
import ru.taxiservice.taxi.domain.Street;
import ru.taxiservice.taxi.util.QueryCriteria;
import ru.taxiservice.taxi.util.QueryCriteria.FilterCriteriaList;

@Service
public class StreetService implements IStreetService {

	@Autowired
	private IStreetDAO streetDAO;
	
	@Transactional
	@Override
	public List<Street> streets(int cityId, String term) {
		QueryCriteria qc = new QueryCriteria();
		FilterCriteriaList fcl = qc.new FilterCriteriaList();
		
		fcl.getConditions().add(qc.new FilterCriteria(null, null, qc.new FilterAtom("cityId", "=", cityId)));
		fcl.getConditions().add(qc.new FilterCriteria(null, null, qc.new FilterAtom("name", "ilike", term)));
		
		qc.setFilter(fcl);
		return streetDAO.find(qc);
	}

}
