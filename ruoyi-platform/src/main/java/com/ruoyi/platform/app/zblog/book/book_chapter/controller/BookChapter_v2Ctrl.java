package com.ruoyi.platform.app.zblog.book.book_chapter.controller;

import cn.hutool.core.util.ObjectUtil;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.EncryptDto;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.platform.app.zblog.book.book_chapter.domain.BookChapter;
import com.ruoyi.platform.app.zblog.book.book_chapter.mapper.BookChapterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author: KissMyLady
 * @Date: Created in 2023/10/31 17:48
 * @Description:
 */
@RestController
@RequestMapping("/book_chapter/chapter")
public class BookChapter_v2Ctrl {

    @Autowired
    private BookChapterMapper bookChapterMapper;

    /**
     * 根据书籍id, 查询最近的10条文章
     */
    @PreAuthorize("@ss.hasPermi('book_chapter:book_chapter:list')")
    @Log(title = "新增章节", businessType = BusinessType.INSERT)
    @PostMapping("/queryBookChapterLastTen")
    public AjaxResult queryBookChapterLastTen(@RequestBody BookChapter dto) {
        if(ObjectUtil.isEmpty(dto.getBookId())){
            return AjaxResult.error("查询书籍id不能为空");
        }
        Long bookId = dto.getBookId();
        SysUser user = SecurityUtils.getLoginUser().getUser();
        BookChapter queryDto = new BookChapter();
        queryDto.setBookId(bookId);
        queryDto.setPageNum(0);
        queryDto.setPageSize(5);
        queryDto.setIsDelete(0);
        queryDto.setSortStr("create_time");
        queryDto.setIsAsc("desc");

        Long userId = user.getUserId();
        if (userId == 1) {
            dto.setUserId(null);
        } else {
            //普通用户, 仅查询自己
            dto.setUserId(user.getUserId());
        }

        //根据id查询最近的5篇文章
        List<Map<String, Object>> mapList = bookChapterMapper.queryBookChapterList_BySQL(queryDto);

        return AjaxResult.success(mapList);
    }
}
