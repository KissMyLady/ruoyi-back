package com.ruoyi.platform.app.zblog.v1_blog.blog_history.controller;

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
import com.ruoyi.platform.app.zblog.v1_blog.blog_history.domain.BlogHistory;
//import com.ruoyi.platform.app.zblog.v1_blog.blog_history.service.IBlogHistoryService;
import com.ruoyi.platform.app.zblog.v1_blog.blog_history.service.impl.BlogHistoryServiceImpl;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文档历史记录Controller
 *
 * @author mylady
 * @date 2023-10-07
 */
@RestController
@RequestMapping("/blog_history/blog_history")
public class BlogHistoryController extends BaseController {

    @Autowired
    private BlogHistoryServiceImpl blogHistoryService;
    //private IBlogHistoryService blogHistoryService;

    /**
     * 查询文档历史记录列表
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:list')")
    @GetMapping("/list")
    public TableDataInfo list(BlogHistory blogHistory) {
        startPage();
        List<BlogHistory> list = blogHistoryService.selectBlogHistoryList(blogHistory);
        return getDataTable(list);
    }

    /**
     * 导出文档历史记录列表
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:export')")
    @Log(title = "导出文档历史记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BlogHistory blogHistory) {
        List<BlogHistory> list = blogHistoryService.selectBlogHistoryList(blogHistory);
        ExcelUtil<BlogHistory> util = new ExcelUtil<BlogHistory>(BlogHistory.class);
        util.exportExcel(response, list, "文档历史记录数据");
    }

    /**
     * 获取文档历史记录详细信息
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return success(blogHistoryService.selectBlogHistoryById(id));
    }

    /**
     * 新增文档历史记录
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:add')")
    @Log(title = "新增文档历史记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BlogHistory blogHistory) {
        return toAjax(blogHistoryService.insertBlogHistory(blogHistory));
    }

    /**
     * 修改文档历史记录
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:edit')")
    @Log(title = "修改文档历史记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BlogHistory blogHistory) {
        return toAjax(blogHistoryService.updateBlogHistory(blogHistory));
    }

    /**
     * 删除文档历史记录
     */
    @PreAuthorize("@ss.hasPermi('blog_history:blog_history:remove')")
    @Log(title = "删除文档历史记录", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(blogHistoryService.deleteBlogHistoryByIds(ids));
    }

}
