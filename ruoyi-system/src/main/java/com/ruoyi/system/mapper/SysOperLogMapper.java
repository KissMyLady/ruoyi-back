package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysOperLog;

/**
 * 操作日志 数据层
 *
 * @author ruoyi
 */
public interface SysOperLogMapper {
    /**
     * 新增操作日志
     */
    void insertOperlog(SysOperLog operLog);

    /**
     * 查询系统操作日志集合
     */
    List<SysOperLog> selectOperLogList(SysOperLog operLog);

    /**
     * 查询总数
     */
    int queryRwoTotal_OperLogList(SysOperLog dto);

    /**
     * 批量删除系统操作日志
     */
    int deleteOperLogByIds(Long[] operIds);

    /**
     * 查询操作日志详细
     */
    SysOperLog selectOperLogById(Long operId);

    /**
     * 清空操作日志
     */
    void cleanOperLog();
}
