package com.xy.customizing.javaconfig;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 使用@FeignClient的configuration属性,指定feign的配置类
 */
@FeignClient(name = "microservice-provider-8001", configuration = FeignConfiguration.class)
public interface UserFeignClient {

    /**
     * 使用feign自带的注解@RequestLine  和 @Param
     * @param id
     * @return
     */
    @RequestLine("GET /{id}")
    public String hello(@Param("id") String id);
}

/*

    还可以自定义
    Feign的编码器,解码器,日志打印,拦截器
 */