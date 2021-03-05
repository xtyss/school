package com.ys.serviceoss.controller;

import com.ys.commonUtils.Result;
import com.ys.serviceoss.service.OssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduOss/fileOss")
@CrossOrigin
public class OssController {

    @Autowired
    private OssService ossService;
    @PostMapping("/uploadAvatarFile")
    public Result uploadAvatarFile(MultipartFile file){
        String url = ossService.uploadAvatarFile(file);
        return Result.success().data("url",url);
    }
}
