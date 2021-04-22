package com.ys.serviceedu.service;

import com.ys.serviceedu.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ys.serviceedu.entity.form.CourseInfoForm;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ys
 * @since 2021-04-21
 */
public interface EduCourseService extends IService<EduCourse> {
    /**
     * 新增课程
     *
     * @param courseInfoForm
     * @return
     */
    String addCourse(CourseInfoForm courseInfoForm);

}
