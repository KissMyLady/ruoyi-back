package com.ruoyi.platform.request_api.request_api_key.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.platform.request_api.request_api_key.domain.RequestApiKey;
import com.ruoyi.platform.request_api.request_api_key.mapper.RequestApiKeyMapper;
import com.ruoyi.platform.request_api.request_api_key.service.IRequestOpenApiServer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 13:56
 * @Description:
 */
@Service
public class RequestOpenApiServerImpl implements IRequestOpenApiServer {

    private static final Logger logger = LoggerFactory.getLogger(RequestOpenApiServerImpl.class);

    @Autowired
    private RequestApiKeyMapper requestApiKeyMapper;

    @Override
    public ResultVo<?> hello(HttpServletRequest request) {
        // 获得IP
        String methodStr = request.getMethod();
        String userAgent = request.getHeader("user-agent");
        String url = request.getRequestURI();
        logger.info("open api测试. 请求方法: {}", methodStr);
        logger.info("open api测试. 请求userAgent: {}", userAgent);
        logger.info("open api测试. 请求url: {}", url);
        return ResultVo.success("Hello world");
    }

    /**
     * key是否有效?
     */
    @Override
    public String hasEffect(String key) {
        //查询key
        RequestApiKey apiKeyEntity = requestApiKeyMapper.selectRequestApiKeyByKey(key);
        if (ObjectUtil.isEmpty(apiKeyEntity)) {
            return "查询不到key";
        }
        Date keyOverdue = apiKeyEntity.getKeyOverdue(); //当前key的过期时间
        Long keySmsCount = apiKeyEntity.getKeySmsCount();  //限制数
        Long sendCount = apiKeyEntity.getSendCount(); // 已发送数
        //判断是否过期
        Date date = new Date();
        if (keyOverdue.before(date)) {
            logger.warn("当前key: {} 已过期", key);
            return "已过期";
        }
        if (keySmsCount - sendCount <= 0) {
            logger.warn("当前key: {} 可用数已使用完毕", key);
            return "当前key可用数已使用完毕";
        }
        return "";
    }

    /**
     * key的使用次数加1
     */
    @Override
    public int addKeyUserCount_one(String key) {
        int i = requestApiKeyMapper.addSendCount(key);
        return i;
    }


}
