package com.demo.springcloud.weather.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Hello Controller.
 * 
 * @since 1.0.0 2017年9月27日
 * @author <a href="https://waylau.com">Way Lau</a> 
 */
@RestController
public class HelloController {
	@Value("${hello}")
	private String hello;
	@RequestMapping("/hello")
	public String hello() {
	    return hello;
	}

}
