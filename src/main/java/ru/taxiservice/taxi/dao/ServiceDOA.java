package ru.taxiservice.taxi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.taxiservice.taxi.domain.Service;
import ru.taxiservice.taxi.util.QueryCriteria;

@Repository
public class ServiceDOA implements IServiceDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void setSessionFactory(SessionFactory newValue) {
		sessionFactory = newValue;
	}

	@Override
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Service> find(QueryCriteria criteria) {
		return sessionFactory.getCurrentSession().createQuery("from Service").list();
	}

	@Override
	public void save(Service entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Service entity) {
		sessionFactory.getCurrentSession().saveOrUpdate(entity);
	}

	@Override
	public void remove(Long id) {
		Session s = sessionFactory.getCurrentSession();
		Service service = (Service)s.load(Service.class, id);
		if (service != null) {
			s.delete(service);
		}
	}

	@Override
	public Service findById(Long id) {
		Session s = sessionFactory.getCurrentSession();
		Service service = (Service)s.get(Service.class, id);
		return service;
	}

}
