package com.ruoyi.platform.app.zblog.blog.blog_blog.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONUtil;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.security.EncryptUtilsService;
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BatchChangeAuthCodeDto;
import com.ruoyi.platform.app.zblog.blog.blog_blog.domain.BlogBlog;
import com.ruoyi.platform.app.zblog.blog.blog_blog.mapper.BlogBlogMapper;
import com.ruoyi.platform.app.zblog.blog.blog_blog.service.impl.BlogBlogAuthorityServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import com.ruoyi.common.annotation.Log;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/28 20:08
 * @Description:
 */
@RestController
@RequestMapping("/blog_blog/authority")
public class BlogBlogAuthorityCtrl extends BaseController {


    @Autowired
    private BlogBlogAuthorityServiceImpl blogBlogAuthorityService;

    /**
     * 批量修改文档权限
     */
    @PreAuthorize("@ss.hasPermi('blog_blog:blog_blog:edit')")
    @Log(title = "批量修改文档权限", businessType = BusinessType.UPDATE)
    @PostMapping("/batchChangeAuth")
    public AjaxResult batchChangeAuth(@RequestBody BatchChangeAuthCodeDto dto) {
        return blogBlogAuthorityService.batchChangeAuth(dto);
    }

}
