package com.example.boot.controller;


import com.example.boot.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {


    @Value("${person.name:李四}")   // 绑定application.properties的值
    private String name;

    // 获取maven的环境变量,MAVEN_HOME：配置时候的命名
    @Value("${MAVEN_HOME}")
    private String msg;

    // 获取操作系统的名字
    @Value("${os.name}")
    private String osName;


    @Autowired
    private Person person;

    @GetMapping("/")
    public String hello(){

        return person.getClass().toString();
    }

    @GetMapping("/person")
    public Person person(){

        return person;
    }

    /**
     * 返回Maven的安装目录
     * @return
     */
    @GetMapping("/msg")
    public String getMsg(){
        return msg;
    }

    /**
     * 返回系统的名称
     * @return
     */
    @GetMapping("/osName")
    public String getOsName(){
        return osName;
    }



}
