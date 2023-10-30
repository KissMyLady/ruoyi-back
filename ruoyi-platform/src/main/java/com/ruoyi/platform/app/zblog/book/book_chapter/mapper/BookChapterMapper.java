package com.ruoyi.platform.app.zblog.book.book_chapter.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.book.book_chapter.domain.BookChapter;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
//import com.ruoyi.common.annotation.DataSource;
//import com.ruoyi.common.enums.DataSourceType;

/**
 * 章节Mapper接口
 *
 * @author mylady
 * @date 2023-10-30
 */
//@DataSource(value = DataSourceType.MASTER)
public interface BookChapterMapper {

    /**
     * 查询详情
     */
    //@MapKey("id")
    Map<String, Object> selectBookChapterById(Long id);

    /**
     * 查询列表
     */
    List<BookChapter> selectBookChapterList(BookChapter dto);

    /**
     * SQL查询列表
     */
    //@MapKey("id")
    List<Map<String, Object>> queryBookChapterList_BySQL(BookChapter dto);

    //查询列表 总条数
    int queryBookChapterList_count(BookChapter dto);

    /**
     * ++新增++
     */
    int insertBookChapter(BookChapter dto);

    /**
     * 修改
     */
    int updateBookChapter(BookChapter dto);

    /**
     * -删除-
     */
    int deleteBookChapterById(Long id);

    /**
     * --批量删除--
     */
    int deleteBookChapterByIds(Long[] ids);
}
