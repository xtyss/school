package com.ys.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ys.serviceedu.entity.EduTeacher;
import com.ys.serviceedu.entity.vo.QueryTeacher;
import com.ys.serviceedu.mapper.EduTeacherMapper;
import com.ys.serviceedu.service.EduTeacherService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author ys
 * @since 2020-09-09
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Override
    public void pageQuery(Page<EduTeacher> page, QueryTeacher teacherQuery) {
        QueryWrapper<EduTeacher> teacherQueryWrapper = new QueryWrapper<EduTeacher>();
        if (!StringUtils.isEmpty(teacherQuery.getName())){
            teacherQueryWrapper.like("name",teacherQuery.getName());
        }

        if (!StringUtils.isEmpty(teacherQuery.getLevel())){
            teacherQueryWrapper.eq("level",teacherQuery.getLevel());
        }

        if (!StringUtils.isEmpty(teacherQuery.getBegin())){
            teacherQueryWrapper.ge("gmt_create",teacherQuery.getBegin());
        }

        if (!StringUtils.isEmpty(teacherQuery.getEnd())){
            teacherQueryWrapper.le("gmt_create",teacherQuery.getEnd());
        }
        // 添加排序
        teacherQueryWrapper.orderByDesc("gmt_create");
        baseMapper.selectPage(page,teacherQueryWrapper);

    }
}
