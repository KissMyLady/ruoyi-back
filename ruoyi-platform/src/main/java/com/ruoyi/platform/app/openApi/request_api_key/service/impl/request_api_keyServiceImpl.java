package com.ruoyi.platform.app.openApi.request_api_key.service.impl;

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
import com.ruoyi.platform.app.openApi.request_api_key.mapper.request_api_keyMapper;
import com.ruoyi.platform.app.openApi.request_api_key.domain.request_api_key;
import com.ruoyi.platform.app.openApi.request_api_key.service.Irequest_api_keyService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * api请求-keyService业务层处理
 *
 * @author mylady
 * @date 2023-10-21
 */
@Service
public class request_api_keyServiceImpl implements Irequest_api_keyService {

    private static final Logger logger = LoggerFactory.getLogger(request_api_keyServiceImpl.class);

    @Autowired
    private request_api_keyMapper request_api_keyMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectrequest_api_keyById(Long id) {
        return request_api_keyMapper.selectrequest_api_keyById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<request_api_key> selectrequest_api_keyList(request_api_key dto) {
        return request_api_keyMapper.selectrequest_api_keyList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertrequest_api_key(request_api_key request_api_key) {
        request_api_key.setCreateTime(DateUtils.getNowDate());
        return request_api_keyMapper.insertrequest_api_key(request_api_key);
    }

    /**
     * 修改
     */
    @Override
    public int updaterequest_api_key(request_api_key request_api_key) {
        request_api_key.setUpdateTime(DateUtils.getNowDate());
        return request_api_keyMapper.updaterequest_api_key(request_api_key);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleterequest_api_keyByIds(Long[] ids) {
        return request_api_keyMapper.deleterequest_api_keyByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleterequest_api_keyById(Long id) {
        return request_api_keyMapper.deleterequest_api_keyById(id);
    }
}
