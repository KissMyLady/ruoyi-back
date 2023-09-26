package com.ruoyi.platform.chip.chip_user_recharge.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.http.RequestEncoder;
import com.ruoyi.platform.chip.chip_user_recharge.domain.ChipUserRecharge;
import com.ruoyi.platform.chip.chip_user_recharge.mapper.ChipUserRechargeMapper;
import com.ruoyi.platform.chip.chip_user_recharge.service.IChipUserRechargeOpenService;
import com.ruoyi.platform.request_api.request_api_key.service.impl.RequestOpenApiServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 17:10
 * @Description:
 */
@Service
public class ChipUserRechargeOpenServiceImpl implements IChipUserRechargeOpenService {

    @Value("${openApi.hasCheckMd5}")
    private boolean hasCheckMd5;

    @Autowired
    private RequestOpenApiServerImpl requestOpenApiServer;

    @Autowired
    private ChipUserRechargeMapper chipUserRechargeMapper;

    @Override
    public ResultVo<?> pushData(ChipUserRecharge dto) {
        //判断key是否存在, 是否有效 ?
        String resHasEffect = requestOpenApiServer.hasEffect(dto.getKey());
        if (!Objects.equals(resHasEffect, "")) {
            return ResultVo.error(resHasEffect);
        }
        //字段存在校验
        if (ObjectUtil.isEmpty(dto.getPhone())) {
            return ResultVo.error("传入手机号不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getRechargeMoney())) {
            return ResultVo.error("传入充值金额不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getRechargeTime())) {
            return ResultVo.error("传入充值时间不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getEffectiveTime())) {
            return ResultVo.error("传入有效时间不能为空.有效时间(单位:秒)");
        }

        //校验md5值
        if (hasCheckMd5) {
            if (ObjectUtil.isEmpty(dto.getMd5())) {
                return ResultVo.error("md5不能为空");
            }
            String s = this.verificationMd5(dto);
            if (!s.isEmpty()) {
                return ResultVo.error(s);
            }
        }

        //写入数据
        dto.setCreateTime(DateUtils.getNowDate());
        int i = chipUserRechargeMapper.insertChipUserRecharge(dto);
        return ResultVo.success("推送用户充值记录成功", i);
    }

    @Override
    public ResultVo<?> editData(ChipUserRecharge dto) {
        //判断key是否存在, 是否有效 ?
        String resHasEffect = requestOpenApiServer.hasEffect(dto.getKey());
        if (!Objects.equals(resHasEffect, "")) {
            return ResultVo.error(resHasEffect);
        }
        //字段存在校验
        if (ObjectUtil.isEmpty(dto.getPhone())) {
            return ResultVo.error("传入手机号不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getRechargeMoney())) {
            return ResultVo.error("传入充值金额不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getRechargeTime())) {
            return ResultVo.error("传入充值时间不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getEffectiveTime())) {
            return ResultVo.error("传入有效时间不能为空.有效时间(单位:秒)");
        }
        if (ObjectUtil.isEmpty(dto.getId())) {
            return ResultVo.error("传入主键id不能为空");
        }

        //校验md5值
        if (hasCheckMd5) {
            if (ObjectUtil.isEmpty(dto.getMd5())) {
                return ResultVo.error("md5不能为空");
            }
            String s = this.verificationMd5(dto);
            if (!s.isEmpty()) {
                return ResultVo.error(s);
            }
        }

        //写入数据
        dto.setCreateTime(DateUtils.getNowDate());
        int i = chipUserRechargeMapper.updateChipUserRecharge(dto);
        return ResultVo.success("编辑用户充值记录成功", i);
    }

    @Override
    public String verificationMd5(ChipUserRecharge dto) {
        String userId = String.format("%d", dto.getUserId());
        String phone = dto.getPhone();
        String effectiveTime = dto.getEffectiveTime();
        BigDecimal rechargeMoney = dto.getRechargeMoney();
        Date rechargeTime = dto.getRechargeTime();
        String key = dto.getKey();
        String timeStamp = dto.getTimeStamp();
        String md5 = dto.getMd5();

        if (userId == null) {
            userId = "";
        }
        if (phone == null) {
            phone = "";
        }
        if (effectiveTime == null) {
            effectiveTime = "";
        }
        if (key == null) {
            key = "";
        }
        if (timeStamp == null) {
            timeStamp = "";
        }
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("userId", userId);
        treeMap.put("phone", phone);
        treeMap.put("key", key);
        treeMap.put("effectiveTime", effectiveTime);
        treeMap.put("timeStamp", timeStamp);

        String signStr = userId + phone + RequestEncoder.formatRequest(treeMap) + effectiveTime + key;

        if (md5.equals(signStr)) {
            return "";
        }
        return "md5校验不通过";
    }

}
