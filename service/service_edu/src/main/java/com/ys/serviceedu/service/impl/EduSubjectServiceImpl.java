package com.ys.serviceedu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ys.service_base.exceptionhandler.YsException;
import com.ys.serviceedu.entity.EduSubject;
import com.ys.serviceedu.entity.excel.SubjectExcel;
import com.ys.serviceedu.entity.subject.Subject;
import com.ys.serviceedu.listener.AddSubjectListener;
import com.ys.serviceedu.mapper.EduSubjectMapper;
import com.ys.serviceedu.service.EduSubjectService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author ys
 * @since 2021-03-10
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void addSubject(MultipartFile file) {
        try {
            System.out.println(this.getClass());
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream,SubjectExcel.class,new AddSubjectListener(this)).sheet().doRead();
        } catch (Exception e) {
            e.printStackTrace();
            throw new YsException(20002,"添加课程分类失败");
        }

    }

    @Override
    public List<Subject> getSubjectList() {
        // 创建查询一级分类的Wrapper
        QueryWrapper<EduSubject> subjectQueryWrapper1 = new QueryWrapper<>();
        // 创建查询二级分类的wrapper
        QueryWrapper<EduSubject> subjectQueryWrapper2 = new QueryWrapper<>();

        //查询出数据
        subjectQueryWrapper1.eq("parent_id","0");
        List<EduSubject> eduSubjectList1 = this.list(subjectQueryWrapper1);
        subjectQueryWrapper2.ne("parent_id","0");
        List<EduSubject> eduSubjectList2 = this.list(subjectQueryWrapper2);

        // 创建返回list容器

        ArrayList<Subject> subjects = new ArrayList<>();
        eduSubjectList1.forEach(eduSubject -> {

            //创建子容器

            ArrayList<Subject> subjectsLv2 = new ArrayList<>();
            String id = eduSubject.getId();
            eduSubjectList2.forEach(eduSubject2 -> {
                if (eduSubject2.getParentId().equalsIgnoreCase(id)){

                    Subject subject = new Subject();
                    subject.setId(eduSubject2.getId());
                    subject.setLabel(eduSubject2.getTitle());
                    subjectsLv2.add(subject);
                }

            });
            Subject subject = new Subject();
            subject.setId(eduSubject.getId());
            subject.setLabel(eduSubject.getTitle());
            subject.setChildren(subjectsLv2);
            subjects.add(subject);
        });
        return subjects;
    }
}
