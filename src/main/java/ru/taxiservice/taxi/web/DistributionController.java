package ru.taxiservice.taxi.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ru.taxiservice.taxi.domain.Distribution;
import ru.taxiservice.taxi.service.IDistributionService;

@Controller
public class DistributionController {

	@Autowired
	private IDistributionService distrService;
	
	@RequestMapping(value = "/distributions", method = { RequestMethod.GET })
	public String distributions(ModelMap model) {
		List<Distribution> distrs = distrService.distributions();
		model.put("distributions", distrs);
		return "distributions"; 
	}
	
	@RequestMapping(value = "/distribution/add", method = { RequestMethod.GET })
	public ModelAndView distribution(ModelMap model, @ModelAttribute(value = "distribution") Distribution distr) {
		model.put("action", "/taxi/distribution/add");
		ModelAndView view = new ModelAndView("distribution");
		return view;
	}
	
	@RequestMapping(value = "/distribution/edit/{id:[\\d]+}", method = { RequestMethod.GET })
	public ModelAndView distribution(ModelMap model, @PathVariable(value = "id") Long id) {
		Distribution distr = distrService.getDistr(id);
		model.put("distribution", distr);
		model.put("action", "/taxi/distribution/edit");
		ModelAndView view = new ModelAndView("distribution");
		return view;
	}
	
	@RequestMapping(value = "/distribution/edit", method = { RequestMethod.POST })
	public String distributionEdit(@ModelAttribute(value = "distribution") Distribution distr, BindingResult result) {
		System.out.println(Arrays.toString(result.getAllErrors().toArray()));
		if (!result.hasErrors()) {
			distrService.editDistr(distr);
		}
		return "redirect:/distributions";
	}
	
	@RequestMapping(value = "/distribution/add", method = { RequestMethod.POST })
	public String distributionAdd(@ModelAttribute(value = "distribution") Distribution distr, BindingResult result) {
		if (!result.hasErrors()) {
			distrService.addDistr(distr);
		}
		return "redirect:/distributions";
	}
	
}
