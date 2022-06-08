package com.lanlantu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanlantu.blog.entity.OperationLog;
import com.lanlantu.blog.dto.ConditionDTO;
import com.lanlantu.blog.vo.OperationLogVO;
import com.lanlantu.blog.vo.PageResult;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/2 22:34
 */
public interface OperationLogService extends IService<OperationLog> {

    /**
     * 查询日志列表
     *
     * @param conditionDTO 条件
     * @return 日志列表
     */
    PageResult<OperationLogVO> listOperationLogs(ConditionDTO conditionDTO);

}
