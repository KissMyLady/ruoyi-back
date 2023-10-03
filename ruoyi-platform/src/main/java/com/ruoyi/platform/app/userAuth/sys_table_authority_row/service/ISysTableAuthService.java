package com.ruoyi.platform.app.userAuth.sys_table_authority_row.service;

import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/3 13:24
 * @Description:
 */
public interface ISysTableAuthService {

    /**
     * 查询当前数据行, 有哪些权限
     */
    String selectRowDept(SysTableAuthorityRow tableAuthorityRow);


    /**
     * 批量写入/更新权限
     */
    int saveOrUpdateRowDept(SysTableAuthorityRow dto);

}
