package com.ruoyi.platform.app.zblog.blog.blog_common.service.impl;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;
import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.blog.blog_common.mapper.BlogCommonMapper;
import com.ruoyi.platform.app.zblog.blog.blog_common.domain.BlogCommon;
import com.ruoyi.platform.app.zblog.blog.blog_common.service.IBlogCommonService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客评论Service业务层处理
 *
 * @author mylady
 * @date 2023-10-24
 */
@Service
public class BlogCommonServiceImpl implements IBlogCommonService {

    private static final Logger logger = LoggerFactory.getLogger(BlogCommonServiceImpl.class);

    @Autowired
    private BlogCommonMapper blogCommonMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectBlogCommonById(Long id) {
        return blogCommonMapper.selectBlogCommonById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<BlogCommon> selectBlogCommonList(BlogCommon dto) {
        return blogCommonMapper.selectBlogCommonList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertBlogCommon(BlogCommon blogCommon) {
        blogCommon.setCreateTime(DateUtils.getNowDate());
        return blogCommonMapper.insertBlogCommon(blogCommon);
    }

    /**
     * 修改
     */
    @Override
    public int updateBlogCommon(BlogCommon blogCommon) {
        blogCommon.setUpdateTime(DateUtils.getNowDate());
        return blogCommonMapper.updateBlogCommon(blogCommon);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteBlogCommonByIds(Long[] ids) {
        return blogCommonMapper.deleteBlogCommonByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteBlogCommonById(Long id) {
        return blogCommonMapper.deleteBlogCommonById(id);
    }
}
