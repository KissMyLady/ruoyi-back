package com.ruoyi.platform.app.zblog.blog.blog_blog.service;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BatchChangeAuthCodeDto;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/28 20:11
 * @Description:
 */
public interface IBlogBlogAuthorityService {

    /**
     * 批量修改文章权限
     */
    AjaxResult batchChangeAuth(BatchChangeAuthCodeDto dto);

}
