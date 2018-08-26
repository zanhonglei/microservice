package com.xy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("toHello")
    public String toProvider() {
        return restTemplate.getForObject("http://microservice-provider/hello", String.class, new Object());
    }

}
