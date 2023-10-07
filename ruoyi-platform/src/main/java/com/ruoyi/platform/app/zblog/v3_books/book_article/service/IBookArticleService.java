package com.ruoyi.platform.app.zblog.v3_books.book_article.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v3_books.book_article.domain.BookArticle;

/**
 * 书籍-详情列内容Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IBookArticleService {
    /**
     * 查询书籍-详情列内容
     *
     * @param id 书籍-详情列内容主键
     * @return 书籍-详情列内容
     */
    public BookArticle selectBookArticleById(Long id);

    /**
     * 查询书籍-详情列内容列表
     *
     * @param bookArticle 书籍-详情列内容
     * @return 书籍-详情列内容集合
     */
    public List<BookArticle> selectBookArticleList(BookArticle bookArticle);

    /**
     * 新增书籍-详情列内容
     *
     * @param bookArticle 书籍-详情列内容
     * @return 结果
     */
    public int insertBookArticle(BookArticle bookArticle);

    /**
     * 修改书籍-详情列内容
     *
     * @param bookArticle 书籍-详情列内容
     * @return 结果
     */
    public int updateBookArticle(BookArticle bookArticle);

    /**
     * 批量删除书籍-详情列内容
     *
     * @param ids 需要删除的书籍-详情列内容主键集合
     * @return 结果
     */
    public int deleteBookArticleByIds(Long[] ids);

    /**
     * 删除书籍-详情列内容信息
     *
     * @param id 书籍-详情列内容主键
     * @return 结果
     */
    public int deleteBookArticleById(Long id);
}
