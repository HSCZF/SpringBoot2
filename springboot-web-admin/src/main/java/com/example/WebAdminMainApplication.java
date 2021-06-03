package com.example;

import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.stereotype.Component;

/**
 * 主程序类：启动类所在的包是最顶部的包，
 * 也不能直接放在main/java文件下，
 * 启动类所在的包是最顶部的包，
 * springboot 的启动类必须要放在其他包的外层。
 *
 * @SpringBootApplication：这是一个SpringBoot应用
 * @MapperScan：要是每个mapper都觉得加@Mapper麻烦，直接在启动类中指定mapper位置即可，建议使用@MapperScan
 */
@ServletComponentScan(basePackages = "com.example")
@MapperScan(basePackages = "com.example.mapper")
@EnableConfigurationProperties
@SpringBootApplication
public class WebAdminMainApplication {

    public static void main(String[] args) {
        // 启动主类，固定写法
        SpringApplication.run(WebAdminMainApplication.class, args);

    }
}
