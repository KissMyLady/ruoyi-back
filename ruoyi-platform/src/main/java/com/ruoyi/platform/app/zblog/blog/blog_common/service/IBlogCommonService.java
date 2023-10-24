package com.ruoyi.platform.app.zblog.blog.blog_common.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.platform.app.zblog.blog.blog_common.domain.BlogCommon;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * 博客评论Service接口
 *
 * @author mylady
 * @date 2023-10-24
 */
public interface IBlogCommonService {
    /**
     * 查询详情
     */
    Map<String, Object> selectBlogCommonById(Long id);

    /**
     * 查询列表
     */
    List<BlogCommon> selectBlogCommonList(BlogCommon dto);

    /**
     * ++新增++
     */
    int insertBlogCommon(BlogCommon dto);

    /**
     * 修改
     */
    int updateBlogCommon(BlogCommon dto);

    /**
     * --批量删除--
     */
    int deleteBlogCommonByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteBlogCommonById(Long id);

}
