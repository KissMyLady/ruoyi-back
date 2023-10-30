package com.ruoyi.platform.app.zblog.book.book_chapter.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.platform.app.zblog.book.book_chapter.domain.BookChapter;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.core.domain.AjaxResult;

/**
 * 章节Service接口
 *
 * @author mylady
 * @date 2023-10-30
 */
public interface IBookChapterService {
    /**
     * 查询详情
     */
    Map<String, Object> selectBookChapterById(Long id);

    /**
     * 查询列表
     */
    List<BookChapter> selectBookChapterList(BookChapter dto);

    /**
     * ++新增++
     */
    int insertBookChapter(BookChapter dto);

    /**
     * 修改
     */
    int updateBookChapter(BookChapter dto);

    /**
     * --批量删除--
     */
    int deleteBookChapterByIds(Long[] ids);

    /**
     * -删除-
     */
    int deleteBookChapterById(Long id);

}
