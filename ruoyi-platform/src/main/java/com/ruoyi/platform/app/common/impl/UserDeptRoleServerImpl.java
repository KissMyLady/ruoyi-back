package com.ruoyi.platform.app.common.impl;


import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.spring.SpringUtils;
import com.ruoyi.platform.app.common.IUserDeptRoleServer;
import com.ruoyi.platform.users.mapper.UserDeptMapper;
import com.ruoyi.platform.users.service.impl.UserDeptMapperImpl;
import com.ruoyi.platform.users.service.impl.UserRoleServerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 当前platform下的通用方法封装
 *
 * @author mylady
 * @date 2023-10-02
 */
@Service
public class UserDeptRoleServerImpl implements IUserDeptRoleServer {

    private static final Logger logger = LoggerFactory.getLogger(UserDeptRoleServerImpl.class);

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


    /**
     * 查询部门树结构信息
     */
    @Override
    public List<TreeSelect> selectDeptTreeList(SysDept dept) {
        List<SysDept> depts = userDeptMapper.selectDeptList(dept);
        List<SysDept> deptTrees = buildDeptTree(depts);
        List<TreeSelect> collect = deptTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
        return collect;
    }

    public List<SysDept> buildDeptTree(List<SysDept> depts) {
        List<SysDept> returnList = new ArrayList<SysDept>();
        List<Long> tempList = depts.stream().map(SysDept::getDeptId).collect(Collectors.toList());
        for (SysDept dept : depts) {
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(dept.getParentId())) {
                recursionFn(depts, dept);
                returnList.add(dept);
            }
        }
        if (returnList.isEmpty()) {
            returnList = depts;
        }
        return returnList;
    }

    private void recursionFn(List<SysDept> list, SysDept t) {
        // 得到子节点列表
        List<SysDept> childList = getChildList(list, t);
        t.setChildren(childList);
        for (SysDept tChild : childList) {
            if (hasChild(list, tChild)) {
                recursionFn(list, tChild);
            }
        }
    }

    /**
     * 得到子节点列表
     */
    private List<SysDept> getChildList(List<SysDept> list, SysDept t) {
        List<SysDept> tlist = new ArrayList<SysDept>();
        Iterator<SysDept> it = list.iterator();
        while (it.hasNext()) {
            SysDept n = (SysDept) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getDeptId().longValue()) {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<SysDept> list, SysDept t) {
        return getChildList(list, t).size() > 0;
    }
}
