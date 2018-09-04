package com.xy.simpleDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user/{value}")
    public String toHelloService(@PathVariable("value") String value) {
        return userFeignClient.testHello(value);
    }

}
