package com.ruoyi.platform.app.zblog.v3_books.book_book.service;

import java.util.List;

import com.ruoyi.platform.app.zblog.v3_books.book_book.domain.BookBook;

/**
 * 书籍信息Service接口
 *
 * @author mylady
 * @date 2023-10-07
 */
public interface IBookBookService {
    /**
     * 查询书籍信息
     *
     * @param id 书籍信息主键
     * @return 书籍信息
     */
    public BookBook selectBookBookById(Long id);

    /**
     * 查询书籍信息列表
     *
     * @param bookBook 书籍信息
     * @return 书籍信息集合
     */
    public List<BookBook> selectBookBookList(BookBook bookBook);

    /**
     * 新增书籍信息
     *
     * @param bookBook 书籍信息
     * @return 结果
     */
    public int insertBookBook(BookBook bookBook);

    /**
     * 修改书籍信息
     *
     * @param bookBook 书籍信息
     * @return 结果
     */
    public int updateBookBook(BookBook bookBook);

    /**
     * 批量删除书籍信息
     *
     * @param ids 需要删除的书籍信息主键集合
     * @return 结果
     */
    public int deleteBookBookByIds(Long[] ids);

    /**
     * 删除书籍信息信息
     *
     * @param id 书籍信息主键
     * @return 结果
     */
    public int deleteBookBookById(Long id);
}
