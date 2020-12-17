package com.yunbao.jctest.controller;

import com.yunbao.jctest.utils.FileUtils;
import com.yunbao.jctest.utils.PicReduce;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * @Author: djl
 * @Date: 2020/6/4 10:56
 * @Version 1.0
 */
@RestController
@RequestMapping("ins")
@Slf4j
public class InstructionController {


    @PostMapping("upload")
    @ResponseBody
    public String updateLoadFile (MultipartFile file,Long id) {
        log.info("入参：" + id);
        System.out.println(id);
        String appNamePath = "e:/app/" + UUID.randomUUID()+ "_" +file.getOriginalFilename();
        try {
            System.out.println("上传图片时间:" + new Date());
            FileUtils.copyInputStreamToFile(file.getInputStream(), new File(appNamePath));
            System.out.println("上传图片时间结束:" + new Date());
            PicReduce.zipImageFile(appNamePath, PicReduce.getImgWidth(new File(appNamePath)), PicReduce.getImgWidth(new File(appNamePath)), 1f, "");
            System.out.println("解压结束:" + new Date());
            return "success";
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
