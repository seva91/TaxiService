package ru.taxiservice.taxi.dao;

import org.hibernate.SessionFactory;

import ru.taxiservice.taxi.domain.Address;

public interface IAddressDAO extends ICrudDAO<Address, Long> {

	void setSessionFactory(SessionFactory sessionFactory);
	SessionFactory getSessionFactory();
}
