package ru.taxiservice.taxi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.taxiservice.taxi.domain.Address;
import ru.taxiservice.taxi.util.QueryCriteria;

@Repository
public class AddressDAO implements IAddressDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Address> find(QueryCriteria criteria) {
		return sessionFactory.getCurrentSession().createQuery("from Address").list();
	}

	@Override
	public void save(Address entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Address entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void remove(Long id) {
		Session s = sessionFactory.getCurrentSession();
		Address h = (Address)s.load(Address.class, id);
		if (h != null) {
			s.delete(h);
		}
	}

	@Override
	public Address findById(Long id) {
		return (Address)sessionFactory.getCurrentSession().get(Address.class, id);
	}

}
