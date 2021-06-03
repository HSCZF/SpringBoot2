package com.example.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bean.User;
import com.example.bean.UserTest;
import com.example.service.UserTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    UserTestService userTestService;

    @GetMapping("/basic_table")
    public String basic_table() {

        return "table/basic_table";
    }

    /**
     * 根据id删除
     *
     * @param id
     * @param pn
     * @param ra
     * @return
     */
    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id,
                             @RequestParam(value = "pn", defaultValue = "1") Integer pn,
                             RedirectAttributes ra) {

        userTestService.removeById(id);

        ra.addAttribute("pn", pn);
        return "redirect:/dynamic_table";
    }

    /**
     * 分页查询
     *
     * @param pn
     * @param model
     * @return
     */
    @GetMapping("/dynamic_table")
    public String dynamic_table(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {

        List<UserTest> list = userTestService.list();
        model.addAttribute("users", list);

        // 分页查询数据
        Page<UserTest> userTestPage = new Page<>(pn, 2);
        // 分页查询结果
        Page<UserTest> page = userTestService.page(userTestPage, null);
//        long current = page.getCurrent();
//        long pages = page.getPages();
//        long total = page.getTotal();
//        List<UserTest> records = page.getRecords();

        model.addAttribute("page", page);

        return "table/dynamic_table";
    }

    @GetMapping("/responsive_table")
    public String responsive_table() {

        return "table/responsive_table";
    }

    @GetMapping("/editable_table")
    public String editable_table() {

        return "table/editable_table";
    }

}
