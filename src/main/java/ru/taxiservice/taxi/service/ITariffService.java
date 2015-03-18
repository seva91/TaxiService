package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.domain.Tariff;

public interface ITariffService {
	List<Tariff> tariffs(int page, int items);
	
	void addTariff(Tariff tariff);
	
	void editTariff(Tariff tariff);
	
	void removeTariff(Integer id);
	
	Tariff getTariff(Integer id);
}
