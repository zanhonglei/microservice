package com.xy.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Auther: zanhonglei
 * @Date: 2018/8/31 14:22
 * @Description:
 */
// name : Eureka服务注册表中的服
// url  : 请求的URL（可以是完成的URL或者是主机名）
@FeignClient(name = "microservice-provider-user",url = "http://localhost:8080/")
public interface UserFeignClient {
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String findSomething(@PathVariable("id") String id);
}
