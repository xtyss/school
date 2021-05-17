package com.ys.serviceedu.controller;


import com.ys.commonUtils.Result;
import com.ys.serviceedu.entity.subject.Subject;
import com.ys.serviceedu.service.EduSubjectService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author ys
 * @since 2021-03-10
 */
@Api("课程管理")
@RestController
@CrossOrigin //跨域
@RequestMapping("/eduService/eduSubject")
public class EduSubjectController {
    @Autowired
    private EduSubjectService eduSubjectService;
    @PostMapping("/addSubject")
    public Result addSubject(MultipartFile file){
        eduSubjectService.addSubject(file);
        return Result.success();
    }

    @GetMapping("/getSubjectList")
    public Result getSubjectList(){
        List<Subject> subjectList = eduSubjectService.getSubjectList();
        return Result.success().data("list",subjectList);
    }
}

