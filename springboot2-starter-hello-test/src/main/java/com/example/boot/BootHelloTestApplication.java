package com.example.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BootHelloTestApplication {


    public static void main(String[] args) {
        //另一边的starter和这个starter的使用都需要重新clean和install，先后顺序，才能使用
        SpringApplication.run(BootHelloTestApplication.class, args);
    }

}
