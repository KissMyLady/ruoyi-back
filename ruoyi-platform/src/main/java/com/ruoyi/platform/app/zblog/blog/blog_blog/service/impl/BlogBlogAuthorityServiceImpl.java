package com.ruoyi.platform.app.zblog.blog.blog_blog.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.security.EncryptUtilsService;
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BatchChangeAuthCodeDto;
import com.ruoyi.platform.app.zblog.blog.blog_blog.mapper.BlogBlogMapper;
import com.ruoyi.platform.app.zblog.blog.blog_blog.service.IBlogBlogAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/28 20:12
 * @Description:
 */
@Service
public class BlogBlogAuthorityServiceImpl implements IBlogBlogAuthorityService {

    @Autowired
    private BlogBlogMapper blogBlogMapper;

    /**
     * 批量修改文档权限
     */
    @Override
    public AjaxResult batchChangeAuth(BatchChangeAuthCodeDto dto) {
        List<Integer> ids = dto.getIds();
        if (ObjectUtil.isEmpty(ids)) {
            return AjaxResult.error("传递ids不能为空");
        }
        String autoCode = dto.getCode();
        if (ObjectUtil.isEmpty(autoCode)) {
            return AjaxResult.error("传递code不能为空");
        }
        //校验code是否存在于数据库

        //更新
        int i = blogBlogMapper.batch_update_authority(dto);
        return AjaxResult.success("更新成功: "+ i);
    }
}
