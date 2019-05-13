package com.demo.springcloud.weather;

import com.demo.springcloud.weather.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
@FeignClient(name="msa-weather-data-service",fallback=DataApiClientFallback.class)
public interface DataApiClient {
    @GetMapping("/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
@Component
class DataApiClientFallback implements DataApiClient{
    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return new WeatherResponse();
    }
}