package com.ruoyi.platform.liveBroadcastApp;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/21 17:45
 * @Description:
 */
@RestController
@RequestMapping("/hello")
public class HelloV2 {

    private static final Logger logger = LoggerFactory.getLogger(HelloV2.class);

    @Log(title = "HelloWorld测试", businessType = BusinessType.TEST)
    @GetMapping("/world")
    public AjaxResult getCode(HttpServletResponse response) {
        logger.info("HelloWorld测试 /hello/world: {}", response.getHeaderNames());
        logger.warn("HelloWorld测试 /hello/world: {}", response.getHeaderNames());
        logger.error("HelloWorld测试 /hello/world: {}", response.getHeaderNames());
        return AjaxResult.success("成功");
    }

}
