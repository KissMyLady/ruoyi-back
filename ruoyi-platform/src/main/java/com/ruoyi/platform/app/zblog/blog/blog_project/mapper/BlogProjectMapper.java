package com.ruoyi.platform.app.zblog.blog.blog_project.mapper;

import java.util.List;
import java.util.Map;
import com.ruoyi.platform.app.zblog.blog.blog_project.domain.BlogProject;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 博客文集Mapper接口
 *
 * @author mylady
 * @date 2023-10-24
 */
//@DataSource(value = DataSourceType.MASTER)
public interface BlogProjectMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectBlogProjectById(Long id);

    /**
     * 查询列表
     */
    List<BlogProject> selectBlogProjectList(BlogProject dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryBlogProjectList_BySQL(BlogProject dto);

    //查询列表 总条数
    int queryBlogProjectList_count(BlogProject dto);

    /**
     * ++新增++
     */
    int insertBlogProject(BlogProject dto);

    /**
     * 修改
     */
    int updateBlogProject(BlogProject dto);

    /**
     * -删除-
     */
    int deleteBlogProjectById(Long id);

    /**
     * --批量删除--
     */
    int deleteBlogProjectByIds(Long[] ids);
}
