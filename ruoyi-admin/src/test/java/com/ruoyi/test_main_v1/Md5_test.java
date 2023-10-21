package com.ruoyi.test_main_v1;

import com.ruoyi.common.utils.http.RequestEncoder;

import java.util.TreeMap;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/21 21:03
 * @Description:
 */
@SpringBootTest
public class Md5_test {

    private static final Logger logger = LoggerFactory.getLogger(Md5_test.class);

    @Test
    public void test_() {
        String msgUuid = "b5bef205d742";
        String title = "色究竟天摩醯首罗天";
        String timeStamp = "1697893837321";

        //验证 1+2+3 = 4
        TreeMap<String, String> requestData = new TreeMap<>();
        requestData.put("msgUuid", msgUuid);
        requestData.put("title", title);
        requestData.put("timeStamp", timeStamp);

        String encodeParams = RequestEncoder.formatRequest(requestData);

        logger.info("formatRequest: {}", encodeParams);

        String signStr = msgUuid + title + encodeParams + title + msgUuid;

        logger.info("signStr: {}", signStr);

        //加密
        String encodeMd5 = RequestEncoder.encode(signStr);
        logger.info("生成的md5: {}", encodeMd5);

    }
}
