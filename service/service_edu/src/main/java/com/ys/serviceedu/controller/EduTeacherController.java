package com.ys.serviceedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ys.commonUtils.Result;
import com.ys.serviceedu.entity.EduTeacher;
import com.ys.serviceedu.entity.vo.QueryTeacher;
import com.ys.serviceedu.service.EduTeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author ys
 * @since 2020-09-09
 */
@Api("讲师管理")
@RestController
@RequestMapping("/eduService/edu_teacher")
@CrossOrigin
public class EduTeacherController {
    /**
     *  把service注入
     */
    @Autowired
    private EduTeacherService teacherService;

    /**
     * 查询所有
     * @return 封装的查询结果
     */
    @ApiOperation("查询所有讲师")
    @GetMapping()
    public Result findAll() {
        List<EduTeacher> eduTeacherList = teacherService.list(null);
        return Result.success().data("items", eduTeacherList);
    }

    /**
     * 逻辑删除
     * @param id 讲师id
     * @return 删除是否成功
     */
    @ApiOperation("根据ID逻辑删除讲师信息")
    @DeleteMapping("{id}")
    public Result remove(@ApiParam(name = "id", value = "讲师ID", required = true) @PathVariable String id) {
        boolean b = teacherService.removeById(id);

        if (b) {
            return Result.success();
        } else {
            return Result.error();
        }
    }

    /**
     * 分页查询
     *
     * @param cur   当前页
     * @param limit 每页数据量
     * @return 封装的结果集
     */
    @GetMapping("/findByPage/{cur}/{limit}")
    public Result findByPage(@PathVariable long cur,
                             @PathVariable long limit) {
        Page<EduTeacher> page = new Page<>(cur, limit);

        teacherService.page(page, null);

        long total = page.getTotal();

        List<EduTeacher> records = page.getRecords();

        return Result.success().data("total", total).data("rows", records);
    }
    @PostMapping("/pageTeacherCondition/{cur}/{limit}")
    public Result pageQuery(
            @ApiParam(name = "cur", value = "当前页码", required = true)
            @PathVariable Integer cur,
            @ApiParam(name = "limit", value = "每页条数", required = true)
            @PathVariable Integer limit,
            @RequestBody(required = false) QueryTeacher queryTeacher
    ) {

        Page<EduTeacher> page = new Page<EduTeacher>(cur, limit);
        teacherService.pageQuery(page, queryTeacher);
        return Result.success().data("total", page.getTotal()).data("rows", page.getRecords());
    }

    /**
     * 修改讲师信息
     * @param eduTeacher 传递的讲师信息
     * @return 结果参数
     */
    @PostMapping("/updateTeacher")
    public Result updateTeacher(@RequestBody EduTeacher eduTeacher){
        boolean flag = teacherService.updateById(eduTeacher);
        if (flag) {
            return Result.success();
        } else {
            return Result.error();
        }

    }
}

