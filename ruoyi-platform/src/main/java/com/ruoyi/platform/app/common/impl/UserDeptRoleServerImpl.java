package com.ruoyi.platform.app.common.impl;


import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.platform.app.common.IUserDeptRoleServer;
import com.ruoyi.platform.users.service.impl.UserDeptMapperImpl;
import com.ruoyi.platform.users.service.impl.UserRoleServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 当前platform下的通用方法封装
 *
 * @author mylady
 * @date 2023-10-02
 */
@Service
public class UserDeptRoleServerImpl implements IUserDeptRoleServer {

    @Autowired
    private UserDeptMapperImpl userDeptMapper;

    @Autowired
    private UserRoleServerImpl userRoleServer;

    /**
     * 获取用户的数据权限列表
     */
    @Override
    public List<Integer> get_auth_dept_set(SysUser user) {
        //获取用户
        // LoginUser loginUser = SecurityUtils.getLoginUser();
        // SysUser user = loginUser.getUser();

        //部门的数据权限集合
        HashSet<Integer> auth_dept_set = new HashSet<>();
        auth_dept_set.add(0);

        if (user.isAdmin()){
            //查询全部数据权限
            List<Integer> longs = userDeptMapper.selectDeptIdsList(new SysDept());
            auth_dept_set.addAll(longs);
        }else{
            //查询用户角色
            List<SysRole> sysRoles = userRoleServer.selectRolePermissionByUserId(user.getUserId());
            for(SysRole role: sysRoles){
                List<Integer> longs = userDeptMapper.selectDeptListByRole(role);
                auth_dept_set.addAll(longs);
            }
        }

        return new ArrayList<>(auth_dept_set);
    }
}
