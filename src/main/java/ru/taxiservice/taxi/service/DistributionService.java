package ru.taxiservice.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.taxiservice.taxi.dao.IDistributionDAO;
import ru.taxiservice.taxi.domain.Distribution;
import ru.taxiservice.taxi.util.QueryCriteria;

@Service
public class DistributionService implements IDistributionService {
	
	@Autowired
	private IDistributionDAO distributionDAO;

	@Transactional
	@Override
	public List<Distribution> distributions() {
		QueryCriteria qc = new QueryCriteria();
		qc.setPaging(qc.new PagingCriteria(0, 100)); 
		return distributionDAO.find(qc);
	}
	
	@Transactional
	@Override
	public List<Distribution> distributions(int page, int items) {
		QueryCriteria qc = new QueryCriteria();
		qc.setPaging(qc.new PagingCriteria(page, items));
		
		return distributionDAO.find(qc);
	}
   
	@Transactional
	@Override
	public void addDistr(Distribution distr) {
		distributionDAO.save(distr);
	}

	@Transactional
	@Override
	public void removeDistr(Long id) {
		distributionDAO.remove(id);
	}

	@Transactional
	@Override
	public Distribution getDistr(Long id) {
		return distributionDAO.findById(id);
	}

	@Transactional
	@Override
	public void editDistr(Distribution distr) {
		distributionDAO.update(distr);
	}
	
	
	
}
