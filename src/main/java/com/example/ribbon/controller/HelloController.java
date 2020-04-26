package com.example.ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.ribbon.config.RibbonConfiguration;

@RestController
@RequestMapping("/ribbon")
@RibbonClient(name = "ribbon-config", configuration = RibbonConfiguration.class)
public class HelloController {

	@Autowired
	RestTemplate restTemplate;

	@GetMapping
	public String hello() {
		String url = "http://hello-service/ribbon/dummy/service";
		return restTemplate.getForObject(url, String.class);
	}
}
