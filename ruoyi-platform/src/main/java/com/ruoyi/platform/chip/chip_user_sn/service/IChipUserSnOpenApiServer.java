package com.ruoyi.platform.chip.chip_user_sn.service;

import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 14:23
 * @Description:
 */
public interface IChipUserSnOpenApiServer {

    public ResultVo<?> pushData(ChipUserSn dto);

    public ResultVo<?> editData(ChipUserSn dto);

    //校验md5
    public String verificationMd5(ChipUserSn dto);

}
