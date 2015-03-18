package ru.taxiservice.taxi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.taxiservice.taxi.domain.Distribution;
import ru.taxiservice.taxi.util.QueryCriteria;

@Repository
public class DistributionDAO implements IDistributionDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Distribution> find(QueryCriteria criteria) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Distribution.class);
		QueryCriteria.setCriteria(c, criteria, "and");
		return c.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Distribution> find() {
		return sessionFactory.getCurrentSession().createQuery("from Distribution").list();
	}

	@Override
	public void save(Distribution entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Distribution entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void remove(Long id) {
		Session s = sessionFactory.getCurrentSession();
		Distribution d = (Distribution)s.load(Distribution.class, id);
		if (d != null) {
			s.delete(d);
		}
	}

	@Override
	public Distribution findById(Long id) {
		Session s = sessionFactory.getCurrentSession();
		return (Distribution)s.get(Distribution.class, id);
	}

}
