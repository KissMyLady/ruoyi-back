package com.ruoyi.platform.app.zblog.v1_blog.blog_project.mapper;

import java.util.List;

import com.ruoyi.platform.app.zblog.v1_blog.blog_project.domain.BlogProject;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 文章分类Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface BlogProjectMapper {
    /**
     * 查询文章分类
     *
     * @param id 文章分类主键
     * @return 文章分类
     */
    BlogProject selectBlogProjectById(Long id);

    /**
     * 查询文章分类列表
     *
     * @param blogProject 文章分类
     * @return 文章分类集合
     */
    List<BlogProject> selectBlogProjectList(BlogProject blogProject);

    /**
     * 新增文章分类
     *
     * @param blogProject 文章分类
     * @return 结果
     */
    int insertBlogProject(BlogProject blogProject);

    /**
     * 修改文章分类
     *
     * @param blogProject 文章分类
     * @return 结果
     */
    int updateBlogProject(BlogProject blogProject);

    /**
     * 删除文章分类
     *
     * @param id 文章分类主键
     * @return 结果
     */
    int deleteBlogProjectById(Long id);

    /**
     * 批量删除文章分类
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBlogProjectByIds(Long[] ids);
}
