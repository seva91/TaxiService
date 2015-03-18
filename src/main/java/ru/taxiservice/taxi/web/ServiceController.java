package ru.taxiservice.taxi.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ru.taxiservice.taxi.domain.Service;
import ru.taxiservice.taxi.service.ICityService;
import ru.taxiservice.taxi.service.IServiceService;

@Controller
public class ServiceController {

	@Autowired
	private IServiceService serviceSer;
	
	@javax.annotation.Resource(name="cityService")
	private ICityService cityService;
	
	@RequestMapping(value="/services")
	public String services(Map<String, Object> map) {
		map.put("services", serviceSer.services());
		return "services";
	}
	
	@RequestMapping(value = "/services/add", method = RequestMethod.GET)
	public String add(ModelMap map, @ModelAttribute(value = "service") Service service) {
		map.put("cities", cityService.cities());
		map.put("action", "/services/add");
		return "service";
	}
	
	@RequestMapping(value = "/services/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("service") Service service, BindingResult result) {
		if (!result.hasErrors()) {
			service.setTaxiServiceId(1);
			serviceSer.addService(service);
		}
		return "redirect:/services";
	}
	
	@RequestMapping(value = "/service/edit/{id:[\\d]+}", method = RequestMethod.GET)
	public String edit(@PathVariable(value="id") Long id, ModelMap model) {
		Service service = serviceSer.getService(id);
		if (service == null) return "redirect:/services";
		model.addAttribute("service", service);
		model.put("action", "/services/edit");
		model.put("cities", cityService.cities());
		return "service";
	}
}
