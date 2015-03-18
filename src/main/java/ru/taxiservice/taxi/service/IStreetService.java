package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.domain.Street;

public interface IStreetService {

	List<Street> streets(int cityId, String term);
	
}
