package ru.taxiservice.taxi.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.taxiservice.taxi.domain.Tariff;
import ru.taxiservice.taxi.util.QueryCriteria;

@Repository
public class TariffDAO implements ITariffDAO {

	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Tariff entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Tariff entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void remove(Integer id) {
		Session session = (Session)sessionFactory.getCurrentSession();
		Tariff tariff = (Tariff)session.load(Tariff.class, id);
		if (tariff != null) {
			session.delete(tariff);
		}
	}

	@Override
	public Tariff findById(Integer id) {
		Session session = (Session)sessionFactory.getCurrentSession();
		Tariff tariff = (Tariff)session.get(Tariff.class, id);
		return tariff;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tariff> find(QueryCriteria criteria) {
		Criteria c = sessionFactory.getCurrentSession().createCriteria(Tariff.class);
		QueryCriteria.setCriteria(c, criteria, "add");
		return c.list();
	}

}
