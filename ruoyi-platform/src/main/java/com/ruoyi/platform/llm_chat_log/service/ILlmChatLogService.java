package com.ruoyi.platform.llm_chat_log.service;

import java.util.List;

import com.ruoyi.platform.llm_chat_log.domain.LlmChatLog;

/**
 * 语言模型聊天记录Service接口
 *
 * @author mylady
 * @date 2023-09-23
 */
public interface ILlmChatLogService {
    /**
     * 查询语言模型聊天记录
     *
     * @param id 语言模型聊天记录主键
     * @return 语言模型聊天记录
     */
    public LlmChatLog selectLlmChatLogById(Long id);

    /**
     * 查询语言模型聊天记录列表
     *
     * @param llmChatLog 语言模型聊天记录
     * @return 语言模型聊天记录集合
     */
    public List<LlmChatLog> selectLlmChatLogList(LlmChatLog llmChatLog);

    /**
     * 新增语言模型聊天记录
     *
     * @param llmChatLog 语言模型聊天记录
     * @return 结果
     */
    public int insertLlmChatLog(LlmChatLog llmChatLog);

    /**
     * 修改语言模型聊天记录
     *
     * @param llmChatLog 语言模型聊天记录
     * @return 结果
     */
    public int updateLlmChatLog(LlmChatLog llmChatLog);

    /**
     * 批量删除语言模型聊天记录
     *
     * @param ids 需要删除的语言模型聊天记录主键集合
     * @return 结果
     */
    public int deleteLlmChatLogByIds(Long[] ids);

    /**
     * 删除语言模型聊天记录信息
     *
     * @param id 语言模型聊天记录主键
     * @return 结果
     */
    public int deleteLlmChatLogById(Long id);
}
