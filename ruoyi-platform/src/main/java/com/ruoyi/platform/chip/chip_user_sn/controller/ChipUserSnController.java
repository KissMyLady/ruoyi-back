package com.ruoyi.platform.chip.chip_user_sn.controller;

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
import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;
import com.ruoyi.platform.chip.chip_user_sn.service.IChipUserSnService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户芯片-序列号Controller
 *
 * @author mylady
 * @date 2023-09-25
 */
@RestController
@RequestMapping("/chip_user_sn/chip_user_sn")
public class ChipUserSnController extends BaseController {

    @Autowired
    private IChipUserSnService chipUserSnService;

    /**
     * 查询用户芯片-序列号列表
     */
    @PreAuthorize("@ss.hasPermi('chip_user_sn:chip_user_sn:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChipUserSn chipUserSn) {
        startPage();
        List<ChipUserSn> list = chipUserSnService.selectChipUserSnList(chipUserSn);
        return getDataTable(list);
    }

    /**
     * 导出用户芯片-序列号列表
     */
    @PreAuthorize("@ss.hasPermi('chip_user_sn:chip_user_sn:export')")
    @Log(title = "导出用用户芯片-序列号", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChipUserSn chipUserSn) {
        List<ChipUserSn> list = chipUserSnService.selectChipUserSnList(chipUserSn);
        ExcelUtil<ChipUserSn> util = new ExcelUtil<ChipUserSn>(ChipUserSn.class);
        util.exportExcel(response, list, "用户芯片-序列号数据");
    }

    /**
     * 获取用户芯片-序列号详细信息
     */
    @PreAuthorize("@ss.hasPermi('chip_user_sn:chip_user_sn:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chipUserSnService.selectChipUserSnById(id));
    }

    /**
     * 新增用户芯片-序列号
     */
    @PreAuthorize("@ss.hasPermi('chip_user_sn:chip_user_sn:add')")
    @Log(title = "新增用户芯片-序列号", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChipUserSn chipUserSn) {
        return toAjax(chipUserSnService.insertChipUserSn(chipUserSn));
    }

    /**
     * 修改用户芯片-序列号
     */
    @PreAuthorize("@ss.hasPermi('chip_user_sn:chip_user_sn:edit')")
    @Log(title = "修改用户芯片-序列号", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChipUserSn chipUserSn) {
        return toAjax(chipUserSnService.updateChipUserSn(chipUserSn));
    }

    /**
     * 删除用户芯片-序列号
     */
    @PreAuthorize("@ss.hasPermi('chip_user_sn:chip_user_sn:remove')")
    @Log(title = "删除用户芯片-序列号", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chipUserSnService.deleteChipUserSnByIds(ids));
    }

}
