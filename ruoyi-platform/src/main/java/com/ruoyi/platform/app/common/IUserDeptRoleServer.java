package com.ruoyi.platform.app.common;

import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysUser;
import java.util.List;


/**
 * 当前platform下的通用方法封装
 *
 * @author mylady
 * @date 2023-10-02
 */
public interface IUserDeptRoleServer {

    /**
     * 获取用户的数据权限列表
     */
    List<Integer> get_auth_dept_set(SysUser user);

    /**
     * 查询部门树结构信息
     */
    List<TreeSelect> selectDeptTreeList(SysDept dept);



}
