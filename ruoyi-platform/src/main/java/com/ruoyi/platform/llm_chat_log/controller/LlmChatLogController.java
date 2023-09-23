package com.ruoyi.platform.llm_chat_log.controller;

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
import com.ruoyi.platform.llm_chat_log.domain.LlmChatLog;
import com.ruoyi.platform.llm_chat_log.service.ILlmChatLogService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 语言模型聊天记录Controller
 *
 * @author mylady
 * @date 2023-09-23
 */
@RestController
@RequestMapping("/llm_chat_log/llm_chat_log")
public class LlmChatLogController extends BaseController {

    @Autowired
    private ILlmChatLogService llmChatLogService;

    /**
     * 查询语言模型聊天记录列表
     */
    @PreAuthorize("@ss.hasPermi('llm_chat_log:llm_chat_log:list')")
    @GetMapping("/list")
    public TableDataInfo list(LlmChatLog llmChatLog) {
        startPage();
        List<LlmChatLog> list = llmChatLogService.selectLlmChatLogList(llmChatLog);
        return getDataTable(list);
    }

    /**
     * 导出语言模型聊天记录列表
     */
    @PreAuthorize("@ss.hasPermi('llm_chat_log:llm_chat_log:export')")
    @Log(title = "语言模型聊天记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LlmChatLog llmChatLog) {
        List<LlmChatLog> list = llmChatLogService.selectLlmChatLogList(llmChatLog);
        ExcelUtil<LlmChatLog> util = new ExcelUtil<LlmChatLog>(LlmChatLog.class);
        util.exportExcel(response, list, "语言模型聊天记录数据");
    }

    /**
     * 获取语言模型聊天记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('llm_chat_log:llm_chat_log:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(llmChatLogService.selectLlmChatLogById(id));
    }

    /**
     * 新增语言模型聊天记录
     */
    @PreAuthorize("@ss.hasPermi('llm_chat_log:llm_chat_log:add')")
    @Log(title = "语言模型聊天记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LlmChatLog llmChatLog) {
        return toAjax(llmChatLogService.insertLlmChatLog(llmChatLog));
    }

    /**
     * 修改语言模型聊天记录
     */
    @PreAuthorize("@ss.hasPermi('llm_chat_log:llm_chat_log:edit')")
    @Log(title = "语言模型聊天记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LlmChatLog llmChatLog) {
        return toAjax(llmChatLogService.updateLlmChatLog(llmChatLog));
    }

    /**
     * 删除语言模型聊天记录
     */
    @PreAuthorize("@ss.hasPermi('llm_chat_log:llm_chat_log:remove')")
    @Log(title = "语言模型聊天记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(llmChatLogService.deleteLlmChatLogByIds(ids));
    }

}
