package ru.taxiservice.taxi.dao;

import java.util.List;

import ru.taxiservice.taxi.domain.Distribution;

public interface IDistributionDAO extends ICrudDAO<Distribution, Long> {
	List<Distribution> find();
}
