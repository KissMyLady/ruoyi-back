package com.ruoyi.platform.app.msg.tb_msg.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.platform.app.msg.tb_msg.domain.tb_msg;
import com.ruoyi.platform.app.msg.tb_msg.service.ITbMsgOpenService;
import com.ruoyi.platform.app.openApi.request_api_key.service.impl.RequestOpenApiServerImpl;
import com.ruoyi.platform.app.openApi.request_api_key_log.domain.request_api_key_log;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import net.dreamlu.mica.ip2region.core.IpInfo;
import com.ruoyi.common.utils.ip.IpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;
import com.ruoyi.platform.app.openApi.request_api_key_log.mapper.request_api_key_logMapper;
import com.ruoyi.platform.app.msg.tb_msg.mapper.tb_msgMapper;
import javax.servlet.http.HttpServletRequest;

import eu.bitwalker.useragentutils.UserAgent;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/21 13:48
 * @Description:
 */
@Service
public class TbMsgOpenServiceImpl implements ITbMsgOpenService {

    private static final Logger logger = LoggerFactory.getLogger(TbMsgOpenServiceImpl.class);

    @Autowired
    private request_api_key_logMapper request_api_key_logMapper;

    @Autowired
    private tb_msgMapper tb_msgMapper;

    @Autowired
    private Ip2regionSearcher ip2regionSearcher;

    @Autowired
    private RequestOpenApiServerImpl requestOpenApiServer;

    //是否需要校验md5
    @Value("${openApi.hasCheckMd5}")
    private boolean hasCheckMd5;

    /**
     * 接收推送数据
     */
    @Override
    public AjaxResult push(HttpServletRequest request, tb_msg dto) {
        request_api_key_log logEntity = new request_api_key_log();
        long startTime = System.currentTimeMillis();
        String methodStr = request.getMethod();
        String userAgentStr = request.getHeader("user-agent");
        String url = request.getRequestURI();
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        String browser = userAgent.getBrowser().toString();
        String os = userAgent.getOperatingSystem().toString();

        String title = hasCheckMd5 ? "api请求推送数据到 消息 表" : "api请求推送数据到 消息 表-[未使用md5校验接口安全性]";
        logEntity.setLogTitle(title);
        String ip = IpUtils.getIpAddr();
        IpInfo ipInfo = ip2regionSearcher.memorySearch(ip);

        logEntity.setReqIp(request.getRemoteAddr());
        logEntity.setReqAddress(ipInfo.getAddress());
        logEntity.setReqMethod(methodStr);
        logEntity.setReqAgent(userAgentStr);
        logEntity.setReqUrl(url);
        logEntity.setReqBrowser(browser);
        logEntity.setReqSystem(os);
        String jsonStr = JSONUtil.toJsonStr(dto);
        logEntity.setReqParams(jsonStr);
        logEntity.setReqKey(dto.getKey());

        //校验请求值是否正确, 校验md5
        AjaxResult ajaxResult = this.pushData(dto);

        //是否成功
        Long ss = System.currentTimeMillis() - startTime;
        logEntity.setTimeOut(ss);  //执行时间
        logEntity.setIsSuccess(ajaxResult.isSuccess() ? 1: 0);
        logEntity.setException("");
        logEntity.setEffectRows("1");

        //不管成功否, 写入日志记录
        int i = request_api_key_logMapper.insertrequest_api_key_log(logEntity);
        return ajaxResult;
    }

    /**
     * 写入数据
     */
    @Override
    public AjaxResult pushData(tb_msg dto) {
        //判断校验key是否存在, 是否有效 ?
        String s = requestOpenApiServer.hasEffect(dto.getKey());
        if (!ObjectUtil.equals(s, "")) {
            return AjaxResult.error(s);
        }

        String key = dto.getKey();
        String md5 = dto.getMd5();
        String timeStamp = dto.getTimeStamp();

        if (ObjectUtil.isEmpty(dto.getMd5())) {
            return AjaxResult.error("传入 md5 不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getKey())) {
            return AjaxResult.error("传入 key 不能为空");
        }

        //校验md5值
        if (hasCheckMd5) {
            if (ObjectUtil.isEmpty(dto.getMd5())) {
                return AjaxResult.error("md5不能为空");
            }
            //生成md5
            String md5Str = this.verificationMd5(dto);
            if (!md5Str.isEmpty()) {
                return AjaxResult.error(md5Str);
            }

            //比对md5
            if (!ObjectUtil.equals(md5, md5Str)){
                return AjaxResult.error("md5校验不通过");
            }
        }

        //校验通过, 写入数据
        int i = tb_msgMapper.inserttb_msg(dto);
        return AjaxResult.success("推送数据成功 " + i);

    }

    /**
     * md5生成
     */
    @Override
    public String verificationMd5(tb_msg dto) {

        return "";
    }
}
