package ru.taxiservice.taxi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.taxiservice.taxi.domain.Street;
import ru.taxiservice.taxi.util.QueryCriteria;

@Repository
public class StreetDAO implements IStreetDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Street> find(QueryCriteria criteria) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Street.class);
		QueryCriteria.setCriteria(c, criteria, "and");
		return c.list();
	}
	

	@Override
	public void save(Street entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Street entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void remove(Long id) {
		Session session = sessionFactory.getCurrentSession();
		Street street = (Street)session.load(Street.class, id);
		if (street != null) {
			session.delete(street);
		}
	}

	@Override
	public Street findById(Long id) {
		return (Street)sessionFactory.getCurrentSession().get(Street.class, id);
	}

}
