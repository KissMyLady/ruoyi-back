package com.ruoyi.platform.chip.chip_user_recharge.service;

import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.platform.chip.chip_user_recharge.domain.ChipUserRecharge;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 17:10
 * @Description:
 */
public interface IChipUserRechargeOpenService {

    public ResultVo<?> pushData(ChipUserRecharge dto);

    public ResultVo<?> editData(ChipUserRecharge dto);

    //校验md5
    public String verificationMd5(ChipUserRecharge dto);

}
