package com.ruoyi.platform.chip.chip_user_sn.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.common.utils.http.RequestEncoder;
import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;
import com.ruoyi.platform.chip.chip_user_sn.service.IChipUserSnOpenApiServer;
import com.ruoyi.platform.request_api.request_api_key.service.impl.RequestOpenApiServerImpl;
import com.ruoyi.platform.users.platform_user.domain.PlatformSysUser;
import com.ruoyi.platform.users.platform_user.service.impl.PlatformSysUserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.TreeMap;

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
    private ChipUserSnServiceImpl chipUserSnService;

    @Autowired
    private PlatformSysUserServiceImpl sysUserService;

    @Value("${openApi.hasCheckMd5}")
    private boolean hasCheckMd5;

    @Override
    public ResultVo<?> pushData(ChipUserSn dto) {
        //判断key是否存在, 是否有效 ?
        String resHasEffect = requestOpenApiServer.hasEffect(dto.getKey());
        if (!Objects.equals(resHasEffect, "")) {
            return ResultVo.error(resHasEffect);
        }
        // 校验
        Long userId = dto.getUserId();  //关联用户id
        String phone = dto.getPhone();  //用户手机
        String nickname = dto.getNickname();  //昵称
        String sn = dto.getSn();  //sn序列号
        Date expiredTime = dto.getExpiredTime();  //到期时间 yyyy-MM-dd
        Integer status = dto.getStatus();  //状态
        if (sn == null || sn.isEmpty()) {
            return ResultVo.error("sn 不能为空");
        }
        if (phone == null || phone.isEmpty()) {
            return ResultVo.error("phone 不能为空");
        }
        if (expiredTime == null) {
            return ResultVo.error("expiredTime 不能为空");
        }
        if (status == null) {
            return ResultVo.error("status 不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getKey())) {
            return ResultVo.error("key 不能为空");
        }

        //校验md5值
        if (hasCheckMd5){
            if(ObjectUtil.isEmpty(dto.getMd5())){
                return ResultVo.error("md5不能为空");
            }
            String s = this.verificationMd5(dto);
            if (!s.isEmpty()){
                return ResultVo.error(s);
            }
        }

        // 判断用户是否存在,
        PlatformSysUser sysUser = sysUserService.selectUserById(userId);
        if (ObjectUtil.isEmpty(sysUser)) {
            return ResultVo.error("推送用户不存在, 请核对用户id是否正确");
        }

        //推送数据写入
        try {
            int i = chipUserSnService.insertChipUserSn(dto);
            //key计数+1
            int addOne = requestOpenApiServer.addKeyUserCount_one(dto.getKey());
        } catch (Exception e) {
            logger.error("推送用户sn数据操作失败, 原因是: {}", "" + e);
            return ResultVo.error("推送失败, 原因是: " + e);
        }
        return ResultVo.success("推送成功");
    }

    @Override
    public ResultVo<?> editData(ChipUserSn dto) {
        //判断校验key是否存在, 是否有效 ?
        String s = requestOpenApiServer.hasEffect(dto.getKey());
        if (!Objects.equals(s, "")) {
            return ResultVo.error(s);
        }

        // sn是否存在
        if (ObjectUtil.isEmpty(dto.getSn())) {
            return ResultVo.error("编辑对象sn不能为空");
        }

        //校验md5值
        if (hasCheckMd5){
            if(ObjectUtil.isEmpty(dto.getMd5())){
                return ResultVo.error("md5不能为空");
            }
            String md5Res = this.verificationMd5(dto);
            if (!md5Res.isEmpty()){
                return ResultVo.error(md5Res);
            }
        }

        Long userId = dto.getUserId();  //关联用户id
        // 判断用户是否存在,
        PlatformSysUser sysUser = sysUserService.selectUserById(userId);
        if (ObjectUtil.isEmpty(sysUser)) {
            return ResultVo.error("推送用户不存在, 请核对用户id是否正确");
        }

        //数据更新
        try {
            int i = chipUserSnService.updateChipUserSnBySn(dto);
            //key计数+1
            int addOne = requestOpenApiServer.addKeyUserCount_one(dto.getKey());
        } catch (Exception e) {
            logger.error("修改用户sn数据操作失败, 原因是: {}", "" + e);
            return ResultVo.error("修改失败, 原因是: " + e);
        }
        return ResultVo.success("修改成功");
    }


    //md5校验
    @Override
    public String verificationMd5(ChipUserSn dto) {
        String userId = String.format("%d", dto.getUserId());
        String key = dto.getKey();
        String nickname = dto.getNickname();
        String phone = dto.getPhone();
        String thumbnail = dto.getThumbnail();
        String timeStamp = dto.getTimeStamp();
        String md5 = dto.getMd5();

        if (userId == null) {
            userId = "";
        }
        if (key == null) {
            key = "";
        }
        if (nickname == null) {
            nickname = "";
        }
        if (phone == null) {
            phone = "";
        }
        if (thumbnail == null) {
            thumbnail = "";
        }
        if (timeStamp == null) {
            timeStamp = "";
        }
        TreeMap<String, String> treeMap = new TreeMap<>();

        treeMap.put("userId", userId);
        treeMap.put("nickname", nickname);
        treeMap.put("key", key);
        treeMap.put("phone", phone);
        treeMap.put("thumbnail", thumbnail);
        treeMap.put("timeStamp", timeStamp);

        String signStr = userId + nickname + RequestEncoder.formatRequest(treeMap) + phone + key;

        if (md5.equals(signStr)) {
            return "";
        }
        return "md5校验不通过";
    }
}
