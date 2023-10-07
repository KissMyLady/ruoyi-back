package com.ruoyi.platform.app.zblog.v1_blog.blog_project.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v1_blog.blog_project.domain.BlogProject;

/**
 * 文章分类Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IBlogProjectService {
    /**
     * 查询文章分类
     *
     * @param id 文章分类主键
     * @return 文章分类
     */
    public BlogProject selectBlogProjectById(Long id);

    /**
     * 查询文章分类列表
     *
     * @param blogProject 文章分类
     * @return 文章分类集合
     */
    public List<BlogProject> selectBlogProjectList(BlogProject blogProject);

    /**
     * 新增文章分类
     *
     * @param blogProject 文章分类
     * @return 结果
     */
    public int insertBlogProject(BlogProject blogProject);

    /**
     * 修改文章分类
     *
     * @param blogProject 文章分类
     * @return 结果
     */
    public int updateBlogProject(BlogProject blogProject);

    /**
     * 批量删除文章分类
     *
     * @param ids 需要删除的文章分类主键集合
     * @return 结果
     */
    public int deleteBlogProjectByIds(Long[] ids);

    /**
     * 删除文章分类信息
     *
     * @param id 文章分类主键
     * @return 结果
     */
    public int deleteBlogProjectById(Long id);
}
