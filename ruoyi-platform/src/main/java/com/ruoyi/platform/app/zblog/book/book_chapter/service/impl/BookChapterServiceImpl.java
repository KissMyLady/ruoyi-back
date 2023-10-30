package com.ruoyi.platform.app.zblog.book.book_chapter.service.impl;

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
import com.ruoyi.platform.app.zblog.book.book_chapter.mapper.BookChapterMapper;
import com.ruoyi.platform.app.zblog.book.book_chapter.domain.BookChapter;
import com.ruoyi.platform.app.zblog.book.book_chapter.service.IBookChapterService;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 章节Service业务层处理
 *
 * @author mylady
 * @date 2023-10-30
 */
@Service
public class BookChapterServiceImpl implements IBookChapterService {

    private static final Logger logger = LoggerFactory.getLogger(BookChapterServiceImpl.class);

    @Autowired
    private BookChapterMapper bookChapterMapper;

    /**
     * 查询详情
     */
    @Override
    public Map<String, Object> selectBookChapterById(Long id) {
        return bookChapterMapper.selectBookChapterById(id);
    }

    /**
     * 查询列表
     */
    @Override
    public List<BookChapter> selectBookChapterList(BookChapter dto) {
        return bookChapterMapper.selectBookChapterList(dto);
    }

    /**
     * 新增
     */
    @Override
    public int insertBookChapter(BookChapter bookChapter) {
        bookChapter.setCreateTime(DateUtils.getNowDate());
        return bookChapterMapper.insertBookChapter(bookChapter);
    }

    /**
     * 修改
     */
    @Override
    public int updateBookChapter(BookChapter bookChapter) {
        bookChapter.setUpdateTime(DateUtils.getNowDate());
        return bookChapterMapper.updateBookChapter(bookChapter);
    }

    /**
     * 批量删除
     */
    @Override
    public int deleteBookChapterByIds(Long[] ids) {
        return bookChapterMapper.deleteBookChapterByIds(ids);
    }

    /**
     * 删除
     */
    @Override
    public int deleteBookChapterById(Long id) {
        return bookChapterMapper.deleteBookChapterById(id);
    }
}
