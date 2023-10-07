package com.ruoyi.platform.app.zblog.v1_blog.blog_doc.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.domain.BlogDoc;

/**
 * 文章Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IBlogDocService {
    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    public BlogDoc selectBlogDocById(Long id);

    /**
     * 查询文章列表
     *
     * @param blogDoc 文章
     * @return 文章集合
     */
    public List<BlogDoc> selectBlogDocList(BlogDoc blogDoc);

    /**
     * 新增文章
     *
     * @param blogDoc 文章
     * @return 结果
     */
    public int insertBlogDoc(BlogDoc blogDoc);

    /**
     * 修改文章
     *
     * @param blogDoc 文章
     * @return 结果
     */
    public int updateBlogDoc(BlogDoc blogDoc);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的文章主键集合
     * @return 结果
     */
    public int deleteBlogDocByIds(Long[] ids);

    /**
     * 删除文章信息
     *
     * @param id 文章主键
     * @return 结果
     */
    public int deleteBlogDocById(Long id);
}
