package ru.taxiservice.taxi.dao;

import java.io.Serializable;
import java.util.List;

import ru.taxiservice.taxi.util.QueryCriteria;

public interface ICrudDAO<T, T2 extends Serializable> {
	
	void save(T entity);
	
	void update(T entity);
	
	void remove(T2 id);
	
	T findById(T2 id);
	
	List<T> find(QueryCriteria criteria);
	
}
