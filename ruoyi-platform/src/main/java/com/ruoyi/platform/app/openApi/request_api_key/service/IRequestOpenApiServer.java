package com.ruoyi.platform.app.openApi.request_api_key.service;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/21 14:05
 * @Description:
 */
public interface IRequestOpenApiServer {

    /**
     * key是否有效?
     */
    String hasEffect(String key);

    /**
     * 当前key加一使用次数
     */
    int addKeyUserCount_one(String key);

}
