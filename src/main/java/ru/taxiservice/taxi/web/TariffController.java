package ru.taxiservice.taxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ru.taxiservice.taxi.domain.Service;
import ru.taxiservice.taxi.domain.Tariff;
import ru.taxiservice.taxi.service.IServiceService;
import ru.taxiservice.taxi.service.ITariffService;

@Controller
public class TariffController {

	@Autowired
	@Qualifier("tariffService")
	private ITariffService serviceTariff;
	
	@javax.annotation.Resource(name="service")
	private IServiceService serviceService;
	
	@RequestMapping(value = "/tariffs", method = { RequestMethod.GET })
	public ModelAndView tariffs(ModelMap model) {
		List<Tariff> tariffs = serviceTariff.tariffs(0, 10);
		model.put("tariffs", tariffs);;
		ModelAndView view = new ModelAndView("tariffs");
		return view;
	}
	
	@RequestMapping(value = "/tariffs/{page:[\\d]+}", method = { RequestMethod.GET })
	public ModelAndView tariffs(ModelMap model, @PathVariable(value = "page") int page, @RequestParam(value = "items", required = true, defaultValue = "10") int items) {
		List<Tariff> tariffs = serviceTariff.tariffs(page, items);
		model.put("tariffs", tariffs);
		ModelAndView view = new ModelAndView("tariffs");
		return view;
	}
	
	@RequestMapping(value = "/tariff/add", method = { RequestMethod.GET })
	public ModelAndView add(@ModelAttribute(value = "tariff") Tariff tariff, ModelMap model) {
		model.put("action", "/tariff/add");
		ModelAndView view = new ModelAndView("tariff");
		List<Service> services = serviceService.services();
		model.put("services", services);System.out.println(services.size());
		return view;
	}
	
	@RequestMapping(value = "/tariff/add", method = { RequestMethod.POST })
	public String add(@ModelAttribute(value = "tariff") Tariff tariff, BindingResult result) {
		if (!result.hasErrors()) {
			serviceTariff.addTariff(tariff);
		}
		return "redirect:/tariffs";
	}
	
	@RequestMapping(value = "/tariff/edit/{id:[\\d]+}", method = { RequestMethod.GET })
	public ModelAndView edit(ModelMap model, @PathVariable(value = "id") int id) {
		model.put("action", "/tariff/edit");
		Tariff tariff = serviceTariff.getTariff(id);
		model.put("tariff", tariff);
		ModelAndView view = new ModelAndView("tariff");
		return view;
	}
	
	@RequestMapping(value = "/tariff/edit", method = { RequestMethod.POST })
	public String edit(@ModelAttribute(value = "tariff") Tariff tariff, BindingResult result) {
		if (!result.hasErrors()) {
			serviceTariff.editTariff(tariff);
		}
		return "redirect:/tariffs";
	}
	
	@RequestMapping(value = "/tariffs/remove", method = { RequestMethod.POST })
	public String removeMulti(@RequestParam(value = "selected_tariff[]", required = false) int[] selectedTariff) {
		if (selectedTariff != null)
			for (int tariffId : selectedTariff)
				serviceTariff.removeTariff(tariffId);
		return "redirect:/tariffs";
	}
	
	@RequestMapping(value = "/tariff/remove/{id:[\\d]+}", method = { RequestMethod.GET })
	public String remove(@PathVariable(value = "id") int id) {
		serviceTariff.removeTariff(id);
		return "redirect:/tariffs";
	}
	
}
