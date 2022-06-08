package com.lanlantu.blog.controller;

import com.lanlantu.blog.service.OperationLogService;
import com.lanlantu.blog.dto.ConditionDTO;
import com.lanlantu.blog.vo.OperationLogVO;
import com.lanlantu.blog.vo.PageResult;
import com.lanlantu.blog.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/2 22:34
 */
@RestController
public class LogController {
    @Autowired
    private OperationLogService operationLogService;

    /**
     * 查看操作日志
     *
     * @param conditionDTO 条件
     * @return {@link Result< OperationLogVO >} 日志列表
     */
    @GetMapping("/admin/operation/logs")
    public Result<PageResult<OperationLogVO>> listOperationLogs(ConditionDTO conditionDTO) {
        return Result.ok(operationLogService.listOperationLogs(conditionDTO));
    }

    /**
     * 删除操作日志
     *
     * @param logIdList 日志id列表
     * @return {@link Result<>}
     */
    @DeleteMapping("/admin/operation/logs")
    public Result<?> deleteOperationLogs(@RequestBody List<Integer> logIdList) {
        operationLogService.removeByIds(logIdList);
        return Result.ok();
    }

}
