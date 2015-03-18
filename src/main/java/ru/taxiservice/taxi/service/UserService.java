package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.dao.IUserDAO;
import ru.taxiservice.taxi.domain.User;
import ru.taxiservice.taxi.util.QueryCriteria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDAO userDAO;
	
	@Transactional
	@Override
	public void addUser(User user) {
		userDAO.save(user);
	}

	@Transactional
	@Override
	public List<User> users() {
		return userDAO.find(new QueryCriteria());
	}

	@Transactional
	@Override
	public void removeUser(Long id) {
		userDAO.remove(id);
	}

}
