package com.lanlantu.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lanlantu.blog.entity.OperationLog;
import com.lanlantu.blog.vo.ConditionVO;
import com.lanlantu.blog.vo.OperationLogDTO;
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
     * @param conditionVO 条件
     * @return 日志列表
     */
    PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO);

}
