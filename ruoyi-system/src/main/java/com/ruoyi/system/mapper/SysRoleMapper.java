package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.entity.SysRole;

/**
 * 角色表 数据层
 *
 * @author ruoyi
 */
public interface SysRoleMapper {

    /**
     * 根据条件分页查询角色数据
     */
    List<SysRole> selectRoleList(SysRole role);

    /**
     * 根据用户ID查询角色
     */
    List<SysRole> selectRolePermissionByUserId(Long userId);

    /**
     * 查询所有角色
     */
    List<SysRole> selectRoleAll();

    /**
     * 根据用户ID获取角色选择框列表
     */
    List<Long> selectRoleListByUserId(Long userId);

    /**
     * 通过角色ID查询角色
     */
    SysRole selectRoleById(Long roleId);

    /**
     * 根据用户ID查询角色
     */
    List<SysRole> selectRolesByUserName(String userName);

    /**
     * 校验角色名称是否唯一
     */
    SysRole checkRoleNameUnique(String roleName);

    /**
     * 校验角色权限是否唯一
     */
    SysRole checkRoleKeyUnique(String roleKey);

    /**
     * 修改角色信息
     */
    int updateRole(SysRole role);

    /**
     * 新增角色信息
     */
    int insertRole(SysRole role);

    /**
     * 通过角色ID删除角色
     */
    int deleteRoleById(Long roleId);

    /**
     * 批量删除角色信息. 逻辑删除
     */
    int deleteRoleByIds(Long[] roleIds);
}
