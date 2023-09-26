package com.ruoyi.platform.request_api.request_api_key.controller;

import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.platform.request_api.request_api_key.service.impl.RequestOpenApiServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 13:55
 * @Description: 开放接口
 */
@RestController
@RequestMapping("/openApi/request_api/")
public class RequestOpenApiCtrl {

    @Autowired
    private RequestOpenApiServerImpl requestOpenApiServer;

    /**
     * 开放接口, 测试用
     */
    @GetMapping("/hello")
    public ResultVo<?> hello(HttpServletRequest request) {
        return requestOpenApiServer.hello(request);
    }




}
