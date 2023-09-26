package com.ruoyi.platform.request_api.request_api_key.service;

import java.util.List;

import com.ruoyi.platform.request_api.request_api_key.domain.RequestApiKey;

/**
 * api请求-keyService接口
 *
 * @author mylady
 * @date 2023-09-26
 */
public interface IRequestApiKeyService {
    /**
     * 查询api请求-key
     *
     * @param id api请求-key主键
     * @return api请求-key
     */
    public RequestApiKey selectRequestApiKeyById(Long id);

    /**
     * 查询api请求-key列表
     *
     * @param requestApiKey api请求-key
     * @return api请求-key集合
     */
    public List<RequestApiKey> selectRequestApiKeyList(RequestApiKey requestApiKey);

    /**
     * 新增api请求-key
     *
     * @param requestApiKey api请求-key
     * @return 结果
     */
    public int insertRequestApiKey(RequestApiKey requestApiKey);

    /**
     * 修改api请求-key
     *
     * @param requestApiKey api请求-key
     * @return 结果
     */
    public int updateRequestApiKey(RequestApiKey requestApiKey);

    /**
     * 批量删除api请求-key
     *
     * @param ids 需要删除的api请求-key主键集合
     * @return 结果
     */
    public int deleteRequestApiKeyByIds(Long[] ids);

    /**
     * 删除api请求-key信息
     *
     * @param id api请求-key主键
     * @return 结果
     */
    public int deleteRequestApiKeyById(Long id);
}
