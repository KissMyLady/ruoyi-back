package com.ruoyi.platform.liveBroadcastApp.sys_option.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.liveBroadcastApp.sys_option.mapper.SysOptionMapper;
import com.ruoyi.platform.liveBroadcastApp.sys_option.domain.SysOption;
import com.ruoyi.platform.liveBroadcastApp.sys_option.service.ISysOptionService;

/**
 * 系统-操作码Service业务层处理
 *
 * @author ruoyi
 * @date 2023-09-22
 */
@Service
public class SysOptionServiceImpl implements ISysOptionService {
    @Autowired
    private SysOptionMapper sysOptionMapper;

    /**
     * 查询系统-操作码
     *
     * @param id 系统-操作码主键
     * @return 系统-操作码
     */
    @Override
    public SysOption selectSysOptionById(Long id) {
        return sysOptionMapper.selectSysOptionById(id);
    }

    /**
     * 查询系统-操作码列表
     *
     * @param sysOption 系统-操作码
     * @return 系统-操作码
     */
    @Override
    public List<SysOption> selectSysOptionList(SysOption sysOption) {
        return sysOptionMapper.selectSysOptionList(sysOption);
    }

    /**
     * 新增系统-操作码
     *
     * @param sysOption 系统-操作码
     * @return 结果
     */
    @Override
    public int insertSysOption(SysOption sysOption) {
        sysOption.setCreateTime(DateUtils.getNowDate());
        return sysOptionMapper.insertSysOption(sysOption);
    }

    /**
     * 修改系统-操作码
     *
     * @param sysOption 系统-操作码
     * @return 结果
     */
    @Override
    public int updateSysOption(SysOption sysOption) {
        sysOption.setUpdateTime(DateUtils.getNowDate());
        return sysOptionMapper.updateSysOption(sysOption);
    }

    /**
     * 批量删除系统-操作码
     *
     * @param ids 需要删除的系统-操作码主键
     * @return 结果
     */
    @Override
    public int deleteSysOptionByIds(Long[] ids) {
        return sysOptionMapper.deleteSysOptionByIds(ids);
    }

    /**
     * 删除系统-操作码信息
     *
     * @param id 系统-操作码主键
     * @return 结果
     */
    @Override
    public int deleteSysOptionById(Long id) {
        return sysOptionMapper.deleteSysOptionById(id);
    }
}
