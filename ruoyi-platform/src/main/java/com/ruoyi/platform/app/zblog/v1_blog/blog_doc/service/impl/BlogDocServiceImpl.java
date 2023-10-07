package com.ruoyi.platform.app.zblog.v1_blog.blog_doc.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.mapper.BlogDocMapper;
import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.domain.BlogDoc;
import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.service.IBlogDocService;

/**
 * 文章Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class BlogDocServiceImpl implements IBlogDocService {
    @Autowired
    private BlogDocMapper blogDocMapper;

    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    @Override
    public BlogDoc selectBlogDocById(Long id) {
        return blogDocMapper.selectBlogDocById(id);
    }

    /**
     * 查询文章列表
     *
     * @param blogDoc 文章
     * @return 文章
     */
    @Override
    public List<BlogDoc> selectBlogDocList(BlogDoc blogDoc) {
        return blogDocMapper.selectBlogDocList(blogDoc);
    }

    /**
     * 新增文章
     *
     * @param blogDoc 文章
     * @return 结果
     */
    @Override
    public int insertBlogDoc(BlogDoc blogDoc) {
        blogDoc.setCreateTime(DateUtils.getNowDate());
        return blogDocMapper.insertBlogDoc(blogDoc);
    }

    /**
     * 修改文章
     *
     * @param blogDoc 文章
     * @return 结果
     */
    @Override
    public int updateBlogDoc(BlogDoc blogDoc) {
        return blogDocMapper.updateBlogDoc(blogDoc);
    }

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键
     * @return 结果
     */
    @Override
    public int deleteBlogDocByIds(Long[] ids) {
        return blogDocMapper.deleteBlogDocByIds(ids);
    }

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     * @return 结果
     */
    @Override
    public int deleteBlogDocById(Long id) {
        return blogDocMapper.deleteBlogDocById(id);
    }
}
