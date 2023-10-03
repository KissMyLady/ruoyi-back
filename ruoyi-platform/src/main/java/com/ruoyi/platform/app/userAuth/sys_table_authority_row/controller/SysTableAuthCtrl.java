package com.ruoyi.platform.app.userAuth.sys_table_authority_row.controller;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.domain.SysTableAuthorityRow;
import com.ruoyi.platform.app.userAuth.sys_table_authority_row.service.impl.SysTableAuthServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/3 13:23
 * @Description: 数据权限 逻辑
 */
@RestController
@RequestMapping("/SysTableAuthCtrl/SysTableAuthCtrl")
public class SysTableAuthCtrl extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SysTableAuthCtrl.class);

    @Autowired
    private SysTableAuthServiceImpl sysTableAuthService;

    /**
     * 查询id数据有哪些权限
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:list')")
    @PostMapping("/rowAuth")
    public AjaxResult list(@RequestBody SysTableAuthorityRow dto) {
        String s = sysTableAuthService.selectRowDept(dto);
        AjaxResult res = new AjaxResult();
        res.put("auth_dept", "s");
        return res;
    }

    /**
     * 批量更新权限数据. 没有就保存
     *
     * 插入数据的主键为 ids
     */
    @PreAuthorize("@ss.hasPermi('sys_table_authority_row:sys_table_authority_row:list')")
    @PostMapping("/batchSaveOrUpdate")
    public AjaxResult batchSaveOrUpdate(@RequestBody SysTableAuthorityRow dto) {
        // logger.info("客户端发送的数据打印: {}", dto);
        int successCount = sysTableAuthService.saveOrUpdateRowDept(dto);
        return successCount == 0 ? error("批量更新错误, 成功数为0"): success(successCount);
    }

}
