package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.system.domain.SysLogininfor;

/**
 * 系统访问日志情况信息 服务层
 *
 * @author ruoyi
 */
public interface ISysLogininforService {
    /**
     * 新增 系统登录日志
     */
    void insertLogininfor(SysLogininfor dto);

    /**
     * 查询系统登录日志集合
     */
    List<SysLogininfor> selectLogininforList(SysLogininfor dto);

    /**
     * 批量删除 系统登录日志
     */
    int deleteLogininforByIds(Long[] infoIds);

    /**
     * 清空 系统登录日志
     */
    void cleanLogininfor();
}
