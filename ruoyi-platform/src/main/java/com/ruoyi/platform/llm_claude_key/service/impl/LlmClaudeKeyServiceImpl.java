package com.ruoyi.platform.llm_claude_key.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.llm_claude_key.mapper.LlmClaudeKeyMapper;
import com.ruoyi.platform.llm_claude_key.domain.LlmClaudeKey;
import com.ruoyi.platform.llm_claude_key.service.ILlmClaudeKeyService;

/**
 * 语言模型,api,claude连接池Service业务层处理
 *
 * @author mylady
 * @date 2023-09-23
 */
@Service
public class LlmClaudeKeyServiceImpl implements ILlmClaudeKeyService {
    @Autowired
    private LlmClaudeKeyMapper llmClaudeKeyMapper;

    /**
     * 查询语言模型,api,claude连接池
     *
     * @param id 语言模型,api,claude连接池主键
     * @return 语言模型, api, claude连接池
     */
    @Override
    public LlmClaudeKey selectLlmClaudeKeyById(Long id) {
        return llmClaudeKeyMapper.selectLlmClaudeKeyById(id);
    }

    /**
     * 查询语言模型,api,claude连接池列表
     *
     * @param llmClaudeKey 语言模型,api,claude连接池
     * @return 语言模型, api, claude连接池
     */
    @Override
    public List<LlmClaudeKey> selectLlmClaudeKeyList(LlmClaudeKey llmClaudeKey) {
        return llmClaudeKeyMapper.selectLlmClaudeKeyList(llmClaudeKey);
    }

    /**
     * 新增语言模型,api,claude连接池
     *
     * @param llmClaudeKey 语言模型,api,claude连接池
     * @return 结果
     */
    @Override
    public int insertLlmClaudeKey(LlmClaudeKey llmClaudeKey) {
        llmClaudeKey.setCreateTime(DateUtils.getNowDate());
        return llmClaudeKeyMapper.insertLlmClaudeKey(llmClaudeKey);
    }

    /**
     * 修改语言模型,api,claude连接池
     *
     * @param llmClaudeKey 语言模型,api,claude连接池
     * @return 结果
     */
    @Override
    public int updateLlmClaudeKey(LlmClaudeKey llmClaudeKey) {
        llmClaudeKey.setUpdateTime(DateUtils.getNowDate());
        return llmClaudeKeyMapper.updateLlmClaudeKey(llmClaudeKey);
    }

    /**
     * 批量删除语言模型,api,claude连接池
     *
     * @param ids 需要删除的语言模型,api,claude连接池主键
     * @return 结果
     */
    @Override
    public int deleteLlmClaudeKeyByIds(Long[] ids) {
        return llmClaudeKeyMapper.deleteLlmClaudeKeyByIds(ids);
    }

    /**
     * 删除语言模型,api,claude连接池信息
     *
     * @param id 语言模型,api,claude连接池主键
     * @return 结果
     */
    @Override
    public int deleteLlmClaudeKeyById(Long id) {
        return llmClaudeKeyMapper.deleteLlmClaudeKeyById(id);
    }
}
