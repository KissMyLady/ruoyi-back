package com.ruoyi.platform.chip.chip_user_recharge.mapper;

import java.util.List;

import com.ruoyi.platform.chip.chip_user_recharge.domain.ChipUserRecharge;

/**
 * 用户芯片-用户充值Mapper接口
 *
 * @author mylady
 * @date 2023-09-25
 */
public interface ChipUserRechargeMapper {
    /**
     * 查询用户芯片-用户充值
     *
     * @param id 用户芯片-用户充值主键
     * @return 用户芯片-用户充值
     */
    public ChipUserRecharge selectChipUserRechargeById(Long id);

    /**
     * 查询用户芯片-用户充值列表
     *
     * @param chipUserRecharge 用户芯片-用户充值
     * @return 用户芯片-用户充值集合
     */
    public List<ChipUserRecharge> selectChipUserRechargeList(ChipUserRecharge chipUserRecharge);

    /**
     * 新增用户芯片-用户充值
     *
     * @param chipUserRecharge 用户芯片-用户充值
     * @return 结果
     */
    public int insertChipUserRecharge(ChipUserRecharge chipUserRecharge);

    /**
     * 修改用户芯片-用户充值
     *
     * @param chipUserRecharge 用户芯片-用户充值
     * @return 结果
     */
    public int updateChipUserRecharge(ChipUserRecharge chipUserRecharge);

    /**
     * 删除用户芯片-用户充值
     *
     * @param id 用户芯片-用户充值主键
     * @return 结果
     */
    public int deleteChipUserRechargeById(Long id);

    /**
     * 批量删除用户芯片-用户充值
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteChipUserRechargeByIds(Long[] ids);
}
