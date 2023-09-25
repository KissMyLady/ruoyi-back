package com.ruoyi.platform.chip.chip_version.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.chip.chip_version.mapper.ChipVersionMapper;
import com.ruoyi.platform.chip.chip_version.domain.ChipVersion;
import com.ruoyi.platform.chip.chip_version.service.IChipVersionService;

/**
 * 硬件版本Service业务层处理
 *
 * @author mylady
 * @date 2023-09-25
 */
@Service
public class ChipVersionServiceImpl implements IChipVersionService {
    @Autowired
    private ChipVersionMapper chipVersionMapper;

    /**
     * 查询硬件版本
     *
     * @param id 硬件版本主键
     * @return 硬件版本
     */
    @Override
    public ChipVersion selectChipVersionById(Long id) {
        return chipVersionMapper.selectChipVersionById(id);
    }

    /**
     * 查询硬件版本列表
     *
     * @param chipVersion 硬件版本
     * @return 硬件版本
     */
    @Override
    public List<ChipVersion> selectChipVersionList(ChipVersion chipVersion) {
        return chipVersionMapper.selectChipVersionList(chipVersion);
    }

    /**
     * 新增硬件版本
     *
     * @param chipVersion 硬件版本
     * @return 结果
     */
    @Override
    public int insertChipVersion(ChipVersion chipVersion) {
                chipVersion.setCreateTime(DateUtils.getNowDate());
            return chipVersionMapper.insertChipVersion(chipVersion);
    }

    /**
     * 修改硬件版本
     *
     * @param chipVersion 硬件版本
     * @return 结果
     */
    @Override
    public int updateChipVersion(ChipVersion chipVersion) {
                chipVersion.setUpdateTime(DateUtils.getNowDate());
        return chipVersionMapper.updateChipVersion(chipVersion);
    }

    /**
     * 批量删除硬件版本
     *
     * @param ids 需要删除的硬件版本主键
     * @return 结果
     */
    @Override
    public int deleteChipVersionByIds(Long[] ids) {
        return chipVersionMapper.deleteChipVersionByIds(ids);
    }

    /**
     * 删除硬件版本信息
     *
     * @param id 硬件版本主键
     * @return 结果
     */
    @Override
    public int deleteChipVersionById(Long id) {
        return chipVersionMapper.deleteChipVersionById(id);
    }
}
