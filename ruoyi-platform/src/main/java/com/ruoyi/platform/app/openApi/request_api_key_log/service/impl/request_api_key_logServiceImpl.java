package com.ruoyi.platform.app.openApi.request_api_key_log.service.impl;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.openApi.request_api_key_log.mapper.request_api_key_logMapper;
import com.ruoyi.platform.app.openApi.request_api_key_log.domain.request_api_key_log;
import com.ruoyi.platform.app.openApi.request_api_key_log.service.Irequest_api_key_logService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * api请求记录Service业务层处理
 *
 * @author mylady
 * @date 2023-10-21
 */
@Service
public class request_api_key_logServiceImpl implements Irequest_api_key_logService {

    private static final Logger logger = LoggerFactory.getLogger(request_api_key_logServiceImpl.class);

    @Autowired
    private request_api_key_logMapper request_api_key_logMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectrequest_api_key_logById(Long id) {
        return request_api_key_logMapper.selectrequest_api_key_logById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<request_api_key_log> selectrequest_api_key_logList(request_api_key_log dto) {
        return request_api_key_logMapper.selectrequest_api_key_logList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertrequest_api_key_log(request_api_key_log request_api_key_log) {
        request_api_key_log.setCreateTime(DateUtils.getNowDate());
        return request_api_key_logMapper.insertrequest_api_key_log(request_api_key_log);
    }

    /**
     * 修改
     */
    @Override
    public int updaterequest_api_key_log(request_api_key_log request_api_key_log) {
        request_api_key_log.setUpdateTime(DateUtils.getNowDate());
        return request_api_key_logMapper.updaterequest_api_key_log(request_api_key_log);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleterequest_api_key_logByIds(Long[] ids) {
        return request_api_key_logMapper.deleterequest_api_key_logByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleterequest_api_key_logById(Long id) {
        return request_api_key_logMapper.deleterequest_api_key_logById(id);
    }
}
