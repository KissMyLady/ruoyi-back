package com.ruoyi.platform.llm_chat_log.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.llm_chat_log.mapper.LlmChatLogMapper;
import com.ruoyi.platform.llm_chat_log.domain.LlmChatLog;
import com.ruoyi.platform.llm_chat_log.service.ILlmChatLogService;

/**
 * 语言模型聊天记录Service业务层处理
 *
 * @author mylady
 * @date 2023-09-23
 */
@Service
public class LlmChatLogServiceImpl implements ILlmChatLogService {
    @Autowired
    private LlmChatLogMapper llmChatLogMapper;

    /**
     * 查询语言模型聊天记录
     *
     * @param id 语言模型聊天记录主键
     * @return 语言模型聊天记录
     */
    @Override
    public LlmChatLog selectLlmChatLogById(Long id) {
        return llmChatLogMapper.selectLlmChatLogById(id);
    }

    /**
     * 查询语言模型聊天记录列表
     *
     * @param llmChatLog 语言模型聊天记录
     * @return 语言模型聊天记录
     */
    @Override
    public List<LlmChatLog> selectLlmChatLogList(LlmChatLog llmChatLog) {
        return llmChatLogMapper.selectLlmChatLogList(llmChatLog);
    }

    /**
     * 新增语言模型聊天记录
     *
     * @param llmChatLog 语言模型聊天记录
     * @return 结果
     */
    @Override
    public int insertLlmChatLog(LlmChatLog llmChatLog) {
        llmChatLog.setCreateTime(DateUtils.getNowDate());
        return llmChatLogMapper.insertLlmChatLog(llmChatLog);
    }

    /**
     * 修改语言模型聊天记录
     *
     * @param llmChatLog 语言模型聊天记录
     * @return 结果
     */
    @Override
    public int updateLlmChatLog(LlmChatLog llmChatLog) {
        llmChatLog.setUpdateTime(DateUtils.getNowDate());
        return llmChatLogMapper.updateLlmChatLog(llmChatLog);
    }

    /**
     * 批量删除语言模型聊天记录
     *
     * @param ids 需要删除的语言模型聊天记录主键
     * @return 结果
     */
    @Override
    public int deleteLlmChatLogByIds(Long[] ids) {
        return llmChatLogMapper.deleteLlmChatLogByIds(ids);
    }

    /**
     * 删除语言模型聊天记录信息
     *
     * @param id 语言模型聊天记录主键
     * @return 结果
     */
    @Override
    public int deleteLlmChatLogById(Long id) {
        return llmChatLogMapper.deleteLlmChatLogById(id);
    }
}
