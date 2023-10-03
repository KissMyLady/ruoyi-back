package com.ruoyi.platform.app.userAuth.sys_table_authority_row.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.mapper.SysTableAuthorityRowMapper;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.service.ISysTableAuthorityRowService;

/**
 * 数据权限Service业务层处理
 *
 * @author mylady
 * @date 2023-10-03
 */
@Service
public class SysTableAuthorityRowServiceImpl implements ISysTableAuthorityRowService {
    @Autowired
    private SysTableAuthorityRowMapper sysTableAuthorityRowMapper;

    /**
     * 查询数据权限
     *
     * @param id 数据权限主键
     * @return 数据权限
     */
    @Override
    public SysTableAuthorityRow selectSysTableAuthorityRowById(Long id) {
        return sysTableAuthorityRowMapper.selectSysTableAuthorityRowById(id);
    }

    /**
     * 查询数据权限列表
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 数据权限
     */
    @Override
    public List<SysTableAuthorityRow> selectSysTableAuthorityRowList(SysTableAuthorityRow sysTableAuthorityRow) {
        return sysTableAuthorityRowMapper.selectSysTableAuthorityRowList(sysTableAuthorityRow);
    }

    /**
     * 新增数据权限
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 结果
     */
    @Override
    public int insertSysTableAuthorityRow(SysTableAuthorityRow sysTableAuthorityRow) {
                sysTableAuthorityRow.setCreateTime(DateUtils.getNowDate());
            return sysTableAuthorityRowMapper.insertSysTableAuthorityRow(sysTableAuthorityRow);
    }

    /**
     * 修改数据权限
     *
     * @param sysTableAuthorityRow 数据权限
     * @return 结果
     */
    @Override
    public int updateSysTableAuthorityRow(SysTableAuthorityRow sysTableAuthorityRow) {
                sysTableAuthorityRow.setUpdateTime(DateUtils.getNowDate());
        return sysTableAuthorityRowMapper.updateSysTableAuthorityRow(sysTableAuthorityRow);
    }

    /**
     * 批量删除数据权限
     *
     * @param ids 需要删除的数据权限主键
     * @return 结果
     */
    @Override
    public int deleteSysTableAuthorityRowByIds(Long[] ids) {
        return sysTableAuthorityRowMapper.deleteSysTableAuthorityRowByIds(ids);
    }

    /**
     * 删除数据权限信息
     *
     * @param id 数据权限主键
     * @return 结果
     */
    @Override
    public int deleteSysTableAuthorityRowById(Long id) {
        return sysTableAuthorityRowMapper.deleteSysTableAuthorityRowById(id);
    }
}
