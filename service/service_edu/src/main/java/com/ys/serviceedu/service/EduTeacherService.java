package com.ys.serviceedu.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ys.serviceedu.entity.EduTeacher;
import com.ys.serviceedu.entity.vo.QueryTeacher;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author ys
 * @since 2020-09-09
 */
public interface EduTeacherService extends IService<EduTeacher> {

    void pageQuery(Page<EduTeacher> pageParam, QueryTeacher teacherQuery);

}
