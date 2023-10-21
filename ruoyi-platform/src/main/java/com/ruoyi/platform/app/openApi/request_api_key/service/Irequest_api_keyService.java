package com.ruoyi.platform.app.openApi.request_api_key.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.platform.app.openApi.request_api_key.domain.request_api_key;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * api请求-keyService接口
 *
 * @author mylady
 * @date 2023-10-21
 */
public interface Irequest_api_keyService {
    /**
     * 查询详情
     */
    Map<String, Object> selectrequest_api_keyById(Long id);

    /**
     * 查询列表
     */
    List<request_api_key> selectrequest_api_keyList(request_api_key dto);

    /**
     * ++新增++
     */
    int insertrequest_api_key(request_api_key dto);

    /**
     * 修改
     */
    int updaterequest_api_key(request_api_key dto);

    /**
     * --批量删除--
     */
    int deleterequest_api_keyByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleterequest_api_keyById(Long id);

}
