package com.lanlantu.blog.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/5/21 13:42
 */

@Api(tags = "首页模块")
@RestController
public class LoginController {

    @ApiOperation(value = "主页")
    @GetMapping("/zhuye")
    public String login(){
        return "主页";
    }
}
