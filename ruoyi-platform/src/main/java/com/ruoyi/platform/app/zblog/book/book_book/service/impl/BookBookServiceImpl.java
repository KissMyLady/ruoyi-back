package com.ruoyi.platform.app.zblog.book.book_book.service.impl;

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
import com.ruoyi.platform.app.zblog.book.book_book.mapper.BookBookMapper;
import com.ruoyi.platform.app.zblog.book.book_book.domain.BookBook;
import com.ruoyi.platform.app.zblog.book.book_book.service.IBookBookService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 书籍Service业务层处理
 *
 * @author mylady
 * @date 2023-10-30
 */
@Service
public class BookBookServiceImpl implements IBookBookService {

    private static final Logger logger = LoggerFactory.getLogger(BookBookServiceImpl.class);

    @Autowired
    private BookBookMapper bookBookMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectBookBookById(Long id) {
        return bookBookMapper.selectBookBookById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<BookBook> selectBookBookList(BookBook dto) {
        return bookBookMapper.selectBookBookList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertBookBook(BookBook bookBook) {
        bookBook.setCreateTime(DateUtils.getNowDate());
        return bookBookMapper.insertBookBook(bookBook);
    }

    /**
     * 修改
     */
    @Override
    public int updateBookBook(BookBook bookBook) {
        bookBook.setUpdateTime(DateUtils.getNowDate());
        return bookBookMapper.updateBookBook(bookBook);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteBookBookByIds(Long[] ids) {
        return bookBookMapper.deleteBookBookByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteBookBookById(Long id) {
        return bookBookMapper.deleteBookBookById(id);
    }
}
