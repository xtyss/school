package com.ys.serviceedu.service;

import com.ys.serviceedu.entity.EduSubject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ys.serviceedu.entity.subject.Subject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author ys
 * @since 2021-03-10
 */
public interface EduSubjectService extends IService<EduSubject> {

    void addSubject(MultipartFile file);

    /**
     * 查询课程列表
     * @return 课程列表树
     */
    List<Subject> getSubjectList();
}
