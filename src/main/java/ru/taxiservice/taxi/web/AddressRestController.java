package ru.taxiservice.taxi.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.taxiservice.taxi.domain.City;
import ru.taxiservice.taxi.domain.Street;
import ru.taxiservice.taxi.service.ICityService;
import ru.taxiservice.taxi.service.IStreetService;

@RestController
public class AddressRestController {

	@Autowired
	private IStreetService streetService;
	
	@Autowired
	private ICityService cityService;
	
	
	@RequestMapping(value = "/streets", method = { RequestMethod.GET })
	public List<Street> streets(@RequestParam(value = "cityId", required=true) Integer cityId, @RequestParam(value = "term", required=true) String term) {
		return streetService.streets(cityId, term);
	}
	
	@RequestMapping(value = "/cities", method = { RequestMethod.GET })
	public List<City> cities(@RequestParam(value = "term", required = true) String term) {
		return cityService.cities(term);
	}
	
}
