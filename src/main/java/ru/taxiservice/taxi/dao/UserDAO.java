package ru.taxiservice.taxi.dao;

import java.util.List;

import ru.taxiservice.taxi.domain.User;
import ru.taxiservice.taxi.util.QueryCriteria;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO implements IUserDAO {

	@Autowired
    private SessionFactory sessionFactory;
	

	@SuppressWarnings("unchecked")
	@Override
	public List<User> find(QueryCriteria criteria) {
		return sessionFactory.getCurrentSession().createQuery("from User").list();
	}

	@Override
	public void save(User entity) {
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(User entity) {
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void remove(Long id) {
		User user = (User)sessionFactory.getCurrentSession().load(User.class, id);
		if (user != null) {
			sessionFactory.getCurrentSession().delete(user);
		}
	}

	@Override
	public User findById(Long id) {
		return (User)sessionFactory.getCurrentSession().get(User.class, id);
	}

}
