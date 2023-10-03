package com.ruoyi.platform.app.userAuth.sys_table_authority_row.service;

import java.util.List;

import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;

/**
 * 数据权限Service接口
 *
 * @author mylady
 * @date 2023-10-03
 */
public interface ISysTableAuthorityRowService {
    /**
     * 查询数据权限
     *
     * @param id 数据权限主键
     * @return 数据权限
     */
    public SysTableAuthorityRow selectSysTableAuthorityRowById(Long id);

    /**
     * 查询数据权限列表
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 数据权限集合
     */
    public List<SysTableAuthorityRow> selectSysTableAuthorityRowList(SysTableAuthorityRow sysTableAuthorityRow);

    /**
     * 新增数据权限
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 结果
     */
    public int insertSysTableAuthorityRow(SysTableAuthorityRow sysTableAuthorityRow);

    /**
     * 修改数据权限
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 结果
     */
    public int updateSysTableAuthorityRow(SysTableAuthorityRow sysTableAuthorityRow);

    /**
     * 批量删除数据权限
     *
     * @param ids 需要删除的数据权限主键集合
     * @return 结果
     */
    public int deleteSysTableAuthorityRowByIds(Long[] ids);

    /**
     * 删除数据权限信息
     *
     * @param id 数据权限主键
     * @return 结果
     */
    public int deleteSysTableAuthorityRowById(Long id);
}
