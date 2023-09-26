package com.ruoyi.platform.request_api.request_api_key_send_log.controller;

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
import com.ruoyi.platform.request_api.request_api_key_send_log.domain.RequestApiKeySendLog;
//import com.ruoyi.platform.request_api.request_api_key_send_log.service.IRequestApiKeySendLogService;
import com.ruoyi.platform.request_api.request_api_key_send_log.service.impl.RequestApiKeySendLogServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * api请求记录Controller
 *
 * @author mylady
 * @date 2023-09-26
 */
@RestController
@RequestMapping("/request_api_key_send_log/request_api_key_send_log")
public class RequestApiKeySendLogController extends BaseController {

    @Autowired
    private RequestApiKeySendLogServiceImpl requestApiKeySendLogService;
    //private IRequestApiKeySendLogService requestApiKeySendLogService;

    /**
     * 查询api请求记录列表
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_send_log:request_api_key_send_log:list')")
    @GetMapping("/list")
    public TableDataInfo list(RequestApiKeySendLog requestApiKeySendLog) {
        startPage();
        List<RequestApiKeySendLog> list = requestApiKeySendLogService.selectRequestApiKeySendLogList(requestApiKeySendLog);
        return getDataTable(list);
    }

    /**
     * 导出api请求记录列表
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_send_log:request_api_key_send_log:export')")
    @Log(title = "导出api请求记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RequestApiKeySendLog requestApiKeySendLog) {
        List<RequestApiKeySendLog> list = requestApiKeySendLogService.selectRequestApiKeySendLogList(requestApiKeySendLog);
        ExcelUtil<RequestApiKeySendLog> util = new ExcelUtil<RequestApiKeySendLog>(RequestApiKeySendLog.class);
        util.exportExcel(response, list, "api请求记录数据");
    }

    /**
     * 获取api请求记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_send_log:request_api_key_send_log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(requestApiKeySendLogService.selectRequestApiKeySendLogById(id));
    }

    /**
     * 新增api请求记录
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_send_log:request_api_key_send_log:add')")
    @Log(title = "新增api请求记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RequestApiKeySendLog requestApiKeySendLog) {
        return toAjax(requestApiKeySendLogService.insertRequestApiKeySendLog(requestApiKeySendLog));
    }

    /**
     * 修改api请求记录
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_send_log:request_api_key_send_log:edit')")
    @Log(title = "修改api请求记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RequestApiKeySendLog requestApiKeySendLog) {
        return toAjax(requestApiKeySendLogService.updateRequestApiKeySendLog(requestApiKeySendLog));
    }

    /**
     * 删除api请求记录
     */
    @PreAuthorize("@ss.hasPermi('request_api_key_send_log:request_api_key_send_log:remove')")
    @Log(title = "删除api请求记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(requestApiKeySendLogService.deleteRequestApiKeySendLogByIds(ids));
    }

}
