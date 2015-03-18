package ru.taxiservice.taxi.dao;


import java.util.List;

import ru.taxiservice.taxi.domain.City;

public interface ICityDAO extends ICrudDAO<City, Integer> {
	
	List<City> find();
	
}
