package com.ruoyi.system.service;

import java.util.List;
import java.util.Set;

import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.system.domain.SysUserRole;

/**
 * 角色业务层
 *
 * @author ruoyi
 */
public interface ISysRoleService {

    /**
     * 根据条件分页查询角色数据
     */
    List<SysRole> selectRoleList(SysRole role);

    /**
     * 根据用户ID查询角色列表
     */
    List<SysRole> selectRolesByUserId(Long userId);

    /**
     * 根据用户ID查询角色权限
     */
    Set<String> selectRolePermissionByUserId(Long userId);

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
     * 校验角色名称是否唯一
     */
    boolean checkRoleNameUnique(SysRole role);

    /**
     * 校验角色权限是否唯一
     */
    boolean checkRoleKeyUnique(SysRole role);

    /**
     * 校验角色是否允许操作
     */
    void checkRoleAllowed(SysRole role);

    /**
     * 校验角色是否有数据权限
     */
    void checkRoleDataScope(Long roleId);

    /**
     * 通过角色ID查询角色使用数量
     */
    int countUserRoleByRoleId(Long roleId);

    /**
     * 新增 保存角色信息
     */
    int insertRole(SysRole role);

    /**
     * 修改保存 角色信息
     */
    int updateRole(SysRole role);

    /**
     * 修改角色状态
     */
    int updateRoleStatus(SysRole role);

    /**
     * 修改数据权限信息
     */
    int authDataScope(SysRole role);

    /**
     * 通过角色ID删除角色
     */
    int deleteRoleById(Long roleId);

    /**
     * 批量删除角色信息
     */
    int deleteRoleByIds(Long[] roleIds);

    /**
     * 取消授权用户角色
     */
    int deleteAuthUser(SysUserRole userRole);

    /**
     * 批量取消授权用户角色
     *
     * @param roleId  角色ID
     * @param userIds 需要取消授权的用户数据ID
     * @return 结果
     */
    int deleteAuthUsers(Long roleId, Long[] userIds);

    /**
     * 批量选择授权用户角色
     *
     * @param roleId  角色ID
     * @param userIds 需要删除的用户数据ID
     * @return 结果
     */
    int insertAuthUsers(Long roleId, Long[] userIds);
}
