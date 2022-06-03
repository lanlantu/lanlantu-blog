package com.lanlantu.blog.domain;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/2 16:31
 */
@Data
@TableName("tb_photo")
public class Photo {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String photoName;

    @TableField("is_delete")
    @TableLogic(value = "0",delval = "-1")
    private Integer isDeletestr;

    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @Version
    private Integer version;
}
