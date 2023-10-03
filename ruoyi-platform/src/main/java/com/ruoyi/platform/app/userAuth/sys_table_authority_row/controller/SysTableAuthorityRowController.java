package com.ruoyi.platform.app.userAuth.sys_table_authority_row.controller;

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
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;
//import com.ruoyi.platform.app.userAuth.sys_table_authority_row.service.ISysTableAuthorityRowService;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.service.impl.SysTableAuthorityRowServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 数据权限Controller
 *
 * @author mylady
 * @date 2023-10-03
 */
@RestController
@RequestMapping("/sys_table_authority_row/sys_table_authority_row")
public class SysTableAuthorityRowController extends BaseController {

    @Autowired
    private SysTableAuthorityRowServiceImpl sysTableAuthorityRowService;
    //private ISysTableAuthorityRowService sysTableAuthorityRowService;

    /**
     * 查询数据权限列表
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:list')")
    @GetMapping("/list")
    public TableDataInfo list(SysTableAuthorityRow sysTableAuthorityRow) {
        startPage();
        List<SysTableAuthorityRow> list = sysTableAuthorityRowService.selectSysTableAuthorityRowList(sysTableAuthorityRow);
        return getDataTable(list);
    }

    /**
     * 导出数据权限列表
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:export')")
    @Log(title = "导出数据权限", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTableAuthorityRow sysTableAuthorityRow) {
        List<SysTableAuthorityRow> list = sysTableAuthorityRowService.selectSysTableAuthorityRowList(sysTableAuthorityRow);
        ExcelUtil<SysTableAuthorityRow> util = new ExcelUtil<SysTableAuthorityRow>(SysTableAuthorityRow.class);
        util.exportExcel(response, list, "数据权限数据");
    }

    /**
     * 获取数据权限详细信息
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(sysTableAuthorityRowService.selectSysTableAuthorityRowById(id));
    }

    /**
     * 新增数据权限
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:add')")
    @Log(title = "新增数据权限", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTableAuthorityRow sysTableAuthorityRow) {
        return toAjax(sysTableAuthorityRowService.insertSysTableAuthorityRow(sysTableAuthorityRow));
    }

    /**
     * 修改数据权限
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:edit')")
    @Log(title = "修改数据权限", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTableAuthorityRow sysTableAuthorityRow) {
        return toAjax(sysTableAuthorityRowService.updateSysTableAuthorityRow(sysTableAuthorityRow));
    }

    /**
     * 删除数据权限
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:remove')")
    @Log(title = "删除数据权限", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(sysTableAuthorityRowService.deleteSysTableAuthorityRowByIds(ids));
    }

}
