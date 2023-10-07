package com.ruoyi.platform.app.zblog.v1_blog.blog_project.service.impl;

import java.util.List;
        import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v1_blog.blog_project.mapper.BlogProjectMapper;
import com.ruoyi.platform.app.zblog.v1_blog.blog_project.domain.BlogProject;
import com.ruoyi.platform.app.zblog.v1_blog.blog_project.service.IBlogProjectService;

/**
 * 文章分类Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class BlogProjectServiceImpl implements IBlogProjectService {
    @Autowired
    private BlogProjectMapper blogProjectMapper;

    /**
     * 查询文章分类
     *
     * @param id 文章分类主键
     * @return 文章分类
     */
    @Override
    public BlogProject selectBlogProjectById(Long id) {
        return blogProjectMapper.selectBlogProjectById(id);
    }

    /**
     * 查询文章分类列表
     *
     * @param blogProject 文章分类
     * @return 文章分类
     */
    @Override
    public List<BlogProject> selectBlogProjectList(BlogProject blogProject) {
        return blogProjectMapper.selectBlogProjectList(blogProject);
    }

    /**
     * 新增文章分类
     *
     * @param blogProject 文章分类
     * @return 结果
     */
    @Override
    public int insertBlogProject(BlogProject blogProject) {
                blogProject.setCreateTime(DateUtils.getNowDate());
            return blogProjectMapper.insertBlogProject(blogProject);
    }

    /**
     * 修改文章分类
     *
     * @param blogProject 文章分类
     * @return 结果
     */
    @Override
    public int updateBlogProject(BlogProject blogProject) {
        return blogProjectMapper.updateBlogProject(blogProject);
    }

    /**
     * 批量删除文章分类
     *
     * @param ids 需要删除的文章分类主键
     * @return 结果
     */
    @Override
    public int deleteBlogProjectByIds(Long[] ids) {
        return blogProjectMapper.deleteBlogProjectByIds(ids);
    }

    /**
     * 删除文章分类信息
     *
     * @param id 文章分类主键
     * @return 结果
     */
    @Override
    public int deleteBlogProjectById(Long id) {
        return blogProjectMapper.deleteBlogProjectById(id);
    }
}
