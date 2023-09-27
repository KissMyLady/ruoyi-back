package com.ruoyi.platform.request_api.request_api_key.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.request_api.request_api_key.mapper.RequestApiKeyMapper;
import com.ruoyi.platform.request_api.request_api_key.domain.RequestApiKey;
import com.ruoyi.platform.request_api.request_api_key.service.IRequestApiKeyService;

/**
 * api请求-keyService业务层处理
 *
 * @author mylady
 * @date 2023-09-26
 */
@Service
public class RequestApiKeyServiceImpl implements IRequestApiKeyService {
    @Autowired
    private RequestApiKeyMapper requestApiKeyMapper;

    /**
     * 查询api请求-key
     *
     * @param id api请求-key主键
     * @return api请求-key
     */
    @Override
    public RequestApiKey selectRequestApiKeyById(Long id) {
        return requestApiKeyMapper.selectRequestApiKeyById(id);
    }

    /**
     * 查询api请求-key列表
     *
     * @param requestApiKey api请求-key
     * @return api请求-key
     */
    @Override
    public List<RequestApiKey> selectRequestApiKeyList(RequestApiKey requestApiKey) {
        return requestApiKeyMapper.selectRequestApiKeyList(requestApiKey);
    }

    /**
     * 新增api请求-key
     *
     * @param requestApiKey api请求-key
     * @return 结果
     */
    @Override
    public int insertRequestApiKey(RequestApiKey requestApiKey) {
        requestApiKey.setCreateTime(DateUtils.getNowDate());
        return requestApiKeyMapper.insertRequestApiKey(requestApiKey);
    }

    /**
     * 修改api请求-key
     *
     * @param requestApiKey api请求-key
     * @return 结果
     */
    @Override
    public int updateRequestApiKey(RequestApiKey requestApiKey) {
        requestApiKey.setUpdateTime(DateUtils.getNowDate());
        return requestApiKeyMapper.updateRequestApiKey(requestApiKey);
    }

    /**
     * 批量删除api请求-key
     *
     * @param ids 需要删除的api请求-key主键
     * @return 结果
     */
    @Override
    public int deleteRequestApiKeyByIds(Long[] ids) {
        return requestApiKeyMapper.deleteRequestApiKeyByIds(ids);
    }

    /**
     * 删除api请求-key信息
     *
     * @param id api请求-key主键
     * @return 结果
     */
    @Override
    public int deleteRequestApiKeyById(Long id) {
        return requestApiKeyMapper.deleteRequestApiKeyById(id);
    }
}
