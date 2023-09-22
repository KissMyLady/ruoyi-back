package com.ruoyi.platform.liveBroadcastApp.sys_option.controller;

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
import com.ruoyi.platform.liveBroadcastApp.sys_option.domain.SysOption;
import com.ruoyi.platform.liveBroadcastApp.sys_option.service.ISysOptionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 系统-操作码Controller
 *
 * @author ruoyi
 * @date 2023-09-22
 */
@RestController
@RequestMapping("/sysOption/sys_option")
public class SysOptionController extends BaseController {

    @Autowired
    private ISysOptionService sysOptionService;

    /**
     * 查询系统-操作码列表
     */
    @PreAuthorize("@ss.hasPermi('sysOption:sys_option:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysOption sysOption) {
        startPage();
        List<SysOption> list = sysOptionService.selectSysOptionList(sysOption);
        return getDataTable(list);
    }

    /**
     * 导出系统-操作码列表
     */
    @PreAuthorize("@ss.hasPermi('sysOption:sys_option:export')")
    @Log(title = "导出系统-操作码列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysOption sysOption) {
        List<SysOption> list = sysOptionService.selectSysOptionList(sysOption);
        ExcelUtil<SysOption> util = new ExcelUtil<SysOption>(SysOption.class);
        util.exportExcel(response, list, "系统-操作码数据");
    }

    /**
     * 获取系统-操作码详细信息
     */
    @PreAuthorize("@ss.hasPermi('sysOption:sys_option:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(sysOptionService.selectSysOptionById(id));
    }

    /**
     * 新增系统-操作码
     */
    @PreAuthorize("@ss.hasPermi('sysOption:sys_option:add')")
    @Log(title = "新增系统-操作码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysOption sysOption) {
        return toAjax(sysOptionService.insertSysOption(sysOption));
    }

    /**
     * 修改系统-操作码
     */
    @PreAuthorize("@ss.hasPermi('sysOption:sys_option:edit')")
    @Log(title = "修改系统-操作码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysOption sysOption) {
        return toAjax(sysOptionService.updateSysOption(sysOption));
    }

    /**
     * 删除系统-操作码
     */
    @PreAuthorize("@ss.hasPermi('sysOption:sys_option:remove')")
    @Log(title = "删除系统-操作码", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysOptionService.deleteSysOptionByIds(ids));
    }

}
