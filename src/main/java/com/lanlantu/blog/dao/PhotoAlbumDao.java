package com.lanlantu.blog.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lanlantu.blog.dto.ConditionDTO;
import com.lanlantu.blog.entity.PhotoAlbum;
import com.lanlantu.blog.vo.PhotoAlbumBackVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * 相册映射器
 *
 * @author yezhiqiu
 * @date 2021/08/04
 */
@Repository
public interface PhotoAlbumDao extends BaseMapper<PhotoAlbum> {

    /**
     * 查询后台相册列表
     *
     * @param current   页码
     * @param size      大小
     * @param condition 条件
     * @return {@link List < PhotoAlbumBackDTO >} 相册列表
     */
    List<PhotoAlbumBackVO> listPhotoAlbumBacks(@Param("current") Long current, @Param("size") Long size, @Param("condition") ConditionDTO condition);

}




