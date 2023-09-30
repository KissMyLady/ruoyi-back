package com.ruoyi.platform.app.zblog.do_spu.controller;

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
import com.ruoyi.platform.app.zblog.do_spu.domain.DoSpu;
//import com.ruoyi.platform.app.zblog.do_spu.service.IDoSpuService;
import com.ruoyi.platform.app.zblog.do_spu.service.impl.DoSpuServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * do_spuController
 *
 * @author mylady
 * @date 2023-09-30
 */
@RestController
@RequestMapping("/do_spu/do_spu")
public class DoSpuController extends BaseController {

    @Autowired
    private DoSpuServiceImpl doSpuService;
    //private IDoSpuService doSpuService;

    /**
     * 查询do_spu列表
     */
    @PreAuthorize("@ss.hasPermi('do_spu:do_spu:list')")
    @GetMapping("/list")
    public TableDataInfo list(DoSpu doSpu) {
        startPage();
        List<DoSpu> list = doSpuService.selectDoSpuList(doSpu);
        return getDataTable(list);
    }

    /**
     * 导出do_spu列表
     */
    @PreAuthorize("@ss.hasPermi('do_spu:do_spu:export')")
    @Log(title = "导出do_spu", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DoSpu doSpu) {
        List<DoSpu> list = doSpuService.selectDoSpuList(doSpu);
        ExcelUtil<DoSpu> util = new ExcelUtil<DoSpu>(DoSpu.class);
        util.exportExcel(response, list, "do_spu数据");
    }

    /**
     * 获取do_spu详细信息
     */
    @PreAuthorize("@ss.hasPermi('do_spu:do_spu:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(doSpuService.selectDoSpuById(id));
    }

    /**
     * 新增do_spu
     */
    @PreAuthorize("@ss.hasPermi('do_spu:do_spu:add')")
    @Log(title = "新增do_spu", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DoSpu doSpu) {
        return toAjax(doSpuService.insertDoSpu(doSpu));
    }

    /**
     * 修改do_spu
     */
    @PreAuthorize("@ss.hasPermi('do_spu:do_spu:edit')")
    @Log(title = "修改do_spu", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DoSpu doSpu) {
        return toAjax(doSpuService.updateDoSpu(doSpu));
    }

    /**
     * 删除do_spu
     */
    @PreAuthorize("@ss.hasPermi('do_spu:do_spu:remove')")
    @Log(title = "删除do_spu", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(doSpuService.deleteDoSpuByIds(ids));
    }

}
