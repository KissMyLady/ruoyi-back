package com.ruoyi.platform.app.userAuth.sys_table_authority_row.mapper;

import java.util.List;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 数据权限Mapper接口
 *
 * @author mylady
 * @date 2023-10-03
 */
//@DataSource(value = DataSourceType.MASTER)
public interface SysTableAuthorityRowMapper {
    /**
     * 查询数据权限
     *
     * @param id 数据权限主键
     * @return 数据权限
     */
    SysTableAuthorityRow selectSysTableAuthorityRowById(Long id);

    /**
     * 查询数据权限列表
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 数据权限集合
     */
    List<SysTableAuthorityRow> selectSysTableAuthorityRowList(SysTableAuthorityRow sysTableAuthorityRow);

    /**
     * 新增数据权限
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 结果
     */
    int insertSysTableAuthorityRow(SysTableAuthorityRow sysTableAuthorityRow);

    /**
     * 修改数据权限
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 结果
     */
    int updateSysTableAuthorityRow(SysTableAuthorityRow sysTableAuthorityRow);

    /**
     * 删除数据权限
     *
     * @param id 数据权限主键
     * @return 结果
     */
    int deleteSysTableAuthorityRowById(Long id);

    /**
     * 批量删除数据权限
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteSysTableAuthorityRowByIds(Long[] ids);
}
