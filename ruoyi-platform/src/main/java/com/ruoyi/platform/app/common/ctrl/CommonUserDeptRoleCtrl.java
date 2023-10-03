package com.ruoyi.platform.app.common.ctrl;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.TreeSelect;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.platform.app.common.impl.UserDeptRoleServerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/3 12:50
 * @Description:
 */
@RestController
@RequestMapping("/CommonUserDeptRoleCtrl/dept")
public class CommonUserDeptRoleCtrl extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CommonUserDeptRoleCtrl.class);

    @Autowired
    private UserDeptRoleServerImpl userDeptRoleServer;

    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:list')")
    @PostMapping("/tree")
    public TableDataInfo list2() {
        List<TreeSelect> treeSelects = userDeptRoleServer.selectDeptTreeList(new SysDept());
        return getDataTable(treeSelects);
    }

}
