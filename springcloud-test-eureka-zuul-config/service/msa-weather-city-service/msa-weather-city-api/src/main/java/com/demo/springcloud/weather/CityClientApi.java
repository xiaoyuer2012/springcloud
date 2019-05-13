package com.demo.springcloud.weather;

import com.demo.springcloud.weather.vo.CityVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
@FeignClient(name="msa-weather-city-service",fallback=CityApiFallback.class)
public interface CityClientApi {
    @GetMapping("/cities")
    List<CityVo> listCity() throws Exception;
}
@Component
class CityApiFallback implements CityClientApi {

    @Override
    public List<CityVo> listCity() throws Exception {
        List<CityVo> cityList = new ArrayList<>();
        CityVo city = new CityVo();
        city.setCityId("101280601");
        city.setCityName("深圳");
        cityList.add(city);

        city = new CityVo();
        city.setCityId("101280301");
        city.setCityName("惠州");
        cityList.add(city);
        return cityList;
    }
}
