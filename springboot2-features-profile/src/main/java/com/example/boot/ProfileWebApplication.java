package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MutablePropertySources;

import java.util.Map;


@SpringBootApplication
public class ProfileWebApplication {

    public static void main(String[] args) {

        // springboot 启动主类
        SpringApplication.run(ProfileWebApplication.class, args);

//        ConfigurableApplicationContext run = SpringApplication.run(ProfileWebApplication.class, args);
//
//        ConfigurableEnvironment environment = run.getEnvironment();
//
//        Map<String, Object> systemEnvironment = environment.getSystemEnvironment();
//
//        Map<String, Object> systemProperties = environment.getSystemProperties();
//
//        System.out.println(systemEnvironment);
//        System.out.println(systemProperties);

    }

}
