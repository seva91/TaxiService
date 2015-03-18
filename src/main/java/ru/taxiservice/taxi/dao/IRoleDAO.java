package ru.taxiservice.taxi.dao;

import org.hibernate.SessionFactory;

import ru.taxiservice.taxi.domain.Role;

public interface IRoleDAO extends ICrudDAO<Role, Integer> {
	
	void setSessionFactory(SessionFactory newValue);
	
	SessionFactory getSessionFactory();
}
