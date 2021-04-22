package com.ys.serviceedu.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ys.serviceedu.entity.EduSubject;
import com.ys.serviceedu.entity.excel.SubjectExcel;
import com.ys.serviceedu.service.EduSubjectService;

/**
 * @author ys
 */
public class AddSubjectListener extends AnalysisEventListener<SubjectExcel> {
    private EduSubjectService eduSubjectService;
    public AddSubjectListener(EduSubjectService eduSubjectService){
        this.eduSubjectService = eduSubjectService;
    }

    @Override
    public void invoke(SubjectExcel subjectExcel, AnalysisContext analysisContext) {
        // 看一级代码是否存在
        EduSubject eduSubjectParent = subjectOneExit(subjectExcel);
        if (eduSubjectParent==null){
            eduSubjectParent.setTitle(subjectExcel.getOneSubject())
                    .setParentId("0");
            eduSubjectService.save(eduSubjectParent);
        }
        String pid = eduSubjectParent.getId();
        EduSubject eduSubject = subjectTwoExit(subjectExcel,pid);
        if(eduSubject==null){
            EduSubject eduSubjectTwo = new EduSubject();
            eduSubjectTwo.setTitle(subjectExcel.getTwoSubject())
                    .setParentId(pid);
            eduSubjectService.save(eduSubjectTwo);
        }

    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }

    /**
     * 一级对应代码是否存在
     * @param subjectExcel 读取的一行Excel
     * @return 存在为ture,不存在为false
     */
    private EduSubject subjectOneExit(SubjectExcel subjectExcel){
        QueryWrapper<EduSubject> eduSubjectQueryWrapper = new QueryWrapper<>();
        eduSubjectQueryWrapper.eq("title",subjectExcel.getOneSubject())
                .eq("parent_id","0");
        EduSubject one = eduSubjectService.getOne(eduSubjectQueryWrapper);
        return one;
    }

    private EduSubject subjectTwoExit(SubjectExcel subjectExcel,String pid){
        QueryWrapper<EduSubject> eduSubjectQueryWrapper = new QueryWrapper<>();
        eduSubjectQueryWrapper.eq("title",subjectExcel.getTwoSubject())
                .eq("parent_id",pid);
        EduSubject one = eduSubjectService.getOne(eduSubjectQueryWrapper);
        return one;
    }
}
