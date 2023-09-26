package com.ruoyi.platform.chip.chip_version.controller;

import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.common.utils.ip.IpUtils;
import com.ruoyi.platform.chip.chip_version.domain.ChipVersion;
import com.ruoyi.platform.chip.chip_version.service.impl.ChipVersionOpenApiServiceImpl;
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
 * @Date: Created in 2023/9/26 17:42
 * @Description:
 */
@RestController
@RequestMapping("/openApi/chipVersion")
public class ChipVersionOpenApiCtrl {

    @Autowired
    private ChipVersionOpenApiServiceImpl chipVersionOpenApiService;

    @Autowired
    private RequestApiKeySendLogServiceImpl requestApiKeySendLogService;

    @Autowired
    private Ip2regionSearcher ip2regionSearcher;

    @GetMapping("/hello")
    public ResultVo<?> hello(HttpServletRequest request) {
        return ResultVo.success("请求成功"+ request.getHeaders("user-agent"));
    }

    @PostMapping("/edit")
    public ResultVo<?> edit(@RequestBody ChipVersion dto, HttpServletRequest request) {
        RequestApiKeySendLog logEntity = new RequestApiKeySendLog();
        long startTime = System.currentTimeMillis();
        String methodStr = request.getMethod();
        String userAgentStr = request.getHeader("user-agent");
        String url = request.getRequestURI();
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        String browser = userAgent.getBrowser().toString();
        String os = userAgent.getOperatingSystem().toString();

        logEntity.setLogTitle("api请求推送数据到用户充值表");
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

        ResultVo<?> resultVo = chipVersionOpenApiService.editData(dto);

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

    @PostMapping("/push")
    public ResultVo<?> pushData(@RequestBody ChipVersion dto, HttpServletRequest request) {
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

        ResultVo<?> resultVo = chipVersionOpenApiService.pushData(dto);

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
