package muratselcuk.hrms.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import muratselcuk.hrms.business.abstracts.CityService;
import muratselcuk.hrms.core.utilities.results.DataResult;
import muratselcuk.hrms.entities.concretes.City;

@RestController
@RequestMapping("/api/cities")
public class CityController {

	private CityService cityService;
	
	@Autowired
	public CityController(CityService cityService) {
		super();
		this.cityService = cityService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<City>> getAll() {
		return this.cityService.getAll();
	}
	
}
