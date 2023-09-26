package com.ruoyi.platform.request_api.request_api_key_send_log.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.request_api.request_api_key_send_log.mapper.RequestApiKeySendLogMapper;
import com.ruoyi.platform.request_api.request_api_key_send_log.domain.RequestApiKeySendLog;
import com.ruoyi.platform.request_api.request_api_key_send_log.service.IRequestApiKeySendLogService;

/**
 * api请求记录Service业务层处理
 *
 * @author mylady
 * @date 2023-09-26
 */
@Service
public class RequestApiKeySendLogServiceImpl implements IRequestApiKeySendLogService {
    @Autowired
    private RequestApiKeySendLogMapper requestApiKeySendLogMapper;

    /**
     * 查询api请求记录
     *
     * @param id api请求记录主键
     * @return api请求记录
     */
    @Override
    public RequestApiKeySendLog selectRequestApiKeySendLogById(Long id) {
        return requestApiKeySendLogMapper.selectRequestApiKeySendLogById(id);
    }

    /**
     * 查询api请求记录列表
     *
     * @param requestApiKeySendLog api请求记录
     * @return api请求记录
     */
    @Override
    public List<RequestApiKeySendLog> selectRequestApiKeySendLogList(RequestApiKeySendLog requestApiKeySendLog) {
        return requestApiKeySendLogMapper.selectRequestApiKeySendLogList(requestApiKeySendLog);
    }

    /**
     * 新增api请求记录
     *
     * @param requestApiKeySendLog api请求记录
     * @return 结果
     */
    @Override
    public int insertRequestApiKeySendLog(RequestApiKeySendLog requestApiKeySendLog) {
                requestApiKeySendLog.setCreateTime(DateUtils.getNowDate());
            return requestApiKeySendLogMapper.insertRequestApiKeySendLog(requestApiKeySendLog);
    }

    /**
     * 修改api请求记录
     *
     * @param requestApiKeySendLog api请求记录
     * @return 结果
     */
    @Override
    public int updateRequestApiKeySendLog(RequestApiKeySendLog requestApiKeySendLog) {
                requestApiKeySendLog.setUpdateTime(DateUtils.getNowDate());
        return requestApiKeySendLogMapper.updateRequestApiKeySendLog(requestApiKeySendLog);
    }

    /**
     * 批量删除api请求记录
     *
     * @param ids 需要删除的api请求记录主键
     * @return 结果
     */
    @Override
    public int deleteRequestApiKeySendLogByIds(Long[] ids) {
        return requestApiKeySendLogMapper.deleteRequestApiKeySendLogByIds(ids);
    }

    /**
     * 删除api请求记录信息
     *
     * @param id api请求记录主键
     * @return 结果
     */
    @Override
    public int deleteRequestApiKeySendLogById(Long id) {
        return requestApiKeySendLogMapper.deleteRequestApiKeySendLogById(id);
    }
}
