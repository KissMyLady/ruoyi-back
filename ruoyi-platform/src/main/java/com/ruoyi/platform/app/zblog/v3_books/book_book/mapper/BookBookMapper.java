package com.ruoyi.platform.app.zblog.v3_books.book_book.mapper;

import java.util.List;

import com.ruoyi.platform.app.zblog.v3_books.book_book.domain.BookBook;
import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;

/**
 * 书籍信息Mapper接口
 *
 * @author mylady
 * @date 2023-10-07
 */
@DataSource(value = DataSourceType.slaveZblog)
public interface BookBookMapper {
    /**
     * 查询书籍信息
     *
     * @param id 书籍信息主键
     * @return 书籍信息
     */
    BookBook selectBookBookById(Long id);

    /**
     * 查询书籍信息列表
     *
     * @param bookBook 书籍信息
     * @return 书籍信息集合
     */
    List<BookBook> selectBookBookList(BookBook bookBook);

    /**
     * 新增书籍信息
     *
     * @param bookBook 书籍信息
     * @return 结果
     */
    int insertBookBook(BookBook bookBook);

    /**
     * 修改书籍信息
     *
     * @param bookBook 书籍信息
     * @return 结果
     */
    int updateBookBook(BookBook bookBook);

    /**
     * 删除书籍信息
     *
     * @param id 书籍信息主键
     * @return 结果
     */
    int deleteBookBookById(Long id);

    /**
     * 批量删除书籍信息
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    int deleteBookBookByIds(Long[] ids);
}
