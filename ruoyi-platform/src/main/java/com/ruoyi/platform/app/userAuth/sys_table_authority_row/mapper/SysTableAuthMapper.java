package com.ruoyi.platform.app.userAuth.sys_table_authority_row.mapper;

import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/3 13:24
 * @Description:
 */
public interface SysTableAuthMapper {


    /**
     * 查询当前数据行, 有哪些权限
     */
    String selectRowDept(SysTableAuthorityRow tableAuthorityRow);

    /**
     * 查询数据是否存在
     */
    int selectDeptAuthExist(SysTableAuthorityRow dto);


    /**
     * 更新数据
     */
    int updateDeptAuth(SysTableAuthorityRow dto);
}
