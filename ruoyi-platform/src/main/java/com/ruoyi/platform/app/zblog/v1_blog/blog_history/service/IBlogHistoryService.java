package com.ruoyi.platform.app.zblog.v1_blog.blog_history.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v1_blog.blog_history.domain.BlogHistory;

/**
 * 文档历史记录Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IBlogHistoryService {
    /**
     * 查询文档历史记录
     *
     * @param id 文档历史记录主键
     * @return 文档历史记录
     */
    public BlogHistory selectBlogHistoryById(Long id);

    /**
     * 查询文档历史记录列表
     *
     * @param blogHistory 文档历史记录
     * @return 文档历史记录集合
     */
    public List<BlogHistory> selectBlogHistoryList(BlogHistory blogHistory);

    /**
     * 新增文档历史记录
     *
     * @param blogHistory 文档历史记录
     * @return 结果
     */
    public int insertBlogHistory(BlogHistory blogHistory);

    /**
     * 修改文档历史记录
     *
     * @param blogHistory 文档历史记录
     * @return 结果
     */
    public int updateBlogHistory(BlogHistory blogHistory);

    /**
     * 批量删除文档历史记录
     *
     * @param ids 需要删除的文档历史记录主键集合
     * @return 结果
     */
    public int deleteBlogHistoryByIds(Long[] ids);

    /**
     * 删除文档历史记录信息
     *
     * @param id 文档历史记录主键
     * @return 结果
     */
    public int deleteBlogHistoryById(Long id);
}
