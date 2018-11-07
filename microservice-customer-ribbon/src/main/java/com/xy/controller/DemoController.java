package com.xy.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @Auther: zanhonglei
 * @Date: 2018/11/7 19:54
 * @Description:
 */
@Controller
public class DemoController {

    private Logger logger = Logger.getLogger(this.getClass());

    @Autowired
    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    public String test() {
        return restTemplate.getForObject("http://microservice-provider/hello",String.class);
    }

    @GetMapping("/logUserInstance")
    public void logUserInstance() {
        ServiceInstance serviceInstance = loadBalancerClient.choose("microservice-provider");
        logger.info(serviceInstance.getServiceId() + ":" +serviceInstance.getHost() + ":" + serviceInstance.getPort());
    }
}
