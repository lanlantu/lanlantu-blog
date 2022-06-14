package com.lanlantu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanlantu.blog.dao.PhotoAlbumDao;
import com.lanlantu.blog.dto.ConditionDTO;
import com.lanlantu.blog.entity.PhotoAlbum;
import com.lanlantu.blog.service.PhotoAlbumService;
import com.lanlantu.blog.util.PageUtils;
import com.lanlantu.blog.vo.PageResult;
import com.lanlantu.blog.vo.PhotoAlbumBackVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.lanlantu.blog.constant.CommonConst.FALSE;


@Service
public class PhotoAlbumServiceImpl extends ServiceImpl<PhotoAlbumDao, PhotoAlbum> implements PhotoAlbumService {
    @Autowired
    private PhotoAlbumDao photoAlbumDao;



    @Override
    public PageResult<PhotoAlbumBackVO> listPhotoAlbumBacks(ConditionDTO condition) {// 查询相册数量
        Long aLong = photoAlbumDao.selectCount(new LambdaQueryWrapper<PhotoAlbum>()
                .like(StringUtils.isNotBlank(condition.getKeywords()), PhotoAlbum::getAlbumName, condition.getKeywords())
                .eq(PhotoAlbum::getIsDelete, FALSE));

        if (aLong == 0) {
            return new PageResult<>();
        }
        // 查询相册信息
        List<PhotoAlbumBackVO> photoAlbumBackList = photoAlbumDao.listPhotoAlbumBacks(PageUtils.getLimitCurrent(), PageUtils.getSize(), condition);
        return new PageResult<>(photoAlbumBackList,aLong.intValue() );
    }



}




