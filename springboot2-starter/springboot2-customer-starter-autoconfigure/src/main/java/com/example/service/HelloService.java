package com.example.service;


import com.example.bean.HelloProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 默认不放在容器中
 */
public class HelloService {

    @Autowired
    HelloProperties helloProperties;

    public String sayHello(String userName) {
        return helloProperties.getPrefix() + "：" + userName + ">>" + helloProperties.getSuffix();
    }

}
