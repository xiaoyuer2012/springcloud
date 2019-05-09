package com.demo.springcloud.weather.service;

import com.demo.springcloud.weather.vo.City;

import java.util.List;

/**
 * 城市数据服务接口.
 * 
 * @since 1.0.0 2017年10月23日
 * @author <a href="https://waylau.com">Way Lau</a>
 */
public interface CityDataService {

	/**
	 * 获取城市列表.
	 * 
	 * @return
	 * @throws Exception
	 */
	List<City> listCity() throws Exception;
}
