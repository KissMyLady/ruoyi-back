package com.ruoyi.platform.users.service;

import com.ruoyi.common.core.domain.entity.SysRole;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 20:33
 * @Description:
 */
public interface IUserRoleMapper {


    /**
     * 根据用户id查询角色列表
     */
    List<SysRole> selectRolePermissionByUserId(Long userId);

}
