package com.ruoyi.platform.app.zblog.v1_blog.blog_doc.mapper;

import java.util.List;
import com.ruoyi.platform.app.zblog.v1_blog.blog_doc.domain.BlogDoc;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 文章Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface BlogDocMapper {
    /**
     * 查询文章
     *
     * @param id 文章主键
     * @return 文章
     */
    BlogDoc selectBlogDocById(Long id);

    /**
     * 查询文章列表
     *
     * @param blogDoc 文章
     * @return 文章集合
     */
    List<BlogDoc> selectBlogDocList(BlogDoc blogDoc);

    /**
     * 新增文章
     *
     * @param blogDoc 文章
     * @return 结果
     */
    int insertBlogDoc(BlogDoc blogDoc);

    /**
     * 修改文章
     *
     * @param blogDoc 文章
     * @return 结果
     */
    int updateBlogDoc(BlogDoc blogDoc);

    /**
     * 删除文章
     *
     * @param id 文章主键
     * @return 结果
     */
    int deleteBlogDocById(Long id);

    /**
     * 批量删除文章
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBlogDocByIds(Long[] ids);
}
