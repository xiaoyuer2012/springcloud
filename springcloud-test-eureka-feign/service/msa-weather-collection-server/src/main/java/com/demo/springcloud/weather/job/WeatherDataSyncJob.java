package com.demo.springcloud.weather.job;

import java.util.List;

import com.demo.springcloud.weather.cityServerApi.CityClient;
import com.demo.springcloud.weather.cityServerApi.vo.CityVo;
import com.demo.springcloud.weather.service.WeatherDataCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * 天气数据同步任务.
 * 
 * @since 1.0.0 2017年10月29日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
public class WeatherDataSyncJob extends QuartzJobBean {
	
	private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class); 

	@Autowired
	private WeatherDataCollectionService weatherDataCollectionService;
	@Autowired
	private CityClient cityClient;
	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		logger.info("Start 天气数据同步任务");
		
		// TODO 改为由城市数据API微服务来提供数据
		
		List<CityVo> cityList = null;
		try {
			// TODO 调用城市数据API
			cityList = cityClient.listCity();
			
		} catch (Exception e) {
			logger.error("获取城市信息异常！", e);
			throw new RuntimeException("获取城市信息异常！", e);
		}
		
		for (CityVo city : cityList) {
			String cityId = city.getCityId();
			logger.info("天气数据同步任务中，cityId:" + cityId);
			
			// 根据城市ID同步天气数据
			weatherDataCollectionService.syncDataByCityId(cityId);
		}
		
		logger.info("End 天气数据同步任务");
	}

}
