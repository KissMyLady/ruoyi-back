package com.ruoyi.platform.chip.chip_user_sn.controller;

import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;
import com.ruoyi.platform.chip.chip_user_sn.service.impl.ChipUserSnOpenApiServerImpl;
import com.ruoyi.platform.request_api.request_api_key_send_log.domain.RequestApiKeySendLog;
import com.ruoyi.platform.request_api.request_api_key_send_log.service.impl.RequestApiKeySendLogServiceImpl;
import eu.bitwalker.useragentutils.UserAgent;
import net.dreamlu.mica.ip2region.core.Ip2regionSearcher;
import net.dreamlu.mica.ip2region.core.IpInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 14:22
 * @Description: 用户硬件序列号的开放接口
 */
@RestController
@RequestMapping("/openApi/userChipSn/")
public class ChipUserSnOpenApiCtrl {

    @Autowired
    private Ip2regionSearcher ip2regionSearcher;

    @Autowired
    private RequestApiKeySendLogServiceImpl requestApiKeySendLogService;

    @Autowired
    private ChipUserSnOpenApiServerImpl chipUserSnOpenApiServer;

    @GetMapping("/hello")
    public ResultVo<?> hello(HttpServletRequest request) {
        return ResultVo.success("请求成功"+ request.getHeaders("user-agent"));
    }

    //推送数据
    @PostMapping("/push")
    public ResultVo<?> pushData(@RequestBody ChipUserSn dto, HttpServletRequest request) {
        RequestApiKeySendLog logEntity = new RequestApiKeySendLog();
        long startTime = System.currentTimeMillis();
        String methodStr = request.getMethod();
        String userAgentStr = request.getHeader("user-agent");
        String url = request.getRequestURI();
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        String browser = userAgent.getBrowser().toString();
        String os = userAgent.getOperatingSystem().toString();

        logEntity.setLogTitle("api请求推送数据到用户sn表");
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

        //调用服务
        ResultVo<?> resultVo = chipUserSnOpenApiServer.pushData(dto);

        //是否成功
        Long ss = System.currentTimeMillis() - startTime;
        logEntity.setTimeOut(ss);  //执行时间
        logEntity.setIsSuccess(resultVo.isSuccess() ? 1 : 0);
        logEntity.setException(resultVo.getMsg());
        logEntity.setEffectRows(resultVo.isSuccess() ? "1" : "0");

        //写入日志数据
        requestApiKeySendLogService.insertRequestApiKeySendLog(logEntity);
        return resultVo;
    }

    //编辑数据
    @PostMapping("/edit")
    public ResultVo<?> editData(@RequestBody ChipUserSn dto, HttpServletRequest request) {
        RequestApiKeySendLog logEntity = new RequestApiKeySendLog();
        long startTime = System.currentTimeMillis();
        String methodStr = request.getMethod();
        String userAgentStr = request.getHeader("user-agent");
        String url = request.getRequestURI();
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        String browser = userAgent.getBrowser().toString();
        String os = userAgent.getOperatingSystem().toString();

        logEntity.setLogTitle("api请求修改用户sn表");
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

        //调用服务
        ResultVo<?> resultVo = chipUserSnOpenApiServer.editData(dto);

        //是否成功
        Long ss = System.currentTimeMillis() - startTime;
        logEntity.setTimeOut(ss);  //执行时间
        logEntity.setIsSuccess(resultVo.isSuccess() ? 1 : 0);
        logEntity.setException(resultVo.getMsg());
        logEntity.setEffectRows(resultVo.isSuccess() ? "1" : "0");

        //写入日志数据
        requestApiKeySendLogService.insertRequestApiKeySendLog(logEntity);
        return resultVo;
    }


}
