package com.ruoyi.platform.users.platform_user.mapper;

import java.util.List;

import com.ruoyi.platform.users.platform_user.domain.PlatformSysUser;

/**
 * 用户信息Mapper接口
 *
 * @author mylady
 * @date 2023-09-26
 */
public interface PlatformSysUserMapper {
    /**
     * 查询用户信息
     *
     * @param userId 用户信息主键
     * @return 用户信息
     */
    PlatformSysUser selectSysUserByUserId(Long userId);

    /**
     * 查询用户信息列表
     *
     * @param sysUser 用户信息
     * @return 用户信息集合
     */
    List<PlatformSysUser> selectSysUserList(PlatformSysUser sysUser);

    /**
     * 新增用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    int insertSysUser(PlatformSysUser sysUser);

    /**
     * 修改用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    int updateSysUser(PlatformSysUser sysUser);

    /**
     * 删除用户信息
     *
     * @param userId 用户信息主键
     * @return 结果
     */
    int deleteSysUserByUserId(Long userId);

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteSysUserByUserIds(Long[] userIds);

    /**
     * 通过id查询用户
     */
    PlatformSysUser selectUserById(Long userId);

}
