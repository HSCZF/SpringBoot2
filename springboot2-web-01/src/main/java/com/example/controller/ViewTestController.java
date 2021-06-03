package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewTestController {

    @GetMapping("/testHtml")
    public String testHtml(Model model) {

        model.addAttribute("msg", "你好！");
        model.addAttribute("link", "http://www.baidu.com");

        return "success";
    }

    ;


}
