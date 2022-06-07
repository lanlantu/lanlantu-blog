package com.lanlantu.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanlantu.blog.dto.ResourceRoleDTO;
import com.lanlantu.blog.entity.Role;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/5 10:14
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

   List<String> listRolesByUserInfoId(Integer userInfoId);

    List<Role> selectTest(@Param("name") String roleName, String roleLabel);

    List<ResourceRoleDTO> listResourceRoles();
}
