package ru.taxiservice.taxi.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import ru.taxiservice.taxi.service.IRoleService;
import ru.taxiservice.taxi.service.IUserService;

@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@RequestMapping(value="/users")
	public String users(Map<String, Object> map) {
		map.put("users", userService.users());
		return "users";
	}
}
