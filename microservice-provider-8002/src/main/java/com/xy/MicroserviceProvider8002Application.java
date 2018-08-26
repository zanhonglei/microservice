package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceProvider8002Application {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceProvider8002Application.class, args);
	}
}
