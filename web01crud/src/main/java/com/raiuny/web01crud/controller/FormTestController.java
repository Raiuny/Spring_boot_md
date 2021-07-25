package com.raiuny.web01crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * 测试文件上传
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts() {
        return "form/form_layouts";
    }

    @PostMapping("/upload")
    public String upload(@RequestParam("email") String email, @RequestParam("username") String username, @RequestPart("headerImg") MultipartFile headerImg, @RequestPart("photos") MultipartFile[] photos) {
        log.info("上传的信息：email={}, username={}, headerImg={}, photos_num={}", email, username, headerImg.getSize(), photos.length);
        if(!headerImg.isEmpty()) {
            //保存到文件服务器，OSS服务器
            String originalFilename = headerImg.getOriginalFilename();
            try {
                headerImg.transferTo(new File("D:\\SpringBoot_Projects\\"+originalFilename));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(photos.length > 0) {
            for (MultipartFile photo : photos) {
                if (!photo.isEmpty()) {
                    String originalFilename = photo.getOriginalFilename();
                    try {
                        photo.transferTo(new File("D:\\SpringBoot_Projects\\photos\\" + originalFilename));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return "main";
    }
}
