package com.ruoyi.platform.request_api.request_api_key.mapper;

import java.util.List;

import com.ruoyi.platform.request_api.request_api_key.domain.RequestApiKey;

/**
 * api请求-keyMapper接口
 *
 * @author mylady
 * @date 2023-09-26
 */
public interface RequestApiKeyMapper {
    /**
     * 查询api请求-key
     *
     * @param id api请求-key主键
     * @return api请求-key
     */
    RequestApiKey selectRequestApiKeyById(Long id);

    /**
     * 查询api请求-key列表
     *
     * @param requestApiKey api请求-key
     * @return api请求-key集合
     */
    List<RequestApiKey> selectRequestApiKeyList(RequestApiKey requestApiKey);

    /**
     * 新增api请求-key
     *
     * @param requestApiKey api请求-key
     * @return 结果
     */
    int insertRequestApiKey(RequestApiKey requestApiKey);

    /**
     * 修改api请求-key
     *
     * @param requestApiKey api请求-key
     * @return 结果
     */
    int updateRequestApiKey(RequestApiKey requestApiKey);

    /**
     * 删除api请求-key
     *
     * @param id api请求-key主键
     * @return 结果
     */
    int deleteRequestApiKeyById(Long id);

    /**
     * 批量删除api请求-key
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteRequestApiKeyByIds(Long[] ids);
}
