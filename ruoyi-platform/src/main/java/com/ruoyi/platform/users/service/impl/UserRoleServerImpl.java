package com.ruoyi.platform.users.service.impl;


import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.platform.users.mapper.UserRoleMapper;
import com.ruoyi.platform.users.service.IUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/2 20:33
 * @Description:
 */
@Service
public class UserRoleServerImpl implements IUserRoleMapper {


    @Autowired
    private UserRoleMapper userRoleMapper;


    @Override
    public List<SysRole> selectRolePermissionByUserId(Long userId) {
        return userRoleMapper.selectRolePermissionByUserId(userId);
    }
}
