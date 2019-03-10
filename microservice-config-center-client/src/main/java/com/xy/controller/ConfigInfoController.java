package com.xy.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RefreshScope
@RestController
public class ConfigInfoController {
    @Value("${info}")
    private String info;

    @RequestMapping("/configInfo")
    public String getConfigInfo() {
        return this.info;
    }
}
