package com.lanlantu.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lanlantu.blog.dao.OperationLogDao;
import com.lanlantu.blog.entity.OperationLog;
import com.lanlantu.blog.service.OperationLogService;
import com.lanlantu.blog.util.BeanCopyUtils;
import com.lanlantu.blog.util.PageUtils;
import com.lanlantu.blog.vo.ConditionVO;
import com.lanlantu.blog.vo.OperationLogDTO;
import com.lanlantu.blog.vo.PageResult;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author lanlantu
 * @Date 2022/6/2 22:34
 */
@Service
public class OperationLogServiceImpl extends ServiceImpl<OperationLogDao, OperationLog> implements OperationLogService {

    @Override
    public PageResult<OperationLogDTO> listOperationLogs(ConditionVO conditionVO) {
        Page<OperationLog> page = new Page<>(PageUtils.getCurrent(), PageUtils.getSize());
        // 查询日志列表
        Page<OperationLog> operationLogPage = this.page(page, new LambdaQueryWrapper<OperationLog>()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), OperationLog::getOptModule, conditionVO.getKeywords())
                .or()
                .like(StringUtils.isNotBlank(conditionVO.getKeywords()), OperationLog::getOptDesc, conditionVO.getKeywords())
                .orderByDesc(OperationLog::getId));
        List<OperationLogDTO> operationLogDTOList = BeanCopyUtils.copyList(operationLogPage.getRecords(), OperationLogDTO.class);
        return new PageResult<>(operationLogDTOList, (int) operationLogPage.getTotal());
    }

}
