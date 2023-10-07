package com.ruoyi.platform.app.zblog.v3_books.book_article.mapper;

import java.util.List;

import com.ruoyi.platform.app.zblog.v3_books.book_article.domain.BookArticle;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 书籍-详情列内容Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface BookArticleMapper {
    /**
     * 查询书籍-详情列内容
     *
     * @param id 书籍-详情列内容主键
     * @return 书籍-详情列内容
     */
    BookArticle selectBookArticleById(Long id);

    /**
     * 查询书籍-详情列内容列表
     *
     * @param bookArticle 书籍-详情列内容
     * @return 书籍-详情列内容集合
     */
    List<BookArticle> selectBookArticleList(BookArticle bookArticle);

    /**
     * 新增书籍-详情列内容
     *
     * @param bookArticle 书籍-详情列内容
     * @return 结果
     */
    int insertBookArticle(BookArticle bookArticle);

    /**
     * 修改书籍-详情列内容
     *
     * @param bookArticle 书籍-详情列内容
     * @return 结果
     */
    int updateBookArticle(BookArticle bookArticle);

    /**
     * 删除书籍-详情列内容
     *
     * @param id 书籍-详情列内容主键
     * @return 结果
     */
    int deleteBookArticleById(Long id);

    /**
     * 批量删除书籍-详情列内容
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBookArticleByIds(Long[] ids);
}
