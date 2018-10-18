package com.xy.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String test() {
        return "hello word cloud 8001";
    }
    @GetMapping("/hello/{value}")
    public String test(@PathVariable("value") String value) {
        return "hello word cloud 8001" + value;
    }
}
