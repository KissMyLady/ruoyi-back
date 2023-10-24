package com.ruoyi.platform.app.zblog.blog.blog_project.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.platform.app.zblog.blog.blog_project.domain.BlogProject;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * 博客文集Service接口
 *
 * @author mylady
 * @date 2023-10-24
 */
public interface IBlogProjectService {
    /**
     * 查询详情
     */
    Map<String, Object> selectBlogProjectById(Long id);

    /**
     * 查询列表
     */
    List<BlogProject> selectBlogProjectList(BlogProject dto);

    /**
     * ++新增++
     */
    int insertBlogProject(BlogProject dto);

    /**
     * 修改
     */
    int updateBlogProject(BlogProject dto);

    /**
     * --批量删除--
     */
    int deleteBlogProjectByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteBlogProjectById(Long id);

}
