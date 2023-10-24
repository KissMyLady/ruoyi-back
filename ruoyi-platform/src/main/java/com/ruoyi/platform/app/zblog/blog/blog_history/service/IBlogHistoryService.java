package com.ruoyi.platform.app.zblog.blog.blog_history.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.blog.blog_history.domain.BlogHistory;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 博客文档历史记录Service接口
 *
 * @author mylady
 * @date 2023-10-24
 */
public interface IBlogHistoryService {
    /**
     * 查询详情
     */
    Map<String, Object> selectBlogHistoryById(Long id);

    /**
     * 查询列表
     */
    List<BlogHistory> selectBlogHistoryList(BlogHistory dto);

    /**
     * ++新增++
     */
    int insertBlogHistory(BlogHistory dto);

    /**
     * 修改
     */
    int updateBlogHistory(BlogHistory dto);

    /**
     * --批量删除--
     */
    int deleteBlogHistoryByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteBlogHistoryById(Long id);

}
