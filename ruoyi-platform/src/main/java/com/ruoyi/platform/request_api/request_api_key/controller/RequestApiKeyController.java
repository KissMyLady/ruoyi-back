package com.ruoyi.platform.request_api.request_api_key.controller;

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
import com.ruoyi.platform.request_api.request_api_key.domain.RequestApiKey;
//import com.ruoyi.platform.request_api.request_api_key.service.IRequestApiKeyService;
import com.ruoyi.platform.request_api.request_api_key.service.impl.RequestApiKeyServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * api请求-keyController
 *
 * @author mylady
 * @date 2023-09-26
 */
@RestController
@RequestMapping("/request_api_key/request_api_key")
public class RequestApiKeyController extends BaseController {

    @Autowired
    private RequestApiKeyServiceImpl requestApiKeyService;
    //private IRequestApiKeyService requestApiKeyService;

    /**
     * 查询api请求-key列表
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:list')")
    @GetMapping("/list")
    public TableDataInfo list(RequestApiKey requestApiKey) {
        startPage();
        List<RequestApiKey> list = requestApiKeyService.selectRequestApiKeyList(requestApiKey);
        return getDataTable(list);
    }

    /**
     * 导出api请求-key列表
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:export')")
    @Log(title = "导出api请求-key", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RequestApiKey requestApiKey) {
        List<RequestApiKey> list = requestApiKeyService.selectRequestApiKeyList(requestApiKey);
        ExcelUtil<RequestApiKey> util = new ExcelUtil<RequestApiKey>(RequestApiKey.class);
        util.exportExcel(response, list, "api请求-key数据");
    }

    /**
     * 获取api请求-key详细信息
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(requestApiKeyService.selectRequestApiKeyById(id));
    }

    /**
     * 新增api请求-key
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:add')")
    @Log(title = "新增api请求-key", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RequestApiKey requestApiKey) {
        return toAjax(requestApiKeyService.insertRequestApiKey(requestApiKey));
    }

    /**
     * 修改api请求-key
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:edit')")
    @Log(title = "修改api请求-key", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RequestApiKey requestApiKey) {
        return toAjax(requestApiKeyService.updateRequestApiKey(requestApiKey));
    }

    /**
     * 删除api请求-key
     */
    @PreAuthorize("@ss.hasPermi('request_api_key:request_api_key:remove')")
    @Log(title = "删除api请求-key", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(requestApiKeyService.deleteRequestApiKeyByIds(ids));
    }

}
