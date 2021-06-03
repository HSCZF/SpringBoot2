package com.example.auto;


import com.example.bean.HelloProperties;
import com.example.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HelloProperties.class)  // 开启自动绑定属性功能,默认HelloProperties放在容器中
public class HellServiceAutoConfiguration {

    @ConditionalOnMissingBean(HelloService.class)   // 没有这个HelloProperties.class属性才会进行条件装配
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }

}
