package com.ys.serviceedu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ys.serviceedu.entity.EduChapter;
import com.ys.serviceedu.entity.EduVideo;
import com.ys.serviceedu.entity.chapter.ChapterVo;
import com.ys.serviceedu.entity.chapter.VideoVo;
import com.ys.serviceedu.mapper.EduChapterMapper;
import com.ys.serviceedu.service.EduChapterService;
import com.ys.serviceedu.service.EduVideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author ys
 * @since 2021-04-21
 */
@Service
public class EduChapterServiceImpl extends ServiceImpl<EduChapterMapper, EduChapter> implements EduChapterService {
    @Autowired
    private EduVideoService eduVideoService;
    @Override
    public List<ChapterVo> nestedList(String courseId) {
        ArrayList<ChapterVo> chapterVoArrayList = new ArrayList<>();

        // 获取章节信息
        QueryWrapper<EduChapter> chapteWrapper = new QueryWrapper<>();
        chapteWrapper.eq("course_id",courseId);
        chapteWrapper.orderByAsc("sort","id");
        List<EduChapter> eduChapters = baseMapper.selectList(chapteWrapper);

        // 查询小节
        QueryWrapper<EduVideo> videoWrapper = new QueryWrapper<>();
        videoWrapper.eq("course_id",courseId);
        videoWrapper.orderByAsc("sort","id");
        List<EduVideo> videoList = eduVideoService.list(videoWrapper);

        // 循环添加,组合成想要的数据结构
        int count1 = eduChapters.size();
        for (int i = 0; i < count1; i++) {
            EduChapter chapter = eduChapters.get(i);

            //创建章节vo对象
            ChapterVo chapterVo = new ChapterVo();
            BeanUtils.copyProperties(chapter, chapterVo);
            chapterVoArrayList.add(chapterVo);

            //填充课时vo数据
            ArrayList<VideoVo> videoVoArrayList = new ArrayList<>();
            int count2 = videoList.size();
            for (int j = 0; j < count2; j++) {

                EduVideo video = videoList.get(j);
                if(chapter.getId().equals(video.getChapterId())){

                    //创建课时vo对象
                    VideoVo videoVo = new VideoVo();
                    BeanUtils.copyProperties(video, videoVo);
                    videoVoArrayList.add(videoVo);
                }
            }
            chapterVo.setChildren(videoVoArrayList);
        }

        return chapterVoArrayList;
    }
}
