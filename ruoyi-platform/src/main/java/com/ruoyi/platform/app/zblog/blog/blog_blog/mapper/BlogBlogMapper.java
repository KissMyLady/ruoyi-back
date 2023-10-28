package com.ruoyi.platform.app.zblog.blog.blog_blog.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BatchChangeAuthCodeDto;
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BlogBlog;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 博客文档Mapper接口
 *
 * @author mylady
 * @date 2023-10-24
 */
//@DataSource(value = DataSourceType.MASTER)
public interface BlogBlogMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectBlogBlogById(Long id);

    /**
     * 查询列表
     */
    List<BlogBlog> selectBlogBlogList(BlogBlog dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryBlogBlogList_BySQL(BlogBlog dto);

    //查询列表 总条数
    int queryBlogBlogList_count(BlogBlog dto);

    /**
     * ++新增++
     */
    int insertBlogBlog(BlogBlog dto);

    /**
     * 修改
     */
    int updateBlogBlog(BlogBlog dto);

    /**
     * 批量更新权限
     */
    int batch_update_authority(BatchChangeAuthCodeDto dto);

    /**
     * -删除-
     */
    int deleteBlogBlogById(Long id);

    /**
     * --批量删除--
     */
    int deleteBlogBlogByIds(Long[] ids);
}
