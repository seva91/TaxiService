package ru.taxiservice.taxi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.taxiservice.taxi.dao.IRoleDAO;
import ru.taxiservice.taxi.domain.Role;
import ru.taxiservice.taxi.util.QueryCriteria;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleDAO roleDAO;
	
	@Transactional
	@Override
	public List<Role> roles() {
		return roleDAO.find(new QueryCriteria());
	}
	
	@Transactional
	@Override
	public void addRole(Role role) {
		roleDAO.save(role);
	}
	
	@Transactional
	@Override
	public void removeRole(Integer id) {
		roleDAO.remove(id);
	}
	
	@Transactional
	@Override
	public Role getRole(Integer id) {
		return roleDAO.findById(id);
	}
	
	@Transactional
	@Override
	public void editRole(Role role) {
		roleDAO.update(role);
	}
}
