package com.ruoyi.platform.app.msg;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.platform.app.msg.tb_msg.domain.tb_msg;
import com.ruoyi.platform.app.msg.tb_msg.service.impl.TbMsgOpenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/21 13:01
 * @Description:  开发接口
 */
@RestController
@RequestMapping("/openApi/openMsg")
public class OpenApi_v1_Ctrl {

    @Autowired
    private TbMsgOpenServiceImpl tbMsgOpenService;

    /**
     * 消息表推送, 接收方
     */
    @PostMapping("/push")
    public AjaxResult push(@RequestBody tb_msg dto, HttpServletRequest request) {
        return tbMsgOpenService.push(request, dto);
    }

}
