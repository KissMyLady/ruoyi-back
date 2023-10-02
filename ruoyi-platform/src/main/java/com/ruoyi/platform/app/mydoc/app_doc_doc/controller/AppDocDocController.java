package com.ruoyi.platform.app.mydoc.app_doc_doc.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.domain.entity.SysRole;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.platform.app.mydoc.app_doc_doc.service.impl.AppDocDocAuthorityServerImpl;
import com.ruoyi.platform.users.service.impl.UserDeptMapperImpl;
import com.ruoyi.platform.users.service.impl.UserRoleServerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.platform.app.mydoc.app_doc_doc.domain.AppDocDoc;
//import com.ruoyi.platform.app.mydoc.app_doc_doc.service.IAppDocDocService;
import com.ruoyi.platform.app.mydoc.app_doc_doc.service.impl.AppDocDocServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * app_doc_docController
 *
 * @author mylady
 * @date 2023-10-02
 */
@RestController
@RequestMapping("/app_doc_doc/app_doc_doc")
public class AppDocDocController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AppDocDocController.class);

    @Autowired
    private AppDocDocServiceImpl appDocDocService;
    //private IAppDocDocService appDocDocService;

    @Autowired
    private AppDocDocAuthorityServerImpl appDocDocAuthorityServer;

    @Autowired
    private UserRoleServerImpl userRoleServer;

    @Autowired
    private UserDeptMapperImpl userDeptMapper;

    /**
     * 查询app_doc_doc列表
     */
    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppDocDoc appDocDoc) {
        startPage();
        List<AppDocDoc> list = appDocDocService.selectAppDocDocList(appDocDoc);
        return getDataTable(list);
    }

    /**
     * 查询列表, 添加权限
     */
    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:list')")
    @GetMapping("/list2")
    public TableDataInfo list2(@RequestBody AppDocDoc appDocDoc) {
        startPage();
        //查询当前用户的权限

        //获取用户
        LoginUser loginUser = SecurityUtils.getLoginUser();
        SysUser user = loginUser.getUser();

        //部门的数据权限集合
        HashSet<Integer> auth_dept_set = new HashSet<>();
        auth_dept_set.add(0);

        if (user.isAdmin()){
            //查询全部数据权限
            List<Integer> longs = userDeptMapper.selectDeptIdsList(new SysDept());
            auth_dept_set.addAll(longs);
        }else{
            //查询用户角色
            List<SysRole> sysRoles = userRoleServer.selectRolePermissionByUserId(loginUser.getUserId());
            for(SysRole role: sysRoles){
                List<Integer> longs = userDeptMapper.selectDeptListByRole(role);
                auth_dept_set.addAll(longs);
            }
        }

        appDocDoc.setDeptAuthList(new ArrayList<>(auth_dept_set));

        // logger.info("查询当前用户 {} 的部门权限list: {}", user.getUserName(), auth_dept_set);
        List<Map<String, Object>> list = appDocDocAuthorityServer.selectAppDocDocList(appDocDoc);
        return getDataTable(list);
    }

    /**
     * 导出app_doc_doc列表
     */
    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:export')")
    @Log(title = "导出app_doc_doc", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppDocDoc appDocDoc) {
        List<AppDocDoc> list = appDocDocService.selectAppDocDocList(appDocDoc);
        ExcelUtil<AppDocDoc> util = new ExcelUtil<AppDocDoc>(AppDocDoc.class);
        util.exportExcel(response, list, "app_doc_doc数据");
    }

    /**
     * 获取app_doc_doc详细信息
     */
    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(appDocDocService.selectAppDocDocById(id));
    }

    /**
     * 新增app_doc_doc
     */
    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:add')")
    @Log(title = "新增app_doc_doc", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppDocDoc appDocDoc) {
        return toAjax(appDocDocService.insertAppDocDoc(appDocDoc));
    }

    /**
     * 修改app_doc_doc
     */
    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:edit')")
    @Log(title = "修改app_doc_doc", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppDocDoc appDocDoc) {
        return toAjax(appDocDocService.updateAppDocDoc(appDocDoc));
    }

    /**
     * 删除app_doc_doc
     */
    @PreAuthorize("@ss.hasPermi('app_doc_doc:app_doc_doc:remove')")
    @Log(title = "删除app_doc_doc", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(appDocDocService.deleteAppDocDocByIds(ids));
    }

}
