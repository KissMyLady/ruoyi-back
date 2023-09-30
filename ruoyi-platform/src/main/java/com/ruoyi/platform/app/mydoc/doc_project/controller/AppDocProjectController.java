package com.ruoyi.platform.app.mydoc.doc_project.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
import com.ruoyi.platform.app.mydoc.doc_project.domain.AppDocProject;
//import com.ruoyi.platform.app.mydoc.doc_project.service.IAppDocProjectService;
import com.ruoyi.platform.app.mydoc.doc_project.service.impl.AppDocProjectServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * doc_projectController
 *
 * @author mylady
 * @date 2023-09-30
 */
@RestController
@RequestMapping("/doc_project/doc_project")
public class AppDocProjectController extends BaseController {

    @Autowired
    private AppDocProjectServiceImpl appDocProjectService;
    //private IAppDocProjectService appDocProjectService;

    /**
     * 查询doc_project列表
     */
    @PreAuthorize("@ss.hasPermi('doc_project:doc_project:list')")
    @GetMapping("/list")
    public TableDataInfo list(AppDocProject appDocProject) {
        startPage();
        List<AppDocProject> list = appDocProjectService.selectAppDocProjectList(appDocProject);
        return getDataTable(list);
    }

    /**
     * 导出doc_project列表
     */
    @PreAuthorize("@ss.hasPermi('doc_project:doc_project:export')")
    @Log(title = "导出doc_project", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AppDocProject appDocProject) {
        List<AppDocProject> list = appDocProjectService.selectAppDocProjectList(appDocProject);
        ExcelUtil<AppDocProject> util = new ExcelUtil<AppDocProject>(AppDocProject.class);
        util.exportExcel(response, list, "doc_project数据");
    }

    /**
     * 获取doc_project详细信息
     */
    @PreAuthorize("@ss.hasPermi('doc_project:doc_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(appDocProjectService.selectAppDocProjectById(id));
    }

    /**
     * 新增doc_project
     */
    @PreAuthorize("@ss.hasPermi('doc_project:doc_project:add')")
    @Log(title = "新增doc_project", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AppDocProject appDocProject) {
        return toAjax(appDocProjectService.insertAppDocProject(appDocProject));
    }

    /**
     * 修改doc_project
     */
    @PreAuthorize("@ss.hasPermi('doc_project:doc_project:edit')")
    @Log(title = "修改doc_project", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AppDocProject appDocProject) {
        return toAjax(appDocProjectService.updateAppDocProject(appDocProject));
    }

    /**
     * 删除doc_project
     */
    @PreAuthorize("@ss.hasPermi('doc_project:doc_project:remove')")
    @Log(title = "删除doc_project", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(appDocProjectService.deleteAppDocProjectByIds(ids));
    }

}
