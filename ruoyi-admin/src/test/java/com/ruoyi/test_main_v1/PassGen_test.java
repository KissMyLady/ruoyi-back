package com.ruoyi.test_main_v1;


import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/16 14:29
 * @Description:
 */
@SpringBootTest
public class PassGen_test {

    private static final Logger logger = LoggerFactory.getLogger(PassGen_test.class);

    //测试使用参考: https://blog.csdn.net/wwh1st/article/details/127990034
    @Test
    public void test_1() {
        // 第一个参数为账户名 第二个参数为密码 第三个参数为盐对应用户表salt（如果没有可以不用填）
        // System.out.println(new PasswordService().encryptPassword("admin", "admin123", "111111"));

        System.out.println("Hello World!");

        logger.info("日志记录 1 >>>>> {}", "尤利西斯");
        logger.info("日志记录 2 >>>>> {}", "神曲-但丁");

    }
}
