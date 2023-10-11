package com.ruoyi.web.controller.common;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.security.EncryptUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.ruoyi.common.annotation.ReturnAESEncrypt;
import com.ruoyi.common.core.domain.EncryptDto;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/21 19:12
 * @Description:
 */
@RestController
@RequestMapping("/hi")
public class HelloWorld {

    private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    @GetMapping("/v1")
    public AjaxResult getCode(HttpServletResponse response) {
        logger.info("访问 /hi/v1: {}", response.getHeaderNames());
        logger.warn("访问 /hi/v1: {}", response.getHeaderNames());
        logger.error("访问 /hi/v1: {}", response.getHeaderNames());
        return AjaxResult.success("Hello World !");
    }


    /**
     * 返回值加密
     */
    @ReturnAESEncrypt()
    @PostMapping("/v2")
    public AjaxResult helloWorld_v2(HttpServletResponse response) {
        List<Map<String, Object>> lists = new ArrayList<>();

        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "你好");
        map.put("content", "Hello");
        lists.add(map);
        // String s = encryptUtilsService.aesEncryptListMap(lists);
        AjaxResult ajx = new AjaxResult();
        ajx.setContent(lists);
        ajx.setMessage("成功");
        return ajx;
    }


    /**
     * 入参解密
     */
    @ReturnAESEncrypt()
    @PostMapping("/v3")
    public AjaxResult helloWorld_v3(@RequestBody EncryptDto dto) {
        logger.info("入参打印: {}", dto);

        EncryptDto encryptDto = encryptUtilsService.decryptString2Dto(dto);

        logger.info("解密后的对象打印: {}", encryptDto);

        List<Map<String, Object>> lists = new ArrayList<>();
        HashMap<String, Object> map = new HashMap<>();
        map.put("msg", "你好");
        map.put("content", "Hello");
        lists.add(map);
        // String s = encryptUtilsService.aesEncryptListMap(lists);
        AjaxResult ajx = new AjaxResult();
        ajx.setContent(lists);
        ajx.setMessage("成功");
        return ajx;
    }


}
