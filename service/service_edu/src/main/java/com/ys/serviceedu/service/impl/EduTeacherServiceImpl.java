package com.ys.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ys.serviceedu.entity.EduTeacher;
import com.ys.serviceedu.entity.vo.QueryTeacher;
import com.ys.serviceedu.mapper.EduTeacherMapper;
import com.ys.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

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
        teacherQueryWrapper.like("name",teacherQuery.getName())
                .eq("level",teacherQuery.getLevel())
                .ge("gmt_create",teacherQuery.getBegin())
                .le("gmt_create",teacherQuery.getEnd());
        baseMapper.selectPage(page,teacherQueryWrapper);

    }
}
