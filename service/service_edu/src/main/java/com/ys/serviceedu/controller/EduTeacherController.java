package com.ys.serviceedu.controller;


import com.ys.serviceedu.entity.EduTeacher;
import com.ys.serviceedu.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ys
 * @since 2020-09-09
 */
@RestController
@RequestMapping("/serviceedu/edu-teacher")
public class EduTeacherController {
    //把service注入
    @Autowired
    private EduTeacherService teacherService;

    //查询所有
    @GetMapping("get")
    public List<EduTeacher> findAll(){
        List<EduTeacher> eduTeacherList = teacherService.list(null);
        return eduTeacherList;
    }
}

