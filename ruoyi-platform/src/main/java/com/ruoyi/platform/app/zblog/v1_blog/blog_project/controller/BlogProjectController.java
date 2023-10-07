package com.ruoyi.platform.app.zblog.v1_blog.blog_project.controller;

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
import com.ruoyi.platform.app.zblog.v1_blog.blog_project.domain.BlogProject;
//import com.ruoyi.platform.app.zblog.v1_blog.blog_project.service.IBlogProjectService;
import com.ruoyi.platform.app.zblog.v1_blog.blog_project.service.impl.BlogProjectServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章分类Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/blog_project/blog_project")
public class BlogProjectController extends BaseController {

    @Autowired
    private BlogProjectServiceImpl blogProjectService;
    //private IBlogProjectService blogProjectService;

    /**
     * 查询文章分类列表
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:list')")
    @GetMapping("/list")
    public TableDataInfo list(BlogProject blogProject) {
        startPage();
        List<BlogProject> list = blogProjectService.selectBlogProjectList(blogProject);
        return getDataTable(list);
    }

    /**
     * 导出文章分类列表
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:export')")
    @Log(title = "导出文章分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogProject blogProject) {
        List<BlogProject> list = blogProjectService.selectBlogProjectList(blogProject);
        ExcelUtil<BlogProject> util = new ExcelUtil<BlogProject>(BlogProject.class);
        util.exportExcel(response, list, "文章分类数据");
    }

    /**
     * 获取文章分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(blogProjectService.selectBlogProjectById(id));
    }

    /**
     * 新增文章分类
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:add')")
    @Log(title = "新增文章分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogProject blogProject) {
        return toAjax(blogProjectService.insertBlogProject(blogProject));
    }

    /**
     * 修改文章分类
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:edit')")
    @Log(title = "修改文章分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogProject blogProject) {
        return toAjax(blogProjectService.updateBlogProject(blogProject));
    }

    /**
     * 删除文章分类
     */
    @PreAuthorize("@ss.hasPermi('blog_project:blog_project:remove')")
    @Log(title = "删除文章分类", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(blogProjectService.deleteBlogProjectByIds(ids));
    }

}
