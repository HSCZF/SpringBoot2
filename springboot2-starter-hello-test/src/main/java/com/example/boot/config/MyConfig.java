package com.example.boot.config;

import com.example.service.HelloService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfig {

    /**
     * 另一边的starter和这个starter的使用都需要重新clean和install，先后顺序，才能使用
     * @return
     */
    @Bean
    public HelloService helloService(){
        HelloService helloService = new HelloService();
        return helloService;
    }
}
