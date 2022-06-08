package com.lanlantu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanlantu.blog.vo.UserMenuVO;
import com.lanlantu.blog.entity.Menu;

import java.util.List;


public interface MenuService extends IService<Menu> {



    /**
     * 查看用户菜单
     *
     * @return 菜单列表
     */
    List<UserMenuVO> listUserMenus();

}
