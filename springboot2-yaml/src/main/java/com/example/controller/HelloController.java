package com.example.controller;

import com.example.bean.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @Autowired
    Person person;

    @RequestMapping("/person")
    public Person person() {
        int age = person.getAge();
        System.out.println("年龄=" + age);
        return person;
    }

}
