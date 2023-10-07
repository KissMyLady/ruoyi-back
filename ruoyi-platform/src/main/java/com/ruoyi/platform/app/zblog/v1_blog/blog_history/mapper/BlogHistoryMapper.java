package com.ruoyi.platform.app.zblog.v1_blog.blog_history.mapper;

import java.util.List;

import com.ruoyi.platform.app.zblog.v1_blog.blog_history.domain.BlogHistory;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 文档历史记录Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface BlogHistoryMapper {
    /**
     * 查询文档历史记录
     *
     * @param id 文档历史记录主键
     * @return 文档历史记录
     */
    BlogHistory selectBlogHistoryById(Long id);

    /**
     * 查询文档历史记录列表
     *
     * @param blogHistory 文档历史记录
     * @return 文档历史记录集合
     */
    List<BlogHistory> selectBlogHistoryList(BlogHistory blogHistory);

    /**
     * 新增文档历史记录
     *
     * @param blogHistory 文档历史记录
     * @return 结果
     */
    int insertBlogHistory(BlogHistory blogHistory);

    /**
     * 修改文档历史记录
     *
     * @param blogHistory 文档历史记录
     * @return 结果
     */
    int updateBlogHistory(BlogHistory blogHistory);

    /**
     * 删除文档历史记录
     *
     * @param id 文档历史记录主键
     * @return 结果
     */
    int deleteBlogHistoryById(Long id);

    /**
     * 批量删除文档历史记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBlogHistoryByIds(Long[] ids);
}
