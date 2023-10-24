package com.ruoyi.platform.app.zblog.blog.blog_blog.service.impl;

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
import com.ruoyi.platform.app.zblog.blog.blog_blog.mapper.BlogBlogMapper;
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BlogBlog;
import com.ruoyi.platform.app.zblog.blog.blog_blog.service.IBlogBlogService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客文档Service业务层处理
 *
 * @author mylady
 * @date 2023-10-24
 */
@Service
public class BlogBlogServiceImpl implements IBlogBlogService {

    private static final Logger logger = LoggerFactory.getLogger(BlogBlogServiceImpl.class);

    @Autowired
    private BlogBlogMapper blogBlogMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectBlogBlogById(Long id) {
        return blogBlogMapper.selectBlogBlogById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<BlogBlog> selectBlogBlogList(BlogBlog dto) {
        return blogBlogMapper.selectBlogBlogList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertBlogBlog(BlogBlog blogBlog) {
        blogBlog.setCreateTime(DateUtils.getNowDate());
        return blogBlogMapper.insertBlogBlog(blogBlog);
    }

    /**
     * 修改
     */
    @Override
    public int updateBlogBlog(BlogBlog blogBlog) {
        blogBlog.setUpdateTime(DateUtils.getNowDate());
        return blogBlogMapper.updateBlogBlog(blogBlog);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteBlogBlogByIds(Long[] ids) {
        return blogBlogMapper.deleteBlogBlogByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteBlogBlogById(Long id) {
        return blogBlogMapper.deleteBlogBlogById(id);
    }
}
