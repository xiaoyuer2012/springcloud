package com.demo.springcloud.weather.api;

import com.demo.springcloud.weather.api.vo.CityVo;
import com.demo.springcloud.weather.api.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
@FeignClient("zuul-server")
public interface ApiClient {
    @GetMapping("/city/cities")
    List<CityVo> listCity() throws Exception;

    @GetMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
