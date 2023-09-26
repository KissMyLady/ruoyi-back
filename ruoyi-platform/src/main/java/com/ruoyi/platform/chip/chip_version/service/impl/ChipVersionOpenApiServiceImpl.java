package com.ruoyi.platform.chip.chip_version.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.ResultVo;
import com.ruoyi.platform.chip.chip_version.mapper.ChipVersionMapper;
import com.ruoyi.platform.chip.chip_version.service.IChipVersionOpenApiService;
import com.ruoyi.platform.request_api.request_api_key.service.impl.RequestOpenApiServerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.chip.chip_version.domain.ChipVersion;

import java.util.Objects;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/9/26 17:43
 * @Description:
 */
@Service
public class ChipVersionOpenApiServiceImpl implements IChipVersionOpenApiService {

    @Autowired
    private ChipVersionMapper chipVersionMapper;

    @Autowired
    private RequestOpenApiServerImpl requestOpenApiServer;

    @Value("${openApi.hasCheckMd5}")
    private boolean hasCheckMd5;

    @Override
    public ResultVo<?> pushData(ChipVersion dto) {
        //判断校验key是否存在, 是否有效 ?
        String s = requestOpenApiServer.hasEffect(dto.getKey());
        if (!Objects.equals(s, "")) {
            return ResultVo.error(s);
        }
        String version = dto.getVersion();
        String url = dto.getUrl();
        String key = dto.getKey();
        String md5 = dto.getMd5();
        String timeStamp = dto.getTimeStamp();

        if (ObjectUtil.isEmpty(dto.getVersion())) {
            return ResultVo.error("传入 version 不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getUrl())) {
            return ResultVo.error("传入 url 不能为空");
        }
        if (ObjectUtil.isEmpty(dto.getKey())) {
            return ResultVo.error("传入 key 不能为空");
        }

        //校验md5值
        if (hasCheckMd5) {
            if (ObjectUtil.isEmpty(dto.getMd5())) {
                return ResultVo.error("md5不能为空");
            }
            String md5Str = this.verificationMd5(dto);
            if (!md5Str.isEmpty()) {
                return ResultVo.error(md5Str);
            }
        }

        int i = chipVersionMapper.insertChipVersion(dto);
        return ResultVo.success("推送数据成功", i);
    }

    @Override
    public ResultVo<?> editData(ChipVersion dto) {
        //判断校验key是否存在, 是否有效 ?
        String s = requestOpenApiServer.hasEffect(dto.getKey());
        if (!Objects.equals(s, "")) {
            return ResultVo.error(s);
        }

        //校验md5值
        if (hasCheckMd5) {
            if (ObjectUtil.isEmpty(dto.getMd5())) {
                return ResultVo.error("md5不能为空");
            }
            String md5Str = this.verificationMd5(dto);
            if (!md5Str.isEmpty()) {
                return ResultVo.error(md5Str);
            }
        }
        int i = chipVersionMapper.updateChipVersion(dto);
        return ResultVo.success("修改数据成功", i);
    }

    @Override
    public String verificationMd5(ChipVersion dto) {
        return null;
    }
}
