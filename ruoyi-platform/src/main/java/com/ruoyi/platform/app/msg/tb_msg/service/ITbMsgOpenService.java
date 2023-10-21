package com.ruoyi.platform.app.msg.tb_msg.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import com.ruoyi.platform.app.msg.tb_msg.domain.tb_msg;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/21 13:47
 * @Description:
 */
public interface ITbMsgOpenService {

    /**
     * 接收推送数据
     */
    AjaxResult push(HttpServletRequest request, tb_msg dto);

    /**
     * 接收加密的推送数据
     */
    AjaxResult push_v2(HttpServletRequest request, EncryptDto dto);

    /**
     * 写入数据到数据库
     */
    AjaxResult pushData(tb_msg dto);

    //校验md5
    String verificationMd5(tb_msg dto);

}
