package com.lanlantu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanlantu.blog.dto.ConditionDTO;
import com.lanlantu.blog.entity.PhotoAlbum;
import com.lanlantu.blog.vo.PageResult;
import com.lanlantu.blog.vo.PhotoAlbumBackVO;

public interface PhotoAlbumService extends IService<PhotoAlbum> {


    /**
     * 查看后台相册列表
     *
     * @param condition 条件
     * @return {@link PageResult<PhotoAlbumBackVO>} 相册列表
     */
    PageResult<PhotoAlbumBackVO> listPhotoAlbumBacks(ConditionDTO condition);



}
