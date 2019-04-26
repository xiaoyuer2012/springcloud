package com.demo.springcloud.weather.controller;

import java.util.List;

import com.demo.springcloud.weather.service.CityDataService;
import com.demo.springcloud.weather.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 城市API.
 * 
 * @since 1.0.0 2017年10月30日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/cities")
public class CityController {

	@Autowired
	private CityDataService cityDataService;

	@GetMapping
	public List<City> listCity() throws Exception {
		return cityDataService.listCity();
	}

}
