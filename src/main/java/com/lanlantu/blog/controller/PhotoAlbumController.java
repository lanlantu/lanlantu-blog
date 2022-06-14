package com.lanlantu.blog.controller;

import com.lanlantu.blog.dto.ConditionDTO;
import com.lanlantu.blog.service.PhotoAlbumService;
import com.lanlantu.blog.vo.PageResult;
import com.lanlantu.blog.vo.PhotoAlbumBackVO;
import com.lanlantu.blog.vo.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Api(tags = "相册模块")
@RestController
public class PhotoAlbumController {

    @Autowired
    private PhotoAlbumService photoAlbumService;

    /**
     * 查看后台相册列表
     *
     * @param condition 条件
     * @return {@link Result<PhotoAlbumBackVO>} 相册列表
     */
    @ApiOperation(value = "查看后台相册列表")
    @GetMapping("/admin/photos/albums")
    public Result<PageResult<PhotoAlbumBackVO>> listPhotoAlbumBacks(ConditionDTO condition) {
        return Result.ok(photoAlbumService.listPhotoAlbumBacks(condition));
    }


}
