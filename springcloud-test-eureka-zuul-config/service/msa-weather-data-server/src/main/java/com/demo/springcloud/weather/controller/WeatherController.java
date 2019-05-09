package com.demo.springcloud.weather.controller;

import com.demo.springcloud.weather.service.WeatherDataService;
import com.demo.springcloud.weather.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 天气API.
 * 
 * @since 1.0.0 2017年10月18日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/weather")
public class WeatherController {

	@Autowired
	private WeatherDataService weatherDataService;

	@GetMapping("/cityId/{cityId}")
	public WeatherResponse getReportByCityId(@PathVariable("cityId") String cityId) {
		return weatherDataService.getDataByCityId(cityId);
	}

	@GetMapping("/cityName/{cityName}")
	public WeatherResponse getReportByCityName(@PathVariable("cityName") String cityName) {
		return weatherDataService.getDataByCityName(cityName);
	}

}
