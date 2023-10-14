package com.ruoyi.system.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.ruoyi.common.core.domain.entity.SysUser;

/**
 * 用户表 数据层
 *
 * @author ruoyi
 */
public interface SysUserMapper {

    /**
     * 根据条件分页查询用户列表
     */
    List<SysUser> selectUserList(SysUser sysUser);

    // List<String> selectRoleUser(SysUser sysUser);

    /**
     * 根据条件 分页查询已配用户角色列表
     */
    List<SysUser> selectAllocatedList(SysUser user);

    /**
     * 根据条件 分页查询未分配用户角色列表
     */
    List<SysUser> selectUnallocatedList(SysUser user);

    /**
     * 通过用户名查询用户
     */
    SysUser selectUserByUserName(String userName);

    /**
     * 通过用户ID查询用户
     */
    SysUser selectUserById(Long userId);

    /**
     * ++新增++ 用户信息
     */
    int insertUser(SysUser user);

    /**
     * 修改 用户信息
     */
    int updateUser(SysUser user);

    /**
     * 修改 用户头像
     */
    int updateUserAvatar(@Param("userName") String userName,
                         @Param("avatar") String avatar);

    /**
     * 重置用户密码
     */
    int resetUserPwd(@Param("userName") String userName,
                     @Param("password") String password);

    /**
     * 通过用户ID删除用户
     */
    int deleteUserById(Long userId);

    /**
     * 批量删除用户信息
     */
    int deleteUserByIds(Long[] userIds);

    /**
     * 校验用户名称是否唯一
     */
    SysUser checkUserNameUnique(String userName);

    /**
     * 校验手机号码是否唯一
     */
    SysUser checkPhoneUnique(String phonenumber);

    /**
     * 校验email是否唯一
     */
    SysUser checkEmailUnique(String email);
}
