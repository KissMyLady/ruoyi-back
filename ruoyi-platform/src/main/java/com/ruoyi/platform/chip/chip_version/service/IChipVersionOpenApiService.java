package com.ruoyi.platform.chip.chip_version.service;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.platform.chip.chip_version.domain.ChipVersion;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 17:43
 * @Description:
 */
public interface IChipVersionOpenApiService {


    public ResultVo<?> pushData(ChipVersion dto);

    public ResultVo<?> editData(ChipVersion dto);

    //校验md5
    public String verificationMd5(ChipVersion dto);
}
