package com.ruoyi.platform.app.zblog.v3_books.book_article.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v3_books.book_article.mapper.BookArticleMapper;
import com.ruoyi.platform.app.zblog.v3_books.book_article.domain.BookArticle;
import com.ruoyi.platform.app.zblog.v3_books.book_article.service.IBookArticleService;

/**
 * 书籍-详情列内容Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class BookArticleServiceImpl implements IBookArticleService {
    @Autowired
    private BookArticleMapper bookArticleMapper;

    /**
     * 查询书籍-详情列内容
     *
     * @param id 书籍-详情列内容主键
     * @return 书籍-详情列内容
     */
    @Override
    public BookArticle selectBookArticleById(Long id) {
        return bookArticleMapper.selectBookArticleById(id);
    }

    /**
     * 查询书籍-详情列内容列表
     *
     * @param bookArticle 书籍-详情列内容
     * @return 书籍-详情列内容
     */
    @Override
    public List<BookArticle> selectBookArticleList(BookArticle bookArticle) {
        return bookArticleMapper.selectBookArticleList(bookArticle);
    }

    /**
     * 新增书籍-详情列内容
     *
     * @param bookArticle 书籍-详情列内容
     * @return 结果
     */
    @Override
    public int insertBookArticle(BookArticle bookArticle) {
        bookArticle.setCreateTime(DateUtils.getNowDate());
        return bookArticleMapper.insertBookArticle(bookArticle);
    }

    /**
     * 修改书籍-详情列内容
     *
     * @param bookArticle 书籍-详情列内容
     * @return 结果
     */
    @Override
    public int updateBookArticle(BookArticle bookArticle) {
        bookArticle.setUpdateTime(DateUtils.getNowDate());
        return bookArticleMapper.updateBookArticle(bookArticle);
    }

    /**
     * 批量删除书籍-详情列内容
     *
     * @param ids 需要删除的书籍-详情列内容主键
     * @return 结果
     */
    @Override
    public int deleteBookArticleByIds(Long[] ids) {
        return bookArticleMapper.deleteBookArticleByIds(ids);
    }

    /**
     * 删除书籍-详情列内容信息
     *
     * @param id 书籍-详情列内容主键
     * @return 结果
     */
    @Override
    public int deleteBookArticleById(Long id) {
        return bookArticleMapper.deleteBookArticleById(id);
    }
}
