package com.ruoyi.platform.app.zblog.v3_books.book_book.service.impl;

import java.util.List;

import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.platform.app.zblog.v3_books.book_book.mapper.BookBookMapper;
import com.ruoyi.platform.app.zblog.v3_books.book_book.domain.BookBook;
import com.ruoyi.platform.app.zblog.v3_books.book_book.service.IBookBookService;

/**
 * 书籍信息Service业务层处理
 *
 * @author mylady
 * @date 2023-10-07
 */
@Service
public class BookBookServiceImpl implements IBookBookService {
    @Autowired
    private BookBookMapper bookBookMapper;

    /**
     * 查询书籍信息
     *
     * @param id 书籍信息主键
     * @return 书籍信息
     */
    @Override
    public BookBook selectBookBookById(Long id) {
        return bookBookMapper.selectBookBookById(id);
    }

    /**
     * 查询书籍信息列表
     *
     * @param bookBook 书籍信息
     * @return 书籍信息
     */
    @Override
    public List<BookBook> selectBookBookList(BookBook bookBook) {
        return bookBookMapper.selectBookBookList(bookBook);
    }

    /**
     * 新增书籍信息
     *
     * @param bookBook 书籍信息
     * @return 结果
     */
    @Override
    public int insertBookBook(BookBook bookBook) {
        bookBook.setCreateTime(DateUtils.getNowDate());
        return bookBookMapper.insertBookBook(bookBook);
    }

    /**
     * 修改书籍信息
     *
     * @param bookBook 书籍信息
     * @return 结果
     */
    @Override
    public int updateBookBook(BookBook bookBook) {
        bookBook.setUpdateTime(DateUtils.getNowDate());
        return bookBookMapper.updateBookBook(bookBook);
    }

    /**
     * 批量删除书籍信息
     *
     * @param ids 需要删除的书籍信息主键
     * @return 结果
     */
    @Override
    public int deleteBookBookByIds(Long[] ids) {
        return bookBookMapper.deleteBookBookByIds(ids);
    }

    /**
     * 删除书籍信息信息
     *
     * @param id 书籍信息主键
     * @return 结果
     */
    @Override
    public int deleteBookBookById(Long id) {
        return bookBookMapper.deleteBookBookById(id);
    }
}
