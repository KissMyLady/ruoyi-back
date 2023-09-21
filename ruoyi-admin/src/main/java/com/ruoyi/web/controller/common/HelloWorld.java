package com.ruoyi.web.controller.common;

import com.ruoyi.common.core.domain.AjaxResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/21 19:12
 * @Description:
 */
@RestController
@RequestMapping("/hi")
public class HelloWorld {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
    @GetMapping("/v1")
    public AjaxResult getCode(HttpServletResponse response) {
        logger.info("访问了Hello world, {}", response.getHeaderNames());
        return AjaxResult.success("Hello World !");
    }

}
