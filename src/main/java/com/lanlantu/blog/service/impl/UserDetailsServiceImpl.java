package com.lanlantu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lanlantu.blog.dao.RoleDao;
import com.lanlantu.blog.dao.UserAuthDao;
import com.lanlantu.blog.dto.UserDetailDTO;
import com.lanlantu.blog.entity.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Objects;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAuthDao userAuthDao;

    @Autowired
    private RoleDao roleDao;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("用户名不能为空！");
        }

        UserAuth userAuth = userAuthDao.selectOne(new LambdaQueryWrapper<UserAuth>()
                .select(UserAuth::getId, UserAuth::getUserInfoId, UserAuth::getUsername, UserAuth::getPassword, UserAuth::getLoginType)
                .eq(UserAuth::getUsername, username));
        if (ObjectUtils.isEmpty(userAuth)){
            throw new UsernameNotFoundException("用户不存在");
        }
        List<String> strings = roleDao.listRolesByUserInfoId(userAuth.getUserInfoId());

        return UserDetailDTO.builder()
                .id(userAuth.getId())
                .loginType(userAuth.getLoginType())
                .username(userAuth.getUsername())
                .password(userAuth.getPassword())
                .roleList(strings)
                .isDisable(0)
                .build();
    }


}
