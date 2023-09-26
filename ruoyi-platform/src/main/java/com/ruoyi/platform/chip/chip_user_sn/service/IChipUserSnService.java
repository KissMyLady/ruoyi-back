package com.ruoyi.platform.chip.chip_user_sn.service;

import java.util.List;

import com.ruoyi.platform.chip.chip_user_sn.domain.ChipUserSn;

/**
 * 用户芯片-序列号Service接口
 *
 * @author mylady
 * @date 2023-09-25
 */
public interface IChipUserSnService {
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

    //通过sn修改
    public int updateChipUserSnBySn(ChipUserSn chipUserSn);

    /**
     * 批量删除用户芯片-序列号
     *
     * @param ids 需要删除的用户芯片-序列号主键集合
     * @return 结果
     */
    public int deleteChipUserSnByIds(Long[] ids);

    /**
     * 删除用户芯片-序列号信息
     *
     * @param id 用户芯片-序列号主键
     * @return 结果
     */
    public int deleteChipUserSnById(Long id);
}
