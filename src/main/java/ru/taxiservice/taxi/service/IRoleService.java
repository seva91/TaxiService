package ru.taxiservice.taxi.service;

import java.util.List;


import ru.taxiservice.taxi.domain.Role;

public interface IRoleService {
	List<Role> roles();
	
	void addRole(Role role);
	
	void removeRole(Integer id);
	
	Role getRole(Integer id);
	
	void editRole(Role role);
	
	
}
