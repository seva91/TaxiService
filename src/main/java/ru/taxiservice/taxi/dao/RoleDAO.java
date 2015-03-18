package ru.taxiservice.taxi.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ru.taxiservice.taxi.domain.Role;
import ru.taxiservice.taxi.util.QueryCriteria;

@Repository
public class RoleDAO implements IRoleDAO {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory newValue) {
		sessionFactory = newValue;
	}
	
	public SessionFactory getSessionFactory() { return sessionFactory; }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Role> find(QueryCriteria criteria) {
		return sessionFactory.getCurrentSession().createQuery("from Role").list();
	}

	@Override
	public void save(Role entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Role entity) {
		Session s = sessionFactory.getCurrentSession();
		s.update(entity); 
	}

	@Override
	public void remove(Integer id) {
		Session s = sessionFactory.getCurrentSession();
		Role role = (Role)s.load(Role.class, id);
		if (role != null) {
			s.delete(role);
		}
	}

	@Override
	public Role findById(Integer id) {
		if (id == null) return null;
		Session s = sessionFactory.getCurrentSession();
		Role role = (Role)s.get(Role.class, id); 
		return role;
	}
}
