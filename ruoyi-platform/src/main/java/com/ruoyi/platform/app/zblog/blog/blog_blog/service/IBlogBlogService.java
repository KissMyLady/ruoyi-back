package com.ruoyi.platform.app.zblog.blog.blog_blog.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BlogBlog;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 博客文档Service接口
 *
 * @author mylady
 * @date 2023-10-24
 */
public interface IBlogBlogService {
    /**
     * 查询详情
     */
    Map<String, Object> selectBlogBlogById(Long id);

    /**
     * 查询列表
     */
    List<BlogBlog> selectBlogBlogList(BlogBlog dto);

    /**
     * ++新增++
     */
    int insertBlogBlog(BlogBlog dto);

    /**
     * 修改
     */
    int updateBlogBlog(BlogBlog dto);

    /**
     * --批量删除--
     */
    int deleteBlogBlogByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteBlogBlogById(Long id);

}
