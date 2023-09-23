package com.ruoyi.platform.llm_claude_key.service;

import java.util.List;

import com.ruoyi.platform.llm_claude_key.domain.LlmClaudeKey;

/**
 * 语言模型,api,claude连接池Service接口
 *
 * @author mylady
 * @date 2023-09-23
 */
public interface ILlmClaudeKeyService {
    /**
     * 查询语言模型,api,claude连接池
     *
     * @param id 语言模型,api,claude连接池主键
     * @return 语言模型,api,claude连接池
     */
    public LlmClaudeKey selectLlmClaudeKeyById(Long id);

    /**
     * 查询语言模型,api,claude连接池列表
     *
     * @param llmClaudeKey 语言模型,api,claude连接池
     * @return 语言模型,api,claude连接池集合
     */
    public List<LlmClaudeKey> selectLlmClaudeKeyList(LlmClaudeKey llmClaudeKey);

    /**
     * 新增语言模型,api,claude连接池
     *
     * @param llmClaudeKey 语言模型,api,claude连接池
     * @return 结果
     */
    public int insertLlmClaudeKey(LlmClaudeKey llmClaudeKey);

    /**
     * 修改语言模型,api,claude连接池
     *
     * @param llmClaudeKey 语言模型,api,claude连接池
     * @return 结果
     */
    public int updateLlmClaudeKey(LlmClaudeKey llmClaudeKey);

    /**
     * 批量删除语言模型,api,claude连接池
     *
     * @param ids 需要删除的语言模型,api,claude连接池主键集合
     * @return 结果
     */
    public int deleteLlmClaudeKeyByIds(Long[] ids);

    /**
     * 删除语言模型,api,claude连接池信息
     *
     * @param id 语言模型,api,claude连接池主键
     * @return 结果
     */
    public int deleteLlmClaudeKeyById(Long id);
}
