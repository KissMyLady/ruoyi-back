package com.ruoyi.platform.llm_claude_key.controller;

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
import com.ruoyi.platform.llm_claude_key.domain.LlmClaudeKey;
import com.ruoyi.platform.llm_claude_key.service.ILlmClaudeKeyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 语言模型,api,claude连接池Controller
 *
 * @author mylady
 * @date 2023-09-23
 */
@RestController
@RequestMapping("/llm_claude_key/llm_claude_key")
public class LlmClaudeKeyController extends BaseController {

    @Autowired
    private ILlmClaudeKeyService llmClaudeKeyService;

    /**
     * 查询语言模型,api,claude连接池列表
     */
    @PreAuthorize("@ss.hasPermi('llm_claude_key:llm_claude_key:list')")
    @GetMapping("/list")
    public TableDataInfo list(LlmClaudeKey llmClaudeKey) {
        startPage();
        List<LlmClaudeKey> list = llmClaudeKeyService.selectLlmClaudeKeyList(llmClaudeKey);
        return getDataTable(list);
    }

    /**
     * 导出语言模型,api,claude连接池列表
     */
    @PreAuthorize("@ss.hasPermi('llm_claude_key:llm_claude_key:export')")
    @Log(title = "语言模型,api,claude连接池", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, LlmClaudeKey llmClaudeKey) {
        List<LlmClaudeKey> list = llmClaudeKeyService.selectLlmClaudeKeyList(llmClaudeKey);
        ExcelUtil<LlmClaudeKey> util = new ExcelUtil<LlmClaudeKey>(LlmClaudeKey.class);
        util.exportExcel(response, list, "语言模型,api,claude连接池数据");
    }

    /**
     * 获取语言模型,api,claude连接池详细信息
     */
    @PreAuthorize("@ss.hasPermi('llm_claude_key:llm_claude_key:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(llmClaudeKeyService.selectLlmClaudeKeyById(id));
    }

    /**
     * 新增语言模型,api,claude连接池
     */
    @PreAuthorize("@ss.hasPermi('llm_claude_key:llm_claude_key:add')")
    @Log(title = "语言模型,api,claude连接池", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody LlmClaudeKey llmClaudeKey) {
        return toAjax(llmClaudeKeyService.insertLlmClaudeKey(llmClaudeKey));
    }

    /**
     * 修改语言模型,api,claude连接池
     */
    @PreAuthorize("@ss.hasPermi('llm_claude_key:llm_claude_key:edit')")
    @Log(title = "语言模型,api,claude连接池", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody LlmClaudeKey llmClaudeKey) {
        return toAjax(llmClaudeKeyService.updateLlmClaudeKey(llmClaudeKey));
    }

    /**
     * 删除语言模型,api,claude连接池
     */
    @PreAuthorize("@ss.hasPermi('llm_claude_key:llm_claude_key:remove')")
    @Log(title = "语言模型,api,claude连接池", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(llmClaudeKeyService.deleteLlmClaudeKeyByIds(ids));
    }

}