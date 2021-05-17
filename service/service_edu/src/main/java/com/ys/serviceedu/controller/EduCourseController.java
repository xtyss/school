package com.ys.serviceedu.controller;


import com.ys.commonUtils.Result;
import com.ys.serviceedu.entity.form.CourseInfoForm;
import com.ys.serviceedu.service.EduCourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ys
 * @since 2021-04-21
 */
@Api("课程管理相关需求")
@RestController
@CrossOrigin
@RequestMapping("/eduService/edu-course")
public class EduCourseController {

    @Autowired
    private EduCourseService eduCourseService;


    @ApiOperation(value = "新增课程")
    @PostMapping("/addCourse")
    public Result addCourse(	@ApiParam(name = "CourseInfoForm", value = "课程基本信息", required = true)
                                    @RequestBody CourseInfoForm courseInfoForm){
        String courseId  = eduCourseService.addCourse(courseInfoForm);
        return Result.success().data("courseId",courseId);
    }
}

