package com.ys.serviceedu.controller;


import com.ys.commonUtils.Result;
import com.ys.serviceedu.entity.EduChapter;
import com.ys.serviceedu.entity.chapter.ChapterVo;
import com.ys.serviceedu.service.EduChapterService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author ys
 * @since 2021-04-21
 */
@RestController
@CrossOrigin
@RequestMapping("/eduService/edu-chapter")
public class EduChapterController {
    @Autowired
    private EduChapterService eduChapterService;

    @ApiOperation(value = "嵌套章节数据列表")
    @GetMapping("/nested-list/{courseId}")
    public Result nestedListByCourseId(
            @ApiParam(name = "courseId", value = "课程ID", required = true)
            @PathVariable String courseId){

        List<ChapterVo> chapterVoList = eduChapterService.nestedList(courseId);
        return Result.success().data("items", chapterVoList);
    }

    @ApiOperation(value = "新增章节")
    @PostMapping
    public Result save(
            @ApiParam(name = "chapterVo", value = "章节对象", required = true)
            @RequestBody EduChapter chapter){
        eduChapterService.save(chapter);
        return Result.success();
    }
}

