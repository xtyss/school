package com.ys.serviceedu.controller;

import com.ys.commonUtils.Result;
import org.springframework.web.bind.annotation.*;

/**
 * 用于教师用户登录
 *
 * @author xt_ys
 */
@RestController
@RequestMapping("/eduService/user")

@CrossOrigin
public class EduTeacherLoginController {

    @PostMapping("login")
    public Result login(){
        return Result.success().data("token","admin");
    }


    @GetMapping("info")
    public Result info(){
        return Result.success().data("roles","[admin]").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }
}
