package com.ruoyi.platform.users.mapper;

import com.ruoyi.common.core.domain.entity.SysRole;

import java.util.List;

/**
 * 角色表 数据层
 *
 * @author ruoyi
 */
public interface UserRoleMapper {

    /**
     * 根据用户ID查询角色
     *
     */
    public List<SysRole> selectRolePermissionByUserId(Long userId);


}
