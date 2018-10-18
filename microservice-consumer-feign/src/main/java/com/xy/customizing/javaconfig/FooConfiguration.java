package com.xy.customizing.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;

/**
 * 甚至一些接口需要进行基于Http basic的认证后才能调用
 */
public class FooConfiguration {
    @Bean
    public BasicAuthorizationInterceptor basicAuthorizationInterceptor() {
        return new BasicAuthorizationInterceptor("user", "password");
    }
}
