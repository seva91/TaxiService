package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.domain.City;

public interface ICityService {

	List<City> cities();
	
	List<City> cities(String term);
	
	void addCity(City city);
	
	void editCity(City city);
	
	void removeCity(Integer id);
	
	City getCity(Integer id);
	
}
