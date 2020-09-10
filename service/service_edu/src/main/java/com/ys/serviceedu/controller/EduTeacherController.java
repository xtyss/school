package com.ys.serviceedu.controller;


import com.ys.serviceedu.entity.EduTeacher;
import com.ys.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ys
 * @since 2020-09-09
 */
@Api("讲师管理")
@RestController
@RequestMapping("/serviceedu/edu_teacher")
public class EduTeacherController {
    //把service注入
    @Autowired
    private EduTeacherService teacherService;

    //查询所有
    @ApiOperation("查询所有讲师")
    @GetMapping()
    public List<EduTeacher> findAll(){
        List<EduTeacher> eduTeacherList = teacherService.list(null);
        return eduTeacherList;
    }

    //逻辑删除
    @ApiOperation("根据ID逻辑删除讲师信息")
    @DeleteMapping("{id}")
    public boolean remove(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id){
        boolean b = teacherService.removeById(id);
        return b;
    }
}

