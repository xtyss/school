package com.ys.serviceedu.service;

import com.ys.serviceedu.entity.EduChapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ys.serviceedu.entity.chapter.ChapterVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author ys
 * @since 2021-04-21
 */
public interface EduChapterService extends IService<EduChapter> {
    /**
     * 查询课程列表
     * @param courseId 课程id
     * @return
     */
    List<ChapterVo> nestedList(String courseId);
}
