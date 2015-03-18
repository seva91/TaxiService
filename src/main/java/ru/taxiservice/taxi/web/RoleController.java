package ru.taxiservice.taxi.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import ru.taxiservice.taxi.domain.Role;
import ru.taxiservice.taxi.service.IRoleService;

@Controller
public class RoleController {

	@Autowired
	private IRoleService roleService;
	
	@RequestMapping("/roles")
	public String manageRoles(Map<String, Object> map) {
		map.put("roles", roleService.roles());
		return "roles";
	}
	
	@RequestMapping(value="/roles/add", method = RequestMethod.GET)
	public String addRoleForm(Map<String, Object> map) {
		map.put("action", "/taxi/roles/add");
		return "role";
	}
	
	@RequestMapping(value="/roles/add", method = RequestMethod.POST)
	public String addRole(@ModelAttribute("role") Role role, BindingResult result) {
		if (!result.hasErrors()) {
			role.setTaxiServiceId(1);
			roleService.addRole(role);
		}
		return "redirect:/roles";
	}
	
	@RequestMapping(value="/roles/remove/{id:[\\d]+}", method = RequestMethod.GET)
	public String removeRole(@PathVariable("id") Integer id) {
		roleService.removeRole(id);
		return "redirect:/roles"; 
	}
	
	@RequestMapping(value="/roles/removemany", method = RequestMethod.POST)
	public String removeManyRole(@RequestParam(value = "selected_roles[]", required=false) Integer[] selectedRoles) {
		if (selectedRoles != null)
			for (Integer id : selectedRoles) 
				roleService.removeRole(id);
		return "redirect:/roles";
	}
	
	@RequestMapping(value = "roles/edit/{id:[\\d]+}", method = RequestMethod.GET)
	public String editRole(@PathVariable("id") int id, Map<String, Object> map) {
		map.put("role", roleService.getRole(id));
		map.put("action", "/taxi/roles/edit");
		return "role";
	}
	
	@RequestMapping(value = "roles/edit", method = RequestMethod.POST)
	public String editRole(@ModelAttribute("role") Role role, BindingResult result) {
		if (!result.hasErrors()) {
			Role old = roleService.getRole(role.getId());
			if (old == null) return "redirect:/roles";
			role.setTaxiServiceId(old.getTaxiServiceId());
			roleService.editRole(role);
		}
		return "redirect:/roles";
	}
	
}
