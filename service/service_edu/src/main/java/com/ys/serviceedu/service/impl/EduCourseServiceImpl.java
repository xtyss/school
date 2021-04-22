package com.ys.serviceedu.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ys.service_base.exceptionhandler.YsException;
import com.ys.serviceedu.entity.EduCourse;
import com.ys.serviceedu.entity.EduCourseDescription;
import com.ys.serviceedu.entity.form.CourseInfoForm;
import com.ys.serviceedu.mapper.EduCourseMapper;
import com.ys.serviceedu.service.EduCourseDescriptionService;
import com.ys.serviceedu.service.EduCourseService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author ys
 * @since 2021-04-21
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionService eduCourseDescriptionService;

    @Override
    public String addCourse(CourseInfoForm courseInfoForm) {
        EduCourse eduCourse = new EduCourse();
        BeanUtils.copyProperties(courseInfoForm,eduCourse);
        boolean saveFlag = this.save(eduCourse);
        if (!saveFlag){
            throw new YsException(20001,"课程新建失败");
        }

        EduCourseDescription eduCourseDescription = new EduCourseDescription();
        eduCourseDescription.setDescription(courseInfoForm.getDescription());
        eduCourseDescription.setId(courseInfoForm.getId());
        boolean desFlag = eduCourseDescriptionService.save(eduCourseDescription);
        if (!desFlag){
            throw new YsException(20001,"课程新建失败");
        }

        return eduCourse.getId();
    }
}
