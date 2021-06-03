package com.example.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 文件上传测试
 */
@Slf4j
@Controller
public class FormTestController {

    @GetMapping("/form_layouts")
    public String form_layouts() {

        //int sum = 10/0;

        return "form/form_layouts";
    }

    /**
     * 文件上传，MultipartFile：自动封装上传过来的文件
     *
     * @param email
     * @param username
     * @param headerImg
     * @param photos
     * @return
     */
    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headerImg") MultipartFile headerImg,
                         @RequestPart("photos") MultipartFile[] photos) throws IOException {
        log.info("上传的信息：email={}, username={},headerImg={},photos={}",
                email, username, headerImg.getSize(), photos.length);

        if (!headerImg.isEmpty()) {
            // 保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("E:\\IdeaProjects\\SpringBoot2\\image\\" + originalFilename));
        }
        if (photos.length > 0) {
            for (MultipartFile photo : photos) {
                String photoOriginalFilename = photo.getOriginalFilename();
                if (!photo.isEmpty()) {
                    photo.transferTo(new File("E:\\IdeaProjects\\SpringBoot2\\image\\" + photoOriginalFilename));
                }
            }
        }

        return "main";
    }

}
