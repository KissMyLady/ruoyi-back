package com.ruoyi.system.service;

import java.util.List;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;

/**
 * 部门管理 服务层
 *
 * @author ruoyi
 */
public interface ISysDeptService {
    /**
     * 查询部门管理数据
     */
    List<SysDept> selectDeptList(SysDept dept);

    /**
     * 查询全部部门ids
     */
    List<Long> selectDeptIdsList(SysDept dept);

    /**
     * 查询部门树结构信息
     */
    List<TreeSelect> selectDeptTreeList(SysDept dept);

    /**
     * 构建前端所需要树结构
     */
    List<SysDept> buildDeptTree(List<SysDept> depts);

    /**
     * 构建前端所需要下拉树结构
     */
    List<TreeSelect> buildDeptTreeSelect(List<SysDept> depts);

    /**
     * 根据角色ID查询部门树信息
     */
    List<Long> selectDeptListByRoleId(Long roleId);

    /**
     * 根据角色查询部门信息 v2
     */
    List<Long> selectDeptListByRole(SysRole role);

    /**
     * 根据部门ID查询信息
     */
    SysDept selectDeptById(Long deptId);

    /**
     * 根据ID查询所有子部门（正常状态）
     */
    int selectNormalChildrenDeptById(Long deptId);

    /**
     * 是否存在部门子节点
     */
    boolean hasChildByDeptId(Long deptId);

    /**
     * 查询部门是否存在用户
     *
     * @param deptId 部门ID
     * @return 结果 true 存在 false 不存在
     */
    boolean checkDeptExistUser(Long deptId);

    /**
     * 校验部门名称是否唯一
     */
    boolean checkDeptNameUnique(SysDept dept);

    /**
     * 校验部门是否有数据权限
     */
    void checkDeptDataScope(Long deptId);

    /**
     * 新增保存部门信息
     */
    int insertDept(SysDept dept);

    /**
     * 修改保存部门信息
     */
    int updateDept(SysDept dept);

    /**
     * 删除部门管理信息
     */
    int deleteDeptById(Long deptId);
}
