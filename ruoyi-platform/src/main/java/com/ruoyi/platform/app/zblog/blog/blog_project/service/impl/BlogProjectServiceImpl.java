package com.ruoyi.platform.app.zblog.blog.blog_project.service.impl;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.blog.blog_project.mapper.BlogProjectMapper;
import com.ruoyi.platform.app.zblog.blog.blog_project.domain.BlogProject;
import com.ruoyi.platform.app.zblog.blog.blog_project.service.IBlogProjectService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客文集Service业务层处理
 *
 * @author mylady
 * @date 2023-10-24
 */
@Service
public class BlogProjectServiceImpl implements IBlogProjectService {

    private static final Logger logger = LoggerFactory.getLogger(BlogProjectServiceImpl.class);

    @Autowired
    private BlogProjectMapper blogProjectMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectBlogProjectById(Long id) {
        return blogProjectMapper.selectBlogProjectById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<BlogProject> selectBlogProjectList(BlogProject dto) {
        return blogProjectMapper.selectBlogProjectList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertBlogProject(BlogProject blogProject) {
        blogProject.setCreateTime(DateUtils.getNowDate());
        return blogProjectMapper.insertBlogProject(blogProject);
    }

    /**
     * 修改
     */
    @Override
    public int updateBlogProject(BlogProject blogProject) {
        blogProject.setUpdateTime(DateUtils.getNowDate());
        return blogProjectMapper.updateBlogProject(blogProject);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteBlogProjectByIds(Long[] ids) {
        return blogProjectMapper.deleteBlogProjectByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteBlogProjectById(Long id) {
        return blogProjectMapper.deleteBlogProjectById(id);
    }
}
