package com.example.controller;

import com.example.bean.Car;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@ResponseBody
//@Controller

/**
 * @RestController = @ResponseBody + @Controller
 */
@Slf4j
@RestController
public class HelloController {

    @Autowired
    Car car;

    @RequestMapping("/car")
    public Car car() {

        return car;
    }

    @RequestMapping("/hello")
    public String handle01() {

        log.info("hello请求进来了");
        return "Hello, Spring Boot 2!";
    }

}
