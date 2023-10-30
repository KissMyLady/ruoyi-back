package com.ruoyi.platform.app.zblog.book.book_book.service;

import java.util.List;
import java.util.Map;
import com.ruoyi.platform.app.zblog.book.book_book.domain.BookBook;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;
/**
 * 书籍Service接口
 *
 * @author mylady
 * @date 2023-10-30
 */
public interface IBookBookService {
    /**
     * 查询详情
     */
    Map<String, Object> selectBookBookById(Long id);

    /**
     * 查询列表
     */
    List<BookBook> selectBookBookList(BookBook dto);

    /**
     * ++新增++
     */
    int insertBookBook(BookBook dto);

    /**
     * 修改
     */
    int updateBookBook(BookBook dto);

    /**
     * --批量删除--
     */
    int deleteBookBookByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteBookBookById(Long id);

}
