package com.ruoyi.platform.users.service;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 20:39
 * @Description:
 */
public interface IUserDeptMapper {

    /**
     * 根据角色查询部门信息 v2
     */
    public List<Integer> selectDeptListByRole(SysRole role);


    /**
     * 查询全部部门ids
     */
    public List<Integer> selectDeptIdsList(SysDept dept);

}
