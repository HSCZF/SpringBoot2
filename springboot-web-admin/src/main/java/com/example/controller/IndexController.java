package com.example.controller;

import com.example.bean.Account;
import com.example.bean.City;
import com.example.bean.User;
import com.example.service.impl.AccountServiceImpl;
import com.example.service.impl.CityServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
public class IndexController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    AccountServiceImpl accountServiceImpl;

    @Autowired
    CityServiceImpl cityServiceImpl;


    @ResponseBody
    @PostMapping("/city")
    public City saveCity(City city) {
        cityServiceImpl.saveCity(city);
        return city;
    }

    @ResponseBody
    @GetMapping("/city")
    public City getById(@RequestParam("id") Long id) {
        return cityServiceImpl.getCityById(id);
    }

    @ResponseBody
    @GetMapping("/acct")
    public Account getById(@RequestParam("id") Integer id) {
        return accountServiceImpl.getAccountById(id);
    }


    @ResponseBody
    @GetMapping("/sql")
    public String queryForObject() {
        Long aLong = jdbcTemplate.queryForObject("select count(*) from user", Long.class);
        return aLong.toString();
    }

    /**
     * 去到登录页
     *
     * @return
     */
    @GetMapping(value = {"/", "/login"})
    public String loginPage() {

        return "login";
    }

    @PostMapping("/login")
    public String main(User user, HttpSession session, Model model) {

        if (!ObjectUtils.isEmpty(user.getUserName()) && !ObjectUtils.isEmpty(user.getPassword()) && "123456".equals(user.getPassword())) {
            // 把登录成功的用户保存起来
            session.setAttribute("loginUser", user);
            // return "main";
            // 登录成功重定向到main.html，与下方的方法对应，防止表单重复提交
            return "redirect:/main.html";
        } else {
            model.addAttribute("msg", "账号或密码错误");
            return "login";
        }

    }

    /**
     * 去main页面
     *
     * @return
     */
    @GetMapping("/main.html")
    public String mainPage(HttpSession session, Model model) {

        log.info("当前方法是：{}", "mainPage");

        // 是否登录，一般都是用拦截器、过滤器
        // 已配置有拦截器，不需要在做检查了
        /*
            Object loginUser = session.getAttribute("loginUser");
            if(loginUser != null){
                return "main";
            }else {
                model.addAttribute("msg", "请重新登录");
                return "login";
            }
        */

        return "main";

    }

}
