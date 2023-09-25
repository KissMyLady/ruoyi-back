package com.ruoyi.platform.chip.chip_user_recharge.controller;

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
import com.ruoyi.platform.chip.chip_user_recharge.domain.ChipUserRecharge;
import com.ruoyi.platform.chip.chip_user_recharge.service.impl.ChipUserRechargeServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户芯片-用户充值Controller
 *
 * @author mylady
 * @date 2023-09-25
 */
@RestController
@RequestMapping("/chip_user_recharge/chip_user_recharge")
public class ChipUserRechargeController extends BaseController {

    @Autowired
    private ChipUserRechargeServiceImpl chipUserRechargeService;

    /**
     * 查询用户芯片-用户充值列表
     */
    @PreAuthorize("@ss.hasPermi('chip_user_recharge:chip_user_recharge:list')")
    @GetMapping("/list")
    public TableDataInfo list(ChipUserRecharge chipUserRecharge) {
        startPage();
        List<ChipUserRecharge> list = chipUserRechargeService.selectChipUserRechargeList(chipUserRecharge);
        return getDataTable(list);
    }

    /**
     * 导出用户芯片-用户充值列表
     */
    @PreAuthorize("@ss.hasPermi('chip_user_recharge:chip_user_recharge:export')")
    @Log(title = "导出用户芯片-用户充值", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ChipUserRecharge chipUserRecharge) {
        List<ChipUserRecharge> list = chipUserRechargeService.selectChipUserRechargeList(chipUserRecharge);
        ExcelUtil<ChipUserRecharge> util = new ExcelUtil<ChipUserRecharge>(ChipUserRecharge.class);
        util.exportExcel(response, list, "用户芯片-用户充值数据");
    }

    /**
     * 获取用户芯片-用户充值详细信息
     */
    @PreAuthorize("@ss.hasPermi('chip_user_recharge:chip_user_recharge:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(chipUserRechargeService.selectChipUserRechargeById(id));
    }

    /**
     * 新增用户芯片-用户充值
     */
    @PreAuthorize("@ss.hasPermi('chip_user_recharge:chip_user_recharge:add')")
    @Log(title = "新增用户芯片-用户充值", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ChipUserRecharge chipUserRecharge) {
        return toAjax(chipUserRechargeService.insertChipUserRecharge(chipUserRecharge));
    }

    /**
     * 修改用户芯片-用户充值
     */
    @PreAuthorize("@ss.hasPermi('chip_user_recharge:chip_user_recharge:edit')")
    @Log(title = "修改用户芯片-用户充值", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ChipUserRecharge chipUserRecharge) {
        return toAjax(chipUserRechargeService.updateChipUserRecharge(chipUserRecharge));
    }

    /**
     * 删除用户芯片-用户充值
     */
    @PreAuthorize("@ss.hasPermi('chip_user_recharge:chip_user_recharge:remove')")
    @Log(title = "删除用户芯片-用户充值", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(chipUserRechargeService.deleteChipUserRechargeByIds(ids));
    }

}
