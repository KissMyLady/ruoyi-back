package com.ruoyi.platform.chip.chip_user_recharge.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.chip.chip_user_recharge.mapper.ChipUserRechargeMapper;
import com.ruoyi.platform.chip.chip_user_recharge.domain.ChipUserRecharge;
import com.ruoyi.platform.chip.chip_user_recharge.service.IChipUserRechargeService;

/**
 * 用户芯片-用户充值Service业务层处理
 *
 * @author mylady
 * @date 2023-09-25
 */
@Service
public class ChipUserRechargeServiceImpl implements IChipUserRechargeService {
    @Autowired
    private ChipUserRechargeMapper chipUserRechargeMapper;

    /**
     * 查询用户芯片-用户充值
     *
     * @param id 用户芯片-用户充值主键
     * @return 用户芯片-用户充值
     */
    @Override
    public ChipUserRecharge selectChipUserRechargeById(Long id) {
        return chipUserRechargeMapper.selectChipUserRechargeById(id);
    }

    /**
     * 查询用户芯片-用户充值列表
     *
     * @param chipUserRecharge 用户芯片-用户充值
     * @return 用户芯片-用户充值
     */
    @Override
    public List<ChipUserRecharge> selectChipUserRechargeList(ChipUserRecharge chipUserRecharge) {
        return chipUserRechargeMapper.selectChipUserRechargeList(chipUserRecharge);
    }

    /**
     * 新增用户芯片-用户充值
     *
     * @param chipUserRecharge 用户芯片-用户充值
     * @return 结果
     */
    @Override
    public int insertChipUserRecharge(ChipUserRecharge chipUserRecharge) {
                chipUserRecharge.setCreateTime(DateUtils.getNowDate());
            return chipUserRechargeMapper.insertChipUserRecharge(chipUserRecharge);
    }

    /**
     * 修改用户芯片-用户充值
     *
     * @param chipUserRecharge 用户芯片-用户充值
     * @return 结果
     */
    @Override
    public int updateChipUserRecharge(ChipUserRecharge chipUserRecharge) {
                chipUserRecharge.setUpdateTime(DateUtils.getNowDate());
        return chipUserRechargeMapper.updateChipUserRecharge(chipUserRecharge);
    }

    /**
     * 批量删除用户芯片-用户充值
     *
     * @param ids 需要删除的用户芯片-用户充值主键
     * @return 结果
     */
    @Override
    public int deleteChipUserRechargeByIds(Long[] ids) {
        return chipUserRechargeMapper.deleteChipUserRechargeByIds(ids);
    }

    /**
     * 删除用户芯片-用户充值信息
     *
     * @param id 用户芯片-用户充值主键
     * @return 结果
     */
    @Override
    public int deleteChipUserRechargeById(Long id) {
        return chipUserRechargeMapper.deleteChipUserRechargeById(id);
    }
}
