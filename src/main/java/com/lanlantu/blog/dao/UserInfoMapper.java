package com.lanlantu.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanlantu.blog.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author lanlantu
 * @Date 2022/6/7 0:31
 */
@Mapper
public interface UserInfoMapper extends BaseMapper<UserInfo> {
}
