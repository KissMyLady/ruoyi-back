package com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.controller;

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
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.domain.IdealCategory;
//import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.service.IIdealCategoryService;
import com.ruoyi.platform.app.zblog.v2_ideal.ideal_category.service.impl.IdealCategoryServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 看理想-类别Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/ideal_category/ideal_category")
public class IdealCategoryController extends BaseController {

    @Autowired
    private IdealCategoryServiceImpl idealCategoryService;
    //private IIdealCategoryService idealCategoryService;

    /**
     * 查询看理想-类别列表
     */
    @PreAuthorize("@ss.hasPermi('ideal_category:ideal_category:list')")
    @GetMapping("/list")
    public TableDataInfo list(IdealCategory idealCategory) {
        startPage();
        List<IdealCategory> list = idealCategoryService.selectIdealCategoryList(idealCategory);
        return getDataTable(list);
    }

    /**
     * 导出看理想-类别列表
     */
    @PreAuthorize("@ss.hasPermi('ideal_category:ideal_category:export')")
    @Log(title = "导出看理想-类别", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, IdealCategory idealCategory) {
        List<IdealCategory> list = idealCategoryService.selectIdealCategoryList(idealCategory);
        ExcelUtil<IdealCategory> util = new ExcelUtil<IdealCategory>(IdealCategory.class);
        util.exportExcel(response, list, "看理想-类别数据");
    }

    /**
     * 获取看理想-类别详细信息
     */
    @PreAuthorize("@ss.hasPermi('ideal_category:ideal_category:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(idealCategoryService.selectIdealCategoryById(id));
    }

    /**
     * 新增看理想-类别
     */
    @PreAuthorize("@ss.hasPermi('ideal_category:ideal_category:add')")
    @Log(title = "新增看理想-类别", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody IdealCategory idealCategory) {
        return toAjax(idealCategoryService.insertIdealCategory(idealCategory));
    }

    /**
     * 修改看理想-类别
     */
    @PreAuthorize("@ss.hasPermi('ideal_category:ideal_category:edit')")
    @Log(title = "修改看理想-类别", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody IdealCategory idealCategory) {
        return toAjax(idealCategoryService.updateIdealCategory(idealCategory));
    }

    /**
     * 删除看理想-类别
     */
    @PreAuthorize("@ss.hasPermi('ideal_category:ideal_category:remove')")
    @Log(title = "删除看理想-类别", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(idealCategoryService.deleteIdealCategoryByIds(ids));
    }

}
