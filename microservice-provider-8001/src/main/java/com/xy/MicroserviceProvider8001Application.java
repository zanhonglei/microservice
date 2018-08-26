package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProvider8001Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProvider8001Application.class, args);
	}
}
