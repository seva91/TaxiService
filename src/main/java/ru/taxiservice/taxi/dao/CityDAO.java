package ru.taxiservice.taxi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.taxiservice.taxi.domain.City;
import ru.taxiservice.taxi.util.QueryCriteria;

@Repository
public class CityDAO implements ICityDAO {

	@Autowired
	private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<City> find(QueryCriteria criteria) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(City.class);
		QueryCriteria.setCriteria(c, criteria, "and"); 
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<City> find() {
		return sessionFactory.getCurrentSession().createQuery("FROM City ORDER BY name").list();
	}

	@Override
	public void save(City entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(City entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void remove(Integer id) {
		Session s = sessionFactory.getCurrentSession();
		City c = (City)s.load(City.class, id);
		if (c != null) {
			s.delete(c);
		}
	}

	@Override
	public City findById(Integer id) {
		Session s = sessionFactory.getCurrentSession();
		City c = (City)s.get(City.class, id);
		return c;
	}

}
