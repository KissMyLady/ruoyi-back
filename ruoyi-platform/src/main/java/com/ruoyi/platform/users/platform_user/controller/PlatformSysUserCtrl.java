package com.ruoyi.platform.users.platform_user.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.users.platform_user.domain.PlatformSysUser;
//import com.ruoyi.platform.users.platform_user.service.ISysUserService;
import com.ruoyi.platform.users.platform_user.service.impl.PlatformSysUserServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户信息Controller
 *
 * @author mylady
 * @date 2023-09-26
 */
@RestController
@RequestMapping("/platform_user/platform_user")
public class PlatformSysUserCtrl extends BaseController {

    @Autowired
    private PlatformSysUserServiceImpl sysUserService;
    //private ISysUserService sysUserService;

    /**
     * 查询用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('platform_user:platform_user:list')")
    @GetMapping("/list")
    public TableDataInfo list(PlatformSysUser sysUser) {
        startPage();
        List<PlatformSysUser> list = sysUserService.selectSysUserList(sysUser);
        return getDataTable(list);
    }

    /**
     * 导出用户信息列表
     */
    @PreAuthorize("@ss.hasPermi('platform_user:platform_user:export')")
    @Log(title = "导出用户信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PlatformSysUser sysUser) {
        List<PlatformSysUser> list = sysUserService.selectSysUserList(sysUser);
        ExcelUtil<PlatformSysUser> util = new ExcelUtil<PlatformSysUser>(PlatformSysUser.class);
        util.exportExcel(response, list, "用户信息数据");
    }

    /**
     * 获取用户信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('platform_user:platform_user:query')")
    @GetMapping(value = "/{userId}")
    public AjaxResult getInfo(@PathVariable("userId") Long userId) {
        return success(sysUserService.selectSysUserByUserId(userId));
    }

    /**
     * 新增用户信息
     */
    @PreAuthorize("@ss.hasPermi('platform_user:platform_user:add')")
    @Log(title = "新增用户信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PlatformSysUser sysUser) {
        return toAjax(sysUserService.insertSysUser(sysUser));
    }

    /**
     * 修改用户信息
     */
    @PreAuthorize("@ss.hasPermi('platform_user:platform_user:edit')")
    @Log(title = "修改用户信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PlatformSysUser sysUser) {
        return toAjax(sysUserService.updateSysUser(sysUser));
    }

    /**
     * 删除用户信息
     */
    @PreAuthorize("@ss.hasPermi('platform_user:platform_user:remove')")
    @Log(title = "删除用户信息", businessType = BusinessType.DELETE)
    @DeleteMapping("/{userIds}")
    public AjaxResult remove(@PathVariable Long[] userIds) {
        return toAjax(sysUserService.deleteSysUserByUserIds(userIds));
    }

}
