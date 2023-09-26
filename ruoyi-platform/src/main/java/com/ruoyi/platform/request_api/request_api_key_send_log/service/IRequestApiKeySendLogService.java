package com.ruoyi.platform.request_api.request_api_key_send_log.service;

import java.util.List;

import com.ruoyi.platform.request_api.request_api_key_send_log.domain.RequestApiKeySendLog;

/**
 * api请求记录Service接口
 *
 * @author mylady
 * @date 2023-09-26
 */
public interface IRequestApiKeySendLogService {
    /**
     * 查询api请求记录
     *
     * @param id api请求记录主键
     * @return api请求记录
     */
    public RequestApiKeySendLog selectRequestApiKeySendLogById(Long id);

    /**
     * 查询api请求记录列表
     *
     * @param requestApiKeySendLog api请求记录
     * @return api请求记录集合
     */
    public List<RequestApiKeySendLog> selectRequestApiKeySendLogList(RequestApiKeySendLog requestApiKeySendLog);

    /**
     * 新增api请求记录
     *
     * @param requestApiKeySendLog api请求记录
     * @return 结果
     */
    public int insertRequestApiKeySendLog(RequestApiKeySendLog requestApiKeySendLog);

    /**
     * 修改api请求记录
     *
     * @param requestApiKeySendLog api请求记录
     * @return 结果
     */
    public int updateRequestApiKeySendLog(RequestApiKeySendLog requestApiKeySendLog);

    /**
     * 批量删除api请求记录
     *
     * @param ids 需要删除的api请求记录主键集合
     * @return 结果
     */
    public int deleteRequestApiKeySendLogByIds(Long[] ids);

    /**
     * 删除api请求记录信息
     *
     * @param id api请求记录主键
     * @return 结果
     */
    public int deleteRequestApiKeySendLogById(Long id);
}
