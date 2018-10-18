package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MicroserviceConsumerFeignApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceConsumerFeignApplication.class, args);
    }
}
