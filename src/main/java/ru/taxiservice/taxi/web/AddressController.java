package ru.taxiservice.taxi.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.taxiservice.taxi.domain.Address;
import ru.taxiservice.taxi.service.IAddressService;
import ru.taxiservice.taxi.service.ICityService;

@Controller
public class AddressController {

	@Autowired
	private IAddressService addrService;
	
	@Autowired 
	private ICityService cityService;
	
	@RequestMapping(value = "/addresses", method = RequestMethod.GET)
	public String addresses(Map<String, Object> map) {
		map.put("addresses", addrService.addresses()); 
		return "addresses";
	}
	
	@RequestMapping(value = "/addresses/add", method = { RequestMethod.GET })
	public String addressAdd(ModelMap model) {
		model.put("action", "/taxi/addresses/add");
		Address address = new Address();
		model.addAttribute("address", address); 
		return "address";
	}
	
	@RequestMapping(value = "/addresses/add", method = { RequestMethod.POST })
	public String addressAdd(@ModelAttribute("address") Address address, BindingResult result) {
		if (!result.hasErrors()) {
			addrService.addAddress(address);
		}
		
		return "redirect:/addresses";
	}
	
	
	
}
