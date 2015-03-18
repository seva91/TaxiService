package ru.taxiservice.taxi.service;

import java.util.List;

import ru.taxiservice.taxi.domain.User;

public interface IUserService {
	public void addUser(User user);
	public List<User> users();
	public void removeUser(Long id);
}
