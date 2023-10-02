package com.ruoyi.platform.app.zblog.do_sku.controller;

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
import com.ruoyi.platform.app.zblog.do_sku.domain.DoSku;
//import com.ruoyi.platform.app.zblog.do_sku.service.IDoSkuService;
import com.ruoyi.platform.app.zblog.do_sku.service.impl.DoSkuServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * do_skuController
 *
 * @author mylady
 * @date 2023-10-02
 */
@RestController
@RequestMapping("/do_sku/do_sku")
public class DoSkuController extends BaseController {

    @Autowired
    private DoSkuServiceImpl doSkuService;
    //private IDoSkuService doSkuService;

    /**
     * 查询do_sku列表
     */
    @PreAuthorize("@ss.hasPermi('do_sku:do_sku:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoSku doSku) {
        startPage();
        List<DoSku> list = doSkuService.selectDoSkuList(doSku);
        return getDataTable(list);
    }

    /**
     * 导出do_sku列表
     */
    @PreAuthorize("@ss.hasPermi('do_sku:do_sku:export')")
    @Log(title = "导出do_sku", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DoSku doSku) {
        List<DoSku> list = doSkuService.selectDoSkuList(doSku);
        ExcelUtil<DoSku> util = new ExcelUtil<DoSku>(DoSku.class);
        util.exportExcel(response, list, "do_sku数据");
    }

    /**
     * 获取do_sku详细信息
     */
    @PreAuthorize("@ss.hasPermi('do_sku:do_sku:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(doSkuService.selectDoSkuById(id));
    }

    /**
     * 新增do_sku
     */
    @PreAuthorize("@ss.hasPermi('do_sku:do_sku:add')")
    @Log(title = "新增do_sku", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoSku doSku) {
        return toAjax(doSkuService.insertDoSku(doSku));
    }

    /**
     * 修改do_sku
     */
    @PreAuthorize("@ss.hasPermi('do_sku:do_sku:edit')")
    @Log(title = "修改do_sku", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoSku doSku) {
        return toAjax(doSkuService.updateDoSku(doSku));
    }

    /**
     * 删除do_sku
     */
    @PreAuthorize("@ss.hasPermi('do_sku:do_sku:remove')")
    @Log(title = "删除do_sku", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(doSkuService.deleteDoSkuByIds(ids));
    }

}
