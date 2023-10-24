package com.ruoyi.platform.app.zblog.blog.blog_common.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.blog.blog_common.domain.BlogCommon;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 博客评论Mapper接口
 *
 * @author mylady
 * @date 2023-10-24
 */
//@DataSource(value = DataSourceType.MASTER)
public interface BlogCommonMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectBlogCommonById(Long id);

    /**
     * 查询列表
     */
    List<BlogCommon> selectBlogCommonList(BlogCommon dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryBlogCommonList_BySQL(BlogCommon dto);

    //查询列表 总条数
    int queryBlogCommonList_count(BlogCommon dto);

    /**
     * ++新增++
     */
    int insertBlogCommon(BlogCommon dto);

    /**
     * 修改
     */
    int updateBlogCommon(BlogCommon dto);

    /**
     * -删除-
     */
    int deleteBlogCommonById(Long id);

    /**
     * --批量删除--
     */
    int deleteBlogCommonByIds(Long[] ids);
}
