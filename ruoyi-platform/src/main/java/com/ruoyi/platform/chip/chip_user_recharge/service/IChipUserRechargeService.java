package com.ruoyi.platform.chip.chip_user_recharge.service;

import java.util.List;

import com.ruoyi.platform.chip.chip_user_recharge.domain.ChipUserRecharge;

/**
 * 用户芯片-用户充值Service接口
 *
 * @author mylady
 * @date 2023-09-25
 */
public interface IChipUserRechargeService {
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
     * 批量删除用户芯片-用户充值
     *
     * @param ids 需要删除的用户芯片-用户充值主键集合
     * @return 结果
     */
    public int deleteChipUserRechargeByIds(Long[] ids);

    /**
     * 删除用户芯片-用户充值信息
     *
     * @param id 用户芯片-用户充值主键
     * @return 结果
     */
    public int deleteChipUserRechargeById(Long id);
}
