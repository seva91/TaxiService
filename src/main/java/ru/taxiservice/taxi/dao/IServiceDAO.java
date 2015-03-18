package ru.taxiservice.taxi.dao;

import org.hibernate.SessionFactory;

import ru.taxiservice.taxi.domain.Service;

public interface IServiceDAO extends ICrudDAO<Service, Long> {
	
	void setSessionFactory(SessionFactory newValue);
	
	SessionFactory getSessionFactory();
	
}
