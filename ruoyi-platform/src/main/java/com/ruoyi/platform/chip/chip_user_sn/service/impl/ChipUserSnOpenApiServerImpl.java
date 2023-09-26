package com.ruoyi.platform.chip.chip_user_sn.service.impl;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;
import com.ruoyi.platform.chip.chip_user_sn.service.IChipUserSnOpenApiServer;
import com.ruoyi.platform.request_api.request_api_key.service.impl.RequestOpenApiServerImpl;
import com.ruoyi.platform.request_api.request_api_key_send_log.domain.RequestApiKeySendLog;
import com.ruoyi.platform.request_api.request_api_key_send_log.service.impl.RequestApiKeySendLogServiceImpl;
import com.ruoyi.platform.users.platform_user.domain.PlatformSysUser;
import com.ruoyi.platform.users.platform_user.service.impl.PlatformSysUserServiceImpl;
import eu.bitwalker.useragentutils.UserAgent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Objects;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 14:23
 * @Description:
 */
@Service
public class ChipUserSnOpenApiServerImpl implements IChipUserSnOpenApiServer {

    private static final Logger logger = LoggerFactory.getLogger(ChipUserSnOpenApiServerImpl.class);

    @Autowired
    private RequestOpenApiServerImpl requestOpenApiServer;

    @Autowired
    private RequestApiKeySendLogServiceImpl requestApiKeySendLogService;

    @Autowired
    private ChipUserSnServiceImpl chipUserSnService;

    @Autowired
    private PlatformSysUserServiceImpl sysUserService;

    @Override
    public ResultVo<?> pushData(ChipUserSn dto) {
        // 校验
        Long userId = dto.getUserId();  //关联用户id
        String phone = dto.getPhone();  //用户手机
        String nickname = dto.getNickname();  //昵称
        String sn = dto.getSn();  //sn序列号
        Date expiredTime = dto.getExpiredTime();  //到期时间 yyyy-MM-dd
        Integer status = dto.getStatus();  //状态
        if (sn == null || sn.isEmpty()){
            return ResultVo.error("sn 不能为空");
        }
        if (phone == null || phone.isEmpty()){
            return ResultVo.error("phone 不能为空");
        }
        if (expiredTime == null){
            return ResultVo.error("expiredTime 不能为空");
        }
        if (status == null){
            return ResultVo.error("status 不能为空");
        }

        if(ObjectUtil.isEmpty(dto.getKey())){
            return ResultVo.error("key 不能为空");
        }

        //判断key是否存在, 是否有效 ?
        String s = requestOpenApiServer.hasEffect(dto.getKey());
        if(!Objects.equals(s, "")){
            return ResultVo.error(s);
        }

        //校验md5值

        // 判断用户是否存在,
        PlatformSysUser sysUser = sysUserService.selectUserById(userId);
        if (ObjectUtil.isEmpty(sysUser)){
            return ResultVo.error("推送用户不存在, 请核对用户id是否正确");
        }

        //推送数据写入
        try {
            int i = chipUserSnService.insertChipUserSn(dto);
            //key计数+1
            int addOne = requestOpenApiServer.addKeyUserCount_one(dto.getKey());
        }
        catch (Exception e){
            logger.error("推送用户sn数据操作失败, 原因是: {}", ""+e);
            return ResultVo.error("推送成功失败, 原因是: "+ e);
        }
        return ResultVo.success("推送成功");
    }

    @Override
    public ResultVo<?> editData(ChipUserSn dto) {
        return null;
    }

    // 通用校验方法
    public ResultVo<?> commonFuc(ChipUserSn dto, HttpServletRequest request){
        RequestApiKeySendLog logEntity = new RequestApiKeySendLog();
        long startTime = System.currentTimeMillis();

        String methodStr = request.getMethod();
        String userAgentStr = request.getHeader("user-agent");
        String url = request.getRequestURI();
        UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
        String browser = userAgent.getBrowser().toString();
        String os = userAgent.getOperatingSystem().toString();

        logEntity.setReqMethod(methodStr);
        logEntity.setReqAgent(userAgentStr);
        logEntity.setReqUrl(url);
        logEntity.setReqBrowser(browser);
        logEntity.setReqSystem(os);
        //糊涂工具包, dto转字符
        String jsonStr = JSONUtil.toJsonStr(dto);
        logEntity.setReqParams(jsonStr);

        // 校验

        // 校验通过 / 不通过

        Long ss = System.currentTimeMillis() - startTime;
        logEntity.setTimeOut(ss);  //执行时间
        //写入日志数据
        requestApiKeySendLogService.insertRequestApiKeySendLog(logEntity);
        return ResultVo.success("成功");
    }
}
