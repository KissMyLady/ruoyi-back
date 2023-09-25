package com.ruoyi.platform.chip.chip_version.mapper;

import java.util.List;

import com.ruoyi.platform.chip.chip_version.domain.ChipVersion;

/**
 * 硬件版本Mapper接口
 *
 * @author mylady
 * @date 2023-09-25
 */
public interface ChipVersionMapper {
    /**
     * 查询硬件版本
     *
     * @param id 硬件版本主键
     * @return 硬件版本
     */
    public ChipVersion selectChipVersionById(Long id);

    /**
     * 查询硬件版本列表
     *
     * @param chipVersion 硬件版本
     * @return 硬件版本集合
     */
    public List<ChipVersion> selectChipVersionList(ChipVersion chipVersion);

    /**
     * 新增硬件版本
     *
     * @param chipVersion 硬件版本
     * @return 结果
     */
    public int insertChipVersion(ChipVersion chipVersion);

    /**
     * 修改硬件版本
     *
     * @param chipVersion 硬件版本
     * @return 结果
     */
    public int updateChipVersion(ChipVersion chipVersion);

    /**
     * 删除硬件版本
     *
     * @param id 硬件版本主键
     * @return 结果
     */
    public int deleteChipVersionById(Long id);

    /**
     * 批量删除硬件版本
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChipVersionByIds(Long[] ids);
}
