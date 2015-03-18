package ru.taxiservice.taxi.service;


import java.util.List;

import ru.taxiservice.taxi.domain.Distribution;;

public interface IDistributionService {
	
	List<Distribution> distributions();
	
	List<Distribution> distributions(int page, int items);
	
	void addDistr(Distribution distr);
	
	void removeDistr(Long id);
	
	Distribution getDistr(Long id);
	
	void editDistr(Distribution distr);
	
}
