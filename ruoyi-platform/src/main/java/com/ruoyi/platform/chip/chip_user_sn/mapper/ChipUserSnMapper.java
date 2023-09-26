package com.ruoyi.platform.chip.chip_user_sn.mapper;

import java.util.List;

import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;

/**
 * 用户芯片-序列号Mapper接口
 *
 * @author mylady
 * @date 2023-09-25
 */
public interface ChipUserSnMapper {
    /**
     * 查询用户芯片-序列号
     *
     * @param id 用户芯片-序列号主键
     * @return 用户芯片-序列号
     */
    public ChipUserSn selectChipUserSnById(Long id);

    /**
     * 查询用户芯片-序列号列表
     *
     * @param chipUserSn 用户芯片-序列号
     * @return 用户芯片-序列号集合
     */
    public List<ChipUserSn> selectChipUserSnList(ChipUserSn chipUserSn);

    /**
     * 新增用户芯片-序列号
     *
     * @param chipUserSn 用户芯片-序列号
     * @return 结果
     */
    public int insertChipUserSn(ChipUserSn chipUserSn);

    /**
     * 修改用户芯片-序列号
     *
     * @param chipUserSn 用户芯片-序列号
     * @return 结果
     */
    public int updateChipUserSn(ChipUserSn chipUserSn);

    //修改, 根据sn修改(sn是唯一的)
    public int updateChipUserSnBySn(ChipUserSn chipUserSn);

    /**
     * 删除用户芯片-序列号
     *
     * @param id 用户芯片-序列号主键
     * @return 结果
     */
    public int deleteChipUserSnById(Long id);

    /**
     * 批量删除用户芯片-序列号
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChipUserSnByIds(Long[] ids);
}
