package com.lanlantu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.lanlantu.blog.dao.RoleMapper;
import com.lanlantu.blog.dao.UserAuthMapper;
import com.lanlantu.blog.dao.UserInfoMapper;
import com.lanlantu.blog.dto.UserDetailDTO;
import com.lanlantu.blog.entity.UserAuth;
import com.lanlantu.blog.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserAuthMapper userAuthMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserInfoMapper userInfoMapper;

    @Autowired
    private HttpServletRequest request;

    @Override
    public UserDetails loadUserByUsername(String username) {
        if (StringUtils.isBlank(username)) {
            throw new UsernameNotFoundException("用户名不能为空！");
        }

        UserAuth userAuth = userAuthMapper.selectOne(new LambdaQueryWrapper<UserAuth>()
                .select(UserAuth::getId, UserAuth::getUserInfoId, UserAuth::getUsername, UserAuth::getPassword, UserAuth::getLoginType)
                .eq(UserAuth::getUsername, username));
        if (ObjectUtils.isEmpty(userAuth)){
            throw new UsernameNotFoundException("用户不存在");
        }

        return convertUserDetail(userAuth, request);
    }

    private UserDetails convertUserDetail(UserAuth userAuth, HttpServletRequest request) {
        UserInfo userInfo = userInfoMapper.selectById(userAuth.getUserInfoId());
        List<String> roles = roleMapper.listRolesByUserInfoId(userAuth.getUserInfoId());

        return UserDetailDTO.builder()
                .id(userAuth.getId())
                .loginType(userAuth.getLoginType())
                .userInfoId(userInfo.getId())
                .username(userAuth.getUsername())
                .password(userAuth.getPassword())
                .email(userInfo.getEmail())
                .roleList(roles)
                .nickname(userInfo.getNickname())
                .avatar(userInfo.getAvatar())
                .intro(userInfo.getIntro())
                .webSite(userInfo.getWebSite())
                .isDisable(userInfo.getIsDisable())
                .lastLoginTime(LocalDateTime.now())
                .build();
    }


}
