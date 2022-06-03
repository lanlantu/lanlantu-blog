package com.mayikt.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/3 0:55
 */
@Component
public class MyMetaObjcetHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
            this.setFieldValByName("createTime", LocalDateTime.now(),metaObject);
            this.setFieldValByName("updateTime", LocalDateTime.now(),metaObject);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", LocalDateTime.now(),metaObject);
    }
}
