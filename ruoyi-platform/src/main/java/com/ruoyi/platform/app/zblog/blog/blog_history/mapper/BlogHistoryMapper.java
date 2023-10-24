package com.ruoyi.platform.app.zblog.blog.blog_history.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.blog.blog_history.domain.BlogHistory;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 博客文档历史记录Mapper接口
 *
 * @author mylady
 * @date 2023-10-24
 */
//@DataSource(value = DataSourceType.MASTER)
public interface BlogHistoryMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectBlogHistoryById(Long id);

    /**
     * 查询列表
     */
    List<BlogHistory> selectBlogHistoryList(BlogHistory dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryBlogHistoryList_BySQL(BlogHistory dto);

    //查询列表 总条数
    int queryBlogHistoryList_count(BlogHistory dto);

    /**
     * ++新增++
     */
    int insertBlogHistory(BlogHistory dto);

    /**
     * 修改
     */
    int updateBlogHistory(BlogHistory dto);

    /**
     * -删除-
     */
    int deleteBlogHistoryById(Long id);

    /**
     * --批量删除--
     */
    int deleteBlogHistoryByIds(Long[] ids);
}
