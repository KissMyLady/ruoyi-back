package com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.controller;

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
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.domain.IdealDetailContent;
//import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.service.IIdealDetailContentService;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_detail_content.service.impl.IdealDetailContentServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 看理想-详情Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/ideal_detail_content/ideal_detail_content")
public class IdealDetailContentController extends BaseController {

    @Autowired
    private IdealDetailContentServiceImpl idealDetailContentService;
    //private IIdealDetailContentService idealDetailContentService;

    /**
     * 查询看理想-详情列表
     */
    @PreAuthorize("@ss.hasPermi('ideal_detail_content:ideal_detail_content:list')")
    @GetMapping("/list")
    public TableDataInfo list(IdealDetailContent idealDetailContent) {
        startPage();
        List<IdealDetailContent> list = idealDetailContentService.selectIdealDetailContentList(idealDetailContent);
        return getDataTable(list);
    }

    /**
     * 导出看理想-详情列表
     */
    @PreAuthorize("@ss.hasPermi('ideal_detail_content:ideal_detail_content:export')")
    @Log(title = "导出看理想-详情", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IdealDetailContent idealDetailContent) {
        List<IdealDetailContent> list = idealDetailContentService.selectIdealDetailContentList(idealDetailContent);
        ExcelUtil<IdealDetailContent> util = new ExcelUtil<IdealDetailContent>(IdealDetailContent.class);
        util.exportExcel(response, list, "看理想-详情数据");
    }

    /**
     * 获取看理想-详情详细信息
     */
    @PreAuthorize("@ss.hasPermi('ideal_detail_content:ideal_detail_content:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(idealDetailContentService.selectIdealDetailContentById(id));
    }

    /**
     * 新增看理想-详情
     */
    @PreAuthorize("@ss.hasPermi('ideal_detail_content:ideal_detail_content:add')")
    @Log(title = "新增看理想-详情", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IdealDetailContent idealDetailContent) {
        return toAjax(idealDetailContentService.insertIdealDetailContent(idealDetailContent));
    }

    /**
     * 修改看理想-详情
     */
    @PreAuthorize("@ss.hasPermi('ideal_detail_content:ideal_detail_content:edit')")
    @Log(title = "修改看理想-详情", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IdealDetailContent idealDetailContent) {
        return toAjax(idealDetailContentService.updateIdealDetailContent(idealDetailContent));
    }

    /**
     * 删除看理想-详情
     */
    @PreAuthorize("@ss.hasPermi('ideal_detail_content:ideal_detail_content:remove')")
    @Log(title = "删除看理想-详情", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(idealDetailContentService.deleteIdealDetailContentByIds(ids));
    }

}
