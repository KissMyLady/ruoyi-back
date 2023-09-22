package com.ruoyi.platform.liveBroadcastApp.sys_option.mapper;

import java.util.List;

import com.ruoyi.platform.liveBroadcastApp.sys_option.domain.SysOption;

/**
 * 系统-操作码Mapper接口
 *
 * @author ruoyi
 * @date 2023-09-22
 */
public interface SysOptionMapper {
    /**
     * 查询系统-操作码
     *
     * @param id 系统-操作码主键
     * @return 系统-操作码
     */
    public SysOption selectSysOptionById(Long id);

    /**
     * 查询系统-操作码列表
     *
     * @param sysOption 系统-操作码
     * @return 系统-操作码集合
     */
    public List<SysOption> selectSysOptionList(SysOption sysOption);

    /**
     * 新增系统-操作码
     *
     * @param sysOption 系统-操作码
     * @return 结果
     */
    public int insertSysOption(SysOption sysOption);

    /**
     * 修改系统-操作码
     *
     * @param sysOption 系统-操作码
     * @return 结果
     */
    public int updateSysOption(SysOption sysOption);

    /**
     * 删除系统-操作码
     *
     * @param id 系统-操作码主键
     * @return 结果
     */
    public int deleteSysOptionById(Long id);

    /**
     * 批量删除系统-操作码
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysOptionByIds(Long[] ids);
}
