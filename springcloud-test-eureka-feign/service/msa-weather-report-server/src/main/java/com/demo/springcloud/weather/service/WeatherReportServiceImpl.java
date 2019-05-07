package com.demo.springcloud.weather.service;

import com.demo.springcloud.weather.weatherDataServerApi.WeatherDataClient;
import com.demo.springcloud.weather.weatherDataServerApi.vo.Weather;
import com.demo.springcloud.weather.weatherDataServerApi.vo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 天气预报服务.
 * 
 * @since 1.0.0 2017年10月25日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@Service
public class WeatherReportServiceImpl implements WeatherReportService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private WeatherDataClient weatherDataClient;
	@Override
	public Weather getDataByCityId(String cityId) {
		// TODO 改为由天气数据API微服务来提供数据
		WeatherResponse response = weatherDataClient.getDataByCityId(cityId);
		return response.getData();
	}

}
