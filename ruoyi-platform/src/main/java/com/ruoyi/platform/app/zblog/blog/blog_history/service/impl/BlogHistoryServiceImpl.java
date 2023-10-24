package com.ruoyi.platform.app.zblog.blog.blog_history.service.impl;

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
import com.ruoyi.platform.app.zblog.blog.blog_history.mapper.BlogHistoryMapper;
import com.ruoyi.platform.app.zblog.blog.blog_history.domain.BlogHistory;
import com.ruoyi.platform.app.zblog.blog.blog_history.service.IBlogHistoryService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 博客文档历史记录Service业务层处理
 *
 * @author mylady
 * @date 2023-10-24
 */
@Service
public class BlogHistoryServiceImpl implements IBlogHistoryService {

    private static final Logger logger = LoggerFactory.getLogger(BlogHistoryServiceImpl.class);

    @Autowired
    private BlogHistoryMapper blogHistoryMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectBlogHistoryById(Long id) {
        return blogHistoryMapper.selectBlogHistoryById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<BlogHistory> selectBlogHistoryList(BlogHistory dto) {
        return blogHistoryMapper.selectBlogHistoryList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertBlogHistory(BlogHistory blogHistory) {
        blogHistory.setCreateTime(DateUtils.getNowDate());
        return blogHistoryMapper.insertBlogHistory(blogHistory);
    }

    /**
     * 修改
     */
    @Override
    public int updateBlogHistory(BlogHistory blogHistory) {
        blogHistory.setUpdateTime(DateUtils.getNowDate());
        return blogHistoryMapper.updateBlogHistory(blogHistory);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteBlogHistoryByIds(Long[] ids) {
        return blogHistoryMapper.deleteBlogHistoryByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteBlogHistoryById(Long id) {
        return blogHistoryMapper.deleteBlogHistoryById(id);
    }
}
