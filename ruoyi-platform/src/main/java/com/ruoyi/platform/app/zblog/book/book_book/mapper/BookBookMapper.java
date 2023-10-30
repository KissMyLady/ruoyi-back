package com.ruoyi.platform.app.zblog.book.book_book.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.book.book_book.domain.BookBook;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 书籍Mapper接口
 *
 * @author mylady
 * @date 2023-10-30
 */
//@DataSource(value = DataSourceType.MASTER)
public interface BookBookMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectBookBookById(Long id);

    /**
     * 查询列表
     */
    List<BookBook> selectBookBookList(BookBook dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryBookBookList_BySQL(BookBook dto);

    //查询列表 总条数
    int queryBookBookList_count(BookBook dto);

    /**
     * ++新增++
     */
    int insertBookBook(BookBook dto);

    /**
     * 修改
     */
    int updateBookBook(BookBook dto);

    /**
     * -删除-
     */
    int deleteBookBookById(Long id);

    /**
     * --批量删除--
     */
    int deleteBookBookByIds(Long[] ids);
}
