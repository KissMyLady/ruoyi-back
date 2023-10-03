package com.ruoyi.platform.app.mydoc.app_doc_doc.controller;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.platform.app.common.impl.UserDeptRoleServerImpl;
import com.ruoyi.platform.app.mydoc.app_doc_doc.service.impl.AppDocDocAuthorityServerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;
import com.ruoyi.platform.app.mydoc.app_doc_doc.service.impl.AppDocDocServiceImpl;
import com.ruoyi.common.core.page.TableDataInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * app_doc_doc Ctrl
 *
 * @author mylady
 * @date 2023-10-02
 */
@RestController
@RequestMapping("/app_doc_doc/doc")
public class AppDocCtrl extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AppDocCtrl.class);

    @Autowired
    private AppDocDocServiceImpl appDocDocService;
    //private IAppDocDocService appDocDocService;

    @Autowired
    private AppDocDocAuthorityServerImpl appDocDocAuthorityServer;

    @Autowired
    private UserDeptRoleServerImpl userDeptRoleServer;

    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:list')")
    @PostMapping("/list2")
    public TableDataInfo list2(@RequestBody AppDocDoc appDocDoc) {
        startPage();
        //查询当前用户的权限

        //获取用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();

        //查询当前用户的权限
        List<Integer> auth_dept_set1 = userDeptRoleServer.get_auth_dept_set(user);

        //设置
        appDocDoc.setDeptAuthList(auth_dept_set1);

        // logger.info("查询当前用户 {} 的部门权限list: {}", user.getUserName(), auth_dept_set);
        List<Map<String, Object>> list = appDocDocAuthorityServer.selectAppDocDocList(appDocDoc);
        // logger.info("查询到的数据返回: {}", list);
        return getDataTable(list);
    }

}
