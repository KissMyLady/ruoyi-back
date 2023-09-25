package com.ruoyi.platform.chip.chip_version.controller;

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
import com.ruoyi.platform.chip.chip_version.domain.ChipVersion;
import com.ruoyi.platform.chip.chip_version.service.IChipVersionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 硬件版本Controller
 *
 * @author mylady
 * @date 2023-09-25
 */
@RestController
@RequestMapping("/chip_version/chip_version")
public class ChipVersionController extends BaseController {

    @Autowired
    private IChipVersionService chipVersionService;

    /**
     * 查询硬件版本列表
     */
    @PreAuthorize("@ss.hasPermi('chip_version:chip_version:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChipVersion chipVersion) {
        startPage();
        List<ChipVersion> list = chipVersionService.selectChipVersionList(chipVersion);
        return getDataTable(list);
    }

    /**
     * 导出硬件版本列表
     */
    @PreAuthorize("@ss.hasPermi('chip_version:chip_version:export')")
    @Log(title = "导出硬件版本", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChipVersion chipVersion) {
        List<ChipVersion> list = chipVersionService.selectChipVersionList(chipVersion);
        ExcelUtil<ChipVersion> util = new ExcelUtil<ChipVersion>(ChipVersion.class);
        util.exportExcel(response, list, "硬件版本数据");
    }

    /**
     * 获取硬件版本详细信息
     */
    @PreAuthorize("@ss.hasPermi('chip_version:chip_version:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chipVersionService.selectChipVersionById(id));
    }

    /**
     * 新增硬件版本
     */
    @PreAuthorize("@ss.hasPermi('chip_version:chip_version:add')")
    @Log(title = "新增硬件版本", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChipVersion chipVersion) {
        return toAjax(chipVersionService.insertChipVersion(chipVersion));
    }

    /**
     * 修改硬件版本
     */
    @PreAuthorize("@ss.hasPermi('chip_version:chip_version:edit')")
    @Log(title = "修改硬件版本", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChipVersion chipVersion) {
        return toAjax(chipVersionService.updateChipVersion(chipVersion));
    }

    /**
     * 删除硬件版本
     */
    @PreAuthorize("@ss.hasPermi('chip_version:chip_version:remove')")
    @Log(title = "删除硬件版本", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chipVersionService.deleteChipVersionByIds(ids));
    }

}
