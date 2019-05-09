package com.demo.springcloud.weather.controller;

import java.util.List;

import com.demo.springcloud.weather.api.ApiClient;
import com.demo.springcloud.weather.api.vo.CityVo;
import com.demo.springcloud.weather.service.WeatherReportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * 天气预报API.
 * 
 * @since 1.0.0 2017年10月29日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherReportController.class);  
	
	@Autowired
	private WeatherReportService weatherReportService;
	@Autowired
	private ApiClient apiClient;

	@GetMapping("/cityId/{cityId}")
	public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
		// TODO 改为由城市数据API微服务来提供数据
		String uri = "";
		List<CityVo> cityList = null;
		try {
			// TODO 调用城市数据API
			cityList = apiClient.listCity();
			
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常!",e);
		}
		
		model.addAttribute("title", "老卫的天气预报");
		model.addAttribute("cityId", cityId);
		model.addAttribute("cityList", cityList);
		model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
		return new ModelAndView("weather/report", "reportModel", model);
	}

}
