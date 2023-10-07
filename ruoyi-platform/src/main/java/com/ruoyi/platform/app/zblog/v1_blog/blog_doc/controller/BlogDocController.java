package com.ruoyi.platform.app.zblog.v1_blog.blog_doc.controller;

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
import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.domain.BlogDoc;
//import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.service.IBlogDocService;
import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.service.impl.BlogDocServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/blog_doc/blog_doc")
public class BlogDocController extends BaseController {

    @Autowired
    private BlogDocServiceImpl blogDocService;
    //private IBlogDocService blogDocService;

    /**
     * 查询文章列表
     */
    @PreAuthorize("@ss.hasPermi('blog_doc:blog_doc:list')")
    @GetMapping("/list")
    public TableDataInfo list(BlogDoc blogDoc) {
        startPage();
        List<BlogDoc> list = blogDocService.selectBlogDocList(blogDoc);
        return getDataTable(list);
    }

    /**
     * 导出文章列表
     */
    @PreAuthorize("@ss.hasPermi('blog_doc:blog_doc:export')")
    @Log(title = "导出文章", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogDoc blogDoc) {
        List<BlogDoc> list = blogDocService.selectBlogDocList(blogDoc);
        ExcelUtil<BlogDoc> util = new ExcelUtil<BlogDoc>(BlogDoc.class);
        util.exportExcel(response, list, "文章数据");
    }

    /**
     * 获取文章详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog_doc:blog_doc:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(blogDocService.selectBlogDocById(id));
    }

    /**
     * 新增文章
     */
    @PreAuthorize("@ss.hasPermi('blog_doc:blog_doc:add')")
    @Log(title = "新增文章", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogDoc blogDoc) {
        return toAjax(blogDocService.insertBlogDoc(blogDoc));
    }

    /**
     * 修改文章
     */
    @PreAuthorize("@ss.hasPermi('blog_doc:blog_doc:edit')")
    @Log(title = "修改文章", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogDoc blogDoc) {
        return toAjax(blogDocService.updateBlogDoc(blogDoc));
    }

    /**
     * 删除文章
     */
    @PreAuthorize("@ss.hasPermi('blog_doc:blog_doc:remove')")
    @Log(title = "删除文章", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(blogDocService.deleteBlogDocByIds(ids));
    }

}
