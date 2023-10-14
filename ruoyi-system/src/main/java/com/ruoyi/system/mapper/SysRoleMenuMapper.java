package com.ruoyi.system.mapper;

import java.util.List;

import com.ruoyi.system.domain.SysRoleMenu;

/**
 * 角色与菜单关联表 数据层
 *
 * @author ruoyi
 */
public interface SysRoleMenuMapper {

    /**
     * 查询 菜单使用数量
     */
    int checkMenuExistRole(Long menuId);

    /**
     * 通过角色ID -删除- 角色和菜单关联
     */
    int deleteRoleMenuByRoleId(Long roleId);

    /**
     * --批量删除--角色菜单关联信息
     */
    int deleteRoleMenu(Long[] ids);

    /**
     * 批量++新增++ 角色菜单信息
     */
    int batchRoleMenu(List<SysRoleMenu> roleMenuList);
}
