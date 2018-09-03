package com.xy.controller;


import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservice-provider-8001",url = "http://localhost:8001/")
public interface UserFeignClient {
    @GetMapping(value = "/hello/{value}")
    public String testHello(@PathVariable("value") String value);

}
