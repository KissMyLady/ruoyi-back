package com.ruoyi.platform.users.platform_user.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.users.platform_user.mapper.PlatformSysUserMapper;
import com.ruoyi.platform.users.platform_user.domain.PlatformSysUser;
import com.ruoyi.platform.users.platform_user.service.IPlatformSysUserService;

/**
 * 用户信息Service业务层处理
 *
 * @author mylady
 * @date 2023-09-26
 */
@Service
public class PlatformSysUserServiceImpl implements IPlatformSysUserService {

    @Autowired
    private PlatformSysUserMapper sysUserMapper;

    /**
     * 查询用户信息
     *
     * @param userId 用户信息主键
     * @return 用户信息
     */
    @Override
    public PlatformSysUser selectSysUserByUserId(Long userId) {
        return sysUserMapper.selectSysUserByUserId(userId);
    }

    /**
     * 查询用户信息列表
     *
     * @param sysUser 用户信息
     * @return 用户信息
     */
    @Override
    public List<PlatformSysUser> selectSysUserList(PlatformSysUser sysUser) {
        return sysUserMapper.selectSysUserList(sysUser);
    }

    /**
     * 新增用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    @Override
    public int insertSysUser(PlatformSysUser sysUser) {
        sysUser.setCreateTime(DateUtils.getNowDate());
        return sysUserMapper.insertSysUser(sysUser);
    }

    /**
     * 修改用户信息
     *
     * @param sysUser 用户信息
     * @return 结果
     */
    @Override
    public int updateSysUser(PlatformSysUser sysUser) {
        sysUser.setUpdateTime(DateUtils.getNowDate());
        return sysUserMapper.updateSysUser(sysUser);
    }

    /**
     * 批量删除用户信息
     *
     * @param userIds 需要删除的用户信息主键
     * @return 结果
     */
    @Override
    public int deleteSysUserByUserIds(Long[] userIds) {
        return sysUserMapper.deleteSysUserByUserIds(userIds);
    }

    /**
     * 删除用户信息信息
     *
     * @param userId 用户信息主键
     * @return 结果
     */
    @Override
    public int deleteSysUserByUserId(Long userId) {
        return sysUserMapper.deleteSysUserByUserId(userId);
    }

    /**
     * 通过id查询用户
     */
    @Override
    public PlatformSysUser selectUserById(Long userId) {
        PlatformSysUser sysUser = sysUserMapper.selectUserById(userId);
        return sysUser;
    }
}
