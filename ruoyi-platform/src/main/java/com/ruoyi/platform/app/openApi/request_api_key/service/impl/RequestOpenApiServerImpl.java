package com.ruoyi.platform.app.openApi.request_api_key.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.platform.app.openApi.request_api_key.domain.request_api_key;
import com.ruoyi.platform.app.openApi.request_api_key.mapper.request_api_keyMapper;
import com.ruoyi.platform.app.openApi.request_api_key.service.IRequestOpenApiServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/21 14:05
 * @Description:
 */
@Service
public class RequestOpenApiServerImpl implements IRequestOpenApiServer {

    private static final Logger logger = LoggerFactory.getLogger(RequestOpenApiServerImpl.class);

    @Autowired
    private request_api_keyMapper requestApiKeyMapper;

    /**
     * 校验key是否存在, 使用有效
     */
    @Override
    public String hasEffect(String key) {
        //查询key
        request_api_key requestApiKey = requestApiKeyMapper.selectByKey(key);
        if (ObjectUtil.isEmpty(requestApiKey)) {
            return "查询不到key";
        }
        Date keyOverdue = requestApiKey.getKeyOverdue(); //当前key的过期时间
        Long keySmsCount = requestApiKey.getKeySmsCount();  //限制数
        Long sendCount = requestApiKey.getSendCount(); // 已发送数

        //判断是否过期
        Date date = new Date();
        if (keyOverdue.before(date)) {
            logger.warn("当前key: {} 已过期", key);
            return "key已过期";
        }
        if (keySmsCount - sendCount <= 0) {
            logger.warn("当前key: {} 可用数已使用完毕", key);
            return "当前key可用数已使用完毕";
        }
        return "";
    }

    /**
     * 自增加
     */
    @Override
    public int addKeyUserCount_one(String key) {
        int i = requestApiKeyMapper.addSendCount(key);
        return i;
    }
}
