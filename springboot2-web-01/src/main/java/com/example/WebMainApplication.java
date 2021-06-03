package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * 主程序类：启动类所在的包是最顶部的包，
 * 也不能直接放在main/java文件下，
 * 启动类所在的包是最顶部的包，
 * springboot 的启动类必须要放在其他包的外层。
 *
 * @SpringBootApplication：这是一个SpringBoot应用
 */
@EnableConfigurationProperties
@SpringBootApplication
public class WebMainApplication {

    public static void main(String[] args) {
        // 启动主类，固定写法
        SpringApplication.run(WebMainApplication.class, args);


    }
}
