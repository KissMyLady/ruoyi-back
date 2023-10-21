package com.ruoyi.platform.app.openApi.request_api_key_log.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.openApi.request_api_key_log.domain.request_api_key_log;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * api请求记录Service接口
 *
 * @author mylady
 * @date 2023-10-21
 */
public interface Irequest_api_key_logService {
    /**
     * 查询详情
     */
    Map<String, Object> selectrequest_api_key_logById(Long id);

    /**
     * 查询列表
     */
    List<request_api_key_log> selectrequest_api_key_logList(request_api_key_log dto);

    /**
     * ++新增++
     */
    int insertrequest_api_key_log(request_api_key_log dto);

    /**
     * 修改
     */
    int updaterequest_api_key_log(request_api_key_log dto);

    /**
     * --批量删除--
     */
    int deleterequest_api_key_logByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleterequest_api_key_logById(Long id);

}
