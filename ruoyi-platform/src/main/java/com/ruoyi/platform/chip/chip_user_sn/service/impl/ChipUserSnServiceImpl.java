package com.ruoyi.platform.chip.chip_user_sn.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.chip.chip_user_sn.mapper.ChipUserSnMapper;
import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;
import com.ruoyi.platform.chip.chip_user_sn.service.IChipUserSnService;

/**
 * 用户芯片-序列号Service业务层处理
 *
 * @author mylady
 * @date 2023-09-25
 */
@Service
public class ChipUserSnServiceImpl implements IChipUserSnService {
    @Autowired
    private ChipUserSnMapper chipUserSnMapper;

    /**
     * 查询用户芯片-序列号
     *
     * @param id 用户芯片-序列号主键
     * @return 用户芯片-序列号
     */
    @Override
    public ChipUserSn selectChipUserSnById(Long id) {
        return chipUserSnMapper.selectChipUserSnById(id);
    }

    /**
     * 查询用户芯片-序列号列表
     *
     * @param chipUserSn 用户芯片-序列号
     * @return 用户芯片-序列号
     */
    @Override
    public List<ChipUserSn> selectChipUserSnList(ChipUserSn chipUserSn) {
        return chipUserSnMapper.selectChipUserSnList(chipUserSn);
    }

    /**
     * 新增用户芯片-序列号
     *
     * @param chipUserSn 用户芯片-序列号
     * @return 结果
     */
    @Override
    public int insertChipUserSn(ChipUserSn chipUserSn) {
        chipUserSn.setCreateTime(DateUtils.getNowDate());
        return chipUserSnMapper.insertChipUserSn(chipUserSn);
    }

    /**
     * 修改用户芯片-序列号
     *
     * @param chipUserSn 用户芯片-序列号
     * @return 结果
     */
    @Override
    public int updateChipUserSn(ChipUserSn chipUserSn) {
        chipUserSn.setUpdateTime(DateUtils.getNowDate());
        return chipUserSnMapper.updateChipUserSn(chipUserSn);
    }

    /**
     * 批量删除用户芯片-序列号
     *
     * @param ids 需要删除的用户芯片-序列号主键
     * @return 结果
     */
    @Override
    public int deleteChipUserSnByIds(Long[] ids) {
        return chipUserSnMapper.deleteChipUserSnByIds(ids);
    }

    /**
     * 删除用户芯片-序列号信息
     *
     * @param id 用户芯片-序列号主键
     * @return 结果
     */
    @Override
    public int deleteChipUserSnById(Long id) {
        return chipUserSnMapper.deleteChipUserSnById(id);
    }
}
