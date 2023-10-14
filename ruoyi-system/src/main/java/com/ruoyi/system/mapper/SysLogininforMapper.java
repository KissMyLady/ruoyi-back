package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysLogininfor;

/**
 * 系统访问日志情况信息 数据层
 *
 * @author ruoyi
 */
public interface SysLogininforMapper {

    /**
     * ++新增++ 系统登录日志
     */
    void insertLogininfor(SysLogininfor logininfor);

    /**
     * 查询 系统登录日志集合
     */
    List<SysLogininfor> selectLogininforList(SysLogininfor logininfor);

    /**
     * 查询总数
     */
    int queryRwoTotal_Logininfo(SysLogininfor dto);

    /**
     * --批量删除-- 系统登录日志
     */
    int deleteLogininforByIds(Long[] infoIds);

    /**
     * --清空-- 系统登录日志
     */
    int cleanLogininfor();
}
