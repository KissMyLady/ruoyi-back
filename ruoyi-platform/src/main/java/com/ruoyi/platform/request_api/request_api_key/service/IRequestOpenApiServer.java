package com.ruoyi.platform.request_api.request_api_key.service;

import com.ruoyi.common.core.domain.ResultVo;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 13:56
 * @Description:
 */

public interface IRequestOpenApiServer {


    ResultVo<?> hello(HttpServletRequest request);

    /**
     * key是否有效?
     */
    String hasEffect(String key);

    /**
     * 当前key加一使用次数
     */
    int addKeyUserCount_one(String key);

}
