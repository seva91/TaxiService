package ru.taxiservice.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.taxiservice.taxi.dao.ITariffDAO;
import ru.taxiservice.taxi.domain.Tariff;
import ru.taxiservice.taxi.util.QueryCriteria;

@Service("tariffService")
public class TariffService implements ITariffService {

	@Autowired
	private ITariffDAO tariffDAO;
	
	@Transactional
	@Override
	public List<Tariff> tariffs(int page, int items) {
		QueryCriteria qc = new QueryCriteria();
		qc.setPaging(qc.new PagingCriteria(page, items));
		
		return tariffDAO.find(qc);
	}

	@Transactional
	@Override
	public void addTariff(Tariff tariff) {
		tariffDAO.save(tariff);
	}

	@Transactional
	@Override
	public void editTariff(Tariff tariff) {
		tariffDAO.update(tariff);
	}

	@Transactional
	@Override
	public void removeTariff(Integer id) {
		tariffDAO.remove(id);
	}

	@Transactional
	@Override
	public Tariff getTariff(Integer id) {
		return tariffDAO.findById(id);
	}

}
