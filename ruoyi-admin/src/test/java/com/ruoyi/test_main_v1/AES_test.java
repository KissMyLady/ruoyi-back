package com.ruoyi.test_main_v1;

import com.ruoyi.common.security.EncryptUtilsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/21 23:01
 * @Description:
 */
@SpringBootTest
public class AES_test {

    private static final Logger logger = LoggerFactory.getLogger(AES_test.class);

    @Autowired
    private EncryptUtilsService encryptUtilsService;

    @Test
    public void test_1(){

        String public_txt = "Hello World !";
        String key_2 = "2023_10_21_23_00";

        String encryptTxt = encryptUtilsService.aesEncrypt(public_txt, key_2);

        logger.info("加密后的内容打印: {}", encryptTxt);

        //解密
        String decryptTxt = encryptUtilsService.aesDecrypt(encryptTxt, key_2);
        logger.info("解密后的内容打印: {}", decryptTxt);

    }
}
