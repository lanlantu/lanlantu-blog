package com.mayikt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/5/21 13:42
 */
@RestController
public class loginController {

    @GetMapping("/zhuye")
    public String login(){
        return "主页";
    }
}
