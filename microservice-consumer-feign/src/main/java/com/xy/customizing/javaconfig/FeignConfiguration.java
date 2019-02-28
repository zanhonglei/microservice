package com.xy.customizing.javaconfig;


import feign.Contract;
import org.springframework.context.annotation.Bean;

/**
 * 该类为Feign的配置类
 * 注意:该类不可以加@Configuration注解;
 * 如果加了@configuration注解,那么该类不能放在主应用程序上下文@ComponentScan所扫描的包中
 */
public class FeignConfiguration {

    /**
     * 将契约改为feign原生的默认契约,就可以使用feign自带的注解了
     * @return
     */
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
}
