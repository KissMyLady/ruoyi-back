package com.ruoyi.platform.app.zblog.v1_blog.blog_history.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v1_blog.blog_history.mapper.BlogHistoryMapper;
import com.ruoyi.platform.app.zblog.v1_blog.blog_history.domain.BlogHistory;
import com.ruoyi.platform.app.zblog.v1_blog.blog_history.service.IBlogHistoryService;

/**
 * 文档历史记录Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class BlogHistoryServiceImpl implements IBlogHistoryService {
    @Autowired
    private BlogHistoryMapper blogHistoryMapper;

    /**
     * 查询文档历史记录
     *
     * @param id 文档历史记录主键
     * @return 文档历史记录
     */
    @Override
    public BlogHistory selectBlogHistoryById(Long id) {
        return blogHistoryMapper.selectBlogHistoryById(id);
    }

    /**
     * 查询文档历史记录列表
     *
     * @param blogHistory 文档历史记录
     * @return 文档历史记录
     */
    @Override
    public List<BlogHistory> selectBlogHistoryList(BlogHistory blogHistory) {
        return blogHistoryMapper.selectBlogHistoryList(blogHistory);
    }

    /**
     * 新增文档历史记录
     *
     * @param blogHistory 文档历史记录
     * @return 结果
     */
    @Override
    public int insertBlogHistory(BlogHistory blogHistory) {
        blogHistory.setCreateTime(DateUtils.getNowDate());
        return blogHistoryMapper.insertBlogHistory(blogHistory);
    }

    /**
     * 修改文档历史记录
     *
     * @param blogHistory 文档历史记录
     * @return 结果
     */
    @Override
    public int updateBlogHistory(BlogHistory blogHistory) {
        blogHistory.setUpdateTime(DateUtils.getNowDate());
        return blogHistoryMapper.updateBlogHistory(blogHistory);
    }

    /**
     * 批量删除文档历史记录
     *
     * @param ids 需要删除的文档历史记录主键
     * @return 结果
     */
    @Override
    public int deleteBlogHistoryByIds(Long[] ids) {
        return blogHistoryMapper.deleteBlogHistoryByIds(ids);
    }

    /**
     * 删除文档历史记录信息
     *
     * @param id 文档历史记录主键
     * @return 结果
     */
    @Override
    public int deleteBlogHistoryById(Long id) {
        return blogHistoryMapper.deleteBlogHistoryById(id);
    }
}
