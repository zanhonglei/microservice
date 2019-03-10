package com.xy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableDiscoveryClient //eureka 客户端 把配置中心注册到注册中心
public class MicroserviceConfigCenterApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceConfigCenterApplication.class, args);
	}

}
