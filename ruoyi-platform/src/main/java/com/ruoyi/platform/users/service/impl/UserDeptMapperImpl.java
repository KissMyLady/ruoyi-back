package com.ruoyi.platform.users.service.impl;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.platform.users.mapper.UserDeptMapper;
import com.ruoyi.platform.users.service.IUserDeptMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 20:39
 * @Description:
 */
@Service
public class UserDeptMapperImpl implements IUserDeptMapper {


    @Autowired
    private UserDeptMapper userDeptMapper;

    /**
     * 根据用户查询数据权限
     */
    @Override
    public List<Integer> selectDeptListByRole(SysRole role) {
        return userDeptMapper.getDeptListByRoleId(role);
    }

    /**
     * 查询全部部门ids
     */
    @Override
    public List<Integer> selectDeptIdsList(SysDept dept) {
        return userDeptMapper.selectDeptIdsList(dept);
    }

    /**
     * 查询部门管理数据
     */
    public List<SysDept> selectDeptList(SysDept dept){
        return userDeptMapper.selectDeptList(dept);
    }
}
