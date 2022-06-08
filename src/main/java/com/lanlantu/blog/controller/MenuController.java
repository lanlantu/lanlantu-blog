package com.lanlantu.blog.controller;

import com.lanlantu.blog.vo.UserMenuVO;
import com.lanlantu.blog.service.MenuService;
import com.lanlantu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author lanlantu
 * @Date 2022/6/7 16:32
 */
@RestController
public class MenuController {
    @Autowired
    private MenuService menuService;

    @GetMapping("/admin/user/menus")
    public Result<List<UserMenuVO>> listUserMenus() {
        return Result.ok(menuService.listUserMenus());
    }
}
