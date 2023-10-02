package com.ruoyi.platform.users.mapper;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 20:38
 * @Description:
 */
public interface UserDeptMapper {


    /**
     * 根据角色查询部门信息 v2
     */
    public List<Integer> getDeptListByRoleId(SysRole role);

    /**
     * 查询部门ids
     */
    public List<Integer> selectDeptIdsList(SysDept dept);

}
