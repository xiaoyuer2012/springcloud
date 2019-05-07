package com.demo.springcloud.weather.cityServerApi;

import com.demo.springcloud.weather.cityServerApi.vo.CityVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient("msa-weather-city-service")
public interface CityClient {
    @GetMapping("/cities")
    List<CityVo> listCity() throws Exception;
}
