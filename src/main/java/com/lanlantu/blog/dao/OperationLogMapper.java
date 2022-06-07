package com.lanlantu.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanlantu.blog.entity.OperationLog;
import org.apache.ibatis.annotations.Mapper;


/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/2 22:34
 */
@Mapper
public interface OperationLogMapper extends BaseMapper<OperationLog> {
}
