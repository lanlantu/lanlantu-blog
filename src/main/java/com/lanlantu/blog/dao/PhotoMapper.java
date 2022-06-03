package com.lanlantu.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanlantu.blog.domain.Photo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/2 16:32
 */
@Mapper
public interface PhotoMapper extends BaseMapper<Photo> {
}
