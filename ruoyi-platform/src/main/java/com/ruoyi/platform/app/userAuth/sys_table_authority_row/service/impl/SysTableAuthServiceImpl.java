package com.ruoyi.platform.app.userAuth.sys_table_authority_row.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.mapper.SysTableAuthMapper;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.mapper.SysTableAuthorityRowMapper;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.service.ISysTableAuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/3 13:24
 * @Description:
 */
@Service
public class SysTableAuthServiceImpl implements ISysTableAuthService {

    private static final Logger logger = LoggerFactory.getLogger(SysTableAuthServiceImpl.class);

    @Autowired
    private SysTableAuthMapper sysTableAuthMapper;

    @Autowired
    private SysTableAuthorityRowMapper sysTableAuthorityRowMapper;
    /**
     * 查询当前数据行, 有哪些权限
     */
    @Override
    public String selectRowDept(SysTableAuthorityRow dto) {
        return sysTableAuthMapper.selectRowDept(dto);
    }

    /**
     * 批量写入/更新权限
     */
    @Override
    public int saveOrUpdateRowDept(SysTableAuthorityRow dto) {
        //插入数据的主键
        List<Integer> ids = dto.getIds();

        if(ids == null){
            logger.warn("传入数组ids为空: {}", ids);
            return 0;
        }

        //主要索引, 重要
        String tableName = dto.getTableName();
        String dbIdName = dto.getDbIdName();
        //String dbId = dto.getDbId();
        //权限内容
        String needDeptId = dto.getNeedDeptId();

        // String needDeptId = dto.getNeedDeptId();
        if (ObjectUtil.isEmpty(tableName)
                || ObjectUtil.isEmpty(dbIdName)
                || ObjectUtil.isEmpty(ids)
                || ObjectUtil.isEmpty(needDeptId)
        ) {
            logger.warn("传入字段为空, 返回0. {}", dto);
            return 0;
        }

        //查询id是否存在
        int success = 0;
        for (int item : ids) {
            // Long itemId = (long) item;

            //被控制数据的id
            String rowDataId = item+"";
            dto.setDbId(rowDataId);

            //查询id下的数据
            int res = sysTableAuthMapper.selectDeptAuthExist(dto);
            //logger.info("查询到的数据dtp打印: {}", res);

            if(res <= 0){
                //保存数据
                int i = sysTableAuthorityRowMapper.insertSysTableAuthorityRow(dto);
                success += i;
            }else {
                //存在数据, 更新
                int i = sysTableAuthMapper.updateDeptAuth(dto);
                success += i;
            }
        }
        return success;
    }
}
